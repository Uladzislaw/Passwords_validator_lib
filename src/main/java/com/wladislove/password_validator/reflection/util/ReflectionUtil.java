package com.wladislove.password_validator.reflection.util;

import java.lang.reflect.Field;

public class ReflectionUtil {
    public static String accessFieldAndGet(final String fieldName,
                                     final Class<?> cl,
                                     final Object o) {
        try {
            Field field = cl.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (String) field.get(o);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(
                    "Field with " + fieldName + " wasn't found.");
        }
    }
}
