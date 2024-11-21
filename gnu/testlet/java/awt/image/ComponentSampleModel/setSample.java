/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferDouble;
import java.awt.image.DataBufferFloat;
import java.awt.image.DataBufferInt;

public class setSample
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("(int, int, int, double, DataBuffer)");
        DataBufferDouble db = new DataBufferDouble(12);
        ComponentSampleModel m = new ComponentSampleModel(5, 3, 2, 2, 6, new int[]{0, 1});
        m.setSample(2, 1, 0, 99.9, (DataBuffer)db);
        harness.check((double)((DataBuffer)db).getElem(0, 10), 99.0);
        m.setSample(2, 1, 1, 88.8, (DataBuffer)db);
        harness.check((double)((DataBuffer)db).getElem(0, 11), 88.0);
        DataBufferInt db2 = new DataBufferInt(12);
        m.setSample(2, 1, 0, 99.9, (DataBuffer)db2);
        harness.check(((DataBuffer)db2).getElem(0, 10), 99);
        m.setSample(2, 1, 1, 88.8, (DataBuffer)db2);
        harness.check(((DataBuffer)db2).getElem(0, 11), 88);
        boolean pass = false;
        try {
            m.setSample(2, 1, 1, 77.7, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("(int, int, int, float, DataBuffer)");
        DataBufferFloat db = new DataBufferFloat(12);
        ComponentSampleModel m = new ComponentSampleModel(4, 3, 2, 2, 6, new int[]{0, 1});
        m.setSample(2, 1, 0, 99.9f, (DataBuffer)db);
        harness.check((double)((DataBuffer)db).getElem(0, 10), 99.0);
        m.setSample(2, 1, 1, 88.8f, (DataBuffer)db);
        harness.check((double)((DataBuffer)db).getElem(0, 11), 88.0);
        DataBufferInt db2 = new DataBufferInt(12);
        m.setSample(2, 1, 0, 99.9f, (DataBuffer)db2);
        harness.check(((DataBuffer)db2).getElem(0, 10), 99);
        m.setSample(2, 1, 1, 88.8f, (DataBuffer)db2);
        harness.check(((DataBuffer)db2).getElem(0, 11), 88);
        boolean pass = false;
        try {
            m.setSample(2, 1, 1, 77.7f, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void test3(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, DataBuffer)");
        DataBufferInt db = new DataBufferInt(12);
        ComponentSampleModel m = new ComponentSampleModel(3, 3, 2, 2, 6, new int[]{0, 1});
        m.setSample(2, 1, 0, 99, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0, 10), 99);
        m.setSample(2, 1, 1, 88, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0, 11), 88);
        DataBufferByte db2 = new DataBufferByte(12);
        m.setSample(2, 1, 0, 99, (DataBuffer)db2);
        harness.check(((DataBuffer)db2).getElem(0, 10), 99);
        m.setSample(2, 1, 1, 888, (DataBuffer)db2);
        harness.check(((DataBuffer)db2).getElem(0, 11), 120);
        boolean pass = false;
        try {
            m.setSample(2, 1, 1, 77, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

