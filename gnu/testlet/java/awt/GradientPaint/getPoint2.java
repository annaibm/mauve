/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GradientPaint;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Point2D;

public class getPoint2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue);
        Point2D p2 = gp.getPoint2();
        harness.check(p2.getX(), 3.0);
        harness.check(p2.getY(), 4.0);
        p2.setLocation(5.0, 6.0);
        Point2D pp = gp.getPoint2();
        harness.check(pp.getX(), 3.0);
        harness.check(pp.getY(), 4.0);
    }
}

