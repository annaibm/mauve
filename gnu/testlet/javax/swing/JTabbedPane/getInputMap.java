/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTabbedPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JTabbedPane;
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
        JTabbedPane tp = new JTabbedPane();
        InputMap m1 = tp.getInputMap();
        InputMap m2 = tp.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JTabbedPane tp = new JTabbedPane();
        InputMap m1 = tp.getInputMap(0);
        harness.check(m1.keys(), null);
        InputMap m1p = m1.getParent();
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed DOWN")), (Object)"requestFocusForVisibleComponent");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed KP_UP")), (Object)"navigateUp");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed LEFT")), (Object)"navigateLeft");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed KP_DOWN")), (Object)"requestFocusForVisibleComponent");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed UP")), (Object)"navigateUp");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed KP_DOWN")), (Object)"navigateDown");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed KP_LEFT")), (Object)"navigateLeft");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed RIGHT")), (Object)"navigateRight");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed KP_RIGHT")), (Object)"navigateRight");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed DOWN")), (Object)"navigateDown");
        InputMap m2 = tp.getInputMap(1);
        harness.check(m2.keys(), null);
        InputMap m2p = m2.getParent();
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed PAGE_DOWN")), (Object)"navigatePageDown");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed PAGE_UP")), (Object)"navigatePageUp");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed UP")), (Object)"requestFocus");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed KP_UP")), (Object)"requestFocus");
        InputMap m3 = tp.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
    }
}

