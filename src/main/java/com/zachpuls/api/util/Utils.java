package com.zachpuls.api.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by zpuls on 3/22/2016.
 */

public class Utils {
    public static String parseName(String id) {
        return StringUtils.capitalize(StringUtils.join(id.split("(?=\\p{Upper})"), " "));
    }
}
