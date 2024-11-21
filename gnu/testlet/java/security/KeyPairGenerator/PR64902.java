/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.KeyPairGenerator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class PR64902
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> algNames = new HashMap<String, String>();
        algNames.put("DiffieHellman", "DH");
        algNames.put("DSA", "DSA");
        algNames.put("RSA", "RSA");
        algNames.put("EC", "EC");
        for (Map.Entry entry : algNames.entrySet()) {
            try {
                String genName = (String)entry.getKey();
                String algName = (String)entry.getValue();
                KeyPairGenerator gen = KeyPairGenerator.getInstance(genName);
                harness.check(gen.getAlgorithm(), genName, "genKeyPair returns generator for " + genName);
                KeyPair pair = gen.genKeyPair();
                harness.check(pair.getPublic().getAlgorithm(), algName, "Returned public key uses requested algorithm " + algName);
                harness.check(pair.getPrivate().getAlgorithm(), algName, "Returned private key uses requested algorithm " + algName);
            }
            catch (NoSuchAlgorithmException ex) {
                harness.debug(ex);
                harness.fail("Algorithm not found: " + ex);
            }
        }
    }
}

