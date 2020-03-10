package com.jay.clone.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //어노테이션 생성 위치를 파라미터로 지정.
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    //@interface 로 LoginUser 라는 어노테이션이 생성됨
}
