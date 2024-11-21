/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;

public class getApproveButtonText
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.getApproveButtonText(), null);
        jfc.setApproveButtonText("XYZ");
        harness.check(jfc.getApproveButtonText(), (Object)"XYZ");
    }
}

