/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi.TestProvider;

public class getNativeImageMetadataFormatName
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new TestProvider().getNativeImageMetadataFormatName(), null);
        h.check(TestProvider.createProvider().getNativeImageMetadataFormatName(), (Object)"TIFF Image Metadata");
    }
}

