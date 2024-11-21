/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.imageio.spi.ImageReaderWriterSpi.TestProvider;
import java.util.Arrays;

public class getFormatNames
implements Testlet {
    @Override
    public void test(TestHarness h) {
        Exception caught = null;
        try {
            new TestProvider().getFormatNames();
        }
        catch (Exception ex) {
            caught = ex;
        }
        h.check(caught instanceof NullPointerException);
        h.check(Arrays.equals(TestProvider.createProvider().getFormatNames(), TestProvider.NAMES));
        h.check(TestProvider.createProvider().getFormatNames() != TestProvider.NAMES);
    }
}

