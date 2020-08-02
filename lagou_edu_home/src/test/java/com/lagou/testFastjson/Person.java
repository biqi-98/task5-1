package com.lagou.testFastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @JSONField(name = "USERNAME")
    private String username;
    @JSONField(name = "AGE")
    private int age;

    private String birthday;

}
