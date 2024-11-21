/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;

public class isFileHidingEnabled
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.isFileHidingEnabled(), true);
        jfc.setFileHidingEnabled(false);
        harness.check(jfc.isFileHidingEnabled(), false);
        jfc.setFileHidingEnabled(true);
        harness.check(jfc.isFileHidingEnabled(), true);
    }
}

