/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.LinkedHashMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Regress
implements Testlet {
    @Override
    public void test(TestHarness th) {
        th.checkPoint("regression test of access order");
        LinkedHashMap<Integer, Object> hm = new LinkedHashMap<Integer, Object>(5, 0.5f, true);
        hm.put(new Integer(1), new Object());
        hm.put(new Integer(2), new Object());
        hm.put(new Integer(3), new Object());
        hm.get(new Integer(2));
        hm.get(new Integer(3));
        Iterator i = hm.keySet().iterator();
        int count = 1;
        boolean ok = true;
        while (i.hasNext()) {
            Integer key = (Integer)i.next();
            if (key != count) {
                ok = false;
            }
            ++count;
        }
        th.check(ok);
    }
}

