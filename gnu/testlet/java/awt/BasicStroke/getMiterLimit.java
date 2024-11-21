/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BasicStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BasicStroke;

public class getMiterLimit
implements Testlet {
    private static final float DEFAULT_MITER_LIMIT = 10.0f;
    private static final float[] DASH_ARRAY = new float[]{1.0f, 2.0f};
    private static final float DASH_PHASE = 0.0f;

    @Override
    public void test(TestHarness harness) {
        this.positiveTests(harness);
        this.positiveTestsSmallMitterOtherJoinTypes(harness, 1);
        this.positiveTestsSmallMitterOtherJoinTypes(harness, 2);
        this.negativeTests(harness);
    }

    public void positiveTests(TestHarness harness) {
        harness.checkPoint("positive tests");
        BasicStroke stroke = null;
        stroke = new BasicStroke();
        harness.check(stroke.getMiterLimit(), 10.0);
        this.testMiterLimit(harness);
        this.testMiterLimit(harness, 1.0f);
        this.testMiterLimit(harness, 10.0f);
        this.testMiterLimit(harness, 2.1474836E9f);
    }

    public void positiveTestsSmallMitterOtherJoinTypes(TestHarness harness, int joinType) {
        harness.checkPoint("positive tests");
        BasicStroke stroke = null;
        try {
            stroke = new BasicStroke(1.0f, 1, joinType, 0.0f);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, joinType, -1.0f);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, joinType, -1000.0f);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, joinType, -2.1474836E9f);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, joinType, 0.0f, DASH_ARRAY, 0.0f);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, joinType, -10.0f, DASH_ARRAY, 0.0f);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
    }

    public void negativeTests(TestHarness harness) {
        harness.checkPoint("positive tests");
        BasicStroke stroke = null;
        try {
            stroke = new BasicStroke(1.0f, 1, 0, 0.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, 0, -1.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, 0, -1000.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, 0, -2.1474836E9f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, 0, 0.0f, DASH_ARRAY, 0.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            stroke = new BasicStroke(1.0f, 1, 0, -10.0f, DASH_ARRAY, 0.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void testMiterLimit(TestHarness harness) {
        int[] caps = new int[]{0, 1, 2};
        int[] joins = new int[]{2, 0, 1};
        for (int cap = 0; cap < caps.length; ++cap) {
            for (int join2 = 0; join2 < joins.length; ++join2) {
                BasicStroke stroke = new BasicStroke(1.0f, caps[cap], joins[join2]);
                harness.check(stroke.getMiterLimit(), 10.0);
            }
        }
    }

    private void testMiterLimit(TestHarness harness, float miterLimit) {
        int[] caps = new int[]{0, 1, 2};
        int[] joins = new int[]{2, 0, 1};
        for (int cap = 0; cap < caps.length; ++cap) {
            for (int join2 = 0; join2 < joins.length; ++join2) {
                BasicStroke stroke = new BasicStroke(1.0f, caps[cap], joins[join2], miterLimit);
                harness.check(stroke.getMiterLimit(), miterLimit);
            }
        }
    }
}

