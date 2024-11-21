/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.net.ssl.SSLContext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

public class TestGetInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SSLContext context = null;
        harness.checkPoint("SSLContext.getInstance(\"SSL\")");
        try {
            context = SSLContext.getInstance("SSL");
            harness.check(context != null);
        }
        catch (NoSuchAlgorithmException nsae) {
            harness.fail("SSLContext.getInstance(\"SSL\")");
            harness.debug(nsae);
        }
    }
}

