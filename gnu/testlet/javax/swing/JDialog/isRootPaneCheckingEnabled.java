/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JDialog;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class isRootPaneCheckingEnabled
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRootPaneCheckingEnabled(harness);
        this.testRootPaneCheckingDisabled(harness);
    }

    private void testRootPaneCheckingEnabled(TestHarness harness) {
        harness.checkPoint("rootPaneCheckingEnabled");
        TestDialog f = new TestDialog();
        f.setRootPaneCheckingEnabled(true);
        JLabel c = new JLabel("Hello");
        f.add(c);
        Component[] children2 = f.getComponents();
        harness.check(children2.length, 1);
        harness.check(children2[0] instanceof JRootPane);
        Component[] content = f.getContentPane().getComponents();
        harness.check(content.length, 1);
        harness.check(content[0], c);
    }

    private void testRootPaneCheckingDisabled(TestHarness harness) {
        harness.checkPoint("rootPaneCheckingDisabled");
        TestDialog f = new TestDialog();
        f.setRootPaneCheckingEnabled(false);
        JLabel c = new JLabel("Hello");
        f.add(c);
        Component[] children2 = f.getComponents();
        harness.check(children2.length, 2);
        harness.check(children2[0] instanceof JRootPane);
        harness.check(children2[1], c);
    }

    class TestDialog
    extends JDialog {
        TestDialog() {
        }

        @Override
        public boolean isRootPaneCheckingEnabled() {
            return super.isRootPaneCheckingEnabled();
        }

        @Override
        public void setRootPaneCheckingEnabled(boolean b) {
            super.setRootPaneCheckingEnabled(b);
        }
    }
}

