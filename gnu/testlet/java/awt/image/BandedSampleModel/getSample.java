/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBufferInt;

public class getSample
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
        harness.check(m.getSample(0, 0, 0, b), 160);
        harness.check(m.getSample(1, 0, 0, b), 161);
        harness.check(m.getSample(0, 1, 0, b), 162);
        harness.check(m.getSample(1, 1, 0, b), 163);
        harness.check(m.getSample(0, 2, 0, b), 164);
        harness.check(m.getSample(1, 2, 0, b), 165);
        harness.check(m.getSample(0, 0, 1, b), 176);
        harness.check(m.getSample(1, 0, 1, b), 177);
        harness.check(m.getSample(0, 1, 1, b), 178);
        harness.check(m.getSample(1, 1, 1, b), 179);
        harness.check(m.getSample(0, 2, 1, b), 180);
        harness.check(m.getSample(1, 2, 1, b), 181);
        boolean pass = false;
        try {
            m.getSample(-1, 0, 0, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSample(0, -1, 0, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSample(0, 0, -1, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSample(0, 0, 0, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

