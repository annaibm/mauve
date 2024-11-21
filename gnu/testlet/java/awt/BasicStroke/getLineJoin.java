/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BasicStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BasicStroke;

public class getLineJoin
implements Testlet {
    private static final float MITER_LIMIT = 10.0f;
    private static final float[] DASH_ARRAY = new float[]{1.0f, 2.0f};
    private static final float DASH_PHASE = 0.0f;

    @Override
    public void test(TestHarness harness) {
        this.positiveTests(harness);
        this.negativeTests(harness);
    }

    public void positiveTests(TestHarness harness) {
        harness.checkPoint("positive tests");
        BasicStroke stroke = new BasicStroke();
        harness.check(stroke.getLineJoin(), 0);
        stroke = new BasicStroke(1.0f, 1, 2);
        harness.check(stroke.getLineJoin(), 2);
        stroke = new BasicStroke(1.0f, 1, 0);
        harness.check(stroke.getLineJoin(), 0);
        stroke = new BasicStroke(1.0f, 1, 1);
        harness.check(stroke.getLineJoin(), 1);
        stroke = new BasicStroke(1.0f, 1, 2, 1.0f);
        harness.check(stroke.getLineJoin(), 2);
        stroke = new BasicStroke(1.0f, 1, 0, 1.0f);
        harness.check(stroke.getLineJoin(), 0);
        stroke = new BasicStroke(1.0f, 1, 1, 1.0f);
        harness.check(stroke.getLineJoin(), 1);
        stroke = new BasicStroke(1.0f, 1, 2, 10.0f, DASH_ARRAY, 0.0f);
        harness.check(stroke.getLineJoin(), 2);
        stroke = new BasicStroke(1.0f, 1, 0, 10.0f, DASH_ARRAY, 0.0f);
        harness.check(stroke.getLineJoin(), 0);
        stroke = new BasicStroke(1.0f, 1, 1, 10.0f, DASH_ARRAY, 0.0f);
        harness.check(stroke.getLineJoin(), 1);
    }

    public void negativeTests(TestHarness harness) {
        BasicStroke stroke;
        harness.checkPoint("positive tests");
        try {
            stroke = new BasicStroke(1.0f, 1, 10);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, -10);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, Integer.MAX_VALUE);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, Integer.MIN_VALUE);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, 10, 10.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, -10, 10.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, 10, 10.0f, DASH_ARRAY, 0.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, -10, 10.0f, DASH_ARRAY, 0.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

