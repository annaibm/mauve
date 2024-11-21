/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Button;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Button button1 = new Button();
        harness.check(button1 != null);
        this.doCommonTests(harness, button1);
        Button button2 = new Button("xyzzy");
        harness.check(button2 != null);
        harness.check(button2.getLabel(), (Object)"xyzzy");
        this.doCommonTests(harness, button2);
    }

    public void doCommonTests(TestHarness harness, Button button) {
        button.setLabel("42");
        harness.check(button.getLabel(), (Object)"42");
        button.setLabel("");
        harness.check(button.getLabel(), (Object)"");
        button.setLabel(null);
        harness.check(button.getLabel() == null);
    }
}

