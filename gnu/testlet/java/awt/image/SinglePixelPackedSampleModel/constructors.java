/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.SinglePixelPackedSampleModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("(int, int, int, int[])");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 1, 2, new int[]{224, 28, 3});
        harness.check(m1.getDataType(), 0);
        harness.check(m1.getWidth(), 1);
        harness.check(m1.getHeight(), 2);
        harness.check(m1.getNumBands(), 3);
        try {
            new SinglePixelPackedSampleModel(5, 1, 2, new int[]{224, 28, 3});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SinglePixelPackedSampleModel(0, 0, 2, new int[]{224, 28, 3});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SinglePixelPackedSampleModel(0, 1, 0, new int[]{224, 28, 3});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SinglePixelPackedSampleModel(0, 1, 2, new int[0]);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SinglePixelPackedSampleModel(0, 1, 2, new int[]{224, 27, 3});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int[])");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 1, 2, 3, new int[]{224, 28, 3});
        harness.check(m1.getDataType(), 0);
        harness.check(m1.getWidth(), 1);
        harness.check(m1.getHeight(), 2);
        harness.check(m1.getNumBands(), 3);
        try {
            new SinglePixelPackedSampleModel(5, 1, 2, 3, new int[]{224, 28, 3});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SinglePixelPackedSampleModel(0, 0, 2, 3, new int[]{224, 28, 3});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SinglePixelPackedSampleModel(0, 1, 0, 3, new int[]{224, 28, 3});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SinglePixelPackedSampleModel(0, 1, 2, 3, new int[0]);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SinglePixelPackedSampleModel(0, 1, 2, new int[]{224, 27, 3});
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

