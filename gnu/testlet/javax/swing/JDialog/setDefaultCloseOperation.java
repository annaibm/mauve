/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JDialog;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JDialog;

public class setDefaultCloseOperation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JDialog dialog = new JDialog();
        harness.checkPoint("default value");
        harness.check(dialog.getDefaultCloseOperation(), 1);
        harness.checkPoint("valid values");
        dialog.setDefaultCloseOperation(2);
        harness.check(dialog.getDefaultCloseOperation(), 2);
        dialog.setDefaultCloseOperation(0);
        harness.check(dialog.getDefaultCloseOperation(), 0);
        dialog.setDefaultCloseOperation(1);
        harness.check(dialog.getDefaultCloseOperation(), 1);
        harness.checkPoint("invalid values");
        dialog.setDefaultCloseOperation(3);
        harness.check(dialog.getDefaultCloseOperation(), 3);
        int SOME_RANDOM = 434323423;
        dialog.setDefaultCloseOperation(434323423);
        harness.check(dialog.getDefaultCloseOperation(), 434323423);
    }
}

