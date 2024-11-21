/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Vector;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Vector;

public class copyInto
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Vector<String> v1 = new Vector<String>();
        v1.add("A");
        v1.add("B");
        v1.add("C");
        Object[] array1 = new Object[3];
        v1.copyInto(array1);
        harness.check(array1[0], (Object)"A");
        harness.check(array1[1], (Object)"B");
        harness.check(array1[2], (Object)"C");
        Object[] array2 = new Object[]{"1", "2", "3", "4"};
        v1.copyInto(array2);
        harness.check(array2[0], (Object)"A");
        harness.check(array2[1], (Object)"B");
        harness.check(array2[2], (Object)"C");
        harness.check(array2[3], (Object)"4");
        Object[] array3 = new Object[]{"1", "2"};
        boolean pass = false;
        try {
            v1.copyInto(array3);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        harness.check(array3[0], (Object)"1");
        harness.check(array3[1], (Object)"2");
        pass = false;
        try {
            v1.copyInto(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

