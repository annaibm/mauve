/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.border.TitledBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class setTitleFont
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TitledBorder b = new TitledBorder(new EmptyBorder(1, 1, 1, 1));
        Font f = UIManager.getLookAndFeelDefaults().getFont("TitledBorder.font");
        harness.check(b.getTitleFont(), f);
        b.setTitleFont(new Font("Dialog", 0, 17));
        harness.check(b.getTitleFont(), new Font("Dialog", 0, 17));
        b.setTitleFont(null);
        harness.check(b.getTitleFont(), f);
    }
}

