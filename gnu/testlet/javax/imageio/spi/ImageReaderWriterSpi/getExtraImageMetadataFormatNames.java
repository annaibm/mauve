/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi.TestProvider;
import java.util.Arrays;

public class getExtraImageMetadataFormatNames
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new TestProvider().getExtraImageMetadataFormatNames(), null);
        h.check(Arrays.equals(TestProvider.createProvider().getExtraImageMetadataFormatNames(), TestProvider.EXTRA_IMAGE_METADATA_FORMAT_NAMES));
    }
}

