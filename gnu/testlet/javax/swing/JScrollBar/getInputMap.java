/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JScrollBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JScrollBar;
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
        JScrollBar sb = new JScrollBar();
        InputMap m1 = sb.getInputMap();
        InputMap m2 = sb.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JScrollBar sb = new JScrollBar();
        InputMap m1 = sb.getInputMap(0);
        harness.check(m1.keys(), null);
        InputMap m1p = m1.getParent();
        harness.check(m1p, null);
        InputMap m2 = sb.getInputMap(1);
        harness.check(m2.keys(), null);
        InputMap m2p = m2.getParent();
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed PAGE_UP")), (Object)"negativeBlockIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed PAGE_DOWN")), (Object)"positiveBlockIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed END")), (Object)"maxScroll");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed HOME")), (Object)"minScroll");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed LEFT")), (Object)"negativeUnitIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_UP")), (Object)"negativeUnitIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_DOWN")), (Object)"positiveUnitIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed UP")), (Object)"negativeUnitIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed RIGHT")), (Object)"positiveUnitIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_LEFT")), (Object)"negativeUnitIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed DOWN")), (Object)"positiveUnitIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_RIGHT")), (Object)"positiveUnitIncrement");
        InputMap m3 = sb.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
    }
}

