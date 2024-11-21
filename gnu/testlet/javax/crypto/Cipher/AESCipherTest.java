/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.crypto.Cipher;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESCipherTest
implements Testlet {
    private static final String ORIGINAL_TEXT_1 = "";
    private static final String ORIGINAL_TEXT_2 = "\u0000";
    private static final String ORIGINAL_TEXT_3 = " ";
    private static final String ORIGINAL_TEXT_4 = "a";
    private static final String ORIGINAL_TEXT_5 = "Hello World!";
    private static final String ORIGINAL_TEXT_6 = "The quick brown fox jumps over the lazy dog";
    private static final String ORIGINAL_TEXT_7 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private static final byte[] EXPECTED_CIPHER_TEXT_1 = new byte[]{-40, -94, -41, -74, 112, 15, 97, -116, -121, -10, -46, -8, 77, -18, -64, -115};
    private static final byte[] EXPECTED_CIPHER_TEXT_2 = new byte[]{-70, 121, 44, 117, 39, 56, -127, 49, -124, 29, 105, 119, -40, -115, 20, -67};
    private static final byte[] EXPECTED_CIPHER_TEXT_3 = new byte[]{-44, -85, 41, 49, -94, -119, -105, 67, 81, 114, 70, -90, 115, 6, -94, 110};
    private static final byte[] EXPECTED_CIPHER_TEXT_4 = new byte[]{62, -26, 78, -123, -12, -22, 78, 96, -38, -112, 60, -29, -107, -94, -23, -78};
    private static final byte[] EXPECTED_CIPHER_TEXT_5 = new byte[]{79, -126, 13, -118, -74, 87, 64, 11, 14, -40, 113, 13, 102, -46, -121, 15};
    private static final byte[] EXPECTED_CIPHER_TEXT_6 = new byte[]{81, -124, 33, 67, -61, 34, 53, -48, -103, -49, 91, 39, 99, -128, 48, 85, 67, -61, -20, 40, 10, -102, 88, 123, 70, -93, 27, 126, -18, 98, -37, 7, -122, -72, -103, -52, -89, 89, 53, -35, -8, -85, 47, 77, -66, 104, -114, 31};
    private static final byte[] EXPECTED_CIPHER_TEXT_7 = new byte[]{-76, -85, 54, -4, 64, 20, -27, 7, 54, -52, 33, 16, 79, -86, 52, -53, -87, 30, -49, 49, -17, 110, 93, 58, 84, -58, -6, 20, -19, 19, 84, -82, -71, 127, -100, -66, -46, 91, -101, 109, 72, 123, 4, -5, 76, -76, 74, 94, 19, -43, -100, -32, -19, 104, -124, -106, -46, 32, 52, -125, 16, -126, 62, 19, 3, -57, 0, 110, 10, 53, -21, -44, 65, 29, -52, 25, 41, -108, 57, 123, -67, 49, 73, 72, -8, 28, 19, 69, -11, -128, 118, -53, -124, -41, -67, -25, -4, 3, 102, 32, 55, 81, 72, 90, 118, -78, 41, -101, 39, -84, -5, 96, 54, 89, -79, 67, -23, 121, 114, -60, 100, 104, 6, -61, -83, -52, -89, 25, -12, -112, 125, 38, -124, -53, -70, 32, -35, 84, -73, -71, 106, 123, -24, -69, 96, -27, 71, -68, -41, 73, -68, 17, -37, 120, -21, -42, -115, 45, 6, 80, -81, -27, 13, 60, 30, -21, -50, -37, -121, -95, -104, -57, 24, 84, -55, 51, -52, 5, -61, -77, 75, 85, 117, -18, 59, -69, 9, -116, -60, -40, 33, -109, 2, -81, -100, -50, 51, 21, 120, -96, 111, 121, -41, 120, -62, 68, -85, 46, -125, -36, -124, -60, -123, 44, -34, 110, 46, -67, -51, 67, 65, 24, 18, -14, 80, 69, -31, -84, 60, 111, 113, 103, -70, -115, 107, -51, 90, -92, 35, -46, -104, -91, 13, 4, 96, 75, -15, 105, 29, -80, 22, -39, 60, -117, -93, 0, -60, 70, 67, -57, 67, -64, -60, 74, -89, 58, -11, 14, -68, -44, -63, 91, -99, 125, 35, -11, -53, -22, -116, -101, 87, 99, -10, 9, -44, -82, -121, 85, 10, -28, -51, -72, -61, -54, -25, -88, -101, -88, -64, 37, -36, -49, -119, -122, -37, -2, 77, -29, -126, -114, 54, -85, -50, -70, -5, -105, 127, -99, -21, -33, 74, -78, -98, -31, -64, -79, -47, -72, 44, -50, -38, -58, -72, 89, 31, 85, -67, 112, 12, -10, 86, -24, -19, -89, 86, -119, 75, 71, -50, 28, -31, 20, -110, 38, 27, 3, -106, 110, -14, -2, -9, 91, -58, 63, 117, -34, 110, -124, -51, 14, -112, 79, 83, 103, -30, -31, -60, -64, 110, 10, -115, -37, -9, 18, 38, 71, 110, 106, 99, 6, 78, 51, -47, 78, -42, 65, -26, 93, -96, 40, -45, -112, -3, -2, 9, -47, 107, -24, 92, 36, 38, -86, -40, -89, 41, 85, 32, -110, 73, 116, -97, -92, -76, -110, 7, -23, 6, -121, 65, 123, -5, 19, -88, -62, -40, 1, -38, -98, 31, -30, 61, 83, -63, -80, -11, 67, -101, -23};
    private static final String PASSWORD = "nbusr123nbusr123";

    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        return new SecretKeySpec(PASSWORD.getBytes(), 0, 16, "AES");
    }

    private static void checkCipher(TestHarness harness, SecretKey secretKey, Cipher aes, String originalText, byte[] expectedCipherText) {
        try {
            aes.init(1, secretKey);
            byte[] ciphertext = aes.doFinal(originalText.getBytes());
            aes.init(2, secretKey);
            String cleartext = new String(aes.doFinal(ciphertext));
            for (int i = 0; i < expectedCipherText.length; ++i) {
                if (expectedCipherText[i] == ciphertext[i]) continue;
                harness.fail("cipher text differ at index " + i);
            }
            if (!originalText.equals(cleartext)) {
                harness.fail("Decrypted text is different from the original!");
            }
        }
        catch (InvalidKeyException e) {
            harness.fail("Failure: " + e.getMessage());
            harness.debug(e);
        }
        catch (IllegalBlockSizeException e) {
            harness.fail("Failure: " + e.getMessage());
            harness.debug(e);
        }
        catch (BadPaddingException e) {
            harness.fail("Failure: " + e.getMessage());
            harness.debug(e);
        }
    }

    private static void printCipherTest(byte[] ciphertext) {
        for (int i = 0; i < ciphertext.length; ++i) {
            System.out.format("(byte)0x%02x, ", ciphertext[i]);
            if ((i + 1) % 8 != 0) continue;
            System.out.println();
        }
    }

    private static void run(TestHarness harness) {
        try {
            SecretKey secretKey = AESCipherTest.generateSecretKey();
            Cipher aes = Cipher.getInstance("AES");
            AESCipherTest.checkCipher(harness, secretKey, aes, ORIGINAL_TEXT_1, EXPECTED_CIPHER_TEXT_1);
            AESCipherTest.checkCipher(harness, secretKey, aes, ORIGINAL_TEXT_2, EXPECTED_CIPHER_TEXT_2);
            AESCipherTest.checkCipher(harness, secretKey, aes, ORIGINAL_TEXT_3, EXPECTED_CIPHER_TEXT_3);
            AESCipherTest.checkCipher(harness, secretKey, aes, ORIGINAL_TEXT_4, EXPECTED_CIPHER_TEXT_4);
            AESCipherTest.checkCipher(harness, secretKey, aes, ORIGINAL_TEXT_5, EXPECTED_CIPHER_TEXT_5);
            AESCipherTest.checkCipher(harness, secretKey, aes, ORIGINAL_TEXT_6, EXPECTED_CIPHER_TEXT_6);
            AESCipherTest.checkCipher(harness, secretKey, aes, ORIGINAL_TEXT_7, EXPECTED_CIPHER_TEXT_7);
        }
        catch (InvalidKeyException e) {
            harness.fail("Failure: " + e.getMessage());
            harness.debug(e);
        }
        catch (NoSuchAlgorithmException e) {
            harness.fail("Failure: " + e.getMessage());
            harness.debug(e);
        }
        catch (InvalidKeySpecException e) {
            harness.fail("Failure: " + e.getMessage());
            harness.debug(e);
        }
        catch (NoSuchPaddingException e) {
            harness.fail("Failure: " + e.getMessage());
            harness.debug(e);
        }
    }

    public boolean isAESCipherAvailable() {
        try {
            Cipher.getInstance("AES");
        }
        catch (NoSuchAlgorithmException e) {
            return false;
        }
        catch (NoSuchPaddingException e) {
            return false;
        }
        return true;
    }

    @Override
    public void test(TestHarness harness) {
        if (!this.isAESCipherAvailable()) {
            return;
        }
        AESCipherTest.run(harness);
    }

    public static void main(String[] args) throws Exception {
        AESCipherTest.run(null);
    }
}

