package com.utility.app.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class PasswordCoder {

    public static String decrypt_AES(String ciphertext) throws Exception {
        SecretKey secretKey = getSecretKey_AES("o9szYIOq1rRMiouNhNvaq96lqUvCekxR");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(ciphertext)));
    }
    public static SecretKey getSecretKey_AES(String secretKey) throws Exception {
        byte[] decodeSecretKey = Base64.getDecoder().decode(secretKey);

        return new SecretKeySpec(decodeSecretKey, 0, decodeSecretKey.length, "AES");
    }
}
