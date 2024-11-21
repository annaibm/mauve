/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Arrays;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class asList
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object[] a1 = new Object[]{"1", "2", "3"};
        List<Object> l1 = Arrays.asList(a1);
        harness.check(l1.size() == 3);
        harness.check(l1.get(0).equals("1"));
        harness.check(l1.get(1).equals("2"));
        harness.check(l1.get(2).equals("3"));
        harness.check(l1 instanceof RandomAccess);
        harness.check(l1 instanceof Serializable);
        l1.set(1, "99");
        harness.check(a1[1].equals("99"));
        a1[1] = "100";
        harness.check(l1.get(1).equals("100"));
        boolean pass = false;
        try {
            l1.add("new item");
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            l1.clear();
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            l1.remove(0);
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            l1.remove("1");
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.asList(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

