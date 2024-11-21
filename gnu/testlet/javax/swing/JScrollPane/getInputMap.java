/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JScrollPane;
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
        JScrollPane sp = new JScrollPane();
        InputMap m1 = sp.getInputMap();
        InputMap m2 = sp.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JScrollPane sp = new JScrollPane();
        InputMap m1 = sp.getInputMap(0);
        harness.check(m1.keys(), null);
        InputMap m1p = m1.getParent();
        harness.check(m1p, null);
        InputMap m2 = sp.getInputMap(1);
        harness.check(m2.keys(), null);
        InputMap m2p = m2.getParent();
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed PAGE_DOWN")), (Object)"scrollRight");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed PAGE_DOWN")), (Object)"scrollDown");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed PAGE_UP")), (Object)"scrollUp");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed PAGE_UP")), (Object)"scrollLeft");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_RIGHT")), (Object)"unitScrollRight");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed DOWN")), (Object)"unitScrollDown");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_LEFT")), (Object)"unitScrollLeft");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed HOME")), (Object)"scrollHome");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed RIGHT")), (Object)"unitScrollRight");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_DOWN")), (Object)"unitScrollDown");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed UP")), (Object)"unitScrollUp");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_UP")), (Object)"unitScrollUp");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed LEFT")), (Object)"unitScrollLeft");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed END")), (Object)"scrollEnd");
        InputMap m3 = sp.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
    }
}

