/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;

public class getDialogType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.getDialogType(), 0);
        jfc.setDialogType(1);
        harness.check(jfc.getDialogType(), 1);
        jfc.setDialogType(2);
        harness.check(jfc.getDialogType(), 2);
    }
}

