/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi.TestProvider;
import java.util.Arrays;

public class getMIMETypes
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(new TestProvider().getMIMETypes(), null);
        h.check(Arrays.equals(TestProvider.createProvider().getMIMETypes(), TestProvider.MIME_TYPES));
    }
}

