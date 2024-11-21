/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageInputStreamSpi;

import java.io.File;
import java.util.Locale;
import javax.imageio.spi.ImageInputStreamSpi;
import javax.imageio.stream.ImageInputStream;

class TestProvider
extends ImageInputStreamSpi {
    public TestProvider(String vendorName, String version, Class inputClass) {
        super(vendorName, version, inputClass);
    }

    public TestProvider() {
    }

    @Override
    public String getDescription(Locale locale) {
        return "desc";
    }

    @Override
    public ImageInputStream createInputStreamInstance(Object obj, boolean useCache, File cacheFile) {
        return null;
    }
}

