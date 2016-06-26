package com.spring.common.utils;


import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class EncryptUtil {

    public static final String KEY_SHA = "SHA";
    public static final String KEY_MD5 = "MD5";
    private final static String KEY_DES = "DES";
    public static final String KEY_HMD5_256 = "HmacSHA256";

    //十六进制下数字到字符的映射数组
    private final static String[] HEXDIGITS = {"0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


    /**
     * HMac256加密
     *
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptHMac256(String content, String key) {

        String resultString = "";
        try {
            // 还原密钥
            SecretKey secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            // 实例化Mac
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            // 初始化mac
            mac.init(secretKey);
            // 执行消息摘要
            byte[] digest = mac.doFinal(content.getBytes());
            resultString = new String(Base64.encode(digest));
        } catch (Exception e) {
            //logger.error("encryptHMac256 fail", e);
        }

        return resultString;
    }


    public static byte[] encryptSHA(String content) throws Exception {

        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(content.getBytes());

        return sha.digest();

    }

    public static byte[] encryptDes(byte[] src, byte[] key) throws Exception {

        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(KEY_DES);
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(src);
    }

    public static byte[] decryptDes(byte[] src, byte[] key) throws Exception {

        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(KEY_DES);
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(src);

    }

    /**
     * 转换字节数组为十六进制字符串
     *
     * @param b
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }
}
