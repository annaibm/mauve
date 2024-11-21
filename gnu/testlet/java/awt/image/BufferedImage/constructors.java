/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BufferedImage;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(int, int, int)");
        BufferedImage image = new BufferedImage(10, 20, 10);
        harness.check(image.getWidth(), 10);
        harness.check(image.getHeight(), 20);
        harness.check(image.getType(), 10);
        ColorModel cm = image.getColorModel();
        harness.check(cm instanceof ComponentColorModel);
        harness.check(cm.getColorSpace(), ColorSpace.getInstance(1003));
        image = new BufferedImage(10, 20, 11);
        harness.check(image.getWidth(), 10);
        harness.check(image.getHeight(), 20);
        harness.check(image.getType(), 11);
        cm = image.getColorModel();
        harness.check(cm instanceof ComponentColorModel);
        harness.check(cm.getColorSpace(), ColorSpace.getInstance(1003));
        boolean pass = false;
        try {
            image = new BufferedImage(0, 20, 10);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            image = new BufferedImage(10, 0, 10);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            image = new BufferedImage(10, 20, 666);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int, int, int, IndexColorModel)");
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(ColorModel, WritableRaster, boolean, Hashtable)");
    }
}

