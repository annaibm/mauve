/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;

public class createTransformedShape
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t1 = new AffineTransform();
        Line2D.Double line1 = new Line2D.Double(1.0, 2.0, 3.0, 4.0);
        Shape shape1 = t1.createTransformedShape(line1);
        GeneralPath p1 = (GeneralPath)shape1;
        PathIterator iterator = p1.getPathIterator(null);
        double[] c = new double[6];
        harness.check(!iterator.isDone());
        harness.check(iterator.currentSegment(c), 0);
        harness.check(c[0], 1.0);
        harness.check(c[1], 2.0);
        iterator.next();
        harness.check(!iterator.isDone());
        harness.check(iterator.currentSegment(c), 1);
        harness.check(c[0], 3.0);
        harness.check(c[1], 4.0);
        iterator.next();
        harness.check(iterator.isDone());
        boolean pass = true;
        try {
            t1.createTransformedShape(null);
        }
        catch (NullPointerException e) {
            pass = false;
        }
        harness.check(pass);
    }
}

