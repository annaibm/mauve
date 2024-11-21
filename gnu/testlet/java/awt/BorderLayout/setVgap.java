/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;

public class setVgap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BorderLayout b = new BorderLayout();
        b.setVgap(99);
        harness.check(b.getVgap(), 99);
        b.setVgap(-99);
        harness.check(b.getVgap(), -99);
    }
}

