/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.MessageDigest;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BasicMessageDigestAlgorithms
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String[] algorithmsNames;
        for (String algorithmName : algorithmsNames = new String[]{"MD5", "SHA-1", "SHA-256"}) {
            try {
                MessageDigest md = MessageDigest.getInstance(algorithmName);
                harness.check(md != null);
            }
            catch (NoSuchAlgorithmException e) {
                harness.fail("Fail for algorithm: " + algorithmName);
                harness.debug(e);
            }
        }
    }
}

