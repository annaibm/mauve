/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.LinkedList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SubListTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SubListTest.test(harness, new LinkedList());
    }

    public static void test(TestHarness harness, List list2) {
        list2.clear();
        list2.add("0");
        list2.add("1");
        list2.add("2");
        list2.add("3");
        boolean start = true;
        int end2 = 3;
        List sub = list2.subList(1, 3);
        harness.check(sub.get(0).equals(list2.get(1)));
        Iterator it = sub.iterator();
        int i = 1;
        while (it.hasNext()) {
            harness.check(it.next().equals(list2.get(i)));
            ++i;
        }
        harness.check(i == 3);
    }
}

