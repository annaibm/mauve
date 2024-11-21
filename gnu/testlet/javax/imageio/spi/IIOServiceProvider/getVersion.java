/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.IIOServiceProvider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.IIOServiceProvider.TestProvider;

public class getVersion
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestProvider sp = new TestProvider("foo", "1.9");
        h.check(sp.getVersion(), (Object)"1.9");
        sp = new TestProvider();
        h.check(sp.getVersion(), null);
    }
}

