/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.MultiPixelPackedSampleModel;

public class setDataElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testTYPE_BYTE(harness);
        this.testTYPE_USHORT(harness);
        this.testBadTransferArray(harness);
        this.testNullTransferArray(harness);
    }

    public void testTYPE_BYTE(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(0, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        m.setDataElements(2, 1, new byte[]{-6}, db);
        harness.check(db.getElem(12), 250);
    }

    public void testTYPE_USHORT(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(1, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        m.setDataElements(0, 0, new byte[]{18}, db);
        harness.check(db.getElem(0), 4608);
        m.setDataElements(1, 0, new byte[]{52}, db);
        harness.check(db.getElem(0), 4660);
        m.setDataElements(2, 1, new byte[]{-85}, db);
        harness.check(db.getElem(6), 43776);
        m.setDataElements(3, 1, new byte[]{-51}, db);
        harness.check(db.getElem(6), 43981);
    }

    public void testBadTransferArray(TestHarness harness) {
        harness.checkPoint("testBadTransferArray()");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(0, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        boolean pass = false;
        try {
            m.setDataElements(2, 1, new int[]{250}, db);
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
        m = new MultiPixelPackedSampleModel(1, 10, 20, 8);
        db = m.createDataBuffer();
        pass = false;
        try {
            m.setDataElements(2, 1, new short[]{250}, db);
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
        m = new MultiPixelPackedSampleModel(1, 10, 20, 16);
        db = m.createDataBuffer();
        pass = false;
        try {
            m.setDataElements(2, 1, new byte[]{-6}, db);
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 16);
        db = m.createDataBuffer();
        pass = false;
        try {
            m.setDataElements(2, 1, new byte[]{-6}, db);
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testNullTransferArray(TestHarness harness) {
        harness.checkPoint("testNullTransferArray()");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(0, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        boolean pass = false;
        try {
            m.setDataElements(2, 1, null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        m = new MultiPixelPackedSampleModel(1, 10, 20, 8);
        db = m.createDataBuffer();
        pass = false;
        try {
            m.setDataElements(2, 1, null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        m = new MultiPixelPackedSampleModel(1, 10, 20, 16);
        db = m.createDataBuffer();
        pass = false;
        try {
            m.setDataElements(2, 1, null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 16);
        db = m.createDataBuffer();
        pass = false;
        try {
            m.setDataElements(2, 1, null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

