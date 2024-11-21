/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JFileChooser.MyFileFilter;
import javax.swing.JFileChooser;

public class getFileFilter
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        harness.check(fc.getFileFilter(), fc.getAcceptAllFileFilter());
        MyFileFilter ff1 = new MyFileFilter(true);
        fc.setFileFilter(ff1);
        harness.check(fc.getFileFilter(), ff1);
        fc.setFileFilter(null);
        harness.check(fc.getFileFilter(), null);
    }
}

