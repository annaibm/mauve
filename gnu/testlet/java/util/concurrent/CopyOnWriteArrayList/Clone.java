/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.concurrent.CopyOnWriteArrayList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10; ++i) {
            list2.add("#" + i);
        }
        CopyOnWriteArrayList cloned = (CopyOnWriteArrayList)list2.clone();
        harness.check(list2.size() == 10);
        harness.check(cloned.size() == list2.size());
        Iterator original = list2.iterator();
        for (String element : cloned) {
            harness.check(original.hasNext());
            harness.check(element, original.next());
        }
    }
}

