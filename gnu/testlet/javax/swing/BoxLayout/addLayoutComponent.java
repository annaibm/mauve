/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.BoxLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class addLayoutComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("(Component, Object)");
        BoxLayout layout2 = new BoxLayout(new JPanel(), 0);
        layout2.addLayoutComponent(new JPanel(), "XYZ");
        layout2.addLayoutComponent((Component)null, null);
        harness.check(true);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("(String, Component)");
        BoxLayout layout2 = new BoxLayout(new JPanel(), 0);
        layout2.addLayoutComponent("Name", new JButton("Test"));
        layout2.addLayoutComponent((String)null, null);
        harness.check(true);
    }
}

