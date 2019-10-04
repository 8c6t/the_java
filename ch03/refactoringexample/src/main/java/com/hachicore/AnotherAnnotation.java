package com.hachicore;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AnotherAnnotation {

    String value() default "hibiki";

    int number() default 58620;

}
