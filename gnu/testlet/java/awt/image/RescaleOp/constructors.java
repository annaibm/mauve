/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.RescaleOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.RescaleOp;
import java.util.Arrays;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(float[], float[], RenderingHints)");
        float[] scale = new float[]{0.6f};
        float[] offset2 = new float[]{1.1f};
        RescaleOp op = new RescaleOp(scale, offset2, null);
        harness.check(Arrays.equals(op.getScaleFactors(null), scale));
        harness.check(Arrays.equals(op.getOffsets(null), offset2));
        harness.check(op.getRenderingHints(), null);
        scale = new float[]{0.6f, 1.2f, 5.6f, 2.2f};
        offset2 = new float[]{1.1f, 3.0f, 2.7f, 8.0f};
        op = new RescaleOp(scale, offset2, null);
        harness.check(Arrays.equals(op.getScaleFactors(null), scale));
        harness.check(Arrays.equals(op.getOffsets(null), offset2));
        harness.check(op.getRenderingHints(), null);
        try {
            op = new RescaleOp(null, offset2, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            op = new RescaleOp(scale, null, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            op = new RescaleOp(null, null, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            op = new RescaleOp(new float[0], new float[0], null);
            harness.check(true);
        }
        catch (NullPointerException e) {
            harness.check(false);
        }
        scale = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
        offset2 = new float[]{1.0f, 2.0f, 3.0f};
        try {
            op = new RescaleOp(scale, offset2, null);
            harness.check(true);
        }
        catch (IllegalArgumentException ex) {
            harness.check(false);
        }
        scale = new float[]{1.0f, -2.0f};
        offset2 = new float[]{2.0f, -1.0f};
        try {
            op = new RescaleOp(scale, offset2, null);
            harness.check(true);
        }
        catch (IllegalArgumentException ex) {
            harness.check(false);
        }
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(float, float, RenderingHints)");
        RescaleOp op = new RescaleOp(2.0f, 6.5f, null);
        harness.check(Arrays.equals(op.getScaleFactors(null), new float[]{2.0f}));
        harness.check(Arrays.equals(op.getOffsets(null), new float[]{6.5f}));
        harness.check(op.getRenderingHints(), null);
        try {
            op = new RescaleOp(-5.0f, -2.0f, null);
            harness.check(true);
        }
        catch (IllegalArgumentException ex) {
            harness.check(false);
        }
    }
}

