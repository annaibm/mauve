/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSplitPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JButton;
import javax.swing.JSplitPane;

public class Constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSplitPane pane = new JSplitPane();
        harness.checkPoint("demo constructor");
        harness.check(pane.getLeftComponent().getClass() == JButton.class);
        harness.check(pane.getRightComponent().getClass() == JButton.class);
        harness.checkPoint("constructor with only orientation");
        pane = new JSplitPane(1);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        pane = new JSplitPane(0);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        harness.checkPoint("constructor with orientation and layout");
        pane = new JSplitPane(0, false);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        pane = new JSplitPane(0, true);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        pane = new JSplitPane(1, true);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        pane = new JSplitPane(1, false);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        harness.checkPoint("constructor with orientation and 2 components");
        pane = new JSplitPane(0, null, null);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        pane = new JSplitPane(1, null, null);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        harness.checkPoint("most general constructor");
        pane = new JSplitPane(1, false, null, null);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        pane = new JSplitPane(1, true, null, null);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        pane = new JSplitPane(0, false, null, null);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
        pane = new JSplitPane(0, true, null, null);
        harness.check(pane.getLeftComponent() == null);
        harness.check(pane.getRightComponent() == null);
    }
}

