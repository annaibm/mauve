/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;

public class getApproveButtonMnemonic
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.getApproveButtonMnemonic(), 0);
        jfc.setApproveButtonMnemonic(79);
        harness.check(jfc.getApproveButtonMnemonic(), 79);
        jfc.setApproveButtonMnemonic(0);
        harness.check(jfc.getApproveButtonMnemonic(), 0);
    }
}

