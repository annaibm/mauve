/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class addLayoutComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("(Component, Object)");
        BorderLayout l = new BorderLayout();
        JPanel p1 = new JPanel();
        boolean pass = false;
        try {
            l.addLayoutComponent(p1, "X");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            l.addLayoutComponent(p1, null);
        }
        catch (RuntimeException e) {
            pass = false;
        }
        harness.check(pass);
    }
}

