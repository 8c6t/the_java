package com.hachicore;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD })
@Inherited
public @interface MyAnnotation {

    // String name();
    // String name() default "hachicore";
    String value() default "hachicore";

    // int number();
    int number() default 8620;

}
