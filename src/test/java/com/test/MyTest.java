package com.test;



import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;


public class MyTest {

    /**
     * 加密
     *
     * @param key
     * @param text
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(Key key, String text) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(text.getBytes());
    }

    /**
     * 解密
     *
     * @param key
     * @param text
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(Key key, byte[] bt) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(bt);
    }
    /**
     * @return
     * @throws Exception
     */
    public static Key keyGenerator() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }



    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Key key = keyGenerator();
        System.out.println("Key : " + Base64Utils.encode(key.getEncoded()));
        String src = "/system/";
        byte[] target = encrypt(key, src);
        System.out.println("密文： " + Base64Utils.encode(target));
        System.out.println("明文： " + new String(decrypt(key, target)));
    }
}