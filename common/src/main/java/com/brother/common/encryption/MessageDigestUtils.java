package com.brother.common.encryption;

import java.security.MessageDigest;

public class MessageDigestUtils {

    public static String encrypt(String password, String algorithm){
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] b = md.digest(password.getBytes("UTF-8"));

            return ByteUtils.byte2HexString(b);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
