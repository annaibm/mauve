/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageOutputStreamSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageOutputStreamSpi.TestProvider;

public class canUseCacheFile
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestProvider sp = new TestProvider();
        h.check(!sp.canUseCacheFile());
    }
}

