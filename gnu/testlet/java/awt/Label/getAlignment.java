/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Label;

public class getAlignment
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label12 = new Label();
        harness.check(label12.getAlignment(), 0);
        Label label2 = new Label("xyzzy");
        harness.check(label2.getAlignment(), 0);
        Label label3 = new Label("xyzzy", 1);
        harness.check(label3.getAlignment(), 1);
        Label label4 = new Label("xyzzy", 0);
        harness.check(label4.getAlignment(), 0);
        Label label5 = new Label("xyzzy", 2);
        harness.check(label5.getAlignment(), 2);
    }
}

