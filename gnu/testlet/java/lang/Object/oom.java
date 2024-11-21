/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Object;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public final class oom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object[] oarray = new Object[5];
        int[] iarray = null;
        try {
            int size2 = 1024;
            while (true) {
                iarray = new int[size2 <<= 1];
            }
        }
        catch (OutOfMemoryError oome) {
            try {
                oarray[0] = iarray.clone();
                oarray[1] = iarray.clone();
                oarray[2] = iarray.clone();
                oarray[3] = iarray.clone();
                oarray[4] = iarray.clone();
                harness.fail("clone didn't cause expected OutOfMemoryError");
            }
            catch (OutOfMemoryError e) {
                harness.check(true, "clone can exceed memory");
            }
            oarray = null;
            return;
        }
    }
}

