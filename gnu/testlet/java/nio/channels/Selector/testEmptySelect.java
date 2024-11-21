/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.channels.Selector;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;

public class testEmptySelect
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("openSelector");
        AbstractSelector sel = null;
        try {
            sel = SelectorProvider.provider().openSelector();
        }
        catch (IOException ioe) {
            harness.fail("openSelector");
            harness.debug(ioe);
            return;
        }
        harness.checkPoint("select");
        try {
            int ret = sel.select(100L);
            harness.check(ret, 0);
        }
        catch (IOException ioe) {
            harness.fail("select");
            harness.debug(ioe);
        }
    }
}

