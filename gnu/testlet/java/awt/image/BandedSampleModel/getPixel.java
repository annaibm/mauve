/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class getPixel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BandedSampleModel m = new BandedSampleModel(3, 2, 3, 2);
        DataBufferInt b = new DataBufferInt(6, 2);
        b.setElem(0, 0, 160);
        b.setElem(0, 1, 161);
        b.setElem(0, 2, 162);
        b.setElem(0, 3, 163);
        b.setElem(0, 4, 164);
        b.setElem(0, 5, 165);
        b.setElem(1, 0, 176);
        b.setElem(1, 1, 177);
        b.setElem(1, 2, 178);
        b.setElem(1, 3, 179);
        b.setElem(1, 4, 180);
        b.setElem(1, 5, 181);
        harness.check(m.getPixel(0, 0, (int[])null, (DataBuffer)b)[0], 160);
        harness.check(m.getPixel(1, 0, (int[])null, (DataBuffer)b)[0], 161);
        harness.check(m.getPixel(0, 1, (int[])null, (DataBuffer)b)[0], 162);
        harness.check(m.getPixel(1, 1, (int[])null, (DataBuffer)b)[0], 163);
        harness.check(m.getPixel(0, 2, (int[])null, (DataBuffer)b)[0], 164);
        harness.check(m.getPixel(1, 2, (int[])null, (DataBuffer)b)[0], 165);
        harness.check(m.getPixel(0, 0, (int[])null, (DataBuffer)b)[1], 176);
        harness.check(m.getPixel(1, 0, (int[])null, (DataBuffer)b)[1], 177);
        harness.check(m.getPixel(0, 1, (int[])null, (DataBuffer)b)[1], 178);
        harness.check(m.getPixel(1, 1, (int[])null, (DataBuffer)b)[1], 179);
        harness.check(m.getPixel(0, 2, (int[])null, (DataBuffer)b)[1], 180);
        harness.check(m.getPixel(1, 2, (int[])null, (DataBuffer)b)[1], 181);
        boolean pass = false;
        try {
            m.getPixel(-1, 0, (int[])null, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(0, -1, (int[])null, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(0, 0, new int[1], (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(0, 0, (int[])null, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

