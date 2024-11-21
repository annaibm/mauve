/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Choice;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Choice;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Choice c = new Choice();
        harness.check(c.getSelectedIndex(), -1);
        harness.check(c.getItemCount(), 0);
        c.add("item1");
        harness.check(c.getSelectedIndex(), 0);
        harness.check(c.getItemCount(), 1);
        c.select(0);
        harness.check(c.getSelectedIndex(), 0);
        c.remove(0);
        harness.check(c.getSelectedIndex(), -1);
        harness.check(c.getItemCount(), 0);
        c.add("item1");
        c.add("item2");
        harness.check(c.getItemCount(), 2);
        c.select(0);
        harness.check(c.getSelectedIndex(), 0);
        c.select(1);
        harness.check(c.getSelectedIndex(), 1);
        c.remove(1);
        harness.check(c.getSelectedIndex(), 0);
        harness.check(c.getItemCount(), 1);
        c.remove(0);
        harness.check(c.getSelectedIndex(), -1);
        harness.check(c.getItemCount(), 0);
        harness.check(c.getSelectedIndex(), -1);
        c.add("item1");
        harness.check(c.getSelectedIndex(), 0);
        c.add("item2");
        harness.check(c.getSelectedIndex(), 0);
        c.add("item3");
        harness.check(c.getSelectedIndex(), 0);
        c.add("item4");
        harness.check(c.getSelectedIndex(), 0);
        harness.check(c.getItemCount(), 4);
        c.select(2);
        harness.check(c.getSelectedIndex(), 2);
        c.select(1);
        harness.check(c.getSelectedIndex(), 1);
        c.remove(1);
        harness.check(c.getSelectedIndex(), 0);
        harness.check(c.getItemCount(), 3);
        c.remove(0);
        harness.check(c.getSelectedIndex(), 0);
        harness.check(c.getItemCount(), 2);
        c.remove(0);
        harness.check(c.getSelectedIndex(), 0);
        harness.check(c.getItemCount(), 1);
        c.remove(0);
        harness.check(c.getSelectedIndex(), -1);
        harness.check(c.getItemCount(), 0);
        boolean fail = false;
        try {
            c.remove(2);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail = true;
        }
        harness.check(fail);
        c.add("item1");
        c.add("item2");
        c.add("item3");
        harness.check(c.getSelectedIndex(), 0);
        c.select(2);
        harness.check(c.getSelectedIndex(), 2);
        c.remove(2);
        harness.check(c.getSelectedIndex(), 0);
    }
}

