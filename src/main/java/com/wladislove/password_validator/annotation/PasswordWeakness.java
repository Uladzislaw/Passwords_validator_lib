package com.wladislove.password_validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface PasswordWeakness {
    PasswordStrength strength() default PasswordStrength.WEAK;

    int minSymbols() default 2;

    int maxSymbols() default 256;
    enum PasswordStrength {
        WEAK, MEDIUM, HARD, DEVIL
    }
}
