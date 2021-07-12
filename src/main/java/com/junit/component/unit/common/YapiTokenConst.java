package com.junit.component.unit.common;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YapiTokenConst {
    /**
     * 个人中心
     */
    public static final Yapi dualToken = new Yapi();

    @Data
    public static class Yapi {
        String token = "";
        Integer project = 442;
    }
}
