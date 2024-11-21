/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class setSample
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testInt(harness);
        this.testFloat(harness);
        this.testDouble(harness);
    }

    public void testInt(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, DataBuffer)");
        BandedSampleModel m = new BandedSampleModel(3, 2, 3, 2);
        DataBufferInt b = new DataBufferInt(6, 2);
        m.setSample(0, 0, 0, 160, (DataBuffer)b);
        m.setSample(1, 0, 0, 161, (DataBuffer)b);
        m.setSample(0, 1, 0, 162, (DataBuffer)b);
        m.setSample(1, 1, 0, 163, (DataBuffer)b);
        m.setSample(0, 2, 0, 164, (DataBuffer)b);
        m.setSample(1, 2, 0, 165, (DataBuffer)b);
        m.setSample(0, 0, 1, 176, (DataBuffer)b);
        m.setSample(1, 0, 1, 177, (DataBuffer)b);
        m.setSample(0, 1, 1, 178, (DataBuffer)b);
        m.setSample(1, 1, 1, 179, (DataBuffer)b);
        m.setSample(0, 2, 1, 180, (DataBuffer)b);
        m.setSample(1, 2, 1, 181, (DataBuffer)b);
        harness.check(b.getElem(0, 0), 160);
        harness.check(b.getElem(0, 1), 161);
        harness.check(b.getElem(0, 2), 162);
        harness.check(b.getElem(0, 3), 163);
        harness.check(b.getElem(0, 4), 164);
        harness.check(b.getElem(0, 5), 165);
        harness.check(b.getElem(1, 0), 176);
        harness.check(b.getElem(1, 1), 177);
        harness.check(b.getElem(1, 2), 178);
        harness.check(b.getElem(1, 3), 179);
        harness.check(b.getElem(1, 4), 180);
        harness.check(b.getElem(1, 5), 181);
        boolean pass = false;
        try {
            m.setSample(-1, 0, 0, 255, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(0, -1, 0, 255, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(0, 0, -1, 255, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(0, 0, 0, 255, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testFloat(TestHarness harness) {
        harness.checkPoint("(int, int, int, float, DataBuffer)");
        BandedSampleModel m = new BandedSampleModel(3, 2, 3, 2);
        DataBufferInt b = new DataBufferInt(6, 2);
        m.setSample(0, 0, 0, 160.0f, (DataBuffer)b);
        m.setSample(1, 0, 0, 161.0f, (DataBuffer)b);
        m.setSample(0, 1, 0, 162.0f, (DataBuffer)b);
        m.setSample(1, 1, 0, 163.0f, (DataBuffer)b);
        m.setSample(0, 2, 0, 164.0f, (DataBuffer)b);
        m.setSample(1, 2, 0, 165.0f, (DataBuffer)b);
        m.setSample(0, 0, 1, 176.0f, (DataBuffer)b);
        m.setSample(1, 0, 1, 177.0f, (DataBuffer)b);
        m.setSample(0, 1, 1, 178.0f, (DataBuffer)b);
        m.setSample(1, 1, 1, 179.0f, (DataBuffer)b);
        m.setSample(0, 2, 1, 180.0f, (DataBuffer)b);
        m.setSample(1, 2, 1, 181.0f, (DataBuffer)b);
        harness.check(b.getElem(0, 0), 160);
        harness.check(b.getElem(0, 1), 161);
        harness.check(b.getElem(0, 2), 162);
        harness.check(b.getElem(0, 3), 163);
        harness.check(b.getElem(0, 4), 164);
        harness.check(b.getElem(0, 5), 165);
        harness.check(b.getElem(1, 0), 176);
        harness.check(b.getElem(1, 1), 177);
        harness.check(b.getElem(1, 2), 178);
        harness.check(b.getElem(1, 3), 179);
        harness.check(b.getElem(1, 4), 180);
        harness.check(b.getElem(1, 5), 181);
        boolean pass = false;
        try {
            m.setSample(-1, 0, 0, 255.0f, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(0, -1, 0, 255.0f, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(0, 0, -1, 255.0f, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(0, 0, 0, 255.0f, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testDouble(TestHarness harness) {
        harness.checkPoint("(int, int, int, double, DataBuffer)");
        BandedSampleModel m = new BandedSampleModel(3, 2, 3, 2);
        DataBufferInt b = new DataBufferInt(6, 2);
        m.setSample(0, 0, 0, 160.0, (DataBuffer)b);
        m.setSample(1, 0, 0, 161.0, (DataBuffer)b);
        m.setSample(0, 1, 0, 162.0, (DataBuffer)b);
        m.setSample(1, 1, 0, 163.0, (DataBuffer)b);
        m.setSample(0, 2, 0, 164.0, (DataBuffer)b);
        m.setSample(1, 2, 0, 165.0, (DataBuffer)b);
        m.setSample(0, 0, 1, 176.0, (DataBuffer)b);
        m.setSample(1, 0, 1, 177.0, (DataBuffer)b);
        m.setSample(0, 1, 1, 178.0, (DataBuffer)b);
        m.setSample(1, 1, 1, 179.0, (DataBuffer)b);
        m.setSample(0, 2, 1, 180.0, (DataBuffer)b);
        m.setSample(1, 2, 1, 181.0, (DataBuffer)b);
        harness.check(b.getElem(0, 0), 160);
        harness.check(b.getElem(0, 1), 161);
        harness.check(b.getElem(0, 2), 162);
        harness.check(b.getElem(0, 3), 163);
        harness.check(b.getElem(0, 4), 164);
        harness.check(b.getElem(0, 5), 165);
        harness.check(b.getElem(1, 0), 176);
        harness.check(b.getElem(1, 1), 177);
        harness.check(b.getElem(1, 2), 178);
        harness.check(b.getElem(1, 3), 179);
        harness.check(b.getElem(1, 4), 180);
        harness.check(b.getElem(1, 5), 181);
        boolean pass = false;
        try {
            m.setSample(-1, 0, 0, 255.0, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(0, -1, 0, 255.0, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(0, 0, -1, 255.0, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(0, 0, 0, 255.0, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

