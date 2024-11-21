/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.KeyPairGenerator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;

public class PR64881
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
            harness.check(gen.getAlgorithm(), "RSA", "genKeyPair returns requested algorithm");
            gen.initialize(2048);
            PublicKey key = gen.genKeyPair().getPublic();
            harness.check(key.getAlgorithm(), "RSA", "Returned key uses requested algorithm");
            if (key instanceof RSAKey) {
                harness.check(((RSAKey)((Object)key)).getModulus().bitLength(), 2048, "Returned key is of specified length");
            }
        }
        catch (NoSuchAlgorithmException ex) {
            harness.debug(ex);
            harness.fail("Algorithm not found: " + ex);
        }
    }
}

