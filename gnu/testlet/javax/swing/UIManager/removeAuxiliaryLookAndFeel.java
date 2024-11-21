/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.UIManager.MyLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class removeAuxiliaryLookAndFeel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        MyLookAndFeel laf = new MyLookAndFeel();
        harness.check(UIManager.getAuxiliaryLookAndFeels(), null);
        UIManager.addAuxiliaryLookAndFeel(laf);
        LookAndFeel[] auxLafs = UIManager.getAuxiliaryLookAndFeels();
        harness.check(auxLafs.length, 1);
        harness.check(auxLafs[0], laf);
        boolean b = UIManager.removeAuxiliaryLookAndFeel(laf);
        harness.check(b, true);
        harness.check(UIManager.getAuxiliaryLookAndFeels(), null);
        boolean pass = true;
        try {
            b = UIManager.removeAuxiliaryLookAndFeel(null);
        }
        catch (NullPointerException e) {
            pass = false;
        }
        harness.check(pass);
        harness.check(b, false);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("test2");
        harness.check(UIManager.getAuxiliaryLookAndFeels(), null);
        MyLookAndFeel laf1 = new MyLookAndFeel();
        MyLookAndFeel laf2 = new MyLookAndFeel();
        MyLookAndFeel laf3 = new MyLookAndFeel();
        MyLookAndFeel laf4 = new MyLookAndFeel();
        UIManager.addAuxiliaryLookAndFeel(laf1);
        UIManager.addAuxiliaryLookAndFeel(laf2);
        UIManager.addAuxiliaryLookAndFeel(laf3);
        UIManager.addAuxiliaryLookAndFeel(laf4);
        UIManager.removeAuxiliaryLookAndFeel(laf2);
        LookAndFeel[] lafs = UIManager.getAuxiliaryLookAndFeels();
        harness.check(lafs[0], laf1);
        harness.check(lafs[1], laf3);
        harness.check(lafs[2], laf4);
        UIManager.removeAuxiliaryLookAndFeel(laf1);
        lafs = UIManager.getAuxiliaryLookAndFeels();
        harness.check(lafs[0], laf3);
        harness.check(lafs[1], laf4);
        UIManager.removeAuxiliaryLookAndFeel(laf4);
        lafs = UIManager.getAuxiliaryLookAndFeels();
        harness.check(lafs[0], laf3);
        UIManager.removeAuxiliaryLookAndFeel(laf3);
        lafs = UIManager.getAuxiliaryLookAndFeels();
        harness.check(lafs, null);
    }
}

