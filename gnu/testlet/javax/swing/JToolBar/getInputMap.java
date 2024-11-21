/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToolBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JToolBar;
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
        JToolBar tb = new JToolBar();
        InputMap m1 = tb.getInputMap();
        InputMap m2 = tb.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JToolBar tb = new JToolBar();
        InputMap m1 = tb.getInputMap(0);
        harness.check(m1.keys(), null);
        InputMap m1p = m1.getParent();
        harness.check(m1p, null);
        InputMap m2 = tb.getInputMap(1);
        harness.check(m2.keys(), null);
        InputMap m2p = m2.getParent();
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed UP")), (Object)"navigateUp");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_UP")), (Object)"navigateUp");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed DOWN")), (Object)"navigateDown");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_DOWN")), (Object)"navigateDown");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed LEFT")), (Object)"navigateLeft");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_LEFT")), (Object)"navigateLeft");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed RIGHT")), (Object)"navigateRight");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_RIGHT")), (Object)"navigateRight");
        InputMap m3 = tb.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
    }
}

