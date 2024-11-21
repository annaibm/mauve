/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DirectColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.color.ColorSpace;
import java.awt.image.DirectColorModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("(ColorSpace, int, int, int, int, int, boolean, int)");
        DirectColorModel m1 = new DirectColorModel(ColorSpace.getInstance(1000), 32, 61440, 3840, 240, 15, false, 3);
        harness.check(m1.getTransparency(), 3);
        boolean pass = false;
        try {
            m1 = new DirectColorModel(null, 32, 61440, 3840, 240, 15, false, 3);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1 = new DirectColorModel(ColorSpace.getInstance(1003), 32, 61440, 3840, 240, 15, false, 3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int, int, int, int)");
        DirectColorModel m1 = new DirectColorModel(8, 240, 12, 3);
        harness.check(m1.getPixelSize(), 8);
        harness.check(m1.getComponentSize(0), 4);
        harness.check(m1.getComponentSize(1), 2);
        harness.check(m1.getComponentSize(2), 2);
        harness.check(m1.getTransparency(), 1);
        harness.check(m1.getTransferType(), 0);
        DirectColorModel m2 = new DirectColorModel(16, 65280, 240, 15);
        harness.check(m2.getPixelSize(), 16);
        harness.check(m2.getComponentSize(0), 8);
        harness.check(m2.getComponentSize(1), 4);
        harness.check(m2.getComponentSize(2), 4);
        harness.check(m2.getTransparency(), 1);
        harness.check(m2.getTransferType(), 1);
        DirectColorModel m3 = new DirectColorModel(32, 0xFFFF00, 65280, 255);
        harness.check(m3.getPixelSize(), 32);
        harness.check(m3.getComponentSize(0), 16);
        harness.check(m3.getComponentSize(1), 8);
        harness.check(m3.getComponentSize(2), 8);
        harness.check(m3.getTransparency(), 1);
        harness.check(m3.getTransferType(), 3);
        boolean pass = false;
        try {
            new DirectColorModel(-1, 0xFFFF00, 65280, 255);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new DirectColorModel(33, 0xFFFF00, 65280, 255);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("DirectColorModel(int, int, int, int, int)");
        DirectColorModel m1 = new DirectColorModel(8, 192, 48, 12, 3);
        harness.check(m1.getPixelSize(), 8);
        harness.check(m1.getComponentSize(0), 2);
        harness.check(m1.getComponentSize(1), 2);
        harness.check(m1.getComponentSize(2), 2);
        harness.check(m1.getComponentSize(3), 2);
        harness.check(m1.getTransparency(), 3);
        harness.check(m1.getTransferType(), 0);
        DirectColorModel m2 = new DirectColorModel(16, 61440, 3840, 240, 15);
        harness.check(m2.getPixelSize(), 16);
        harness.check(m2.getComponentSize(0), 4);
        harness.check(m2.getComponentSize(1), 4);
        harness.check(m2.getComponentSize(2), 4);
        harness.check(m2.getComponentSize(3), 4);
        harness.check(m2.getTransparency(), 3);
        harness.check(m2.getTransferType(), 1);
        DirectColorModel m3 = new DirectColorModel(32, -16777216, 0xFF0000, 65280, 255);
        harness.check(m3.getPixelSize(), 32);
        harness.check(m3.getComponentSize(0), 8);
        harness.check(m3.getComponentSize(1), 8);
        harness.check(m3.getComponentSize(2), 8);
        harness.check(m3.getComponentSize(3), 8);
        harness.check(m3.getTransparency(), 3);
        harness.check(m3.getTransferType(), 3);
        boolean pass = false;
        try {
            new DirectColorModel(-1, -16777216, 0xFF0000, 65280, 255);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new DirectColorModel(33, -16777216, 0xFF0000, 65280, 255);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

