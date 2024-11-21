/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.crypto.spec;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.crypto.spec.SecretKeySpec;

public class TestOfSecretKeySpec
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testEquals(harness);
    }

    private void testEquals(TestHarness harness) {
        String algorithm = "DES";
        String algorithm2 = "AES";
        byte[] key = new byte[32];
        for (int i = 0; i < key.length; ++i) {
            key[i] = (byte)i;
        }
        byte[] key2 = new byte[32];
        for (int i = 0; i < key2.length; ++i) {
            key2[i] = (byte)i;
        }
        byte[] key3 = new byte[32];
        for (int i = 0; i < key3.length; ++i) {
            key3[i] = (byte)(i + 3);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, algorithm);
        SecretKeySpec secretKeySpec2 = new SecretKeySpec(key2, algorithm);
        SecretKeySpec secretKeySpec3 = new SecretKeySpec(key3, algorithm);
        SecretKeySpec secretKeySpec4 = new SecretKeySpec(key, algorithm2);
        try {
            harness.check(secretKeySpec.equals(secretKeySpec2), "equals(secretKeySpec2) should return true");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("equals (secretkeyspec2) : " + String.valueOf(x));
        }
        try {
            harness.check(!secretKeySpec.equals(secretKeySpec3), "equals(secretKeySpec3) should return false");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("equals (secretkeyspec3) : " + String.valueOf(x));
        }
        try {
            harness.check(!secretKeySpec.equals(secretKeySpec4), "equals(secretKeySpec4) should return false");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("equals (secretkeyspec4) : " + String.valueOf(x));
        }
        try {
            harness.check(!secretKeySpec.equals("Hello World"), "equals (\"Hello World\") should have returned false");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("equals (\"Hello World\") : " + String.valueOf(x));
        }
    }
}

