/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.Kernel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.Kernel;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        float[] d1 = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f};
        Kernel k1 = new Kernel(3, 5, d1);
        harness.check(k1.getWidth(), 3);
        harness.check(k1.getHeight(), 5);
        harness.check(k1.getXOrigin(), 1);
        harness.check(k1.getYOrigin(), 2);
        d1[0] = Float.NaN;
        float[] d2 = k1.getKernelData(null);
        harness.check(!Float.isNaN(d2[0]));
        boolean pass = false;
        try {
            k1 = new Kernel(-1, 2, new float[]{1.0f, 2.0f});
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            k1 = new Kernel(1, -2, new float[]{1.0f, 2.0f});
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            k1 = new Kernel(1, 2, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

