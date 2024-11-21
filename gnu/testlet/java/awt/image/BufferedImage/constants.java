/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BufferedImage;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SinglePixelPackedSampleModel;

public class constants
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test_int_rgb(harness);
        this.test_int_argb(harness);
        this.test_int_argb_pre(harness);
        this.test_3byte_bgr(harness);
        this.test_4byte_abgr(harness);
        this.test_4byte_abgr_pre(harness);
        this.test_ushort_565_rgb(harness);
        this.test_ushort_555_rgb(harness);
        this.test_byte_gray(harness);
        this.test_ushort_gray(harness);
        this.test_byte_binary(harness);
        this.test_byte_indexed(harness);
    }

    public void test_int_rgb(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 1);
        harness.check(img.getColorModel().equals(new DirectColorModel(24, 0xFF0000, 65280, 255)));
        harness.check(img.getSampleModel().equals(new SinglePixelPackedSampleModel(3, 10, 10, new int[]{0xFF0000, 65280, 255})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_int_argb(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 2);
        harness.check(img.getColorModel().equals(new DirectColorModel(32, 0xFF0000, 65280, 255, -16777216)));
        harness.check(img.getSampleModel().equals(new SinglePixelPackedSampleModel(3, 10, 10, new int[]{0xFF0000, 65280, 255, -16777216})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_int_argb_pre(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 3);
        harness.check(img.getColorModel().equals(new DirectColorModel(ColorSpace.getInstance(1000), 32, 0xFF0000, 65280, 255, -16777216, true, 3)));
        harness.check(img.getSampleModel().equals(new SinglePixelPackedSampleModel(3, 10, 10, new int[]{0xFF0000, 65280, 255, -16777216})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_int_bgr(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 4);
        harness.check(img.getColorModel().equals(new DirectColorModel(24, 255, 65280, 0xFF0000)));
        harness.check(img.getSampleModel().equals(new SinglePixelPackedSampleModel(3, 10, 10, new int[]{255, 65280, 0xFF0000})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_3byte_bgr(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 5);
        harness.check(img.getColorModel().equals(new ComponentColorModel(ColorSpace.getInstance(1000), false, false, 1, 0)));
        harness.check(img.getSampleModel().equals(new PixelInterleavedSampleModel(0, 10, 10, 3, 30, new int[]{2, 1, 0})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_4byte_abgr(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 6);
        harness.check(img.getColorModel().equals(new ComponentColorModel(ColorSpace.getInstance(1000), true, false, 3, 0)));
        harness.check(img.getSampleModel().equals(new PixelInterleavedSampleModel(0, 10, 10, 4, 40, new int[]{3, 2, 1, 0})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_4byte_abgr_pre(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 7);
        harness.check(img.getColorModel().equals(new ComponentColorModel(ColorSpace.getInstance(1000), true, true, 3, 0)));
        harness.check(img.getSampleModel().equals(new PixelInterleavedSampleModel(0, 10, 10, 4, 40, new int[]{3, 2, 1, 0})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_ushort_565_rgb(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 8);
        harness.check(img.getColorModel().equals(new DirectColorModel(16, 63488, 2016, 31)));
        harness.check(img.getSampleModel().equals(new SinglePixelPackedSampleModel(1, 10, 10, new int[]{63488, 2016, 31})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_ushort_555_rgb(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 9);
        harness.check(img.getColorModel().equals(new DirectColorModel(15, 31744, 992, 31)));
        harness.check(img.getSampleModel().equals(new SinglePixelPackedSampleModel(1, 10, 10, new int[]{31744, 992, 31})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_byte_gray(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 10);
        harness.check(img.getColorModel().equals(new ComponentColorModel(ColorSpace.getInstance(1003), new int[]{8}, false, false, 1, 0)));
        harness.check(img.getSampleModel().equals(new PixelInterleavedSampleModel(0, 10, 10, 1, 10, new int[]{0})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_ushort_gray(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 11);
        harness.check(img.getColorModel().equals(new ComponentColorModel(ColorSpace.getInstance(1003), new int[]{16}, false, false, 1, 1)));
        harness.check(img.getSampleModel().equals(new PixelInterleavedSampleModel(1, 10, 10, 1, 10, new int[]{0})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_byte_binary(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 12);
        byte[] t = new byte[]{0, -1};
        harness.check(img.getColorModel().equals(new IndexColorModel(1, 2, t, t, t)));
        harness.check(img.getSampleModel().equals(new MultiPixelPackedSampleModel(0, 10, 10, 1)));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }

    public void test_byte_indexed(TestHarness harness) {
        BufferedImage img = new BufferedImage(10, 10, 13);
        byte[] r = new byte[256];
        byte[] g = new byte[256];
        byte[] b = new byte[256];
        int index = 0;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                for (int k = 0; k < 6; ++k) {
                    r[index] = (byte)(i * 51);
                    g[index] = (byte)(j * 51);
                    b[index] = (byte)(k * 51);
                    ++index;
                }
            }
        }
        while (index < 256) {
            g[index] = b[index] = (byte)(18 + (index - 216) * 6);
            r[index] = b[index];
            ++index;
        }
        harness.check(img.getColorModel().equals(new IndexColorModel(8, 256, r, g, b)));
        harness.check(img.getSampleModel().equals(new PixelInterleavedSampleModel(0, 10, 10, 1, 10, new int[]{0})));
        harness.check(img.isAlphaPremultiplied(), img.getColorModel().isAlphaPremultiplied());
    }
}

