/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Label;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label12 = new Label();
        harness.check(label12 != null);
        this.doCommonTests(harness, label12);
        Label label2 = new Label("xyzzy");
        harness.check(label2 != null);
        harness.check(label2.getText(), (Object)"xyzzy");
        this.doCommonTests(harness, label2);
        Label label3 = new Label("xyzzy", 1);
        harness.check(label3 != null);
        harness.check(label3.getText(), (Object)"xyzzy");
        harness.check(label3.getAlignment(), 1);
        this.doCommonTests(harness, label3);
        Label label4 = new Label("xyzzy", 0);
        harness.check(label4 != null);
        harness.check(label4.getText(), (Object)"xyzzy");
        harness.check(label4.getAlignment(), 0);
        this.doCommonTests(harness, label4);
        Label label5 = new Label("xyzzy", 2);
        harness.check(label5 != null);
        harness.check(label5.getText(), (Object)"xyzzy");
        harness.check(label5.getAlignment(), 2);
        this.doCommonTests(harness, label5);
    }

    public void doCommonTests(TestHarness harness, Label label) {
        label.setText("42");
        harness.check(label.getText(), (Object)"42");
        label.setText("");
        harness.check(label.getText(), (Object)"");
        label.setText(null);
        harness.check(label.getText() == null);
        label.setAlignment(1);
        harness.check(label.getAlignment(), 1);
        label.setAlignment(0);
        harness.check(label.getAlignment(), 0);
        label.setAlignment(2);
        harness.check(label.getAlignment(), 2);
    }
}

