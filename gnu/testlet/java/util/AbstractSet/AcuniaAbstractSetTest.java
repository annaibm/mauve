/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.AbstractSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Vector;

public class AcuniaAbstractSetTest
extends AbstractSet
implements Testlet {
    protected TestHarness th;
    public Vector v = new Vector();

    @Override
    public void test(TestHarness harness) {
        this.th = harness;
        this.test_equals();
        this.test_hashCode();
    }

    public void test_equals() {
        this.th.checkPoint("equals(java.lang.Object)boolean");
        AcuniaAbstractSetTest xas1 = new AcuniaAbstractSetTest();
        AcuniaAbstractSetTest xas2 = new AcuniaAbstractSetTest();
        this.th.check(xas1.equals(xas2), "checking equality -- 1");
        this.th.check(!xas1.equals(null), "checking equality -- 2");
        this.th.check(!xas1.equals(new Object()), "checking equality -- 3");
        this.th.check(xas1.equals(xas1), "checking equality -- 4");
        xas1.v.add(null);
        xas1.v.add("a");
        xas2.v.add("b");
        xas2.v.add(null);
        xas2.v.add("a");
        xas1.v.add("b");
        this.th.check(xas1.equals(xas2), "checking equality -- 5");
        this.th.check(xas1.equals(xas1), "checking equality -- 6");
    }

    public void test_hashCode() {
        this.th.checkPoint("hashCode()int");
        AcuniaAbstractSetTest xas = new AcuniaAbstractSetTest();
        this.th.check(xas.hashCode() == 0, "checking hc-algorithm -- 1");
        xas.v.add(null);
        this.th.check(xas.hashCode() == 0, "checking hc-algorithm -- 2");
        xas.v.add("a");
        int hash2 = "a".hashCode();
        this.th.check(xas.hashCode() == hash2, "checking hc-algorithm -- 3");
        xas.v.add("b");
        this.th.check(xas.hashCode() == (hash2 += "b".hashCode()), "checking hc-algorithm -- 4");
        xas.v.add("c");
        this.th.check(xas.hashCode() == (hash2 += "c".hashCode()), "checking hc-algorithm -- 5");
        xas.v.add("d");
        this.th.check(xas.hashCode() == (hash2 += "d".hashCode()), "checking hc-algorithm -- 6");
    }

    @Override
    public int size() {
        return this.v.size();
    }

    @Override
    public Iterator iterator() {
        return this.v.iterator();
    }
}

