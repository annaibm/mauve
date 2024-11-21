/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.crypto.Cipher;

import gnu.testlet.TestHarness;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class RC4CipherTest {
    private static final String ORIGINAL_TEXT_1 = "";
    private static final String ORIGINAL_TEXT_2 = "\u0000";
    private static final String ORIGINAL_TEXT_3 = " ";
    private static final String ORIGINAL_TEXT_4 = "a";
    private static final String ORIGINAL_TEXT_5 = "Hello World!";
    private static final String ORIGINAL_TEXT_6 = "The quick brown fox jumps over the lazy dog";
    private static final String ORIGINAL_TEXT_7 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private static final byte[] EXPECTED_CIPHER_TEXT_1 = new byte[0];
    private static final byte[] EXPECTED_CIPHER_TEXT_2 = new byte[]{-107};
    private static final byte[] EXPECTED_CIPHER_TEXT_3 = new byte[]{-75};
    private static final byte[] EXPECTED_CIPHER_TEXT_4 = new byte[]{-12};
    private static final byte[] EXPECTED_CIPHER_TEXT_5 = new byte[]{-35, 126, 52, 114, 111, 94, 34, 29, 96, 62, 82, 27};
    private static final byte[] EXPECTED_CIPHER_TEXT_6 = new byte[]{-63, 115, 61, 62, 113, 11, 28, 17, 121, 114, 84, 72, -120, 81, -57, -116, 73, -121, -105, -112, 126, 43, -21, 31, -114, 124, 111, 99, 37, 22, 12, -72, -62, 39, 25, -39, 95, 15, -111, 98, -88, 39, 65};
    private static final byte[] EXPECTED_CIPHER_TEXT_7 = new byte[]{-39, 116, 42, 123, 109, 94, 28, 2, 97, 39, 91, 26, -125, 73, -59, -61, 93, -56, -100, -39, 96, 126, -25, 2, -104, 40, 44, 53, 35, 11, 66, -65, -49, 33, 77, -48, 74, 0, -102, 98, -83, 44, 79, 12, -94, 25, 78, -100, 30, 19, 5, 11, -112, -127, -77, 61, -38, 84, 43, -27, -29, 82, -50, -29, 111, 69, 7, -65, -105, 82, 16, -65, -1, -39, 110, 16, -107, -86, 60, 126, -76, -128, 81, 75, -29, -92, -22, 42, -73, 17, 94, -10, -104, 3, -28, -32, 31, -112, -28, 40, -59, 0, -33, -51, 32, 82, 7, -13, 14, 98, 123, 86, -95, 104, -120, 53, -45, -62, 45, 76, -124, -107, -35, -6, -26, -89, -80, 112, -111, 65, 78, 44, 101, 38, 7, -55, -124, -52, -65, -89, -123, 41, -107, -120, -117, 95, 126, 24, -36, 50, -33, 64, -44, 65, 56, 52, -108, 26, -98, -128, -94, 84, -122, -24, -109, -12, -10, 115, -114, -15, 17, -30, -106, 106, -78, 87, 41, -91, 88, -9, 35, 89, 99, 40, 41, 17, -2, -33, -91, 21, -46, -78, -43, 0, 27, -28, -18, -118, -84, 29, -101, -95, -2, -91, 77, 98, -37, -24, 90, 122, -25, -123, 78, 100, 56, 106, 100, -86, -44, 83, 98, 100, -100, -65, 127, 70, 94, 101, 120, 118, 12, -52, 93, -4, 112, 124, 45, -110, 77, 81, -8, -3, -33, 46, -66, 1, 81, -110, -27, -128, 17, 116, 21, -95, 1, -47, 43, 70, 68, 12, -59, 40, -25, -16, -76, 70, -126, -49, -128, 66, -95, -21, -91, 114, 9, -36, 8, -128, 37, -6, -28, 3, 90, 78, -45, -28, 82, -47, 32, 103, -86, -51, -25, -72, 2, -88, 17, -9, 19, 66, -12, -76, 105, 11, 55, -27, -7, -38, 68, -19, 43, 105, 62, 106, -31, -45, 81, 33, 73, 10, -45, -17, -10, -23, 25, -52, 123, -57, 75, 90, -74, -103, 62, 29, 61, -72, 96, 36, 42, 106, 50, -118, 43, -51, 53, -74, -65, 57, 93, -30, -96, -110, 74, -114, -110, 105, 92, -95, 85, -26, -65, 11, 24, 91, 34, 51, 109, 45, 111, -8, -82, 78, 88, 109, -25, 55, 1, 57, -18, 4, 75, -115, -100, 119, -77, 77, 81, -24, -55, 38, 20, 16, -8, 15, -75, -46, 4, 48, 4, 37, -99, -95, 65, -83, 120, -19, -78, -6, -70, 99, 10, 60, -128, -87, -47, 94, 3, 15, 91, 120, 101, 61, 11, -15, -116, 6, 45, 34, 82, 112, 58, -89, 15, -31, 122, 13, 63, 117, 37, 22, -34, -53, 8, -102, 12, -72};
    private static final byte[] RC4_KEY = new byte[]{47, -27, -73, 64, 12, -40, -91, -17, -121, 35, -74, 48, 80, -61, 79, -89};

    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        return new SecretKeySpec(RC4_KEY, "RC4");
    }

    private static void checkCipher(TestHarness harness, SecretKey secretKey, Cipher rc4, String originalText, byte[] expectedCipherText) {
        try {
            rc4.init(1, secretKey);
            byte[] ciphertext = rc4.doFinal(originalText.getBytes());
            rc4.init(2, secretKey);
            String cleartext = new String(rc4.doFinal(ciphertext));
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
            SecretKey secretKey = RC4CipherTest.generateSecretKey();
            Cipher RC4 = Cipher.getInstance("RC4");
            RC4CipherTest.checkCipher(harness, secretKey, RC4, ORIGINAL_TEXT_1, EXPECTED_CIPHER_TEXT_1);
            RC4CipherTest.checkCipher(harness, secretKey, RC4, ORIGINAL_TEXT_2, EXPECTED_CIPHER_TEXT_2);
            RC4CipherTest.checkCipher(harness, secretKey, RC4, ORIGINAL_TEXT_3, EXPECTED_CIPHER_TEXT_3);
            RC4CipherTest.checkCipher(harness, secretKey, RC4, ORIGINAL_TEXT_4, EXPECTED_CIPHER_TEXT_4);
            RC4CipherTest.checkCipher(harness, secretKey, RC4, ORIGINAL_TEXT_5, EXPECTED_CIPHER_TEXT_5);
            RC4CipherTest.checkCipher(harness, secretKey, RC4, ORIGINAL_TEXT_6, EXPECTED_CIPHER_TEXT_6);
            RC4CipherTest.checkCipher(harness, secretKey, RC4, ORIGINAL_TEXT_7, EXPECTED_CIPHER_TEXT_7);
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

    public boolean isRC4CipherAvailable() {
        try {
            Cipher.getInstance("RC4");
        }
        catch (NoSuchAlgorithmException e) {
            return false;
        }
        catch (NoSuchPaddingException e) {
            return false;
        }
        return true;
    }

    public void test(TestHarness harness) {
        if (!this.isRC4CipherAvailable()) {
            return;
        }
        RC4CipherTest.run(harness);
    }

    public static void main(String[] args) throws Exception {
        RC4CipherTest.run(null);
    }
}

