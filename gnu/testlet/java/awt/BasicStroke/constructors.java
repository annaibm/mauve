/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BasicStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BasicStroke;
import java.util.Arrays;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("BasicStroke()");
        BasicStroke s = new BasicStroke();
        harness.check(s.getLineWidth(), 1.0);
        harness.check(s.getEndCap(), 2);
        harness.check(s.getLineJoin(), 0);
        harness.check(s.getMiterLimit(), 10.0);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("BasicStroke(float)");
        BasicStroke s = new BasicStroke(3.4f);
        harness.check(s.getLineWidth(), 3.4f);
        harness.check(s.getEndCap(), 2);
        harness.check(s.getLineJoin(), 0);
        harness.check(s.getMiterLimit(), 10.0);
        try {
            s = new BasicStroke(-1.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(0.0f);
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("BasicStroke(float, int, int)");
        BasicStroke s = new BasicStroke(4.5f, 1, 1);
        harness.check(s.getLineWidth(), 4.5);
        harness.check(s.getEndCap(), 1);
        harness.check(s.getLineJoin(), 1);
        harness.check(s.getMiterLimit(), 10.0);
        try {
            s = new BasicStroke(-1.0f, 1, 1);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 11, 1);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 1, 22);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("BasicStroke(float, int, int, float)");
        BasicStroke s = new BasicStroke(4.5f, 1, 1, 15.0f);
        harness.check(s.getLineWidth(), 4.5);
        harness.check(s.getEndCap(), 1);
        harness.check(s.getLineJoin(), 1);
        harness.check(s.getMiterLimit(), 15.0);
        try {
            s = new BasicStroke(-1.0f, 1, 1, 9.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 11, 1, 9.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 1, 22, 9.0f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 1, 0, 0.5f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("BasicStroke(float, int, int, float, float[], float)");
        BasicStroke s = new BasicStroke(4.5f, 1, 1, 15.0f, new float[]{1.0f, 2.0f}, 1.5f);
        harness.check(s.getLineWidth(), 4.5);
        harness.check(s.getEndCap(), 1);
        harness.check(s.getLineJoin(), 1);
        harness.check(s.getMiterLimit(), 15.0);
        harness.check(Arrays.equals(s.getDashArray(), new float[]{1.0f, 2.0f}));
        harness.check(s.getDashPhase(), 1.5);
        try {
            s = new BasicStroke(-1.0f, 1, 1, 9.0f, new float[]{1.0f, 2.0f}, 1.5f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 11, 1, 9.0f, new float[]{1.0f, 2.0f}, 1.5f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 1, 22, 9.0f, new float[]{1.0f, 2.0f}, 1.5f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 1, 0, 0.5f, new float[]{1.0f, 2.0f}, 1.5f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 1, 0, 0.5f, new float[]{0.0f, 0.0f}, 1.5f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 1, 0, 0.5f, new float[0], 1.5f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 1, 0, 0.5f, null, 1.5f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            s = new BasicStroke(-1.0f, 1, 0, 0.5f, new float[]{1.0f, 2.0f}, -1.5f);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

