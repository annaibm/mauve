/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.List;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Frame;
import java.awt.List;

public class testSetMultipleMode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    public void test1(TestHarness harness) {
        List list2 = new List();
        list2.setMultipleMode(true);
        harness.check(list2.isMultipleMode());
        list2.add("item");
        list2.add("item1");
        list2.select(1);
        list2.select(0);
        Frame f = new Frame("");
        f.add(list2);
        f.pack();
        harness.check(list2.getSelectedIndex(), -1);
        list2.setMultipleMode(false);
        harness.check(list2.getSelectedIndex(), 0);
        harness.check(list2.isMultipleMode(), false);
        harness.check(list2.getSelectedIndex(), 0);
        f.dispose();
    }

    public void test2(TestHarness harness) {
        List list2 = new List();
        list2.setMultipleMode(true);
        harness.check(list2.isMultipleMode());
        list2.add("item1");
        list2.add("item2");
        list2.add("item3");
        harness.check(list2.getItemCount(), 3);
        list2.select(1);
        list2.select(0);
        list2.select(2);
        harness.check(list2.isSelected(0));
        harness.check(list2.isSelected(1));
        harness.check(list2.isSelected(2));
        list2.setMultipleMode(false);
        harness.check(list2.isMultipleMode(), false);
        harness.check(list2.getItemCount(), 3);
        harness.check(list2.getSelectedIndex(), -1);
        harness.check(list2.isSelected(0));
        harness.check(list2.isSelected(1), true);
        harness.check(list2.isSelected(2), true);
    }

    public void test3(TestHarness harness) {
        List list2 = new List();
        list2.add("item1");
        list2.add("item2");
        list2.add("item3");
        harness.check(list2.isMultipleMode(), false);
        list2.select(2);
        list2.select(0);
        list2.select(1);
        harness.check(list2.isSelected(0), false);
        harness.check(list2.isSelected(1), true);
        harness.check(list2.isSelected(2), false);
        list2.setMultipleMode(true);
        harness.check(list2.isSelected(0), false);
        harness.check(list2.isSelected(1), true);
        harness.check(list2.isSelected(2), false);
    }
}

