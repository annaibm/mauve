/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageInputStreamSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageInputStreamSpi.TestProvider;

public class ImageInputStreamSpi
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestProvider sp = new TestProvider();
        h.check(sp.getVendorName(), null);
        h.check(sp.getVersion(), null);
        h.check(sp.getInputClass(), null);
        Exception caught = null;
        try {
            new TestProvider(null, "foo", (Class)String.class);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        caught = null;
        try {
            new TestProvider("foo", null, (Class)String.class);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof IllegalArgumentException);
        caught = null;
        try {
            new TestProvider("foo", "bar", null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught == null);
        sp = new TestProvider("FSF", "1.0", (Class)String.class);
        h.check(sp.getVendorName(), (Object)"FSF");
        h.check(sp.getVersion(), (Object)"1.0");
        h.check(sp.getInputClass(), String.class);
    }
}

