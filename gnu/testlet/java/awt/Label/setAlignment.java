/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Label;

public class setAlignment
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label12 = new Label();
        this.doTest(harness, label12);
        Label label2 = new Label("xyzzy");
        this.doTest(harness, label2);
        Label label3 = new Label("xyzzy", 1);
        this.doTest(harness, label3);
        Label label4 = new Label("xyzzy", 0);
        this.doTest(harness, label4);
        Label label5 = new Label("xyzzy", 2);
        this.doTest(harness, label5);
    }

    public void doTest(TestHarness harness, Label label) {
        label.setAlignment(0);
        harness.check(label.getAlignment(), 0);
        label.setAlignment(2);
        harness.check(label.getAlignment(), 2);
        label.setAlignment(1);
        harness.check(label.getAlignment(), 1);
    }
}

