/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;

public class createDataBuffer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testSingleBand(harness);
        this.testMultiBand(harness);
    }

    public void testSingleBand(TestHarness harness) {
        ComponentSampleModel m = new ComponentSampleModel(0, 10, 20, 1, 30, new int[]{0, 1, 2});
        DataBuffer db = m.createDataBuffer();
        harness.check(db.getDataType(), 0);
        harness.check(db.getNumBanks(), 1);
        harness.check(db.getSize(), 582);
        m = new ComponentSampleModel(3, 5, 10, 1, 5, new int[]{0, 1, 2});
        db = m.createDataBuffer();
        harness.check(db.getDataType(), 3);
        harness.check(db.getNumBanks(), 1);
        harness.check(db.getSize(), 52);
        m = new ComponentSampleModel(3, 5, 10, 1, 6, new int[]{0, 1, 2});
        db = m.createDataBuffer();
        harness.check(db.getDataType(), 3);
        harness.check(db.getNumBanks(), 1);
        harness.check(db.getSize(), 61);
        m = new ComponentSampleModel(3, 5, 10, 2, 10, new int[]{0, 1});
        db = m.createDataBuffer();
        harness.check(db.getDataType(), 3);
        harness.check(db.getNumBanks(), 1);
        harness.check(db.getSize(), 100);
    }

    public void testMultiBand(TestHarness harness) {
        harness.checkPoint("testMultiBand()");
        ComponentSampleModel m = new ComponentSampleModel(0, 10, 20, 1, 10, new int[]{0, 1, 2}, new int[]{0, 0, 0});
        DataBuffer db = m.createDataBuffer();
        harness.check(db.getDataType(), 0);
        harness.check(db.getNumBanks(), 3);
        harness.check(db.getSize(), 200);
    }
}

