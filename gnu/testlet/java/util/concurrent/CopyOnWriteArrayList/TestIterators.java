/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.concurrent.CopyOnWriteArrayList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestIterators
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.iteratorTests(harness);
        this.listIteratorTests(harness);
    }

    private void listIteratorTests(TestHarness harness) {
        harness.checkPoint("listIterator");
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 6, 7, 8, 9};
        CopyOnWriteArrayList list2 = new CopyOnWriteArrayList();
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 10; ++i) {
            data.add(i);
        }
        list2.addAll(data);
        ListIterator iterator = list2.listIterator();
        int i = 0;
        harness.checkPoint("listIterator - forward");
        while (iterator.hasNext()) {
            harness.check((Integer)iterator.next() == expected[i++]);
        }
        harness.checkPoint("listIterator - backward");
        while (iterator.hasPrevious()) {
            harness.check((Integer)iterator.previous() == expected[--i]);
        }
        harness.checkPoint("listIterator - forward from element");
        iterator = list2.listIterator(5);
        i = 5;
        while (iterator.hasNext()) {
            harness.check((Integer)iterator.next() == expected[i++]);
        }
        harness.checkPoint("listIterator - backward from element");
        while (iterator.hasPrevious()) {
            harness.check((Integer)iterator.previous() == expected[--i]);
        }
    }

    private void iteratorTests(TestHarness harness) {
        int i;
        harness.checkPoint("iterator");
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CopyOnWriteArrayList list2 = new CopyOnWriteArrayList();
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (i = 0; i < 10; ++i) {
            data.add(i);
        }
        list2.addAll(data);
        i = 0;
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            harness.check((Integer)iterator.next() == expected[i++]);
        }
        harness.checkPoint("iterator - snapshot");
        iterator = list2.iterator();
        list2.clear();
        harness.check(list2.size() == 0);
        i = 0;
        while (iterator.hasNext()) {
            harness.check((Integer)iterator.next() == expected[i++]);
        }
        harness.checkPoint("iterator - remove");
        list2.addAll(data);
        try {
            Iterator iter2 = list2.iterator();
            while (iter2.hasNext()) {
                iter2.remove();
                harness.check(false);
            }
            harness.check(false);
        }
        catch (UnsupportedOperationException e) {
            harness.check(true);
        }
    }
}

