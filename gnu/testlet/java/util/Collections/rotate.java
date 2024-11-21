/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class rotate
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        List<String> list1 = new ArrayList<String>();
        list1.add("t");
        list1.add("a");
        list1.add("n");
        list1.add("k");
        list1.add("s");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("s");
        list2.add("t");
        list2.add("a");
        list2.add("n");
        list2.add("k");
        Collections.rotate(list1, -4);
        harness.check(list1.equals(list2));
        list1 = new ArrayList();
        Collections.rotate(list1, 2);
        harness.check(list1.isEmpty());
        boolean pass = false;
        try {
            Collections.rotate(null, 2);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        list1 = Collections.unmodifiableList(list1);
        pass = false;
        try {
            Collections.rotate(null, 2);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

