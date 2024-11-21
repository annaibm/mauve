/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.concurrent.CopyOnWriteArrayList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class AddAllTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testAdd(harness);
        this.testExceptions(harness);
    }

    private void testExceptions(TestHarness harness) {
        CopyOnWriteArrayList<Object> list2 = new CopyOnWriteArrayList<Object>();
        ArrayList<Integer> list22 = new ArrayList<Integer>();
        list22.add(0);
        harness.checkPoint("addAll - IndexOutOfBoundsException");
        try {
            list2.addAll(-1, list22);
            harness.check(false);
        }
        catch (IndexOutOfBoundsException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false, "Exception of unexpected type: " + e.getMessage());
        }
        list2.add(0);
        list2.add(1);
        try {
            list2.addAll(list2.size() + 1, list22);
            harness.check(false);
        }
        catch (IndexOutOfBoundsException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false, "Exception of unexpected type: " + e.getMessage());
        }
        harness.checkPoint("addAll - NullPointerException");
        try {
            list2.addAll(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false, "Exception of unexpected type: " + e.getMessage());
        }
    }

    private void testAdd(TestHarness harness) {
        int i;
        harness.checkPoint("addAll");
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<Integer>();
        for (int i2 = 0; i2 < 10; ++i2) {
            list2.add(i2);
        }
        ArrayList<Integer> list22 = new ArrayList<Integer>();
        for (i = 5; i < 15; ++i) {
            list22.add(i);
        }
        list2.addAll(list22);
        harness.check(list2.size() == 20);
        i = 0;
        ListIterator elements2 = list2.listIterator();
        while (elements2.hasNext()) {
            harness.check((Integer)elements2.next() == expected[i++]);
        }
    }
}

