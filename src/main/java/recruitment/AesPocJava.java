package recruitment;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

class AesPocJava {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        final String password = "uiTestAppSecret";

        SecretKey secret = getSecret(password);

        System.out.println("\n\nEncrypt");
        String encryptedUrlEncoded = encrypt(secret,
                "{" +
//                        "\"firstName\":\"John\"," +
//                        "\"lastName\":\"Doe\"," +
                        "\"phoneCountryCode\":\"48\"," +
                        "\"phoneNumber\":\"504111444\"," +
//                        "\"email\":\"mail@ck.com\"," +
                        "\"verifyPhoneNumber\":false" +
//                        "\"country\":\"no\"" +
//                        "\"lockCountry\":true" +
                        "}");

        System.out.println("\n\nDecrypt");
//        encryptedUrlEncoded = "6gLOfgFq4eL3XD6Fi%2FdnbOjRBTtnKRYyTesaEpgU%2BF1ESNwYCmb5y4D8QOd6t5tg9cxbTQpbM2pWx9lirV8xLe6b9qQGmuHjJGq%2BAvdgbt8%3D";
        String plaintext = decrypt(secret, encryptedUrlEncoded);
    }

    private static SecretKeySpec getSecret(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(UTF_8));
        return new SecretKeySpec(hash, "AES");
    }

    private static String encrypt(SecretKey secret, String textToEncrypt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        byte[] encryptedBytes = cipher.doFinal(textToEncrypt.getBytes(UTF_8));

        final String encryptedString = new String(encryptedBytes, UTF_8);
        System.out.println("Encrypted String : " + encryptedString);

        byte[] encodedBase64 = org.apache.commons.codec.binary.Base64.encodeBase64(encryptedBytes);
        final String encryptedBase64EncodedString = new String(encodedBase64);
        System.out.println("Encrypted Base64 encoded: " + encryptedBase64EncodedString);

        final String urlEncoded = URLEncoder.encode(encryptedBase64EncodedString, UTF_8.name());
        System.out.println("Encrypted String url-encoded: " + urlEncoded);

        return urlEncoded;
    }

    private static String decrypt(SecretKey secret, String encryptedUrlEncoded) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidParameterSpecException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {

        final String encryptedUrlDecoded = URLDecoder.decode(encryptedUrlEncoded, UTF_8.name());
        System.out.println("Encrypted url-decoded: " + encryptedUrlDecoded);

        final byte[] encryptedBytesBase64Encoded = encryptedUrlDecoded.getBytes(UTF_8);
        System.out.println("Encrypted base64 encoded: " + new String(encryptedBytesBase64Encoded, UTF_8));

        byte[] base64Decoded = Base64.getDecoder().decode(encryptedBytesBase64Encoded);
        System.out.println("Encrypted bytes: " + new String(encryptedBytesBase64Encoded, UTF_8));


        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secret);
        String decrypted = new String(cipher.doFinal(base64Decoded), UTF_8);
        System.out.println("Decrypted: " + decrypted);
        return decrypted;
    }
}
