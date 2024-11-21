/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ColorConvertOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

public class filterImage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("filter(BufferedImage) from ColorConvertOp(RenderingHints)");
        BufferedImage img = new BufferedImage(20, 20, 11);
        Graphics2D g = (Graphics2D)img.getGraphics();
        g.draw(new Line2D.Double(0.0, 0.0, 20.0, 20.0));
        ColorConvertOp op = new ColorConvertOp(null);
        try {
            op.filter(img, img);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        BufferedImage dst = new BufferedImage(30, 40, 1);
        try {
            op.filter(img, dst);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            op.filter(img, null);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void test2(TestHarness harness) {
        BufferedImage dst;
        harness.checkPoint("filter(BufferedImage) from ColorConvertOp(ColorSpace, RenderingHints)");
        BufferedImage img = new BufferedImage(20, 20, 11);
        Graphics2D g = (Graphics2D)img.getGraphics();
        g.draw(new Line2D.Double(0.0, 0.0, 20.0, 20.0));
        ColorSpace cs = ColorSpace.getInstance(1000);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        try {
            dst = op.filter(img, null);
            harness.check(dst.getColorModel().getColorSpace().getType(), 5);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            dst = new BufferedImage(20, 20, 1);
            dst = op.filter(img, dst);
            harness.check(dst.getColorModel().getColorSpace().getType(), 5);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            dst = new BufferedImage(20, 20, 2);
            dst = op.filter(img, dst);
            harness.check(dst.getColorModel().getColorSpace().getType(), 5);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            dst = new BufferedImage(20, 20, 10);
            dst = op.filter(img, dst);
            harness.check(dst.getColorModel().getColorSpace().getType(), 6);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
    }

    private void test3(TestHarness harness) {
        BufferedImage dst;
        harness.checkPoint("filter(BufferedImage) from ColorConvertOp(ColorSpace, ColorSpace, RenderingHints)");
        BufferedImage img = new BufferedImage(20, 20, 11);
        Graphics2D g = (Graphics2D)img.getGraphics();
        g.draw(new Line2D.Double(0.0, 0.0, 20.0, 20.0));
        ColorSpace cs1 = ColorSpace.getInstance(1001);
        ColorSpace cs2 = ColorSpace.getInstance(1000);
        ColorConvertOp op = new ColorConvertOp(cs1, cs2, null);
        try {
            dst = op.filter(img, null);
            harness.check(dst.getColorModel().getColorSpace().getType(), 5);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            dst = new BufferedImage(20, 20, 3);
            op.filter(img, dst);
            harness.check(dst.getColorModel().getColorSpace().getType(), 5);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void test4(TestHarness harness) {
        BufferedImage dst;
        harness.checkPoint("filter(BufferedImage) from ColorConvertOp(ICC_Profile[], RenderingHints)");
        BufferedImage img = new BufferedImage(20, 20, 11);
        Graphics2D g = (Graphics2D)img.getGraphics();
        g.draw(new Line2D.Double(0.0, 0.0, 20.0, 20.0));
        ICC_Profile[] profile = new ICC_Profile[]{ICC_Profile.getInstance(1004), ICC_Profile.getInstance(1001), ICC_Profile.getInstance(1000)};
        ColorConvertOp op = new ColorConvertOp(profile, null);
        try {
            dst = op.filter(img, null);
            harness.check(dst.getColorModel().getColorSpace().getType(), 5);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            dst = new BufferedImage(20, 20, 10);
            dst = op.filter(img, dst);
            harness.check(dst.getColorModel().getColorSpace().getType(), 6);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
    }
}

