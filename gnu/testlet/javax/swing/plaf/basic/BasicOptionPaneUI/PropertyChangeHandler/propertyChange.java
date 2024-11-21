/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicOptionPaneUI.PropertyChangeHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class propertyChange
implements Testlet {
    boolean installComponentsCalled;
    boolean uninstallComponentsCalled;

    @Override
    public void test(TestHarness h) {
        this.testVisualProperties(h);
    }

    private void testVisualProperties(TestHarness h) {
        JOptionPane p = new JOptionPane();
        TestOptionPaneUI ui = new TestOptionPaneUI();
        p.setUI(ui);
        this.installComponentsCalled = false;
        this.uninstallComponentsCalled = false;
        p.setIcon(new ImageIcon());
        this.checkReinstalled(h);
        p.setInitialSelectionValue("Hello World");
        this.checkReinstalled(h);
        p.setInitialValue(new Object());
        this.checkReinstalled(h);
        p.setMessage(new Object());
        this.checkReinstalled(h);
        p.setMessageType(0);
        this.checkReinstalled(h);
        p.setOptions(new Object[0]);
        this.checkReinstalled(h);
        p.setOptionType(1);
        this.checkReinstalled(h);
        p.setWantsInput(false);
        p.setWantsInput(true);
        this.checkReinstalled(h);
    }

    private void checkReinstalled(TestHarness h) {
        h.check(this.installComponentsCalled, true);
        h.check(this.uninstallComponentsCalled, true);
        this.installComponentsCalled = false;
        this.uninstallComponentsCalled = false;
    }

    class TestOptionPaneUI
    extends BasicOptionPaneUI {
        TestOptionPaneUI() {
        }

        @Override
        protected void installComponents() {
            super.installComponents();
            propertyChange.this.installComponentsCalled = true;
        }

        @Override
        protected void uninstallComponents() {
            super.uninstallComponents();
            propertyChange.this.uninstallComponentsCalled = true;
        }
    }
}

