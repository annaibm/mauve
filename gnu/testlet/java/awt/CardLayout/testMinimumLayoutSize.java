/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CardLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.CardLayout;

public class testMinimumLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CardLayout layout2 = new CardLayout();
        boolean failed = false;
        try {
            layout2.minimumLayoutSize(null);
        }
        catch (NullPointerException e) {
            failed = true;
        }
        harness.check(failed);
    }
}

