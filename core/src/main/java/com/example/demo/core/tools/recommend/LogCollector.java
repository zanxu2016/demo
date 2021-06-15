package com.example.demo.core.tools.recommend;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LogCollector {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/xuzan/work/test/demo/core/src/main/resources/5";
        List<String> params = IOUtils.readLines(new FileInputStream(new File(fileName)), Charset.defaultCharset());

        int pointer = 0;
        Map<String, String> map = new LinkedHashMap<>();

        String key = null, value = null;
        for (int i = 0; i < params.size(); i++) {
            if (StringUtils.isBlank(params.get(i))) {
                System.out.println("忽略空行：" + (i+1));
                continue;
            }

            if (pointer % 3 == 0) {
                key = params.get(i);
            } else if (pointer % 3 == 1) {
                value = params.get(i);

                if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                    map.put(key, value);
                    key = null;
                    value = null;
                }
            } else {
                System.out.println("忽略第" + (i+1) + "行的备注：" + params.get(i));
            }
            pointer ++;
        }

        System.out.println(JSON.toJSONString(map));
    }
}
