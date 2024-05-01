package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * When continuously perform hash(hash(hash...(hash(something))...)) - is it possible to get the same hash?
 */
public class HashOfHash {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        String currentHash = "";

        Function<byte[], String> md5Function = h -> bytesToHex(digest.digest(h));

        Set<String> hashes = new HashSet<>();
        boolean added;
        do {
            added = hashes.add(currentHash = hashFromHashcode(md5Function, currentHash.getBytes()));
            System.out.println("Current hash: " + currentHash);
        } while (added);

        System.out.println("Duplicate found: " + bytesToHex(currentHash.getBytes()));
    }

    private static String hashFromHashcode(Function<byte[], String> func, byte[] h) {
        return func.apply(h);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
