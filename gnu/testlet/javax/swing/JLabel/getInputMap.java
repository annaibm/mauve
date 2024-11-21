/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class getInputMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("()");
        JLabel label = new JLabel("Test");
        InputMap m1 = label.getInputMap();
        InputMap m2 = label.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JLabel label = new JLabel("Test");
        InputMap m1 = label.getInputMap(0);
        harness.check(m1.keys(), null);
        InputMap m1p = m1.getParent();
        harness.check(m1p, null);
        InputMap m2 = label.getInputMap(1);
        harness.check(m2.keys(), null);
        harness.check(m2.getParent(), null);
        InputMap m3 = label.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
        JLabel label2 = new JLabel("Test");
        JButton button = new JButton("Target");
        label2.setLabelFor(button);
        label2.setDisplayedMnemonic('A');
        m1 = label2.getInputMap(0);
        harness.check(m1.keys(), null);
        m1p = m1.getParent();
        harness.check(m1p, null);
        m2 = label2.getInputMap(1);
        harness.check(m2.keys(), null);
        harness.check(m2.getParent(), null);
        m3 = label2.getInputMap(2);
        harness.check(m3.keys(), null);
        InputMap m3p = m3.getParent();
        harness.check(m3p.get(KeyStroke.getKeyStroke("alt pressed A")), (Object)"press");
        label2.setDisplayedMnemonic('B');
        harness.check(m3p.get(KeyStroke.getKeyStroke("alt pressed B")), (Object)"press");
    }
}

