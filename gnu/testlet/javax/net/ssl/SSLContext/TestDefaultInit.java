/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.net.ssl.SSLContext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

public class TestDefaultInit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SSLContext context = null;
        try {
            context = SSLContext.getInstance("SSL");
            harness.check(context != null);
        }
        catch (NoSuchAlgorithmException nsae) {
            harness.fail("getInstance");
            harness.debug(nsae);
        }
        try {
            System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
            context.init(null, null, null);
            harness.check(true);
        }
        catch (KeyManagementException kme) {
            harness.fail("SSLContext.init");
            harness.debug(kme);
        }
    }
}

