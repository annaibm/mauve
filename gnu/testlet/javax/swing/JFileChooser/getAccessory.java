/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class getAccessory
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.getAccessory(), null);
        JPanel acc1 = new JPanel();
        jfc.setAccessory(acc1);
        harness.check(jfc.getAccessory(), acc1);
        jfc.setAccessory(null);
        harness.check(jfc.getAccessory(), null);
    }
}

