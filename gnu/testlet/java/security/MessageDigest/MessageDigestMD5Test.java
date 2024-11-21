/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestMD5Test
implements Testlet {
    private static final byte[] EXPECTED_HASH_1 = new byte[]{-44, 29, -116, -39, -113, 0, -78, 4, -23, -128, 9, -104, -20, -8, 66, 126};
    private static final byte[] EXPECTED_HASH_2 = new byte[]{-109, -72, -123, -83, -2, 13, -96, -119, -51, -10, 52, -112, 79, -43, -97, 113};
    private static final byte[] EXPECTED_HASH_3 = new byte[]{114, 21, -18, -100, 125, -99, -62, 41, -46, -110, 26, 64, -24, -103, -20, 95};
    private static final byte[] EXPECTED_HASH_4 = new byte[]{12, -63, 117, -71, -64, -15, -74, -88, 49, -61, -103, -30, 105, 119, 38, 97};
    private static final byte[] EXPECTED_HASH_5 = new byte[]{28, -78, 81, -20, 13, 86, -115, -26, -87, 41, -75, 32, -60, -82, -40, -47};
    private static final byte[] EXPECTED_HASH_6 = new byte[]{-122, -5, 38, -99, 25, 13, 44, -123, -10, -32, 70, -116, -20, -92, 42, 32};
    private static final byte[] EXPECTED_HASH_7 = new byte[]{-60, 87, 48, 88, -99, 28, -90, -43, 93, -39, 71, -112, -115, 90, 2, -3};
    private static final byte[] EXPECTED_HASH_8 = new byte[]{-6, 92, -119, -13, -56, -117, -127, -65, -43, -24, 33, -80, 49, 101, 105, -81};

    private static byte[] generateHash(TestHarness harness, String algorithmName, String text2) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithmName);
        harness.check(md != null);
        md.update(text2.getBytes());
        byte[] digest = md.digest();
        harness.check(digest != null);
        harness.check(digest.length, 16);
        return digest;
    }

    private void dotest(TestHarness harness, String algorithmName, byte[] expectedHash, String text2) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigestMD5Test.generateHash(harness, algorithmName, text2);
        for (int i = 0; i < digest.length; ++i) {
            if (digest[i] == expectedHash[i]) continue;
            harness.fail("Difference found at offset " + i);
        }
    }

    private void run(TestHarness harness) throws NoSuchAlgorithmException {
        this.dotest(harness, "MD5", EXPECTED_HASH_1, "");
        this.dotest(harness, "MD5", EXPECTED_HASH_2, "\u0000");
        this.dotest(harness, "MD5", EXPECTED_HASH_3, " ");
        this.dotest(harness, "MD5", EXPECTED_HASH_4, "a");
        this.dotest(harness, "MD5", EXPECTED_HASH_5, "text");
        this.dotest(harness, "MD5", EXPECTED_HASH_6, "Hello world!");
        this.dotest(harness, "MD5", EXPECTED_HASH_7, "Even longer text...");
        this.dotest(harness, "MD5", EXPECTED_HASH_8, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    @Override
    public void test(TestHarness harness) {
        try {
            this.run(harness);
        }
        catch (NoSuchAlgorithmException e) {
            harness.fail("Fail for algorithm MD5.");
            harness.debug(e);
        }
    }

    public static void main(String[] args) {
        try {
            new MessageDigestMD5Test().run(null);
            System.out.println("OK");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
    }
}

