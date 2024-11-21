/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Scrollbar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Scrollbar;

public class testSetValues
implements Testlet {
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
    }

    public void test1(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(0, 1, 1, 2);
        harness.check(bar.getValue(), 1);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), 1);
        harness.check(bar.getMaximum(), 2);
    }

    public void test2(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(4, -5, 4, 8);
        harness.check(bar.getValue(), 4);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), 4);
        harness.check(bar.getMaximum(), 8);
    }

    public void test3(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(0, 0, 5, 10);
        harness.check(bar.getValue(), 5);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), 5);
        harness.check(bar.getMaximum(), 10);
    }

    public void test4(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(10, 1, 10, 5);
        harness.check(bar.getValue(), 10);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), 10);
        harness.check(bar.getMaximum(), 11);
    }

    public void test5(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(10, 1, 5, 10);
        harness.check(bar.getValue(), 9);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), 5);
        harness.check(bar.getMaximum(), 10);
    }

    public void test6(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(5, 30, 5, 20);
        harness.check(bar.getValue(), 5);
        harness.check(bar.getVisibleAmount(), 15);
        harness.check(bar.getMinimum(), 5);
        harness.check(bar.getMaximum(), 20);
    }

    public void test7(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(5, 10, 20, 20);
        harness.check(bar.getValue(), 20);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), 20);
        harness.check(bar.getMaximum(), 21);
    }

    public void test8(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(-3, -2, -4, -8);
        harness.check(bar.getValue(), -4);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), -4);
        harness.check(bar.getMaximum(), -3);
    }

    public void test9(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(0, 10, -100, 100);
        harness.check(bar.getValue(), 0);
        harness.check(bar.getVisibleAmount(), 10);
        harness.check(bar.getMinimum(), -100);
        harness.check(bar.getMaximum(), 100);
        bar.setMinimum(Integer.MIN_VALUE);
        harness.check(bar.getValue(), -11);
        harness.check(bar.getVisibleAmount(), 10);
        harness.check(bar.getMinimum(), Integer.MIN_VALUE);
        harness.check(bar.getMaximum(), -1);
    }

    public void test10(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(1, 1, 1, 2);
        harness.check(bar.getValue(), 1);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), 1);
        harness.check(bar.getMaximum(), 2);
        bar.setUnitIncrement(4);
        harness.check(bar.getUnitIncrement() > bar.getMaximum() - bar.getMinimum());
        harness.check(bar.getUnitIncrement() == 4);
        harness.check(bar.getUnitIncrement() != bar.getMaximum() - bar.getMinimum());
    }

    public void test11(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        bar.setValues(1, 1, 1, 2);
        harness.check(bar.getValue(), 1);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), 1);
        harness.check(bar.getMaximum(), 2);
        bar.setBlockIncrement(4);
        harness.check(bar.getBlockIncrement() > bar.getMaximum() - bar.getMinimum());
        harness.check(bar.getBlockIncrement() == 4);
        harness.check(bar.getBlockIncrement() != bar.getMaximum() - bar.getMinimum());
    }
}

