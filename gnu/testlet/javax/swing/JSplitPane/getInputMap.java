/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSplitPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

public class getInputMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSplitPane sp = new JSplitPane();
        InputMap m1 = sp.getInputMap(0);
        harness.check(m1.keys(), null);
        harness.check(m1.getParent(), null);
        InputMap m2 = sp.getInputMap(1);
        harness.check(m2.keys(), null);
        InputMap m2p = m2.getParent();
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed TAB")), (Object)"focusOutBackward");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_RIGHT")), (Object)"positiveIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed DOWN")), (Object)"positiveIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_LEFT")), (Object)"negativeIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed RIGHT")), (Object)"positiveIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_DOWN")), (Object)"positiveIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed UP")), (Object)"negativeIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_UP")), (Object)"negativeIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed F8")), (Object)"startResize");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed TAB")), (Object)"focusOutForward");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed LEFT")), (Object)"negativeIncrement");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed HOME")), (Object)"selectMin");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed F6")), (Object)"toggleFocus");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed END")), (Object)"selectMax");
        InputMap m3 = sp.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
    }
}

