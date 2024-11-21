/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FlowLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FlowLayout;

public class setAlignment
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FlowLayout layout2 = new FlowLayout();
        layout2.setAlignment(0);
        harness.check(layout2.getAlignment(), 0);
        layout2.setAlignment(2);
        harness.check(layout2.getAlignment(), 2);
        layout2.setAlignment(1);
        harness.check(layout2.getAlignment(), 1);
    }
}

