/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBufferInt;

public class getSampleDouble
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BandedSampleModel m = new BandedSampleModel(3, 2, 3, 2);
        DataBufferInt b = new DataBufferInt(6, 2);
        b.setElem(0, 0, 65440);
        b.setElem(0, 1, 65441);
        b.setElem(0, 2, 65442);
        b.setElem(0, 3, 65443);
        b.setElem(0, 4, 65444);
        b.setElem(0, 5, 65445);
        b.setElem(1, 0, 65456);
        b.setElem(1, 1, 65457);
        b.setElem(1, 2, 65458);
        b.setElem(1, 3, 65459);
        b.setElem(1, 4, 65460);
        b.setElem(1, 5, 65461);
        harness.check(m.getSampleDouble(0, 0, 0, b), 65440.0);
        harness.check(m.getSampleDouble(1, 0, 0, b), 65441.0);
        harness.check(m.getSampleDouble(0, 1, 0, b), 65442.0);
        harness.check(m.getSampleDouble(1, 1, 0, b), 65443.0);
        harness.check(m.getSampleDouble(0, 2, 0, b), 65444.0);
        harness.check(m.getSampleDouble(1, 2, 0, b), 65445.0);
        harness.check(m.getSampleDouble(0, 0, 1, b), 65456.0);
        harness.check(m.getSampleDouble(1, 0, 1, b), 65457.0);
        harness.check(m.getSampleDouble(0, 1, 1, b), 65458.0);
        harness.check(m.getSampleDouble(1, 1, 1, b), 65459.0);
        harness.check(m.getSampleDouble(0, 2, 1, b), 65460.0);
        harness.check(m.getSampleDouble(1, 2, 1, b), 65461.0);
        boolean pass = false;
        try {
            m.getSampleDouble(-1, 0, 0, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSampleDouble(0, -1, 0, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSampleDouble(0, 0, -1, b);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSampleDouble(0, 0, 0, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

