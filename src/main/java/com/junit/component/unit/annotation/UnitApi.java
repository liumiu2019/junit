package com.junit.component.unit.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface UnitApi {
    /**
     * 接口备注
     */
    String comment() default "";

    /**
     * 请求方式
     */
    String method() default "";

    /**
     * 路由
     */
    String route() default "";

    /**
     * 接口名
     */
    String title() default "";

    /**
     * 类目id
     */
    int catId() default 0;
}
