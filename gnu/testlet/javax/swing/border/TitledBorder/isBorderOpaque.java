/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.border.TitledBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class isBorderOpaque
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TitledBorder b = new TitledBorder(new EmptyBorder(1, 1, 1, 1));
        harness.check(b.isBorderOpaque(), false);
    }
}

