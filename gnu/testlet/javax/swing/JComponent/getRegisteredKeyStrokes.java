/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class getRegisteredKeyStrokes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyJComponent c = new MyJComponent();
        harness.check(c.getRegisteredKeyStrokes().length, 0);
        KeyStroke ks0 = KeyStroke.getKeyStroke('a');
        KeyStroke ks1 = KeyStroke.getKeyStroke('b');
        KeyStroke ks2 = KeyStroke.getKeyStroke('c');
        c.getInputMap(0).put(ks0, "A");
        harness.check(c.getRegisteredKeyStrokes()[0], ks0);
        c.getInputMap(1).put(ks1, "B");
        harness.check(c.getRegisteredKeyStrokes()[0], ks0);
        harness.check(c.getRegisteredKeyStrokes()[1], ks1);
        c.getInputMap(2).put(ks2, "C");
        harness.check(c.getRegisteredKeyStrokes()[0], ks0);
        harness.check(c.getRegisteredKeyStrokes()[1], ks1);
        harness.check(c.getRegisteredKeyStrokes()[2], ks2);
    }

    static class MyJComponent
    extends JComponent {
    }
}

