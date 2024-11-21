/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class copy
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArrayList<String> l1 = new ArrayList<String>();
        List<String> l2 = new ArrayList<String>();
        Collections.copy(l2, l1);
        harness.check(l2.isEmpty());
        l1.add("A");
        l2.add("B");
        Collections.copy(l2, l1);
        harness.check(l2.get(0).equals("A"));
        l1 = new ArrayList();
        l1.add("A");
        l2 = new ArrayList();
        l2.add("B");
        l2.add("C");
        l2.add("D");
        Collections.copy(l2, l1);
        harness.check(l2.get(0).equals("A"));
        harness.check(l2.get(1).equals("C"));
        harness.check(l2.get(2).equals("D"));
        l1 = new ArrayList();
        l1.add("Item 1");
        l2 = new ArrayList();
        boolean pass = false;
        try {
            Collections.copy(l2, l1);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Collections.copy(null, l1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            Collections.copy(l2, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        l1 = new ArrayList();
        l1.add("A");
        l1.add("B");
        l2 = new ArrayList();
        l2.add("C");
        l2.add("D");
        l2 = Collections.unmodifiableList(l2);
        pass = false;
        try {
            Collections.copy(l2, l1);
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

