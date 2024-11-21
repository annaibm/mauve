/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageInputStreamSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageInputStreamSpi.TestProvider;

public class needsCacheFile
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestProvider sp = new TestProvider();
        h.check(!sp.needsCacheFile());
    }
}

