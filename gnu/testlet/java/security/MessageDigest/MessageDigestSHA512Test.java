/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestSHA512Test
implements Testlet {
    private static final byte[] EXPECTED_HASH_1 = new byte[]{-49, -125, -31, 53, 126, -17, -72, -67, -15, 84, 40, 80, -42, 109, -128, 7, -42, 32, -28, 5, 11, 87, 21, -36, -125, -12, -87, 33, -45, 108, -23, -50, 71, -48, -47, 60, 93, -123, -14, -80, -1, -125, 24, -46, -121, 126, -20, 47, 99, -71, 49, -67, 71, 65, 122, -127, -91, 56, 50, 122, -7, 39, -38, 62};
    private static final byte[] EXPECTED_HASH_2 = new byte[]{-72, 36, 77, 2, -119, -127, -42, -109, -81, 123, 69, 106, -8, -17, -92, -54, -42, 61, 40, 46, 25, -1, 20, -108, 44, 36, 110, 80, -39, 53, 29, 34, 112, 74, -128, 42, 113, -61, 88, 11, 99, 112, -34, 76, -21, 41, 60, 50, 74, -124, 35, 52, 37, 87, -44, -27, -61, -124, 56, -16, -29, 105, 16, -18};
    private static final byte[] EXPECTED_HASH_3 = new byte[]{-7, 13, -35, 119, -28, 0, -33, -26, -93, -4, -12, 121, -80, 11, 30, -30, -98, 112, 21, -59, -69, -116, -41, 15, 95, 21, -76, -120, 108, -61, 57, 39, 95, -11, 83, -4, -118, 5, 63, -115, -36, 115, 36, -12, 81, 104, -49, -6, -8, 31, -116, 58, -55, 57, -106, -10, 83, 110, -17, 56, -27, -28, 7, 104};
    private static final byte[] EXPECTED_HASH_4 = new byte[]{31, 64, -4, -110, -38, 36, 22, -108, 117, 9, 121, -18, 108, -11, -126, -14, -43, -41, -46, -114, 24, 51, 93, -32, 90, -68, 84, -48, 86, 14, 15, 83, 2, -122, 12, 101, 43, -16, -115, 86, 2, 82, -86, 94, 116, 33, 5, 70, -13, 105, -5, -69, -50, -116, 18, -49, -57, -107, 123, 38, 82, -2, -102, 117};
    private static final byte[] EXPECTED_HASH_5 = new byte[]{-22, -14, -63, 39, 66, -53, -116, 22, 27, -53, -40, 75, 3, 43, -101, -71, -119, -103, -94, 50, -126, 84, 38, 114, -54, 1, -52, 110, -35, 38, -113, 125, -50, -103, -121, -83, 107, 43, -57, -109, 5, 99, 79, -119, -39, 11, -112, 16, 43, -51, 89, -91, 126, 113, 53, -72, -29, -50, -71, 60, 5, -105, 17, 123};
    private static final byte[] EXPECTED_HASH_6 = new byte[]{-10, -51, -30, -96, -8, 25, 49, 76, -35, -27, 95, -62, 39, -40, -41, -38, -29, -46, -116, -59, 86, 34, 42, 10, -118, -42, 109, -111, -52, -83, 74, -83, 96, -108, -11, 23, -94, 24, 35, 96, -55, -86, -49, 106, 61, -61, 35, 22, 44, -74, -3, -116, -33, -2, -37, 15, -32, 56, -11, 94, -123, -1, -75, -74};
    private static final byte[] EXPECTED_HASH_7 = new byte[]{40, 49, -63, 47, 110, 71, -93, 76, 10, 72, -33, 79, -4, -71, 119, 55, -113, -35, 23, 110, -95, 8, 62, 16, -102, -92, 33, 113, -18, 25, -68, -70, -124, 50, 75, 11, 109, 55, -98, 13, -117, 19, 106, 33, -113, -68, 90, 63, 89, -43, -57, 103, 101, 83, 72, -65, 9, -84, 37, 73, -106, 43, -44, -23};
    private static final byte[] EXPECTED_HASH_8 = new byte[]{-12, 29, -110, -68, -97, -63, 21, 122, 13, 19, -121, -26, 127, 61, 8, -109, -73, 15, 112, 57, -45, -44, 109, -127, 21, -75, 7, -99, 69, -83, 96, 17, 89, 57, -116, 121, -62, -127, 104, 30, 45, -96, -101, -9, -39, -8, -62, 59, 65, -47, -96, -93, -59, -75, 40, -89, -14, 115, 89, 51, -92, 53, 49, -108};

    private static byte[] generateHash(TestHarness harness, String algorithmName, String text2) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithmName);
        harness.check(md != null);
        md.update(text2.getBytes());
        byte[] digest = md.digest();
        harness.check(digest != null);
        harness.check(digest.length, 64);
        return digest;
    }

    private void dotest(TestHarness harness, String algorithmName, byte[] expectedHash, String text2) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigestSHA512Test.generateHash(harness, algorithmName, text2);
        for (int i = 0; i < digest.length; ++i) {
            if (digest[i] == expectedHash[i]) continue;
            harness.fail("Difference found at offset " + i);
        }
    }

    private void run(TestHarness harness) throws NoSuchAlgorithmException {
        this.dotest(harness, "SHA-512", EXPECTED_HASH_1, "");
        this.dotest(harness, "SHA-512", EXPECTED_HASH_2, "\u0000");
        this.dotest(harness, "SHA-512", EXPECTED_HASH_3, " ");
        this.dotest(harness, "SHA-512", EXPECTED_HASH_4, "a");
        this.dotest(harness, "SHA-512", EXPECTED_HASH_5, "text");
        this.dotest(harness, "SHA-512", EXPECTED_HASH_6, "Hello world!");
        this.dotest(harness, "SHA-512", EXPECTED_HASH_7, "Even longer text...");
        this.dotest(harness, "SHA-512", EXPECTED_HASH_8, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    @Override
    public void test(TestHarness harness) {
        if (!this.isSHA512Available()) {
            return;
        }
        try {
            this.run(harness);
        }
        catch (NoSuchAlgorithmException e) {
            harness.fail("Fail for algorithm SHA512.");
            harness.debug(e);
        }
    }

    public boolean isSHA512Available() {
        try {
            MessageDigest.getInstance("SHA-512");
        }
        catch (NoSuchAlgorithmException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            new MessageDigestSHA512Test().run(null);
            System.out.println("OK");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
    }
}

