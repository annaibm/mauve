/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.IIOServiceProvider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.IIOServiceProvider.TestProvider;

public class getVendorName
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestProvider sp = new TestProvider("foo", "bar");
        h.check(sp.getVendorName(), (Object)"foo");
        sp = new TestProvider();
        h.check(sp.getVendorName(), null);
    }
}

