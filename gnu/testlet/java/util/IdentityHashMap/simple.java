/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IdentityHashMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IdentityHashMap;

public class simple
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object k;
        int i;
        Integer[] is = new Integer[1000];
        Integer[] vs = new Integer[1000];
        IdentityHashMap<Integer, Integer> map2 = new IdentityHashMap<Integer, Integer>();
        for (i = 0; i < 1000; ++i) {
            is[i] = new Integer(i);
            vs[i] = new Integer(2000 + i);
            map2.put(is[i], vs[i]);
        }
        harness.check(map2.size(), 1000, "size");
        harness.checkPoint("values");
        for (i = 0; i < 1000; ++i) {
            k = map2.get(is[i]);
            harness.check(k, vs[i]);
        }
        harness.checkPoint("remove");
        for (i = 0; i < 1000; i += 2) {
            Object v = map2.remove(is[i]);
            harness.check(v, vs[i]);
        }
        harness.checkPoint("post remove");
        for (i = 1; i < 1000; i += 2) {
            k = map2.get(is[i]);
            harness.check(k, vs[i]);
        }
    }
}

