/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;

public class getFileSelectionMode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        harness.check(fc.getFileSelectionMode(), 0);
        fc.setFileSelectionMode(1);
        harness.check(fc.getFileSelectionMode(), 1);
    }
}

