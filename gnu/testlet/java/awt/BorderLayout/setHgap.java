/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;

public class setHgap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BorderLayout b = new BorderLayout();
        b.setHgap(99);
        harness.check(b.getHgap(), 99);
        b.setHgap(-99);
        harness.check(b.getHgap(), -99);
    }
}

