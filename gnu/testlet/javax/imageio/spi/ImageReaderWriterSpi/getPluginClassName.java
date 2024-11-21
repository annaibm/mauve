/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi.TestProvider;

public class getPluginClassName
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new TestProvider().getPluginClassName(), null);
        h.check(TestProvider.createProvider().getPluginClassName(), (Object)"gnu.javax.imageio.plugin.tiff.Reader");
    }
}

