package com.alyas20.projectbased.core.security.securityUtil.encryption;


import com.alyas20.projectbased.core.security.exception.EncryptErrorException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES256Encryption {
    private static final String AES = "AES";
    private static final String HASH_ALGORITHM = "SHA-256";

    private AES256Encryption() {
        throw new IllegalStateException("Utility class");
    }

    public static String encrypt(String password, String salt) throws EncryptErrorException {
        try {
            byte[] key = deriveKey(password, salt);
            SecretKey secretKey = new SecretKeySpec(key, AES);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new EncryptErrorException(e.getMessage(), e);
        }
    }

    /**
     * NOTE: This one is suggestion by chatGPT. The real calculation is above.
     */

//    public static String encrypt(String data, String password, String salt) throws Exception {
//        byte[] key = deriveKey(password, salt);
//        SecretKey secretKey = new SecretKeySpec(key, AES);
//        Cipher cipher = Cipher.getInstance(AES);
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
//        return Base64.getEncoder().encodeToString(encryptedBytes);
//    }

//    public static String decrypt(String encryptedData, String password, String salt) throws Exception {
//        byte[] key = deriveKey(password, salt);
//        SecretKey secretKey = new SecretKeySpec(key, AES);
//        Cipher cipher = Cipher.getInstance(AES);
//        cipher.init(Cipher.DECRYPT_MODE, secretKey);
//        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
//        return new String(decryptedBytes);
//    }
    private static byte[] deriveKey(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        md.update((password + salt).getBytes());
        return md.digest();
    }
}