package misc.jwt;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {

    public static String generateSecretKey(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[length];
        secureRandom.nextBytes(keyBytes);
        return Base64.getEncoder().encodeToString(keyBytes);
    }

    public static void main(String[] args) {
        String secretKey = generateSecretKey(32); // 32 байти для HMAC-SHA256
        System.out.println("Generated Secret Key: " + secretKey);
    }
}
