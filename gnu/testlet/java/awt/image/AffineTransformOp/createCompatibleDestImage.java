/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.AffineTransformOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SinglePixelPackedSampleModel;

public class createCompatibleDestImage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.simpleTest(harness);
        this.colorModelTest(harness);
    }

    private void simpleTest(TestHarness harness) {
        harness.checkPoint("createCompatibleDestImage");
        AffineTransform xform = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(xform, 3);
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
        AffineTransform xform = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        int[] types = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10, 11};
        block4: for (int i = 0; i < types.length; ++i) {
            int type = types[i];
            harness.checkPoint("type: " + type);
            BufferedImage img = new BufferedImage(25, 40, type);
            BufferedImage dest = op.createCompatibleDestImage(img, null);
            dest = op.createCompatibleDestImage(img, null);
            harness.check(dest.getColorModel().isCompatibleSampleModel(dest.getSampleModel()));
            switch (type) {
                case 1: 
                case 2: 
                case 3: 
                case 5: 
                case 8: 
                case 9: 
                case 10: 
                case 11: {
                    if (type == 3) {
                        harness.check(dest.getType(), 3);
                    } else {
                        harness.check(dest.getType(), 2);
                    }
                    harness.check(dest.getColorModel() instanceof DirectColorModel);
                    harness.check(dest.getSampleModel() instanceof SinglePixelPackedSampleModel);
                    harness.check(dest.getColorModel().getPixelSize(), 32);
                    harness.check(dest.getColorModel().getNumComponents(), 4);
                    harness.check(dest.getColorModel().getTransparency(), 3);
                    harness.check(dest.getColorModel().hasAlpha(), true);
                    harness.check(dest.getColorModel().getTransferType(), 3);
                    harness.check(dest.getColorModel().isAlphaPremultiplied(), type == 3);
                    harness.check(dest.getColorModel().getColorSpace().getType(), 5);
                    harness.check(dest.getRaster().getNumBands(), 4);
                    harness.check(dest.getRaster().getNumDataElements(), 1);
                    continue block4;
                }
                case 6: 
                case 7: {
                    harness.check(dest.getColorModel() instanceof ComponentColorModel);
                    harness.check(dest.getSampleModel() instanceof PixelInterleavedSampleModel);
                    harness.check(dest.getColorModel().getPixelSize(), 32);
                    harness.check(dest.getColorModel().getNumComponents(), 4);
                    harness.check(dest.getColorModel().getTransparency(), 3);
                    harness.check(dest.getColorModel().hasAlpha(), true);
                    harness.check(dest.getColorModel().getTransferType(), 0);
                    harness.check(dest.getColorModel().isAlphaPremultiplied(), type == 7);
                    harness.check(dest.getColorModel().getColorSpace().getType(), 5);
                    harness.check(dest.getRaster().getNumBands(), 4);
                    harness.check(dest.getRaster().getNumDataElements(), 4);
                }
            }
        }
    }
}

