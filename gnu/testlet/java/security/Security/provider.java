/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Security;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.Provider;
import java.security.Security;

public class provider
extends Provider
implements Testlet {
    static final String NAME = "Mauve-Test-Provider";
    static final double VERSION = 3.14;
    static final String INFO = "Mauve Info-Test";

    public provider() {
        super(NAME, 3.14, INFO);
    }

    provider(int i) {
        super(NAME + i, 3.14, INFO);
    }

    @Override
    public void test(TestHarness harness) {
        Provider[] orig_providers = Security.getProviders();
        harness.check(orig_providers != null);
        provider p1 = new provider(1);
        int pos1 = Security.addProvider(p1);
        harness.check(pos1 != -1);
        Provider[] new_providers = Security.getProviders();
        harness.check(orig_providers.length + 1, new_providers.length);
        harness.check(new_providers[pos1 - 1], p1);
        provider p2 = new provider(2);
        int pos2 = Security.addProvider(p2);
        harness.check(pos2 - 1, pos1);
        new_providers = Security.getProviders();
        harness.check(orig_providers.length + 2, new_providers.length);
        harness.check(new_providers[pos1 - 1], p1);
        harness.check(new_providers[pos2 - 1], p2);
        provider p0 = new provider(0);
        int pos0 = Security.insertProviderAt(p0, 1);
        harness.check(pos0 != -1);
        new_providers = Security.getProviders();
        harness.check(orig_providers.length + 3, new_providers.length);
        harness.check(new_providers[pos0 - 1], p0);
        harness.check(Security.getProvider(p0.getName()), p0);
        harness.check(Security.getProvider(p1.getName()), p1);
        harness.check(Security.getProvider(p2.getName()), p2);
        harness.check(Security.getProvider("UNKNOWN Mauve-Test-Provider42"), null);
        harness.check(Security.addProvider(p1), -1);
        harness.check(Security.addProvider(p2), -1);
        harness.check(Security.insertProviderAt(p1, 1), -1);
        harness.check(Security.insertProviderAt(p2, 2), -1);
        Security.removeProvider(p0.getName());
        Security.removeProvider(p2.getName());
        Security.removeProvider("UNKNOWN Mauve-Test-Provider42");
        Security.removeProvider(p2.getName());
        Security.removeProvider(p0.getName());
        harness.check(Security.getProvider(p0.getName()), null);
        harness.check(Security.getProvider(p2.getName()), null);
        harness.check(Security.getProvider(p1.getName()), p1);
        new_providers = Security.getProviders();
        harness.check(new_providers[pos1 - 1], p1);
        Security.removeProvider(p1.getName());
        new_providers = Security.getProviders();
        harness.check(new_providers.length, orig_providers.length);
    }
}

