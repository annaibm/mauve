/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ColorConvertOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.ColorConvertOp;
import java.util.Arrays;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(ColorSpace, ColorSpace, RenderingHints)");
        ColorSpace srcCs = ColorSpace.getInstance(1000);
        ColorSpace dstCs = ColorSpace.getInstance(1003);
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        ColorConvertOp op = new ColorConvertOp(srcCs, dstCs, hints);
        harness.check(op.getICC_Profiles(), null);
        harness.check(op.getRenderingHints(), hints);
        op = new ColorConvertOp(srcCs, dstCs, null);
        harness.check(op.getICC_Profiles(), null);
        harness.check(op.getRenderingHints(), null);
        try {
            op = new ColorConvertOp(null, dstCs, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            op = new ColorConvertOp(srcCs, null, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            op = new ColorConvertOp(null, null, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(ColorSpace, RenderingHints)");
        ColorSpace cs = ColorSpace.getInstance(1000);
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        ColorConvertOp op = new ColorConvertOp(cs, hints);
        harness.check(op.getICC_Profiles(), null);
        harness.check(op.getRenderingHints(), hints);
        op = new ColorConvertOp(cs, null);
        harness.check(op.getICC_Profiles(), null);
        harness.check(op.getRenderingHints(), null);
        try {
            op = new ColorConvertOp((ColorSpace)null, (RenderingHints)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(ICC_Profile[], RenderingHints)");
        Object[] profile = new ICC_Profile[]{ICC_Profile.getInstance(1004), ICC_Profile.getInstance(1001), ICC_Profile.getInstance(1000), ICC_Profile.getInstance(1002)};
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        ColorConvertOp op = new ColorConvertOp((ICC_Profile[])profile, hints);
        harness.check(Arrays.equals(op.getICC_Profiles(), profile));
        harness.check(op.getRenderingHints(), hints);
        try {
            op = new ColorConvertOp(new ICC_Profile[0], null);
            harness.check(Arrays.equals(op.getICC_Profiles(), new ICC_Profile[0]));
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            profile = new ICC_Profile[]{ICC_Profile.getInstance(1004)};
            op = new ColorConvertOp((ICC_Profile[])profile, null);
            harness.check(Arrays.equals(op.getICC_Profiles(), profile));
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        op = new ColorConvertOp((ICC_Profile[])profile, null);
        harness.check(Arrays.equals(op.getICC_Profiles(), profile));
        harness.check(op.getRenderingHints(), null);
        try {
            op = new ColorConvertOp((ICC_Profile[])null, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(RenderingHints)");
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        ColorConvertOp op = new ColorConvertOp(hints);
        harness.check(op.getICC_Profiles(), null);
        harness.check(op.getRenderingHints(), hints);
        op = new ColorConvertOp(null);
        harness.check(op.getICC_Profiles(), null);
        harness.check(op.getRenderingHints(), null);
    }
}

