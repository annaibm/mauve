/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class getTransferType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBYTE(harness);
        this.testUSHORT(harness);
        this.testINT(harness);
    }

    public void testBYTE(TestHarness harness) {
        harness.checkPoint("testBYTE()");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(0, 10, 20, 1);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(0, 10, 20, 2);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(0, 10, 20, 4);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(0, 10, 20, 8);
        harness.check(m.getTransferType(), 0);
    }

    public void testUSHORT(TestHarness harness) {
        harness.checkPoint("testUSHORT()");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(1, 10, 20, 1);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(1, 10, 20, 2);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(1, 10, 20, 4);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(1, 10, 20, 8);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(1, 10, 20, 16);
        harness.check(m.getTransferType(), 1);
    }

    public void testINT(TestHarness harness) {
        harness.checkPoint("testINT()");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 1);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 2);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 4);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        harness.check(m.getTransferType(), 0);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 16);
        harness.check(m.getTransferType(), 1);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 32);
        harness.check(m.getTransferType(), 3);
    }
}

