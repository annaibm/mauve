/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;

public class getDialogTitle
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.getDialogTitle(), null);
        jfc.setDialogTitle("XYZ");
        harness.check(jfc.getDialogTitle(), (Object)"XYZ");
        jfc.setDialogTitle(null);
        harness.check(jfc.getDialogTitle(), null);
    }
}

