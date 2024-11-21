/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.MultiPixelPackedSampleModel;

public class setPixel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        m.setPixel(0, 1, new int[]{170}, db);
        m.setPixel(1, 1, new int[]{187}, db);
        m.setPixel(2, 1, new int[]{204}, db);
        m.setPixel(3, 1, new int[]{221}, db);
        harness.check(db.getElem(3), -1430532899);
        boolean pass = false;
        try {
            m.setPixel(3, 1, new int[]{170}, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8, 4, 16);
        DataBuffer db = m.createDataBuffer();
        m.setPixel(2, 1, new int[]{170}, db);
        m.setPixel(3, 1, new int[]{187}, db);
        m.setPixel(4, 1, new int[]{204}, db);
        m.setPixel(5, 1, new int[]{221}, db);
        harness.check(db.getElem(5), -1430532899);
    }
}

