/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicRootPaneUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicRootPaneUI;

public class installDefaults
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBackground(harness);
    }

    private void testBackground(TestHarness h) {
        UIManager.put("RootPane.background", Color.RED);
        TestRootUI ui = new TestRootUI();
        JRootPane rp = new JRootPane();
        rp.setBackground(null);
        ui.installDefaults(rp);
        h.check(rp.getBackground(), null);
    }

    class TestRootUI
    extends BasicRootPaneUI {
        TestRootUI() {
        }

        @Override
        public void installDefaults(JRootPane rp) {
            super.installDefaults(rp);
        }
    }
}

