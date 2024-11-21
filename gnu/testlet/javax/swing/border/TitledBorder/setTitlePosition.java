/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.border.TitledBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class setTitlePosition
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TitledBorder b = new TitledBorder(new EmptyBorder(1, 1, 1, 1));
        harness.check(b.getTitlePosition(), 0);
        b.setTitlePosition(6);
        harness.check(b.getTitlePosition(), 6);
        boolean pass = false;
        try {
            b.setTitlePosition(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

