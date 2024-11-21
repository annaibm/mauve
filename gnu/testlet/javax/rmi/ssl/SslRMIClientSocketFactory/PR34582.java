/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.rmi.ssl.SslRMIClientSocketFactory;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.rmi.ssl.SslRMIClientSocketFactory;

public class PR34582
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            new SslRMIClientSocketFactory();
            h.check(true, "Factory created succesfully.");
        }
        catch (Exception e) {
            h.debug(e);
            h.fail("Factory could not be created.");
        }
    }
}

