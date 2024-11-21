/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSplitPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class setComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSplitPane pane = new JSplitPane();
        JScrollPane scroll = new JScrollPane();
        JButton button = new JButton();
        harness.checkPoint("set left");
        pane.setLeftComponent(null);
        harness.check(pane.getLeftComponent() == null);
        pane.setLeftComponent(scroll);
        harness.check(pane.getLeftComponent() == scroll);
        pane.setLeftComponent(null);
        harness.check(pane.getLeftComponent() == null);
        harness.checkPoint("set right");
        pane.setRightComponent(null);
        harness.check(pane.getRightComponent() == null);
        pane.setRightComponent(button);
        harness.check(pane.getRightComponent() == button);
        pane.setRightComponent(null);
        harness.check(pane.getRightComponent() == null);
    }
}

