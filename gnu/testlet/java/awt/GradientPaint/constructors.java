/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GradientPaint;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Point2D;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("(float, float, Color, float, float, Color)");
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue);
        harness.check(gp.getPoint1().getX(), 1.0);
        harness.check(gp.getPoint1().getY(), 2.0);
        harness.check(gp.getColor1(), Color.red);
        harness.check(gp.getPoint2().getX(), 3.0);
        harness.check(gp.getPoint2().getY(), 4.0);
        harness.check(gp.getColor2(), Color.blue);
        harness.check(gp.isCyclic(), false);
        boolean pass = false;
        try {
            gp = new GradientPaint(1.0f, 2.0f, null, 3.0f, 4.0f, Color.blue);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(float, float, Color, float, float, Color, boolean)");
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue, true);
        harness.check(gp.getPoint1().getX(), 1.0);
        harness.check(gp.getPoint1().getY(), 2.0);
        harness.check(gp.getColor1(), Color.red);
        harness.check(gp.getPoint2().getX(), 3.0);
        harness.check(gp.getPoint2().getY(), 4.0);
        harness.check(gp.getColor2(), Color.blue);
        harness.check(gp.isCyclic(), true);
        boolean pass = false;
        try {
            gp = new GradientPaint(1.0f, 2.0f, null, 3.0f, 4.0f, Color.blue, true);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, null, true);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("(Point2D, Color, Point2D, Color)");
        GradientPaint gp = new GradientPaint(new Point2D.Float(1.0f, 2.0f), Color.red, new Point2D.Float(3.0f, 4.0f), Color.blue);
        harness.check(gp.getPoint1().getX(), 1.0);
        harness.check(gp.getPoint1().getY(), 2.0);
        harness.check(gp.getColor1(), Color.red);
        harness.check(gp.getPoint2().getX(), 3.0);
        harness.check(gp.getPoint2().getY(), 4.0);
        harness.check(gp.getColor2(), Color.blue);
        harness.check(gp.isCyclic(), false);
        boolean pass = false;
        try {
            gp = new GradientPaint(null, Color.red, new Point2D.Float(3.0f, 4.0f), Color.blue);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gp = new GradientPaint(new Point2D.Float(1.0f, 2.0f), null, new Point2D.Float(3.0f, 4.0f), Color.blue);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gp = new GradientPaint(new Point2D.Float(1.0f, 2.0f), Color.red, null, Color.blue);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gp = new GradientPaint(new Point2D.Float(1.0f, 2.0f), Color.red, new Point2D.Float(1.0f, 2.0f), null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("(Point2D, Color, Point2D, Color, boolean)");
        GradientPaint gp = new GradientPaint(new Point2D.Float(1.0f, 2.0f), Color.red, new Point2D.Float(3.0f, 4.0f), Color.blue, true);
        harness.check(gp.getPoint1().getX(), 1.0);
        harness.check(gp.getPoint1().getY(), 2.0);
        harness.check(gp.getColor1(), Color.red);
        harness.check(gp.getPoint2().getX(), 3.0);
        harness.check(gp.getPoint2().getY(), 4.0);
        harness.check(gp.getColor2(), Color.blue);
        harness.check(gp.isCyclic(), true);
        boolean pass = false;
        try {
            gp = new GradientPaint(null, Color.red, new Point2D.Float(3.0f, 4.0f), Color.blue, true);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gp = new GradientPaint(new Point2D.Float(1.0f, 2.0f), null, new Point2D.Float(3.0f, 4.0f), Color.blue, true);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gp = new GradientPaint(new Point2D.Float(1.0f, 2.0f), Color.red, null, Color.blue, true);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gp = new GradientPaint(new Point2D.Float(1.0f, 2.0f), Color.red, new Point2D.Float(1.0f, 2.0f), null, true);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

