package com.example.manageruniversity.common.string;

import com.example.manageruniversity.common.object.ObjectUtils;

public class StringUtils {
    public static boolean isEmpty(String val) {
        if(ObjectUtils.isNull(val) || val.isEmpty() || val.isBlank()) {
            return true;
        }
        return false;
    }

    public static boolean startWithIgnoreCase(String parent, String children) {
        return parent.trim()
                .toLowerCase()
                .startsWith(children.trim().toLowerCase());
    }

    public static boolean containsIgnoreCase(
            String parent,
            String children
    ) {
        return parent.trim().toLowerCase()
                .contains(children.trim().toLowerCase());
    }
}
