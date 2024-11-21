/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.Kernel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.Kernel;
import java.util.Arrays;

public class getKernelData
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        float[] d1 = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f};
        Kernel k1 = new Kernel(3, 5, d1);
        float[] d2 = k1.getKernelData(null);
        harness.check(d1 != d2);
        harness.check(Arrays.equals(d1, d2));
        boolean pass = false;
        try {
            d2 = new float[14];
            d2 = k1.getKernelData(d2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

