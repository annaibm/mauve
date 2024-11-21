/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.LookupTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.awt.image.LookupTable.MyLookupTable;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyLookupTable t = new MyLookupTable(1, 2);
        harness.check(t.getOffset(), 1);
        harness.check(t.getNumComponents(), 2);
        boolean pass = false;
        try {
            t = new MyLookupTable(-1, 2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            t = new MyLookupTable(1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

