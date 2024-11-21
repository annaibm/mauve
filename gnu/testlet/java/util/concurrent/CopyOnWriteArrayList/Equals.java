/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.concurrent.CopyOnWriteArrayList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CopyOnWriteArrayList<String> one = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10; ++i) {
            one.add("#" + i);
        }
        CopyOnWriteArrayList<String> two = (CopyOnWriteArrayList<String>)one.clone();
        harness.checkPoint("cloned CopyOnWriteArrayList");
        harness.check(one.equals(two));
        two.clear();
        two = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10; ++i) {
            two.add("#" + i);
        }
        harness.checkPoint("both CopyOnWriteArrayList, same elements, different instances");
        harness.check(one.equals(two));
        ArrayList<String> someList = new ArrayList<String>();
        for (int i = 0; i < 10; ++i) {
            someList.add("#" + i);
        }
        harness.checkPoint("Different list, CopyOnWriteArrayList and ArrayList, but same elements");
        harness.check(one.equals(someList));
        one.remove(one.size() - 1);
        harness.checkPoint("removed elements from CopyOnWriteArrayList");
        harness.check(!one.equals(two));
        harness.check(!one.equals(someList));
    }
}

