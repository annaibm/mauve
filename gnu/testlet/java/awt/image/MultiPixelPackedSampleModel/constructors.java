/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(int, int, int, int)");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        harness.check(m.getDataType(), 3);
        harness.check(m.getWidth(), 10);
        harness.check(m.getHeight(), 20);
        harness.check(m.getSampleSize(0), 8);
        harness.check(m.getNumBands(), 1);
        harness.check(m.getNumDataElements(), 1);
        harness.check(m.getScanlineStride(), 3);
        harness.check(m.getDataBitOffset(), 0);
        boolean pass = false;
        try {
            m = new MultiPixelPackedSampleModel(5, 10, 20, 8);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int, int)");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8, 5, 1);
        harness.check(m.getDataType(), 3);
        harness.check(m.getWidth(), 10);
        harness.check(m.getHeight(), 20);
        harness.check(m.getSampleSize(0), 8);
        harness.check(m.getNumBands(), 1);
        harness.check(m.getNumDataElements(), 1);
        harness.check(m.getScanlineStride(), 5);
        harness.check(m.getDataBitOffset(), 1);
    }
}

