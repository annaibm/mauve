/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi.TestProvider;

public class getNativeStreamMetadataFormatName
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new TestProvider().getNativeStreamMetadataFormatName(), null);
        h.check(TestProvider.createProvider().getNativeStreamMetadataFormatName(), (Object)"TIFF File Metadata");
    }
}

