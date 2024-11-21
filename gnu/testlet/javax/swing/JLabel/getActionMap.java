/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JLabel;

public class getActionMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JLabel label = new JLabel("XYZ");
        ActionMap m = label.getActionMap();
        harness.check(m.keys(), null);
        ActionMap mp = m.getParent();
        harness.check(mp, null);
        JLabel label2 = new JLabel("ABC");
        JButton button = new JButton("Target");
        label2.setLabelFor(button);
        label2.setDisplayedMnemonic('A');
        m = label2.getActionMap();
        harness.check(m.keys(), null);
        mp = m.getParent();
        harness.check(mp.size(), 2);
        harness.check(mp.get("press") != null);
        harness.check(mp.get("release") != null);
    }
}

