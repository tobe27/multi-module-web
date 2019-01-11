package com.example.common.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author Created by L.C.Y on 2018-11-26
 */
public class MD5Util {
    private static final String SALT = "com.example";

    private MD5Util(){}

    /**
     * 生成加盐MD5
     * @param initValue 初始值
     * @return 加盐后的MD5
     */
    public static String create(String initValue) {
        return new Md5Hash(initValue, SALT).toString();
    }

    /**
     * 校验初始值与加盐MD5是否相等
     * @param saltMD5 加盐后的MD5
     * @param initValue 初始值
     * @return boolean
     */
    public static boolean verify(String saltMD5, String initValue) {
        return saltMD5.equals(create(initValue));
    }
}
