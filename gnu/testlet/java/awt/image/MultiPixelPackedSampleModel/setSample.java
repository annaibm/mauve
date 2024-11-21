/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.MultiPixelPackedSampleModel;

public class setSample
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.testTYPE_USHORT(harness);
        this.testTYPE_BYTE(harness);
    }

    public void test1(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        m.setSample(0, 1, 0, 170, db);
        m.setSample(1, 1, 0, 187, db);
        m.setSample(2, 1, 0, 204, db);
        m.setSample(3, 1, 0, 221, db);
        harness.check(db.getElem(3), -1430532899);
        boolean pass = false;
        try {
            m.setSample(3, 1, 0, 170, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8, 4, 16);
        DataBuffer db = m.createDataBuffer();
        m.setSample(2, 1, 0, 170, db);
        m.setSample(3, 1, 0, 187, db);
        m.setSample(4, 1, 0, 204, db);
        m.setSample(5, 1, 0, 221, db);
        harness.check(db.getElem(5), -1430532899);
    }

    public void testTYPE_USHORT(TestHarness harness) {
        harness.checkPoint("TYPE_USHORT");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(1, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        m.setSample(0, 0, 0, 18, db);
        harness.check(db.getElem(0), 4608);
        m.setSample(1, 0, 0, 52, db);
        harness.check(db.getElem(0), 4660);
        m.setSample(2, 1, 0, 171, db);
        harness.check(db.getElem(6), 43776);
        m.setSample(3, 1, 0, 205, db);
        harness.check(db.getElem(6), 43981);
    }

    public void testTYPE_BYTE(TestHarness harness) {
        harness.checkPoint("TYPE_BYTE");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(0, 10, 20, 2);
        DataBuffer db = m.createDataBuffer();
        m.setSample(0, 0, 0, 1, db);
        harness.check(db.getElem(0), 64);
        m.setSample(1, 0, 0, 2, db);
        harness.check(db.getElem(0), 96);
        m.setSample(2, 1, 0, 3, db);
        harness.check(db.getElem(3), 12);
        m.setSample(3, 1, 0, 4, db);
        harness.check(db.getElem(3), 12);
    }
}

