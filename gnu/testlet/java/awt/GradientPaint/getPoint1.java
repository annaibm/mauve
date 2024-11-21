/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GradientPaint;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Point2D;

public class getPoint1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue);
        Point2D p1 = gp.getPoint1();
        harness.check(p1.getX(), 1.0);
        harness.check(p1.getY(), 2.0);
        p1.setLocation(3.0, 4.0);
        Point2D p2 = gp.getPoint1();
        harness.check(p2.getX(), 1.0);
        harness.check(p2.getY(), 2.0);
    }
}

