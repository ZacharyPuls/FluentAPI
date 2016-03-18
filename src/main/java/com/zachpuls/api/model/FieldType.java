package com.zachpuls.api.model;

/**
 * Created by zpuls on 3/17/2016.
 */

public class FieldType {

    public static String fromClass(Class<?> clazz) {
        return (clazz == Short.class || clazz == short.class ||
                clazz == Integer.class || clazz == int.class ||
                clazz == Long.class || clazz == long.class ||
                clazz == Float.class || clazz == float.class ||
                clazz == Double.class || clazz == double.class) ?
                "number" : "text";
    }
}
