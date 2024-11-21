/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.KeyPairGenerator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Set;

public class PR64904
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Provider[] providers;
        Set<Provider.Service> services = null;
        for (Provider provider2 : providers = Security.getProviders()) {
            String provName = provider2.getName();
            harness.debug("Provider " + provName + ": " + provider2.getInfo());
            services = provider2.getServices();
            for (Provider.Service service : services) {
                String algName;
                if (!service.getType().equals("KeyPairGenerator")) continue;
                String desiredName = algName = service.getAlgorithm();
                if (algName.equals("DiffieHellman")) {
                    desiredName = "DH";
                }
                try {
                    harness.debug("Requesting " + algName + " from " + provName);
                    KeyPairGenerator gen = KeyPairGenerator.getInstance(algName, provider2);
                    KeyPair pair = gen.genKeyPair();
                    harness.check(pair.getPublic().getAlgorithm(), desiredName, "Provider " + provName + " returned public key using requested algorithm " + desiredName);
                    harness.check(pair.getPrivate().getAlgorithm(), desiredName, "Provider " + provName + " returned private key using requested algorithm " + desiredName);
                }
                catch (NoSuchAlgorithmException ex) {
                    harness.debug(ex);
                    harness.fail("Algorithm not found: " + ex);
                }
            }
        }
    }
}

