/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.border.TitledBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class getBorder
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Border baseBorder = new EmptyBorder(1, 1, 1, 1);
        TitledBorder b = new TitledBorder(baseBorder);
        harness.check(b.getBorder(), baseBorder);
        baseBorder = new EmptyBorder(1, 2, 3, 4);
        b.setBorder(baseBorder);
        harness.check(b.getBorder(), baseBorder);
        b.setBorder(null);
        baseBorder = UIManager.getLookAndFeelDefaults().getBorder("TitledBorder.border");
        harness.check(b.getBorder(), baseBorder);
    }
}

