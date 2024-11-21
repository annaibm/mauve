/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;

public class getApproveButtonToolTipText
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.getApproveButtonToolTipText(), null);
        jfc.setApproveButtonToolTipText("XYZ");
        harness.check(jfc.getApproveButtonToolTipText(), (Object)"XYZ");
    }
}

