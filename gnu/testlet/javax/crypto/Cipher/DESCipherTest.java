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
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESCipherTest
implements Testlet {
    private static final String ORIGINAL_TEXT_1 = "";
    private static final String ORIGINAL_TEXT_2 = "\u0000";
    private static final String ORIGINAL_TEXT_3 = " ";
    private static final String ORIGINAL_TEXT_4 = "a";
    private static final String ORIGINAL_TEXT_5 = "Hello World!";
    private static final String ORIGINAL_TEXT_6 = "The quick brown fox jumps over the lazy dog";
    private static final String ORIGINAL_TEXT_7 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private static final byte[] EXPECTED_CIPHER_TEXT_1 = new byte[]{-83, 99, -54, -106, -43, -19, -84, -73};
    private static final byte[] EXPECTED_CIPHER_TEXT_2 = new byte[]{-126, 1, -25, -127, 74, -61, 33, 71};
    private static final byte[] EXPECTED_CIPHER_TEXT_3 = new byte[]{28, -97, 127, -57, 126, -102, 4, -101};
    private static final byte[] EXPECTED_CIPHER_TEXT_4 = new byte[]{-26, -92, 74, 54, -92, 105, -40, 119};
    private static final byte[] EXPECTED_CIPHER_TEXT_5 = new byte[]{88, 119, -63, -45, -74, -116, 49, 28, 9, -19, 23, -103, -87, 117, 42, -61};
    private static final byte[] EXPECTED_CIPHER_TEXT_6 = new byte[]{-50, -48, -118, 97, -39, -25, -101, 82, 13, 87, 65, -19, 117, -61, 33, -94, 77, -19, 16, 116, -110, 89, -116, -67, 32, -98, -128, 106, -21, 52, 71, -21, 115, 12, -59, 93, 73, -70, -52, 102, -93, -19, -44, 105, -116, 97, 13, 36};
    private static final byte[] EXPECTED_CIPHER_TEXT_7 = new byte[]{-17, -105, -14, -11, -119, 21, -79, 40, 91, -103, -49, 109, -122, 69, -110, 118, 12, -100, 79, -80, 51, -9, -90, -46, -39, -39, 23, 6, 37, 48, -48, -69, 123, 46, -125, -96, 81, 74, -60, -59, 91, -102, 125, -104, -82, 40, -10, -105, -11, -65, 5, 33, 63, -35, -94, 65, 19, 110, -37, 108, -53, -79, -11, -44, -61, -116, 25, -115, 79, 48, -111, -96, -72, 18, -95, 10, -60, 124, -76, -76, -14, 84, 30, -29, -30, 86, -29, 42, 5, -98, -78, 6, 68, 54, 20, -32, -113, 7, -14, 75, 9, -96, 14, 60, -90, -2, 98, 51, 90, 84, 100, 90, 22, 67, -8, 115, -10, -90, -21, -23, 78, 30, 111, 50, 50, -85, 78, 55, 115, 19, -111, -50, -60, -22, 107, 50, -69, -53, 105, 3, 124, 5, 98, 93, 117, 98, 86, -3, 99, -55, 102, -86, 114, 3, -11, -73, -112, 89, -107, -92, 20, 37, -121, -85, 7, -80, -111, -102, 48, 68, -49, 28, 97, 113, 3, -97, -116, -50, -48, -53, 64, -68, -63, 64, 88, 119, 121, 58, -58, -123, 39, -37, -92, 27, 39, -47, -83, 47, -82, -85, 12, -102, -78, 82, -3, -25, 70, 120, -109, 104, -78, 17, -31, 23, -85, 48, -48, -40, -61, -111, 115, 127, -96, -41, -17, -83, 94, 24, -6, -110, -85, -128, -9, 58, 77, 100, -95, -8, -77, -59, -100, -123, 28, -39, 42, 97, -88, 96, -84, -117, -19, -27, -53, -112, -105, -125, 28, -36, 53, 42, 62, 10, 108, 69, -2, -119, -44, 43, 117, 121, 71, -91, 124, -46, -17, -15, 33, 56, -28, 50, 20, -12, -67, 101, -14, 10, 36, -69, -62, -21, -33, 74, -70, -50, 23, -48, 31, -12, 23, 33, 94, -44, 48, -93, -69, -56, 26, 87, -38, -67, -41, -124, 65, 113, -23, -52, -63, -102, 104, -1, -102, -5, -70, 100, -76, 77, -103, 44, 75, 101, -20, 126, 122, 115, -67, 0, 28, 125, 91, -69, 30, 100, 104, -128, 94, 51, 50, 60, -69, 79, -88, -46, 3, -79, 5, 27, -121, 82, -89, -18, -70, 60, 82, -79, 33, -63, 46, 124, -58, 2, -15, 52, -64, 121, -109, -61, 81, -71, 98, -42, 106, -83, 5, -98, 108, 98, -66, -77, -126, -75, 32, 119, -96, -127, -96, 127, 52, -101, -57, 122, -98, -41, -47, -128, 27, 112, -9, 120, -98, -41, 98, 60, -3, 94, -59, -114, 6, -104, -77, -6, 119, -32, -75, 74, 123, -54, -23, 106, -58, -71, -36, 59, 77, -8, 86, -21, -32, 27, -96, -88, -89, -4, 126, -107, 98, 108, -75, -14};
    private static final String PASSWORD = "nbusr123";

    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        DESKeySpec desKeySpec = new DESKeySpec(PASSWORD.getBytes());
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        return secretKey;
    }

    private static void checkCipher(TestHarness harness, SecretKey secretKey, Cipher des, String originalText, byte[] expectedCipherText) {
        try {
            des.init(1, secretKey);
            byte[] ciphertext = des.doFinal(originalText.getBytes());
            des.init(2, secretKey);
            String cleartext = new String(des.doFinal(ciphertext));
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
            SecretKey secretKey = DESCipherTest.generateSecretKey();
            Cipher des = Cipher.getInstance("DES");
            DESCipherTest.checkCipher(harness, secretKey, des, ORIGINAL_TEXT_1, EXPECTED_CIPHER_TEXT_1);
            DESCipherTest.checkCipher(harness, secretKey, des, ORIGINAL_TEXT_2, EXPECTED_CIPHER_TEXT_2);
            DESCipherTest.checkCipher(harness, secretKey, des, ORIGINAL_TEXT_3, EXPECTED_CIPHER_TEXT_3);
            DESCipherTest.checkCipher(harness, secretKey, des, ORIGINAL_TEXT_4, EXPECTED_CIPHER_TEXT_4);
            DESCipherTest.checkCipher(harness, secretKey, des, ORIGINAL_TEXT_5, EXPECTED_CIPHER_TEXT_5);
            DESCipherTest.checkCipher(harness, secretKey, des, ORIGINAL_TEXT_6, EXPECTED_CIPHER_TEXT_6);
            DESCipherTest.checkCipher(harness, secretKey, des, ORIGINAL_TEXT_7, EXPECTED_CIPHER_TEXT_7);
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

    public boolean isDESCipherAvailable() {
        try {
            Cipher.getInstance("DES");
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
        if (!this.isDESCipherAvailable()) {
            return;
        }
        DESCipherTest.run(harness);
    }

    public static void main(String[] args) throws Exception {
        DESCipherTest.run(null);
    }
}

