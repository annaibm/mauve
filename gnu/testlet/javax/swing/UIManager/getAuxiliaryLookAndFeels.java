/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.UIManager.MyLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class getAuxiliaryLookAndFeels
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        LookAndFeel[] lafs = UIManager.getAuxiliaryLookAndFeels();
        harness.check(lafs, null);
        MyLookAndFeel laf = new MyLookAndFeel();
        UIManager.addAuxiliaryLookAndFeel(laf);
        lafs = UIManager.getAuxiliaryLookAndFeels();
        harness.check(lafs.length, 1);
        harness.check(lafs[0], laf);
        UIManager.removeAuxiliaryLookAndFeel(laf);
    }
}

