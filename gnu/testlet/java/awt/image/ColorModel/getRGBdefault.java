/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.color.ColorSpace;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;

public class getRGBdefault
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ColorModel rgb = ColorModel.getRGBdefault();
        harness.check(rgb instanceof DirectColorModel);
        harness.check(rgb.getPixelSize(), 32);
        harness.check(rgb.getNumColorComponents(), 3);
        harness.check(rgb.getNumComponents(), 4);
        harness.check(rgb.getComponentSize(0), 8);
        harness.check(rgb.getComponentSize(1), 8);
        harness.check(rgb.getComponentSize(2), 8);
        harness.check(rgb.getComponentSize(3), 8);
        harness.check(rgb.getTransparency(), 3);
        harness.check(rgb.getTransferType(), 3);
        harness.check(rgb.isAlphaPremultiplied(), false);
        harness.check(rgb.getColorSpace(), ColorSpace.getInstance(1000));
    }
}

