package com.aiblogserver.util;


import java.lang.annotation.*;

/**
 * 对有此注解的方法不进行拦截
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoCheck {
}
