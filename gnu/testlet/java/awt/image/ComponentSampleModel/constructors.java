/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.awt.image.ComponentSampleModel.MyComponentSampleModel;
import java.awt.image.ComponentSampleModel;
import java.util.Arrays;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testDefensiveCopies(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("testConstructor1()");
        ComponentSampleModel m = new ComponentSampleModel(0, 10, 20, 3, 30, new int[]{0, 1, 2});
        harness.check(m.getDataType(), 0);
        harness.check(m.getWidth(), 10);
        harness.check(m.getHeight(), 20);
        harness.check(m.getPixelStride(), 3);
        harness.check(m.getScanlineStride(), 30);
        harness.check(Arrays.equals(m.getBandOffsets(), new int[]{0, 1, 2}));
        boolean pass = false;
        try {
            m = new ComponentSampleModel(32, 10, 20, 3, 30, new int[]{0, 1, 2});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(0, 0, 20, 3, 30, new int[]{0, 1, 2});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(0, 10, 0, 3, 30, new int[]{0, 1, 2});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(0, 10, 20, -1, 30, new int[]{0, 1, 2});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(0, 10, 20, 3, -1, new int[]{0, 1, 2});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(0, 3, 0x3FFFFFFF, 3, 30, new int[]{0, 1, 2});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(0, 10, 20, 3, 30, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int, int[], int[])");
        int[] bankIndices = new int[]{0, 1};
        int[] bandOffsets = new int[]{0, 0};
        ComponentSampleModel m = new ComponentSampleModel(3, 22, 11, 1, 25, bankIndices, new int[]{0, 0});
        harness.check(m.getDataType(), 3);
        harness.check(m.getWidth(), 22);
        harness.check(m.getHeight(), 11);
        harness.check(m.getPixelStride(), 1);
        harness.check(m.getNumBands(), 2);
        harness.check(m.getNumDataElements(), 2);
        harness.check(Arrays.equals(m.getBankIndices(), new int[]{0, 1}));
        harness.check(m.getBankIndices() != bankIndices);
        harness.check(Arrays.equals(m.getBandOffsets(), bandOffsets));
        harness.check(m.getBandOffsets() != bandOffsets);
        boolean pass = false;
        try {
            m = new ComponentSampleModel(32, 22, 11, 1, 25, new int[]{0, 1}, new int[]{0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(3, 0, 11, 1, 25, new int[]{0, 1}, new int[]{0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(3, 22, 0, 1, 25, new int[]{0, 1}, new int[]{0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(3, 0x7FFFFFFE, 2, 1, 25, new int[]{0, 1}, new int[]{0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(3, 22, 11, -1, 25, new int[]{0, 1}, new int[]{0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(3, 22, 11, 1, -1, new int[]{0, 1}, new int[]{0, 0});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(3, 22, 11, 1, 25, null, new int[]{0, 0});
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(3, 22, 11, 1, 25, new int[0], new int[]{0, 0});
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(3, 22, 11, 1, 25, new int[]{0, 0}, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new ComponentSampleModel(3, 22, 11, 1, 25, new int[1], new int[2]);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testDefensiveCopies(TestHarness harness) {
        harness.checkPoint("testDefensiveCopies()");
        int[] bandOffsets = new int[]{0, 1, 2};
        MyComponentSampleModel m = new MyComponentSampleModel(0, 10, 20, 3, 30, bandOffsets);
        harness.check(bandOffsets != m.getBandOffsetsDirect());
        harness.check(Arrays.equals(bandOffsets, m.getBandOffsetsDirect()));
        int[] bankIndices = new int[]{0, 0, 0};
        MyComponentSampleModel m2 = new MyComponentSampleModel(0, 10, 20, 3, 30, bandOffsets, bankIndices);
        harness.check(bandOffsets != m2.getBandOffsetsDirect());
        harness.check(Arrays.equals(bandOffsets, m2.getBandOffsetsDirect()));
        harness.check(bankIndices != m2.getBankIndicesDirect());
        harness.check(Arrays.equals(bankIndices, m2.getBankIndicesDirect()));
    }
}

