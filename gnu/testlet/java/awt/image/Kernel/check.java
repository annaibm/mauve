/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.Kernel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.Kernel;

public class check
implements Testlet {
    @Override
    public void test(TestHarness h) {
        float[] data1;
        float[] data = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f};
        Kernel k = new Kernel(3, 4, data);
        h.check(k != null);
        h.check(k.getWidth() == 3);
        h.check(k.getHeight() == 4);
        h.check(k.getXOrigin() == 1);
        h.check(k.getYOrigin() == 1);
        try {
            data1 = k.getKernelData(null);
        }
        catch (IllegalArgumentException e) {
            data1 = new float[]{};
            h.fail("Kernel.getKernelData");
        }
        h.checkPoint("Check kernel data");
        boolean ok = true;
        h.check(data1.length == data.length);
        for (int i = 0; i < data1.length; ++i) {
            if (data[i] == data1[i]) continue;
            ok = false;
            break;
        }
        h.check(ok);
        data1 = new float[12];
        try {
            data1 = k.getKernelData(data1);
        }
        catch (IllegalArgumentException e) {
            h.fail("Kernel.getKernelData");
        }
        ok = true;
        h.check(data1.length == data.length);
        for (int i = 0; i < data1.length; ++i) {
            if (data[i] == data1[i]) continue;
            ok = false;
            break;
        }
        h.check(ok);
        h.checkPoint("Failure modes");
        ok = false;
        try {
            k.getKernelData(new float[1]);
        }
        catch (IllegalArgumentException e) {
            ok = true;
        }
        h.check(ok);
        ok = false;
        try {
            k = new Kernel(10, 10, data);
        }
        catch (IllegalArgumentException e) {
            ok = true;
        }
        h.check(ok);
        data = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f};
        k = new Kernel(3, 4, data);
        data1 = k.getKernelData(null);
        h.check(data1.length == 12);
        ok = true;
        for (int i = 0; i < data1.length; ++i) {
            if (data[i] == data1[i]) continue;
            ok = false;
            break;
        }
        h.check(ok);
    }
}

