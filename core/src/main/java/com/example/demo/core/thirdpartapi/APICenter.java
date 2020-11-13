package com.example.demo.core.thirdpartapi;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

@Slf4j
public class APICenter {

    private static OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    // 创建用户方法
    public static String createUser(String name, int age, String identity, String mobile) throws Exception {
        return remoteCall(CreateUserAPI.builder()
                .name(name)
                .age(age)
                .identity(identity)
                .mobile(mobile)
                .build()
        );
    }

    // 支付方法
    public static String pay(long userId, BigDecimal amount) throws Exception {
        return remoteCall(PayAPI.builder()
                .userId(userId)
                .amount(amount)
                .build()
        );
    }


    private static String remoteCall(AbstractAPI api) throws Exception {
        //从ThirdPartAPI注解获取请求地址
        ThirdPartAPI thirdPartAPI = api.getClass().getAnnotation(ThirdPartAPI.class);
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(api.getClass().getDeclaredFields()) //获得所有字段
                .filter(field -> field.isAnnotationPresent(ThirdPartAPIField.class)) //查找标记了注解的字段
                .sorted(Comparator.comparingInt(a -> a.getAnnotation(ThirdPartAPIField.class).order())) //根据注解中的order对字段排序
                .peek(field -> field.setAccessible(true)) //设置可以访问私有字段
                .forEach(field -> {
                    //获得注解
                    ThirdPartAPIField ThirdPartAPIField = field.getAnnotation(ThirdPartAPIField.class);
                    Object value = "";
                    try {
                        //反射获取字段值
                        value = field.get(api);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    //根据字段类型以正确的填充方式格式化字符串
                    switch (ThirdPartAPIField.type()) {
                        case "S": {
                            stringBuilder.append(String.format("%-" + ThirdPartAPIField.length() + "s", value.toString()).replace(' ', '_'));
                            break;
                        }
                        case "N": {
                            stringBuilder.append(String.format("%" + ThirdPartAPIField.length() + "s", value.toString()).replace(' ', '0'));
                            break;
                        }
                        case "M": {
                            if (!(value instanceof BigDecimal))
                                throw new RuntimeException(String.format("%s 的 %s 必须是BigDecimal", api, field));
                            stringBuilder.append(String.format("%0" + ThirdPartAPIField.length() + "d", ((BigDecimal) value).setScale(2, RoundingMode.DOWN).multiply(new BigDecimal("100")).longValue()));
                            break;
                        }
                        default:
                            break;
                    }
                });
        //签名逻辑
        stringBuilder.append(md2Hex(stringBuilder.toString()));
        String param = stringBuilder.toString();
        long begin = System.currentTimeMillis();
        //发请求
        RequestBody body = RequestBody.create(JSON, param);
        Request request = new Request.Builder()
                .url("http://localhost:45678/reflection" + thirdPartAPI.url())
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("调用银行API {} url:{} 参数:{} 耗时:{}ms", thirdPartAPI.desc(), thirdPartAPI.url(), param, System.currentTimeMillis() - begin);
            assert response.body() != null;
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static String md2Hex(String toSign) {
        return DigestUtils.md5DigestAsHex(toSign.getBytes(Charset.defaultCharset()));
    }
}
