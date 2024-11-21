/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fill
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        List<String> list2 = new ArrayList<String>();
        Collections.fill(list2, "X");
        harness.check(list2.isEmpty());
        list2.add("A");
        Collections.fill(list2, "X");
        harness.check(list2.get(0).equals("X"));
        list2 = new ArrayList();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        Collections.fill(list2, "X");
        harness.check(list2.get(0).equals("X"));
        harness.check(list2.get(1).equals("X"));
        harness.check(list2.get(2).equals("X"));
        boolean pass = false;
        try {
            Collections.fill(null, "X");
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        Collections.fill(list2, null);
        harness.check(list2.get(0) == null);
        harness.check(list2.get(1) == null);
        harness.check(list2.get(2) == null);
        list2 = new ArrayList();
        list2.add("A");
        list2.add("B");
        list2 = Collections.unmodifiableList(list2);
        pass = false;
        try {
            Collections.fill(list2, "X");
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

