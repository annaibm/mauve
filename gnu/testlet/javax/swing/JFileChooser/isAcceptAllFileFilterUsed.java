/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;

public class isAcceptAllFileFilterUsed
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.isAcceptAllFileFilterUsed(), true);
        jfc.setAcceptAllFileFilterUsed(false);
        harness.check(jfc.isAcceptAllFileFilterUsed(), false);
        jfc.setAcceptAllFileFilterUsed(true);
        harness.check(jfc.isAcceptAllFileFilterUsed(), true);
    }
}

