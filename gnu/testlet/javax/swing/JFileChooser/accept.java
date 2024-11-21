/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JFileChooser.MyFileFilter;
import java.io.File;
import javax.swing.JFileChooser;

public class accept
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        File f = new File(System.getProperty("user.home"));
        harness.check(fc.accept(f), true);
        harness.check(fc.accept(null), true);
        fc.setFileFilter(new MyFileFilter(true));
        harness.check(fc.accept(f), true);
        fc.setFileFilter(new MyFileFilter(false));
        harness.check(fc.accept(f), false);
        fc.setFileFilter(null);
        harness.check(fc.accept(f), true);
    }
}

