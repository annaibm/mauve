/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints.Key;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;

public class isCompatibleValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("KEY_ALPHA_INTERPOLATION");
        RenderingHints.Key key = RenderingHints.KEY_ALPHA_INTERPOLATION;
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DISABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_ENABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_NORMALIZE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_PURE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(null));
        harness.checkPoint("KEY_ANTIALIASING");
        key = RenderingHints.KEY_ANTIALIASING;
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_DEFAULT));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_OFF));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DISABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_ENABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_NORMALIZE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_PURE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(null));
        harness.checkPoint("KEY_COLOR_RENDERING");
        key = RenderingHints.KEY_COLOR_RENDERING;
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_ON));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_DEFAULT));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DISABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_ENABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_NORMALIZE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_PURE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(null));
        harness.checkPoint("KEY_DITHERING");
        key = RenderingHints.KEY_DITHERING;
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_SPEED));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_DITHER_DEFAULT));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_DITHER_DISABLE));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_DITHER_ENABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_NORMALIZE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_PURE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(null));
        harness.checkPoint("KEY_FRACTIONALMETRICS");
        key = RenderingHints.KEY_FRACTIONALMETRICS;
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DISABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_ENABLE));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_OFF));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_NORMALIZE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_PURE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(null));
        harness.checkPoint("KEY_INTERPOLATION");
        key = RenderingHints.KEY_INTERPOLATION;
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DISABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_ENABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_NORMALIZE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_PURE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(null));
        harness.checkPoint("KEY_RENDERING");
        key = RenderingHints.KEY_RENDERING;
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DISABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_ENABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_RENDER_DEFAULT));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_RENDER_QUALITY));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_NORMALIZE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_PURE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(null));
        harness.checkPoint("KEY_STROKE_CONTROL");
        key = RenderingHints.KEY_STROKE_CONTROL;
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DISABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_ENABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_SPEED));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_STROKE_DEFAULT));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_STROKE_NORMALIZE));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_STROKE_PURE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(null));
        harness.checkPoint("KEY_TEXT_ANTIALIASING");
        key = RenderingHints.KEY_TEXT_ANTIALIASING;
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_COLOR_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_DISABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_DITHER_ENABLE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_OFF));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_QUALITY));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_RENDER_SPEED));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_DEFAULT));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_NORMALIZE));
        harness.check(!key.isCompatibleValue(RenderingHints.VALUE_STROKE_PURE));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(key.isCompatibleValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!key.isCompatibleValue(null));
    }
}

