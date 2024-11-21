/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBufferInt;

public class getDataElements
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
        int[] elements2 = (int[])m.getDataElements(1, 1, null, b);
        harness.check(elements2[0], 163);
        harness.check(elements2[1], 179);
        boolean pass = false;
        try {
            m.getDataElements(-1, 1, null, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getDataElements(1, -1, null, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getDataElements(1, 1, null, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

