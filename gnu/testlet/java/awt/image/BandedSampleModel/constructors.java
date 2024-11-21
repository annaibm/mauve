/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(int, int, int, int)");
        BandedSampleModel m = new BandedSampleModel(2, 10, 20, 2);
        harness.check(m.getDataType(), 2);
        harness.check(m.getWidth(), 10);
        harness.check(m.getHeight(), 20);
        harness.check(m.getNumBands(), 2);
        harness.check(m.getNumDataElements(), 2);
        harness.check(m.getScanlineStride(), 10);
        harness.check(m.getPixelStride(), 1);
        int[] bankIndices = m.getBankIndices();
        harness.check(bankIndices[0], 0);
        harness.check(bankIndices[1], 1);
        boolean pass = false;
        try {
            m = new BandedSampleModel(32, 10, 20, 2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new BandedSampleModel(3, 0, 20, 2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new BandedSampleModel(3, 10, 0, 2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new BandedSampleModel(3, 10, 20, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int[], int[])");
        BandedSampleModel m = new BandedSampleModel(2, 10, 20, 10, new int[]{3, 2, 1}, new int[]{0, 0, 0});
        harness.check(m.getDataType(), 2);
        harness.check(m.getWidth(), 10);
        harness.check(m.getHeight(), 20);
        harness.check(m.getScanlineStride(), 10);
        harness.check(m.getPixelStride(), 1);
        harness.check(m.getNumBands(), 3);
        harness.check(m.getBankIndices()[0], 3);
        harness.check(m.getBankIndices()[1], 2);
        harness.check(m.getBankIndices()[2], 1);
        harness.check(m.getBandOffsets()[0], 0);
        harness.check(m.getBandOffsets()[1], 0);
        harness.check(m.getBandOffsets()[2], 0);
        boolean pass = false;
        try {
            m = new BandedSampleModel(32, 10, 20, 10, new int[]{3, 2, 1}, new int[]{0, 0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new BandedSampleModel(3, 0, 20, 10, new int[]{3, 2, 1}, new int[]{0, 0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new BandedSampleModel(3, 10, 0, 10, new int[]{3, 2, 1}, new int[]{0, 0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new BandedSampleModel(3, 10, 20, 10, null, new int[]{0, 0, 0});
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new BandedSampleModel(3, 10, 20, 10, new int[]{3, 2, 1}, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new BandedSampleModel(3, 10, 20, 0, new int[]{2, 1}, new int[]{0, 0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

