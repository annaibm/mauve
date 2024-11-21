/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class getSamples
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
        int[] samples = m.getSamples(1, 1, 1, 2, 0, (int[])null, (DataBuffer)b);
        harness.check(samples[0], 163);
        harness.check(samples[1], 165);
        samples = m.getSamples(1, 1, 1, 2, 1, (int[])null, (DataBuffer)b);
        harness.check(samples[0], 179);
        harness.check(samples[1], 181);
        boolean pass = false;
        try {
            m.getSamples(-1, 1, 1, 2, 1, (int[])null, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSamples(1, -1, 1, 2, 1, (int[])null, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSamples(1, 1, -1, 2, 1, (int[])null, (DataBuffer)b);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSamples(1, 1, 1, -1, 1, (int[])null, (DataBuffer)b);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSamples(1, 1, 1, 1, 1, (int[])null, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

