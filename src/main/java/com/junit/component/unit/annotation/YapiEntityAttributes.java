package com.junit.component.unit.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
@Repeatable(YapiEntityAttributes.List.class)
public @interface YapiEntityAttributes {

    String required() default "0";

    String desc() default "";

    String type() default "text";

    /**
     * mock值
     */
    String[] value() default {""};

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        YapiEntityAttributes[] value();
    }
}
