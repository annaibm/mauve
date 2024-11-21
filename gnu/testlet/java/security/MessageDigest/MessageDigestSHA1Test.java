/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestSHA1Test
implements Testlet {
    private static final byte[] EXPECTED_HASH_1 = new byte[]{-38, 57, -93, -18, 94, 107, 75, 13, 50, 85, -65, -17, -107, 96, 24, -112, -81, -40, 7, 9};
    private static final byte[] EXPECTED_HASH_2 = new byte[]{91, -87, 60, -99, -80, -49, -7, 63, 82, -75, 33, -41, 66, 14, 67, -10, -19, -94, 120, 79};
    private static final byte[] EXPECTED_HASH_3 = new byte[]{-72, 88, -53, 40, 38, 23, -5, 9, 86, -39, 96, 33, 92, -114, -124, -47, -52, -7, 9, -58};
    private static final byte[] EXPECTED_HASH_4 = new byte[]{-122, -9, -28, 55, -6, -91, -89, -4, -31, 93, 29, -36, -71, -22, -22, -22, 55, 118, 103, -72};
    private static final byte[] EXPECTED_HASH_5 = new byte[]{55, 46, -96, -116, -85, 51, -25, 28, 2, -58, 81, -37, -56, 58, 71, 77, 50, -58, 118, -22};
    private static final byte[] EXPECTED_HASH_6 = new byte[]{-45, 72, 106, -23, 19, 110, 120, 86, -68, 66, 33, 35, -123, -22, 121, 112, -108, 71, 88, 2};
    private static final byte[] EXPECTED_HASH_7 = new byte[]{78, 11, -64, -31, -110, -100, -72, -29, 108, -15, -76, -23, 40, -58, 79, -104, -61, 44, -1, -110};
    private static final byte[] EXPECTED_HASH_8 = new byte[]{25, -81, -94, -92, -93, 116, 98, -57, -71, 64, -90, -60, -58, 19, 99, -44, -100, 58, 53, -12};

    private static byte[] generateHash(TestHarness harness, String algorithmName, String text2) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithmName);
        harness.check(md != null);
        md.update(text2.getBytes());
        byte[] digest = md.digest();
        harness.check(digest != null);
        harness.check(digest.length, 20);
        return digest;
    }

    private void dotest(TestHarness harness, String algorithmName, byte[] expectedHash, String text2) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigestSHA1Test.generateHash(harness, algorithmName, text2);
        for (int i = 0; i < digest.length; ++i) {
            if (digest[i] == expectedHash[i]) continue;
            harness.fail("Difference found at offset " + i);
        }
    }

    private void run(TestHarness harness) throws NoSuchAlgorithmException {
        this.dotest(harness, "SHA-1", EXPECTED_HASH_1, "");
        this.dotest(harness, "SHA-1", EXPECTED_HASH_2, "\u0000");
        this.dotest(harness, "SHA-1", EXPECTED_HASH_3, " ");
        this.dotest(harness, "SHA-1", EXPECTED_HASH_4, "a");
        this.dotest(harness, "SHA-1", EXPECTED_HASH_5, "text");
        this.dotest(harness, "SHA-1", EXPECTED_HASH_6, "Hello world!");
        this.dotest(harness, "SHA-1", EXPECTED_HASH_7, "Even longer text...");
        this.dotest(harness, "SHA-1", EXPECTED_HASH_8, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    @Override
    public void test(TestHarness harness) {
        try {
            this.run(harness);
        }
        catch (NoSuchAlgorithmException e) {
            harness.fail("Fail for algorithm SHA1.");
            harness.debug(e);
        }
    }

    public static void main(String[] args) {
        try {
            new MessageDigestSHA1Test().run(null);
            System.out.println("OK");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
    }
}

