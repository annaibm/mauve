/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSplitPaneUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class getDividerLocation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSplitPane sp = new JSplitPane(1, new JPanel(), new JPanel());
        BasicSplitPaneUI ui = (BasicSplitPaneUI)sp.getUI();
        Component divider = sp.getComponent(2);
        divider.setLocation(1234, 5678);
        harness.check(ui.getDividerLocation(sp), 1234);
        sp = new JSplitPane(0, new JPanel(), new JPanel());
        ui = (BasicSplitPaneUI)sp.getUI();
        divider = sp.getComponent(2);
        divider.setLocation(1234, 5678);
        harness.check(ui.getDividerLocation(sp), 5678);
    }
}

