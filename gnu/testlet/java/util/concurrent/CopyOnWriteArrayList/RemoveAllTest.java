/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.concurrent.CopyOnWriteArrayList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class RemoveAllTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int i;
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<String>();
        for (int i2 = 0; i2 < 10; ++i2) {
            list2.add("#" + i2);
        }
        ArrayList<String> list22 = new ArrayList<String>();
        for (i = 3; i < 20; ++i) {
            list22.add("#" + i);
        }
        list2.removeAll(list22);
        harness.check(list2.size() == 3);
        i = 0;
        ListIterator elements2 = list2.listIterator();
        while (elements2.hasNext()) {
            harness.check(((String)elements2.next()).equals("#" + i));
            ++i;
        }
    }
}

