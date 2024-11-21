/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.RescaleOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.RescaleOp;
import java.util.Arrays;

public class getOffsets
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int i;
        RescaleOp op = new RescaleOp(1.0f, 1.0f, null);
        harness.check(Arrays.equals(op.getOffsets(null), new float[]{1.0f}));
        op = new RescaleOp(new float[]{1.0f}, new float[]{1.0f}, null);
        harness.check(Arrays.equals(op.getOffsets(null), new float[]{1.0f}));
        float[] flt = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        op = new RescaleOp(flt, flt, null);
        harness.check(op.getOffsets(null) != flt);
        harness.check(Arrays.equals(op.getOffsets(null), new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}));
        op = new RescaleOp(new float[]{1.0f, 2.0f}, flt, null);
        harness.check(op.getOffsets(null).length == 2);
        harness.check(op.getOffsets(null)[0] == 1.0f);
        harness.check(op.getOffsets(null)[1] == 2.0f);
        op = new RescaleOp(flt, flt, null);
        float[] arr = new float[5];
        harness.check(Arrays.equals(op.getOffsets(arr), arr));
        harness.check(Arrays.equals(arr, flt));
        arr = new float[10];
        Arrays.fill(arr, 25.0f);
        op.getOffsets(arr);
        for (i = 0; i < 5; ++i) {
            harness.check(arr[i] == flt[i]);
        }
        for (i = 5; i < arr.length; ++i) {
            harness.check(arr[i] == 25.0f);
        }
        arr = new float[2];
        try {
            harness.check(op.getOffsets(arr).length == 2);
            harness.check(op.getOffsets(arr)[0] == 1.0f);
            harness.check(op.getOffsets(arr)[1] == 2.0f);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            harness.check(false);
        }
    }
}

