/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestMD2Test
implements Testlet {
    private static final byte[] EXPECTED_HASH_1 = new byte[]{-125, 80, -27, -93, -30, 76, 21, 61, -14, 39, 92, -97, -128, 105, 39, 115};
    private static final byte[] EXPECTED_HASH_2 = new byte[]{-18, -115, -70, -29, -68, 98, -67, -55, 78, -90, 63, 105, -63, -68, 38, -55};
    private static final byte[] EXPECTED_HASH_3 = new byte[]{-54, 68, 122, -122, 109, 64, 65, -82, 74, 16, 125, -79, 78, 40, -55, 19};
    private static final byte[] EXPECTED_HASH_4 = new byte[]{50, -20, 1, -20, 74, 109, -84, 114, -64, -85, -106, -5, 52, -64, -75, -47};
    private static final byte[] EXPECTED_HASH_5 = new byte[]{90, 49, 32, 34, -96, -17, 109, 124, -48, -87, -105, 97, 106, 67, 75, -35};
    private static final byte[] EXPECTED_HASH_6 = new byte[]{99, 80, 61, 49, 23, -83, 51, -7, 65, -46, 15, 87, 20, 78, -50, 100};
    private static final byte[] EXPECTED_HASH_7 = new byte[]{-89, 14, 44, 74, -13, -109, 5, 98, 108, -102, -81, 20, 92, -16, -41, 61};
    private static final byte[] EXPECTED_HASH_8 = new byte[]{-82, -95, -91, -50, 44, -96, -113, -45, 107, -107, -10, -21, 111, -127, -55, 98};

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
        byte[] digest = MessageDigestMD2Test.generateHash(harness, algorithmName, text2);
        for (int i = 0; i < digest.length; ++i) {
            if (digest[i] == expectedHash[i]) continue;
            harness.fail("Difference found at offset " + i);
        }
    }

    private void run(TestHarness harness) throws NoSuchAlgorithmException {
        this.dotest(harness, "MD2", EXPECTED_HASH_1, "");
        this.dotest(harness, "MD2", EXPECTED_HASH_2, "\u0000");
        this.dotest(harness, "MD2", EXPECTED_HASH_3, " ");
        this.dotest(harness, "MD2", EXPECTED_HASH_4, "a");
        this.dotest(harness, "MD2", EXPECTED_HASH_5, "text");
        this.dotest(harness, "MD2", EXPECTED_HASH_6, "Hello world!");
        this.dotest(harness, "MD2", EXPECTED_HASH_7, "Even longer text...");
        this.dotest(harness, "MD2", EXPECTED_HASH_8, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    @Override
    public void test(TestHarness harness) {
        if (!this.isMD2Available()) {
            return;
        }
        try {
            this.run(harness);
        }
        catch (NoSuchAlgorithmException e) {
            harness.fail("Fail for algorithm MD2.");
            harness.debug(e);
        }
    }

    public boolean isMD2Available() {
        try {
            MessageDigest.getInstance("MD2");
        }
        catch (NoSuchAlgorithmException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            new MessageDigestMD2Test().run(null);
            System.out.println("OK");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
    }
}

