/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Object;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Vector;

public class ObjectTest
implements Testlet {
    boolean finFlag = false;
    protected static TestHarness harness;

    public void test_getClass() {
        ObjectTest obj;
        Integer i = new Integer(10);
        Class<?> cls = i.getClass();
        if (cls == null) {
            harness.fail("Error: test_getClass returned null");
        }
        if ((obj = new ObjectTest()).getClass() != this.getClass()) {
            harness.fail("Error: test_getClass returned wrong class");
        }
    }

    public void test_toString() {
        if (this.toString() == null) {
            harness.fail("Error: test_toString returned null string");
        }
        if (!this.toString().equals(this.getClass().getName() + "@" + Integer.toHexString(this.hashCode()))) {
            harness.fail("Error: test_toString returned wrong string");
        }
    }

    public void test_equals() {
        Object p;
        ObjectTest nu1;
        ObjectTest nu = this;
        if (this != nu) {
            harness.fail("Error: test_equals returned wrong results - 1");
        }
        if (!this.equals(nu)) {
            harness.fail("Error: test_equals returned wrong results - 2");
        }
        if (!nu.equals(nu)) {
            harness.fail("Error: test_equals returned wrong results - 3");
        }
        if (!nu.equals(nu1 = nu) || !nu1.equals(nu)) {
            harness.fail("Error: test_equals returned wrong results - 4");
        }
        if (!(nu.equals(nu1) && nu1.equals(this) && this.equals(nu))) {
            harness.fail("Error: test_equals returned wrong results - 5");
        }
        if (this.equals(p = null)) {
            harness.fail("Error: test_equals returned wrong results - 6");
        }
    }

    public void test_hashCode() {
        int hash2;
        ObjectTest s = this;
        if (s.hashCode() != this.hashCode()) {
            harness.fail("Error: test_hashCode returned wrong results - 1");
        }
        if ((hash2 = s.hashCode()) != s.hashCode()) {
            harness.fail("Error: test_hashCode returned wrong results - 2");
        }
    }

    public void test_clone() {
        try {
            this.clone();
            harness.fail("Error: test_clone did not raise CloneNotSupportedException");
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            // empty catch block
        }
        Vector v = new Vector();
        try {
            Vector vclone = (Vector)v.clone();
        }
        catch (Exception e) {
            if (e instanceof CloneNotSupportedException) {
                harness.fail("Error: test_clone should not raise CloneNotSupportedException on Vector ");
            }
            harness.fail("Error: test_clone should not raise Exception " + e + " on Vector ");
        }
    }

    public void testall() {
        this.test_getClass();
        this.test_toString();
        this.test_equals();
        this.test_hashCode();
        this.test_clone();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

