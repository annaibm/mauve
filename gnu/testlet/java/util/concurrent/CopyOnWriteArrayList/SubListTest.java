/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.concurrent.CopyOnWriteArrayList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SubListTest
implements Testlet {
    private int[] data = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

    @Override
    public void test(TestHarness harness) {
        Integer element;
        int n;
        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<Integer>();
        int[] nArray = this.data;
        int n2 = nArray.length;
        for (int i = 0; i < n2; ++i) {
            Integer element2 = nArray[i];
            list2.add(element2);
        }
        List<Integer> subList2 = list2.subList(5, 15);
        int i = 5;
        Iterator iterator = subList2.iterator();
        while (iterator.hasNext()) {
            int element3 = (Integer)iterator.next();
            harness.check(element3 == i);
            ++i;
        }
        harness.checkPoint("clear list");
        subList2.clear();
        harness.check(subList2.size() == 0);
        harness.check(list2.size() == 10);
        i = 0;
        iterator = list2.iterator();
        while (iterator.hasNext()) {
            int element4 = (Integer)iterator.next();
            harness.check(element4 == i);
            if (++i <= 4 || i >= 15) continue;
            i = 15;
        }
        harness.checkPoint("ConcurrentModificationException");
        list2.clear();
        iterator = (Iterator)this.data;
        int element4 = ((Object)iterator).length;
        for (n = 0; n < element4; ++n) {
            element = (int)iterator[n];
            list2.add(element);
        }
        subList2 = list2.subList(5, 15);
        list2.remove(5);
        try {
            iterator = subList2.iterator();
            while (iterator.hasNext()) {
                element4 = (Integer)iterator.next();
                harness.check(false);
            }
        }
        catch (ConcurrentModificationException e) {
            harness.check(true);
        }
        harness.checkPoint("Remove elements from SubList");
        list2.clear();
        iterator = (Iterator)this.data;
        element4 = ((Object)iterator).length;
        for (n = 0; n < element4; ++n) {
            element = (int)iterator[n];
            list2.add(element);
        }
        subList2 = list2.subList(5, 15);
        subList2.remove(0);
        subList2.remove(0);
        harness.check(subList2.size() == 8);
        harness.check(list2.size() == 18);
        subList2.add(0, 6);
        subList2.add(0, 5);
        i = 5;
        iterator = subList2.iterator();
        while (iterator.hasNext()) {
            element4 = (Integer)iterator.next();
            harness.check(element4 == i);
            ++i;
        }
    }
}

