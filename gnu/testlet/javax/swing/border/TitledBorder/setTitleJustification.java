/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.border.TitledBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class setTitleJustification
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TitledBorder b = new TitledBorder(new EmptyBorder(1, 1, 1, 1));
        harness.check(b.getTitleJustification(), 4);
        b.setTitleJustification(1);
        harness.check(b.getTitleJustification(), 1);
        boolean pass = false;
        try {
            b.setTitleJustification(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

