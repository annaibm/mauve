/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.UIManager.MyLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class addAuxiliaryLookAndFeel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyLookAndFeel laf = new MyLookAndFeel();
        harness.check(UIManager.getAuxiliaryLookAndFeels(), null);
        UIManager.addAuxiliaryLookAndFeel(laf);
        LookAndFeel[] auxLafs = UIManager.getAuxiliaryLookAndFeels();
        harness.check(auxLafs.length, 1);
        harness.check(auxLafs[0], laf);
        UIManager.removeAuxiliaryLookAndFeel(laf);
        boolean pass = false;
        try {
            UIManager.addAuxiliaryLookAndFeel(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

