/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBufferInt;

public class setDataElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, DataBuffer)");
        BandedSampleModel m = new BandedSampleModel(3, 2, 3, 2);
        DataBufferInt b = new DataBufferInt(6, 2);
        m.setDataElements(0, 0, new int[]{160, 176}, b);
        m.setDataElements(1, 0, new int[]{161, 177}, b);
        m.setDataElements(0, 1, new int[]{162, 178}, b);
        m.setDataElements(1, 1, new int[]{163, 179}, b);
        m.setDataElements(0, 2, new int[]{164, 180}, b);
        m.setDataElements(1, 2, new int[]{165, 181}, b);
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
            m.setDataElements(-1, 0, new int[]{160, 176}, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setDataElements(0, -1, new int[]{160, 176}, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setDataElements(0, 1, new int[]{160}, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setDataElements(0, 1, null, b);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setDataElements(0, 0, new int[]{160, 176}, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

