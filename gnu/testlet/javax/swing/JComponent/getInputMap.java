/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.plaf.InputMapUIResource;

public class getInputMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("()");
        JButton button = new JButton("X");
        InputMap m1 = button.getInputMap();
        InputMap m2 = button.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JButton button = new JButton("X");
        InputMap m1 = button.getInputMap(0);
        InputMap m2 = button.getInputMap(1);
        InputMap m3 = button.getInputMap(2);
        harness.check(m1.keys(), null);
        harness.check(m1.getParent() instanceof InputMapUIResource);
        harness.check(m2.keys(), null);
        harness.check(m2.getParent(), null);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
        boolean pass = false;
        try {
            m1 = button.getInputMap(3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1 = button.getInputMap(-1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

