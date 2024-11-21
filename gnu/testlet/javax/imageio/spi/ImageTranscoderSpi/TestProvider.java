/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageTranscoderSpi;

import java.util.Locale;
import javax.imageio.ImageTranscoder;
import javax.imageio.spi.ImageTranscoderSpi;

class TestProvider
extends ImageTranscoderSpi {
    public TestProvider(String vendorName, String version) {
        super(vendorName, version);
    }

    public TestProvider() {
    }

    @Override
    public String getDescription(Locale locale) {
        return "desc";
    }

    @Override
    public String getReaderServiceProviderName() {
        return "gnu.javax.imageio.UnimplementedReader";
    }

    @Override
    public String getWriterServiceProviderName() {
        return "gnu.javax.imageio.UnimplementedWriter";
    }

    @Override
    public ImageTranscoder createTranscoderInstance() {
        return null;
    }
}

