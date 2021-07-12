package com.xmw.component.unit.common;

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
        String token = "078ed28234717b0b6ac1cdaef79a1b2c7f49fb2f3bdc3d2494cf0440894ffa7c";
        Integer project = 442;
    }
}
