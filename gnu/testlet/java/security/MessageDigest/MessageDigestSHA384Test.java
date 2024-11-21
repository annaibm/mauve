/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestSHA384Test
implements Testlet {
    private static final byte[] EXPECTED_HASH_1 = new byte[]{56, -80, 96, -89, 81, -84, -106, 56, 76, -39, 50, 126, -79, -79, -29, 106, 33, -3, -73, 17, 20, -66, 7, 67, 76, 12, -57, -65, 99, -10, -31, -38, 39, 78, -34, -65, -25, 111, 101, -5, -43, 26, -46, -15, 72, -104, -71, 91};
    private static final byte[] EXPECTED_HASH_2 = new byte[]{-66, -64, 33, -76, -13, 104, -29, 6, -111, 52, -32, 18, -62, -76, 48, 112, -125, -45, -87, -67, -46, 6, -30, 78, 95, 13, -122, -31, 61, 102, 54, 101, 89, 51, -20, 43, 65, 52, 101, -106, 104, 23, -87, -62, 8, -95, 23, 23};
    private static final byte[] EXPECTED_HASH_3 = new byte[]{88, -128, 22, -21, 16, 4, 93, -40, 88, 52, -42, 125, 24, 125, 107, -105, -123, -113, 56, -59, -116, 105, 3, 32, -60, -90, 78, 12, 47, -110, -18, -67, -97, 27, -41, 77, -30, 86, -24, 38, -120, 21, -112, 81, 89, 68, -107, 102};
    private static final byte[] EXPECTED_HASH_4 = new byte[]{84, -91, -101, -97, 34, -80, -72, 8, -128, -40, 66, 126, 84, -117, 124, 35, -85, -40, 115, 72, 110, 31, 3, 93, -50, -100, -42, -105, -24, 81, 117, 3, 60, -86, -120, -26, -43, 123, -61, 94, -6, -32, -75, -81, -45, 20, 95, 49};
    private static final byte[] EXPECTED_HASH_5 = new byte[]{49, 58, 126, 51, 34, -84, 101, 92, 39, 107, 58, 10, -98, 107, 39, -60, 72, -59, 112, 123, 27, 14, 32, 3, 123, 66, -85, 119, 97, -70, 37, 22, 47, 118, 89, -44, -1, -31, -22, -3, -103, 102, 32, 76, 27, 65, -5, 115};
    private static final byte[] EXPECTED_HASH_6 = new byte[]{-122, 37, 95, -94, -61, 110, 75, 48, -106, -98, -82, 23, -36, 52, -57, 114, -53, -21, -33, -59, -117, 88, 64, 57, 0, -66, -121, 97, 78, -79, -93, 75, -121, -128, 38, 63, 37, 94, -75, -26, 92, -87, -69, -72, 100, 28, -52, -2};
    private static final byte[] EXPECTED_HASH_7 = new byte[]{-53, -61, -36, 19, 26, -25, -17, 46, -52, 89, 32, 78, -119, -105, -67, -7, -30, -65, 72, 54, -38, 33, 36, 66, 72, 62, 110, 17, -48, 58, -124, -6, 104, -58, -115, 100, -35, 106, 97, -75, 112, -118, -114, 92, -10, -100, 86, -85};
    private static final byte[] EXPECTED_HASH_8 = new byte[]{99, -104, 15, -48, 66, 92, -46, -61, -40, -92, 0, -18, 15, 38, 113, -17, 19, 93, -80, 59, -108, 126, -63, -81, 33, -74, -30, -113, 25, -63, 108, -94, 114, 3, 100, 105, 84, 31, 77, -114, 51, 106, -58, -47, -38, 80, 88, 15};

    private static byte[] generateHash(TestHarness harness, String algorithmName, String text2) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithmName);
        harness.check(md != null);
        md.update(text2.getBytes());
        byte[] digest = md.digest();
        harness.check(digest != null);
        harness.check(digest.length, 48);
        return digest;
    }

    private void dotest(TestHarness harness, String algorithmName, byte[] expectedHash, String text2) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigestSHA384Test.generateHash(harness, algorithmName, text2);
        for (int i = 0; i < digest.length; ++i) {
            if (digest[i] == expectedHash[i]) continue;
            harness.fail("Difference found at offset " + i);
        }
    }

    private void run(TestHarness harness) throws NoSuchAlgorithmException {
        this.dotest(harness, "SHA-384", EXPECTED_HASH_1, "");
        this.dotest(harness, "SHA-384", EXPECTED_HASH_2, "\u0000");
        this.dotest(harness, "SHA-384", EXPECTED_HASH_3, " ");
        this.dotest(harness, "SHA-384", EXPECTED_HASH_4, "a");
        this.dotest(harness, "SHA-384", EXPECTED_HASH_5, "text");
        this.dotest(harness, "SHA-384", EXPECTED_HASH_6, "Hello world!");
        this.dotest(harness, "SHA-384", EXPECTED_HASH_7, "Even longer text...");
        this.dotest(harness, "SHA-384", EXPECTED_HASH_8, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    @Override
    public void test(TestHarness harness) {
        if (!this.isSHA384Available()) {
            return;
        }
        try {
            this.run(harness);
        }
        catch (NoSuchAlgorithmException e) {
            harness.fail("Fail for algorithm SHA384.");
            harness.debug(e);
        }
    }

    public boolean isSHA384Available() {
        try {
            MessageDigest.getInstance("SHA-384");
        }
        catch (NoSuchAlgorithmException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            new MessageDigestSHA384Test().run(null);
            System.out.println("OK");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
    }
}

