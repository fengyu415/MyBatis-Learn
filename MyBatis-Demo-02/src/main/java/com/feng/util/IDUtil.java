package com.feng.util;

import java.util.UUID;

public class IDUtil {

    public static   String getId()
    {
        return    UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }
}
