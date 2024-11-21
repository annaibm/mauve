/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageOutputStreamSpi;

import java.io.File;
import java.util.Locale;
import javax.imageio.spi.ImageOutputStreamSpi;
import javax.imageio.stream.ImageOutputStream;

class TestProvider
extends ImageOutputStreamSpi {
    public TestProvider(String vendorName, String version, Class outputClass) {
        super(vendorName, version, outputClass);
    }

    public TestProvider() {
    }

    @Override
    public String getDescription(Locale locale) {
        return "desc";
    }

    @Override
    public ImageOutputStream createOutputStreamInstance(Object obj, boolean useCache, File cacheFile) {
        return null;
    }
}

