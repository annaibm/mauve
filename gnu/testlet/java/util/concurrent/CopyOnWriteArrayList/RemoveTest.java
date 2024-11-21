/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.concurrent.CopyOnWriteArrayList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class RemoveTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CopyOnWriteArrayList list2 = new CopyOnWriteArrayList();
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 10; ++i) {
            data.add(i);
        }
        list2.addAll(data);
        harness.check(list2.size() == 10);
        Integer el = (Integer)list2.remove(5);
        harness.check(el == 5);
        harness.check(list2.size() == 9);
        harness.check(list2.add(el));
        harness.check(list2.size() == 10);
        harness.check(list2.remove(el));
        harness.check(list2.size() == 9);
        int[] expected = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9};
        int i = 0;
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            harness.check((Integer)iterator.next() == expected[i++]);
        }
    }
}

