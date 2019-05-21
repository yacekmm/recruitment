package recruitment;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

class AesPocSpring {
    public static void main(String[] args) {
        final String password = "I AM SHERLOCKED";
        final String salt = KeyGenerators.string().generateKey();

        TextEncryptor encryptor = Encryptors.text(password, salt);
        System.out.println("Salt: " + salt);

        String textToEncrypt = "{\n" +
                "            \"firstName\": \"John\",\n" +
                "            \"lastName\": \"Doe\",\n" +
                "            \"birthdate\": \"1987-02-02\",\n" +
                "            \"phoneCountryCode\": \"48\",\n" +
                "            \"phoneNumber\": \"500121333\",\n" +
                "            \"email\": \"very.long.email@address.com\",\n" +
                "            \"region\": \"POLAND\"\n" +
                "        }";
        System.out.println("Original text (len=" + textToEncrypt.length() + "): \"" + textToEncrypt + "\"");

        String encryptedText = encryptor.encrypt(textToEncrypt);
        System.out.println("Encrypted text (len=" + encryptedText.length() + "): \"" + encryptedText + "\"");

        // Could reuse encryptor but wanted to show reconstructing TextEncryptor
        TextEncryptor decryptor = Encryptors.text(password, salt);
        String decryptedText = decryptor.decrypt(encryptedText);
        System.out.println("Decrypted text: \"" + decryptedText + "\"");

        if (textToEncrypt.equals(decryptedText)) {
            System.out.println("Success: decrypted text matches");
        } else {
            System.out.println("Failed: decrypted text does not match");
        }
    }
}