/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.AbstractCollection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Vector;

public class AcuniaAddCollectionTest
extends AbstractCollection
implements Testlet {
    protected TestHarness th;
    public Vector v = new Vector();

    @Override
    public void test(TestHarness harness) {
        this.th = harness;
        this.test_add();
    }

    public void test_add() {
        this.th.checkPoint("add(java.lang.Object)boolean");
        AcuniaAddCollectionTest eac = new AcuniaAddCollectionTest();
        try {
            eac.add(this);
            this.th.fail("should throw an UnsupportedOperationException");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.check(true);
        }
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

