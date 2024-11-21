/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.List;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.List;

public class testSelected
implements Testlet {
    private List list;

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
        this.test5(harness);
        this.test6(harness);
        this.test7(harness);
        this.test8(harness);
        this.test9(harness);
        this.test10(harness);
        this.test11(harness);
        this.test12(harness);
        this.test13(harness);
        this.test14(harness);
        this.test15(harness);
        this.test16(harness);
    }

    public void test1(TestHarness harness) {
        this.list = new List();
        harness.check(this.list.getSelectedIndex() == -1);
        this.list.setMultipleMode(false);
        this.list.add("item1");
        this.list.add("item2");
        this.list.select(0);
        this.list.select(1);
        harness.check(this.list.isSelected(0), false);
        harness.check(this.list.isSelected(1), true);
    }

    public void test2(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(true);
        this.list.add("item1");
        this.list.add("item2");
        this.list.select(0);
        this.list.select(1);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), true);
    }

    public void test3(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(false);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.select(0);
        this.list.select(2);
        this.list.select(1);
        harness.check(this.list.isSelected(0), false);
        harness.check(this.list.isSelected(1), true);
        harness.check(this.list.isSelected(2), false);
    }

    public void test4(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(true);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.select(0);
        this.list.select(2);
        this.list.select(1);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), true);
        harness.check(this.list.isSelected(2), true);
    }

    public void test5(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(false);
        this.list.add("item1");
        this.list.add("item2");
        this.list.select(0);
        this.list.select(1);
        harness.check(this.list.isSelected(0), false);
        harness.check(this.list.isSelected(1), true);
        this.list.deselect(1);
        harness.check(this.list.isSelected(0), false);
        harness.check(this.list.isSelected(1), false);
    }

    public void test6(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(true);
        this.list.add("item1");
        this.list.add("item2");
        this.list.select(0);
        this.list.select(1);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), true);
        this.list.deselect(1);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), false);
    }

    public void test7(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(true);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.add("item4");
        this.list.select(0);
        this.list.select(1);
        this.list.select(2);
        this.list.select(3);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), true);
        harness.check(this.list.isSelected(2), true);
        harness.check(this.list.isSelected(3), true);
        this.list.deselect(1);
        this.list.deselect(3);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), false);
        harness.check(this.list.isSelected(2), true);
        harness.check(this.list.isSelected(3), false);
    }

    public void test8(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(true);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.select(0);
        this.list.select(1);
        this.list.select(2);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), true);
        harness.check(this.list.isSelected(2), true);
        this.list.deselect(0);
        this.list.deselect(1);
        harness.check(this.list.isSelected(0), false);
        harness.check(this.list.isSelected(1), false);
        harness.check(this.list.isSelected(2), true);
    }

    public void test9(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(false);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.add("item4");
        this.list.select(0);
        this.list.select(1);
        this.list.select(2);
        this.list.select(3);
        harness.check(this.list.getItemCount(), 4);
        harness.check(this.list.isSelected(0), false);
        harness.check(this.list.isSelected(1), false);
        harness.check(this.list.isSelected(2), false);
        harness.check(this.list.isSelected(3), true);
        this.list.clear();
        harness.check(this.list.getItemCount(), 0);
    }

    public void test10(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(true);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.add("item4");
        this.list.select(0);
        this.list.select(2);
        harness.check(this.list.getItemCount(), 4);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), false);
        harness.check(this.list.isSelected(2), true);
        harness.check(this.list.isSelected(3), false);
        this.list.clear();
        harness.check(this.list.getItemCount(), 0);
    }

    public void test11(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(false);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.select(2);
        harness.check(this.list.getItemCount(), 3);
        harness.check(this.list.isSelected(0), false);
        harness.check(this.list.isSelected(1), false);
        harness.check(this.list.isSelected(2), true);
        this.list.delItem(2);
        harness.check(this.list.getItemCount(), 2);
        harness.check(this.list.isSelected(0), false);
        harness.check(this.list.isSelected(1), false);
        harness.check(this.list.isSelected(2), true);
        boolean exceptionCaught = false;
        try {
            this.list.getItem(2);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            exceptionCaught = true;
        }
        harness.check(exceptionCaught);
    }

    public void test12(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(true);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.select(0);
        this.list.select(1);
        harness.check(this.list.getItemCount(), 3);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), true);
        harness.check(this.list.isSelected(2), false);
        this.list.delItem(0);
        harness.check(this.list.getItemCount(), 2);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), true);
        this.list.delItem(1);
        harness.check(this.list.getItemCount(), 1);
        harness.check(this.list.isSelected(0), true);
    }

    public void test13(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(false);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.select(2);
        this.list.select(1);
        harness.check(this.list.getItemCount(), 3);
        harness.check(this.list.isSelected(0), false);
        harness.check(this.list.isSelected(1), true);
        harness.check(this.list.isSelected(2), false);
        this.list.delItems(1, 2);
        harness.check(this.list.getItemCount(), 1);
        harness.check(this.list.isSelected(0), false);
    }

    public void test14(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(true);
        this.list.add("item1");
        this.list.add("item2");
        this.list.add("item3");
        this.list.add("item4");
        this.list.select(0);
        this.list.select(3);
        harness.check(this.list.getItemCount(), 4);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), false);
        harness.check(this.list.isSelected(2), false);
        harness.check(this.list.isSelected(3), true);
        this.list.delItems(0, 1);
        harness.check(this.list.getItemCount(), 2);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), false);
    }

    public void test15(TestHarness harness) {
        this.list = new List();
        this.list.add("item1");
        this.list.select(0);
        this.list.deselect(1);
        harness.check(this.list.isSelected(0), true);
        boolean fail = false;
        harness.check(this.list.getItemCount(), 1);
        try {
            this.list.delItem(1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail = true;
        }
        harness.check(fail);
        harness.check(this.list.getItemCount(), 1);
        harness.check(this.list.isSelected(0), true);
        fail = false;
        this.list.add("item2");
        this.list.add("item3");
        harness.check(this.list.getItemCount(), 3);
        try {
            this.list.delItems(1, 3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail = true;
        }
        harness.check(fail);
        harness.check(this.list.getItemCount(), 3);
        fail = false;
        harness.check(this.list.getItemCount(), 3);
        try {
            this.list.delItems(-4, 1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail = true;
        }
        harness.check(fail);
        harness.check(this.list.getItemCount(), 1);
        fail = false;
        harness.check(this.list.getItemCount(), 1);
        try {
            this.list.delItems(-1, 5);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            fail = true;
        }
        harness.check(fail);
        harness.check(this.list.getItemCount(), 1);
        harness.check(this.list.getItemCount(), 1);
        this.list.delItems(4, 1);
        harness.check(this.list.getItemCount(), 1);
    }

    public void test16(TestHarness harness) {
        this.list = new List();
        this.list.setMultipleMode(false);
        this.list.add("item1");
        this.list.select(0);
        this.list.select(0);
        harness.check(this.list.isSelected(0), true);
        this.list.add("item2");
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), false);
        this.list.deselect(1);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), false);
        harness.check(this.list.isSelected(0), true);
        this.list.replaceItem("newItem1", 0);
        harness.check(this.list.isSelected(0), true);
        harness.check(this.list.isSelected(1), false);
        this.list.replaceItem("newItem2", 1);
        harness.check(this.list.isSelected(1), false);
    }
}

