/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.border.TitledBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class setTitleColor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TitledBorder b = new TitledBorder(new EmptyBorder(1, 1, 1, 1));
        Color c = UIManager.getLookAndFeelDefaults().getColor("TitledBorder.titleColor");
        harness.check(b.getTitleColor(), c);
        b.setTitleColor(Color.yellow);
        harness.check(b.getTitleColor(), Color.yellow);
        b.setTitleColor(null);
        harness.check(b.getTitleColor(), c);
    }
}

