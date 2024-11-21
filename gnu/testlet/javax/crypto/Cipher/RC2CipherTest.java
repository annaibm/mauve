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

public class RC2CipherTest
implements Testlet {
    private static final String ORIGINAL_TEXT_1 = "";
    private static final String ORIGINAL_TEXT_2 = "\u0000";
    private static final String ORIGINAL_TEXT_3 = " ";
    private static final String ORIGINAL_TEXT_4 = "a";
    private static final String ORIGINAL_TEXT_5 = "Hello World!";
    private static final String ORIGINAL_TEXT_6 = "The quick brown fox jumps over the lazy dog";
    private static final String ORIGINAL_TEXT_7 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private static final byte[] EXPECTED_CIPHER_TEXT_1 = new byte[]{75, 66, 67, -51, 31, -20, 63, -16};
    private static final byte[] EXPECTED_CIPHER_TEXT_2 = new byte[]{110, 108, 56, 19, 4, -70, -84, -3};
    private static final byte[] EXPECTED_CIPHER_TEXT_3 = new byte[]{119, -25, 2, -50, 113, -65, -48, -11};
    private static final byte[] EXPECTED_CIPHER_TEXT_4 = new byte[]{26, -106, 35, -20, 105, -80, -124, -33};
    private static final byte[] EXPECTED_CIPHER_TEXT_5 = new byte[]{11, 20, -3, 23, 10, 119, 5, -99, 74, -115, 53, 53, -125, 89, 113, 21};
    private static final byte[] EXPECTED_CIPHER_TEXT_6 = new byte[]{113, -85, 60, -91, 53, 117, 66, 74, -1, 5, -113, 58, 2, 99, -21, -99, -78, -5, 109, 89, 26, 112, -90, -108, 12, -107, -126, -45, -6, -126, 71, 44, -55, 92, -92, 88, -115, 56, -121, -95, -106, -14, -49, -54, -50, 39, 19, -120};
    private static final byte[] EXPECTED_CIPHER_TEXT_7 = new byte[]{-66, 75, -71, -29, 35, -62, -8, -42, 112, -112, -20, -14, -10, -110, -107, -85, -53, -103, 110, 117, 32, -66, 60, 105, -120, -75, 29, 56, 3, 100, 23, -3, -114, -67, -59, 33, -77, 12, -115, -5, -110, 39, 120, -126, 69, 19, 124, -18, 52, -31, -38, -108, 47, 78, 2, 30, 8, -7, -13, 49, 41, 55, -54, 92, 47, 1, 127, 54, 63, -96, -31, -15, 31, -100, -124, 97, 58, 29, 123, 83, 42, 3, 10, 106, 4, 59, -16, -65, 64, -11, -119, 61, -64, -19, -76, 69, 17, -66, 117, -117, -17, -59, 8, -21, -43, 30, -125, 41, 4, 59, -43, 98, -18, 50, 21, -76, 58, -75, -28, 123, -59, -104, 110, -53, 70, 113, -52, 116, -65, 39, 81, 81, 19, -30, 44, 56, 110, -18, -45, 71, 92, -125, 56, 63, 67, 20, 108, 20, -28, 123, 98, 89, -104, 13, 27, 78, 106, -95, 63, 86, 1, -49, -76, 115, -54, 117, -113, -28, 113, -107, 115, 84, 120, -60, -120, 105, 51, 21, -75, -40, 55, 24, -62, -102, 65, -29, -124, -66, 41, -119, 35, -72, 28, 99, -21, 45, -14, 47, 100, 97, -104, -74, -6, 63, -24, -20, -99, 47, 79, 61, 116, 79, -8, 115, -81, -112, -110, 100, -22, -73, -104, -120, 91, 67, 72, 26, -6, 47, -125, 38, -81, -63, 60, -33, 56, -121, -48, 3, -79, -97, -71, 19, -105, -95, 101, -110, -13, -113, 59, -71, -81, -127, -116, -115, -49, 37, 4, -47, 41, -6, 34, 81, -19, -42, -34, 42, -11, -7, -56, 86, 63, 43, -61, -97, -124, -18, 65, -37, 22, 91, -77, -112, 67, 13, 79, -113, 17, -12, 70, 10, -123, 46, 28, -39, -115, -62, 27, -54, 61, 95, 108, 46, 82, -72, 19, -44, -88, -67, 25, -98, 50, -78, 89, 6, 0, -75, 81, -57, -41, 91, 41, 107, -75, -46, -21, -86, -70, -4, -98, -87, -42, -15, 114, 25, 63, -6, 21, 61, 59, 6, 62, 73, 127, -3, 67, -119, -54, 21, 65, 33, 48, 5, -90, 0, 92, -29, 5, -45, -72, -75, 10, -89, -92, -22, 89, 9, 92, 3, -5, 20, 95, -102, -19, -126, -92, 125, -32, -63, -94, 9, 102, 86, 56, 34, 73, 73, 93, -69, -103, 71, 37, -117, 99, 67, -34, -93, -94, 74, 71, 11, -24, 40, 125, 26, -104, -28, -84, 52, 63, 78, -86, 70, 28, -98, 118, -95, -68, 6, -86, -25, -58, -106, 31, -71, 58, -72, 65, -105, -26, 29, -41, -74, 24, 42, 114, 113, -61, 7, -87, 37, -47, 14, -121, 18, -113, -63, -45, -51};
    private static final byte[] RC2_KEY = new byte[]{47, -27, -73, 64, 12, -40, -91, -17, -121, 35, -74, 48, 80, -61, 79, -89};

    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        return new SecretKeySpec(RC2_KEY, "RC2");
    }

    private static void checkCipher(TestHarness harness, SecretKey secretKey, Cipher RC2, String originalText, byte[] expectedCipherText) {
        try {
            RC2.init(1, secretKey);
            byte[] ciphertext = RC2.doFinal(originalText.getBytes());
            RC2.init(2, secretKey);
            String cleartext = new String(RC2.doFinal(ciphertext));
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
            SecretKey secretKey = RC2CipherTest.generateSecretKey();
            Cipher RC2 = Cipher.getInstance("RC2");
            RC2CipherTest.checkCipher(harness, secretKey, RC2, ORIGINAL_TEXT_1, EXPECTED_CIPHER_TEXT_1);
            RC2CipherTest.checkCipher(harness, secretKey, RC2, ORIGINAL_TEXT_2, EXPECTED_CIPHER_TEXT_2);
            RC2CipherTest.checkCipher(harness, secretKey, RC2, ORIGINAL_TEXT_3, EXPECTED_CIPHER_TEXT_3);
            RC2CipherTest.checkCipher(harness, secretKey, RC2, ORIGINAL_TEXT_4, EXPECTED_CIPHER_TEXT_4);
            RC2CipherTest.checkCipher(harness, secretKey, RC2, ORIGINAL_TEXT_5, EXPECTED_CIPHER_TEXT_5);
            RC2CipherTest.checkCipher(harness, secretKey, RC2, ORIGINAL_TEXT_6, EXPECTED_CIPHER_TEXT_6);
            RC2CipherTest.checkCipher(harness, secretKey, RC2, ORIGINAL_TEXT_7, EXPECTED_CIPHER_TEXT_7);
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

    public boolean isRC2CipherAvailable() {
        try {
            Cipher.getInstance("RC2");
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
        if (!this.isRC2CipherAvailable()) {
            return;
        }
        RC2CipherTest.run(harness);
    }

    public static void main(String[] args) throws Exception {
        RC2CipherTest.run(null);
    }
}

