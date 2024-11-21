/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ConvolveOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.DirectColorModel;
import java.awt.image.Kernel;

public class createCompatibleDestImage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.simpleTest(harness);
        this.colorModelTest(harness);
    }

    private void simpleTest(TestHarness harness) {
        harness.checkPoint("createCompatibleDestImage");
        Kernel kern = new Kernel(3, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f});
        ConvolveOp op = new ConvolveOp(kern, 1, null);
        BufferedImage img = new BufferedImage(25, 40, 1);
        BufferedImage dest = op.createCompatibleDestImage(img, img.getColorModel());
        harness.check(dest.getHeight(), 40);
        harness.check(dest.getWidth(), 25);
        harness.check(dest.getColorModel(), img.getColorModel());
        img = new BufferedImage(25, 40, 1);
        DirectColorModel cm = new DirectColorModel(16, 3840, 240, 15);
        dest = op.createCompatibleDestImage(img, cm);
        harness.check(dest.getHeight(), 40);
        harness.check(dest.getWidth(), 25);
        harness.check(dest.getColorModel(), cm);
    }

    private void colorModelTest(TestHarness harness) {
        Kernel kern = new Kernel(3, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f});
        ConvolveOp op = new ConvolveOp(kern, 1, null);
        int[] types = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10, 11};
        for (int i = 0; i < types.length; ++i) {
            int type = types[i];
            harness.checkPoint("type: " + type);
            BufferedImage img = new BufferedImage(25, 40, type);
            BufferedImage dest = op.createCompatibleDestImage(img, null);
            harness.check(dest.getColorModel().getPixelSize(), img.getColorModel().getPixelSize());
            harness.check(dest.getColorModel().getClass() == img.getColorModel().getClass());
            harness.check(dest.getSampleModel().getClass() == img.getSampleModel().getClass());
            harness.check(dest.getColorModel().getNumComponents(), img.getColorModel().getNumComponents());
            harness.check(dest.getColorModel().getTransparency(), img.getColorModel().getTransparency());
            harness.check(dest.getColorModel().hasAlpha(), img.getColorModel().hasAlpha());
            harness.check(dest.getColorModel().getTransferType(), img.getColorModel().getTransferType());
            harness.check(dest.getColorModel().isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
            harness.check(dest.getColorModel().getColorSpace().getType(), img.getColorModel().getColorSpace().getType());
            harness.check(dest.getRaster().getNumBands(), img.getRaster().getNumBands());
            harness.check(dest.getRaster().getNumDataElements(), img.getRaster().getNumDataElements());
        }
    }
}

