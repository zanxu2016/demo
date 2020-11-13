package com.example.demo.core.thirdpartapi;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ThirdPartAPI(url = "/third-part/user/create", desc = "创建用户接口")
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class CreateUserAPI extends AbstractAPI {
    @ThirdPartAPIField(order = 1, type = "S", length = 10)
    private String name;
    @ThirdPartAPIField(order = 2, type = "S", length = 18)
    private String identity;
    @ThirdPartAPIField(order = 3, type = "N", length = 5)
    private int age;
    @ThirdPartAPIField(order = 4, type = "S", length = 11) //注意这里的order需要按照API表格中的顺序
    private String mobile;
}