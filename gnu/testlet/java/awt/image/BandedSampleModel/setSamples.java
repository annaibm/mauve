/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class setSamples
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BandedSampleModel m = new BandedSampleModel(3, 2, 3, 2);
        DataBufferInt b = new DataBufferInt(6, 2);
        m.setSamples(0, 0, 1, 3, 0, new int[]{160, 162, 164}, (DataBuffer)b);
        m.setSamples(1, 0, 1, 1, 0, new int[]{161}, (DataBuffer)b);
        m.setSamples(1, 1, 1, 2, 0, new int[]{163, 165}, (DataBuffer)b);
        m.setSamples(0, 0, 1, 3, 1, new int[]{176, 178, 180}, (DataBuffer)b);
        m.setSamples(1, 0, 1, 3, 1, new int[]{177, 179, 181}, (DataBuffer)b);
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
            m.setSamples(-1, 0, 0, 3, 0, new int[]{160, 162, 164}, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSamples(0, -1, 0, 3, 0, new int[]{160, 162, 164}, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSamples(0, 0, 1, 3, -1, new int[]{160, 162, 164}, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSamples(0, 0, 1, 3, -1, new int[]{160, 162}, (DataBuffer)b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSamples(0, 0, 1, 3, 0, (int[])null, (DataBuffer)b);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSamples(0, 0, 1, 3, 0, new int[]{160, 162, 164}, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

