/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.MultiPixelPackedSampleModel;

public class getPixel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        db.setElem(3, -1430532899);
        harness.check(m.getPixel(0, 1, (int[])null, db)[0], 170);
        harness.check(m.getPixel(1, 1, (int[])null, db)[0], 187);
        harness.check(m.getPixel(2, 1, (int[])null, db)[0], 204);
        harness.check(m.getPixel(3, 1, (int[])null, db)[0], 221);
        boolean pass = false;
        try {
            m.getPixel(3, 1, (int[])null, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8, 4, 16);
        DataBuffer db = m.createDataBuffer();
        db.setElem(5, -1430532899);
        harness.check(m.getPixel(0, 1, (int[])null, db)[0], 0);
        harness.check(m.getPixel(1, 1, (int[])null, db)[0], 0);
        harness.check(m.getPixel(2, 1, (int[])null, db)[0], 170);
        harness.check(m.getPixel(3, 1, (int[])null, db)[0], 187);
        harness.check(m.getPixel(4, 1, (int[])null, db)[0], 204);
        harness.check(m.getPixel(5, 1, (int[])null, db)[0], 221);
    }
}

