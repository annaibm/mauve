/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.IIOServiceProvider;

import java.util.Locale;
import javax.imageio.spi.IIOServiceProvider;

class TestProvider
extends IIOServiceProvider {
    public TestProvider(String vendorName, String version) {
        super(vendorName, version);
    }

    public TestProvider() {
    }

    @Override
    public String getDescription(Locale locale) {
        return "desc";
    }
}

