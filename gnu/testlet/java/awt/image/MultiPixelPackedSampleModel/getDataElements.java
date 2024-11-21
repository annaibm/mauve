/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.MultiPixelPackedSampleModel;

public class getDataElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("test1()");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        db.setElem(3, -1430532899);
        byte[] elements2 = (byte[])m.getDataElements(0, 1, null, db);
        harness.check(elements2.length, 1);
        harness.check(elements2[0], -86);
        elements2 = (byte[])m.getDataElements(1, 1, null, db);
        harness.check(elements2.length, 1);
        harness.check(elements2[0], -69);
        elements2 = (byte[])m.getDataElements(2, 1, null, db);
        harness.check(elements2.length, 1);
        harness.check(elements2[0], -52);
        elements2 = (byte[])m.getDataElements(3, 1, null, db);
        harness.check(elements2.length, 1);
        harness.check(elements2[0], -35);
        boolean pass = false;
        try {
            m.getDataElements(3, 1, null, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("test2()");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 16);
        DataBuffer db = m.createDataBuffer();
        db.setElem(5, -1430532899);
        short[] elements2 = (short[])m.getDataElements(0, 1, null, db);
        harness.check(elements2.length, 1);
        harness.check(elements2[0], -21829);
        elements2 = (short[])m.getDataElements(1, 1, null, db);
        harness.check(elements2.length, 1);
        harness.check(elements2[0], -13091);
    }
}

