/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageTranscoderSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageTranscoderSpi.TestProvider;

public class ImageTranscoderSpi
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestProvider sp = new TestProvider();
        h.check(sp.getVendorName(), null);
        h.check(sp.getVersion(), null);
        Exception caught = null;
        try {
            new TestProvider(null, "foo");
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        caught = null;
        try {
            new TestProvider("foo", null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        sp = new TestProvider("FSF", "1.0");
        h.check(sp.getVendorName(), (Object)"FSF");
        h.check(sp.getVersion(), (Object)"1.0");
    }
}

