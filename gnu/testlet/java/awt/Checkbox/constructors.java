/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Checkbox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Checkbox checkbox1 = new Checkbox();
        harness.check(checkbox1 != null);
        harness.check(!checkbox1.getState());
        this.doCommonTests(harness, checkbox1);
        Checkbox checkbox2 = new Checkbox("xyzzy");
        harness.check(checkbox2 != null);
        harness.check(checkbox2.getLabel(), (Object)"xyzzy");
        harness.check(!checkbox2.getState());
        this.doCommonTests(harness, checkbox2);
        Checkbox checkbox3 = new Checkbox("xyzzy", false);
        harness.check(checkbox3 != null);
        harness.check(checkbox3.getLabel(), (Object)"xyzzy");
        harness.check(!checkbox3.getState());
        this.doCommonTests(harness, checkbox3);
        Checkbox checkbox4 = new Checkbox("xyzzy", true);
        harness.check(checkbox4 != null);
        harness.check(checkbox4.getLabel(), (Object)"xyzzy");
        harness.check(checkbox4.getState());
        this.doCommonTests(harness, checkbox4);
    }

    public void doCommonTests(TestHarness harness, Checkbox checkbox) {
        checkbox.setLabel("42");
        harness.check(checkbox.getLabel(), (Object)"42");
        checkbox.setLabel("");
        harness.check(checkbox.getLabel(), (Object)"");
        checkbox.setLabel(" ");
        harness.check(checkbox.getLabel(), (Object)" ");
        checkbox.setLabel(null);
        harness.check(checkbox.getLabel() == null);
        checkbox.setState(true);
        harness.check(checkbox.getState());
        checkbox.setState(false);
        harness.check(!checkbox.getState());
    }
}

