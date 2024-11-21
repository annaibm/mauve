/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestSHA256Test
implements Testlet {
    private static final byte[] EXPECTED_HASH_1 = new byte[]{-29, -80, -60, 66, -104, -4, 28, 20, -102, -5, -12, -56, -103, 111, -71, 36, 39, -82, 65, -28, 100, -101, -109, 76, -92, -107, -103, 27, 120, 82, -72, 85};
    private static final byte[] EXPECTED_HASH_2 = new byte[]{110, 52, 11, -100, -1, -77, 122, -104, -100, -91, 68, -26, -69, 120, 10, 44, 120, -112, 29, 63, -77, 55, 56, 118, -123, 17, -93, 6, 23, -81, -96, 29};
    private static final byte[] EXPECTED_HASH_3 = new byte[]{54, -87, -25, -15, -55, 91, -126, -1, -71, -105, 67, -32, -59, -60, -50, -107, -40, 60, -102, 67, 10, -84, 89, -8, 78, -13, -53, -6, -74, 20, 80, 104};
    private static final byte[] EXPECTED_HASH_4 = new byte[]{-54, -105, -127, 18, -54, 27, -67, -54, -6, -62, 49, -77, -102, 35, -36, 77, -89, -122, -17, -8, 20, 124, 78, 114, -71, -128, 119, -123, -81, -18, 72, -69};
    private static final byte[] EXPECTED_HASH_5 = new byte[]{-104, 45, -98, 62, -71, -106, -11, 89, -26, 51, -12, -47, -108, -34, -13, 118, 29, -112, -97, 90, 59, 100, 125, 26, -123, 31, -22, -42, 124, 50, -55, -47};
    private static final byte[] EXPECTED_HASH_6 = new byte[]{-64, 83, 94, 75, -30, -73, -97, -3, -109, 41, 19, 5, 67, 107, -8, -119, 49, 78, 74, 63, -82, -64, 94, -49, -4, -69, 125, -13, 26, -39, -27, 26};
    private static final byte[] EXPECTED_HASH_7 = new byte[]{21, -23, -58, 11, 69, 61, 15, 31, -110, 11, -73, 20, -12, 97, 5, -117, 20, 25, 27, -73, -2, -23, -45, 19, 17, -57, -127, -1, 127, 74, -90, -104};
    private static final byte[] EXPECTED_HASH_8 = new byte[]{44, 124, 61, 95, 36, 79, 26, 64, 6, -102, 50, 34, 66, 21, -32, -49, -101, 66, 72, 92, -103, -40, 15, 53, 125, 118, -16, 6, 53, -100, 122, 24};

    private static byte[] generateHash(TestHarness harness, String algorithmName, String text2) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithmName);
        harness.check(md != null);
        md.update(text2.getBytes());
        byte[] digest = md.digest();
        harness.check(digest != null);
        harness.check(digest.length, 32);
        return digest;
    }

    private void dotest(TestHarness harness, String algorithmName, byte[] expectedHash, String text2) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigestSHA256Test.generateHash(harness, algorithmName, text2);
        for (int i = 0; i < digest.length; ++i) {
            if (digest[i] == expectedHash[i]) continue;
            harness.fail("Difference found at offset " + i);
        }
    }

    private void run(TestHarness harness) throws NoSuchAlgorithmException {
        this.dotest(harness, "SHA-256", EXPECTED_HASH_1, "");
        this.dotest(harness, "SHA-256", EXPECTED_HASH_2, "\u0000");
        this.dotest(harness, "SHA-256", EXPECTED_HASH_3, " ");
        this.dotest(harness, "SHA-256", EXPECTED_HASH_4, "a");
        this.dotest(harness, "SHA-256", EXPECTED_HASH_5, "text");
        this.dotest(harness, "SHA-256", EXPECTED_HASH_6, "Hello world!");
        this.dotest(harness, "SHA-256", EXPECTED_HASH_7, "Even longer text...");
        this.dotest(harness, "SHA-256", EXPECTED_HASH_8, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    @Override
    public void test(TestHarness harness) {
        if (!this.isSHA256Available()) {
            return;
        }
        try {
            this.run(harness);
        }
        catch (NoSuchAlgorithmException e) {
            harness.fail("Fail for algorithm SHA256.");
            harness.debug(e);
        }
    }

    public boolean isSHA256Available() {
        try {
            MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            new MessageDigestSHA256Test().run(null);
            System.out.println("OK");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
    }
}

