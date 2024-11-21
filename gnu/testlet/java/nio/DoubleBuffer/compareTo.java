/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.DoubleBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.DoubleBuffer;

public class compareTo
implements Testlet {
    @Override
    public void test(TestHarness h) {
        double[] darray = new double[]{Double.NaN};
        DoubleBuffer fb1 = DoubleBuffer.wrap(darray);
        DoubleBuffer fb2 = DoubleBuffer.wrap(darray);
        h.check(fb1.compareTo(fb2), 0, "double buffer compare with NaN entry");
    }
}

