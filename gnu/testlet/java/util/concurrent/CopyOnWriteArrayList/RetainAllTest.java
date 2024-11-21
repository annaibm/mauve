/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.concurrent.CopyOnWriteArrayList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class RetainAllTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int i;
        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<Integer>();
        for (int i2 = 0; i2 < 10; ++i2) {
            list2.add(i2);
        }
        ArrayList<Integer> list22 = new ArrayList<Integer>();
        for (i = 5; i < 15; ++i) {
            list22.add(i);
        }
        list2.retainAll(list22);
        harness.check(list2.size() == 5);
        i = 5;
        ListIterator elements2 = list2.listIterator();
        while (elements2.hasNext()) {
            harness.check((Integer)elements2.next() == i);
            ++i;
        }
    }
}

