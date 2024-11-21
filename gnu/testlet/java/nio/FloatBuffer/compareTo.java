/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.FloatBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.FloatBuffer;

public class compareTo
implements Testlet {
    @Override
    public void test(TestHarness h) {
        float[] farray = new float[]{Float.NaN};
        FloatBuffer fb1 = FloatBuffer.wrap(farray);
        FloatBuffer fb2 = FloatBuffer.wrap(farray);
        h.check(fb1.compareTo(fb2), 0, "float buffer compare with NaN entry");
    }
}

