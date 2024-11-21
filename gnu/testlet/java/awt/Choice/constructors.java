/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Choice;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Choice;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Choice choice = new Choice();
        harness.check(choice != null);
        harness.check(choice.getItemCount(), 0);
        harness.check(choice.countItems(), 0);
        harness.check(choice.getSelectedIndex(), -1);
    }
}

