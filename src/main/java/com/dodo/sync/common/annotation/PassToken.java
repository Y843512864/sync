package com.dodo.sync.common.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE }) // Target 注解的使用域，FIELD表示使用在属性上面，TYPE表示使用在类上面
@Retention(RetentionPolicy.RUNTIME) // Retention 设置注解的生命周期 ，这里定义为RetentionPolicy.RUNTIME 非常关键
@Documented
public @interface PassToken {
    // 自定义属性
    boolean required();
}