/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSplitPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class getDividerLocation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testCallUI(harness);
    }

    private void testCallUI(TestHarness h) {
        JSplitPane sp = new JSplitPane();
        sp.setDividerLocation(1234);
        sp.setUI(new TestSplitPaneUI());
        h.check(sp.getDividerLocation(), 1234);
    }

    private class TestSplitPaneUI
    extends BasicSplitPaneUI {
        private TestSplitPaneUI() {
        }

        @Override
        public int getDividerLocation(JSplitPane sp) {
            return 9876;
        }
    }
}

