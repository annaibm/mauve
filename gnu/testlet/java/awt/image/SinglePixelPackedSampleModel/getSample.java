/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferByte;
import java.awt.image.SinglePixelPackedSampleModel;

public class getSample
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 2, 2, new int[]{240, 15});
        DataBufferByte db = new DataBufferByte(new byte[]{18, 52, -85, -51}, 4);
        int sample = m1.getSample(1, 1, 1, db);
        harness.check(sample, 13);
        try {
            sample = m1.getSample(-2, 0, 0, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            sample = m1.getSample(0, -1, 0, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            sample = m1.getSample(0, 0, 0, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

