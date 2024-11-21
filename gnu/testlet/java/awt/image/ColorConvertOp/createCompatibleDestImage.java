/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ColorConvertOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;

public class createCompatibleDestImage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int i;
        this.simpleTest(harness);
        int[] models = new int[]{1000, 1001, 1003, 1004, 1002};
        for (i = 0; i < models.length; ++i) {
            this.colorModelTest(harness, models[i]);
        }
        for (i = 0; i < models.length; ++i) {
            for (int j = 0; j < models.length; ++j) {
                this.colorModelTest(harness, models[i], models[j]);
            }
        }
        this.profileTest(harness, new ICC_Profile[]{ICC_Profile.getInstance(1004), ICC_Profile.getInstance(1001), ICC_Profile.getInstance(1000), ICC_Profile.getInstance(1003)});
        this.profileTest(harness, new ICC_Profile[]{ICC_Profile.getInstance(1003), ICC_Profile.getInstance(1000)});
        this.profileTest(harness, new ICC_Profile[]{ICC_Profile.getInstance(1003), ICC_Profile.getInstance(1001)});
    }

    private void simpleTest(TestHarness harness) {
        harness.checkPoint("createCompatibleDestImage");
        ColorSpace cs = ColorSpace.getInstance(1000);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        BufferedImage img = new BufferedImage(25, 40, 1);
        BufferedImage dest = op.createCompatibleDestImage(img, img.getColorModel());
        harness.check(dest.getHeight(), 40);
        harness.check(dest.getWidth(), 25);
        harness.check(dest.getColorModel(), img.getColorModel());
        harness.check(dest.getSampleModel().getTransferType(), img.getColorModel().getTransferType());
        img = new BufferedImage(25, 40, 10);
        DirectColorModel cm = new DirectColorModel(32, 0xFF0000, 65280, 255);
        dest = op.createCompatibleDestImage(img, cm);
        harness.check(dest.getHeight(), 40);
        harness.check(dest.getWidth(), 25);
        harness.check(dest.getColorModel(), cm);
        harness.check(dest.getSampleModel().getTransferType(), cm.getTransferType());
        op = new ColorConvertOp(null);
        dest = op.createCompatibleDestImage(img, img.getColorModel());
        harness.check(dest.getHeight(), 40);
        harness.check(dest.getWidth(), 25);
        harness.check(dest.getColorModel(), img.getColorModel());
        harness.check(dest.getSampleModel().getTransferType(), img.getColorModel().getTransferType());
        try {
            dest = op.createCompatibleDestImage(img, null);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void colorModelTest(TestHarness harness, int cspace) {
        this.colorModelTest(harness, -1, cspace);
    }

    private void colorModelTest(TestHarness harness, int cspace, int cspace2) {
        ColorConvertOp op;
        ColorSpace cs2;
        if (cspace == -1) {
            cs2 = ColorSpace.getInstance(cspace2);
            op = new ColorConvertOp(cs2, null);
        } else {
            ColorSpace cs = ColorSpace.getInstance(cspace);
            cs2 = ColorSpace.getInstance(cspace2);
            op = new ColorConvertOp(cs, cs2, null);
        }
        int[] types = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10, 11};
        block4: for (int i = 0; i < types.length; ++i) {
            int type = types[i];
            if (cspace == -1) {
                harness.checkPoint("colorspace " + cspace2 + ", type: " + type);
            } else {
                harness.checkPoint("src colorspace " + cspace + ", dest colorspace " + cspace2 + ", type: " + type);
            }
            BufferedImage img = new BufferedImage(25, 40, type);
            BufferedImage dest = op.createCompatibleDestImage(img, null);
            dest = op.createCompatibleDestImage(img, null);
            harness.check(dest.isAlphaPremultiplied(), img.isAlphaPremultiplied());
            harness.check(dest.getSampleModel() instanceof PixelInterleavedSampleModel);
            harness.check(dest.getColorModel() instanceof ComponentColorModel);
            harness.check(dest.getColorModel().isCompatibleSampleModel(dest.getSampleModel()));
            harness.check(dest.getColorModel().getTransferType(), 0);
            harness.check(dest.getColorModel().getColorSpace().getType(), cs2.getType());
            harness.check(dest.getColorModel().hasAlpha(), img.getColorModel().hasAlpha());
            harness.check(dest.getColorModel().getTransparency(), img.getColorModel().getTransparency());
            harness.check(dest.getColorModel().getPixelSize(), DataBuffer.getDataTypeSize(0) * dest.getRaster().getNumDataElements());
            harness.check(dest.getRaster().getNumDataElements(), dest.getColorModel().getNumComponents());
            harness.check(dest.getRaster().getNumBands(), dest.getRaster().getNumDataElements());
            harness.check(dest.getSampleModel().getTransferType(), 0);
            switch (type) {
                case 2: 
                case 3: 
                case 6: 
                case 7: {
                    if (cspace2 == 1003) {
                        harness.check(dest.getColorModel().getNumComponents(), 2);
                    } else {
                        harness.check(dest.getColorModel().getNumComponents(), 4);
                    }
                    harness.check(dest.getColorModel().getNumColorComponents(), dest.getColorModel().getNumComponents() - 1);
                    harness.check(dest.getColorModel().getTransparency(), 3);
                    harness.check(dest.getColorModel().hasAlpha(), true);
                    harness.check(dest.getColorModel().isAlphaPremultiplied(), type == 3 || type == 7);
                    harness.check(dest.getType(), 0);
                    continue block4;
                }
                case 1: 
                case 5: 
                case 8: 
                case 9: 
                case 10: 
                case 11: {
                    if (cs2.getType() == 6) {
                        harness.check(dest.getColorModel().getNumComponents(), 1);
                    } else {
                        harness.check(dest.getType(), 0);
                        harness.check(dest.getColorModel().getNumComponents(), 3);
                    }
                    harness.check(dest.getColorModel().getNumColorComponents(), dest.getColorModel().getNumComponents());
                    harness.check(dest.getColorModel().getTransparency(), 1);
                    harness.check(dest.getColorModel().hasAlpha(), false);
                    harness.check(dest.getColorModel().isAlphaPremultiplied(), false);
                }
            }
        }
    }

    private void profileTest(TestHarness harness, ICC_Profile[] profile) {
        ColorConvertOp op = new ColorConvertOp(profile, null);
        int[] types = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10, 11};
        block4: for (int i = 0; i < types.length; ++i) {
            int type = types[i];
            harness.checkPoint("profile " + profile[profile.length - 1].getClass() + ", type: " + type);
            BufferedImage img = new BufferedImage(25, 40, type);
            BufferedImage dest = op.createCompatibleDestImage(img, null);
            dest = op.createCompatibleDestImage(img, null);
            harness.check(dest.getColorModel() instanceof ComponentColorModel);
            harness.check(dest.getSampleModel() instanceof PixelInterleavedSampleModel);
            harness.check(dest.getColorModel().isCompatibleSampleModel(dest.getSampleModel()));
            harness.check(dest.getColorModel().getTransferType(), 0);
            harness.check(dest.getColorModel().getColorSpace().getType(), profile[profile.length - 1].getColorSpaceType());
            harness.check(dest.getRaster().getNumDataElements(), dest.getColorModel().getNumComponents());
            harness.check(dest.getRaster().getNumBands(), dest.getRaster().getNumDataElements());
            harness.check(dest.getColorModel().getPixelSize(), DataBuffer.getDataTypeSize(0) * dest.getRaster().getNumDataElements());
            switch (type) {
                case 2: 
                case 3: 
                case 6: 
                case 7: {
                    if (profile[profile.length - 1].getColorSpaceType() == 6) {
                        harness.check(dest.getColorModel().getNumComponents(), 2);
                    } else {
                        harness.check(dest.getColorModel().getNumComponents(), 4);
                    }
                    harness.check(dest.getColorModel().getNumColorComponents(), dest.getColorModel().getNumComponents() - 1);
                    harness.check(dest.getColorModel().getTransparency(), 3);
                    harness.check(dest.getColorModel().hasAlpha(), true);
                    harness.check(dest.getColorModel().isAlphaPremultiplied(), type == 3 || type == 7);
                    harness.check(dest.getType(), 0);
                    continue block4;
                }
                case 1: 
                case 5: 
                case 8: 
                case 9: 
                case 10: 
                case 11: {
                    if (profile[profile.length - 1].getColorSpaceType() == 6) {
                        harness.check(dest.getColorModel().getNumComponents(), 1);
                    } else {
                        harness.check(dest.getType(), 0);
                        harness.check(dest.getColorModel().getNumComponents(), 3);
                    }
                    harness.check(dest.getColorModel().getNumColorComponents(), dest.getColorModel().getNumComponents());
                    harness.check(dest.getColorModel().getTransparency(), 1);
                    harness.check(dest.getColorModel().hasAlpha(), false);
                    harness.check(dest.getColorModel().isAlphaPremultiplied(), false);
                }
            }
        }
    }
}

