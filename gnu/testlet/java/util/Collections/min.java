/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class min
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object e3;
        ArrayList<Object> list2 = new ArrayList<Object>();
        boolean pass = false;
        try {
            Object e2 = Collections.min(list2);
        }
        catch (NoSuchElementException e3) {
            pass = true;
        }
        harness.check(true);
        list2.add(new Integer(12));
        list2.add(new Integer(9));
        list2.add(new Integer(17));
        harness.check(((Comparable)Collections.min(list2)).equals(new Integer(9)));
        pass = false;
        try {
            e3 = Collections.min(null);
        }
        catch (NullPointerException e4) {
            pass = true;
        }
        harness.check(pass);
        list2.clear();
        list2.add("A");
        list2.add(new Long(1L));
        pass = false;
        try {
            e3 = Collections.min(list2);
        }
        catch (ClassCastException e5) {
            pass = true;
        }
        harness.check(pass);
    }
}

