/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.GeneralPath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;

public class GeneralPath
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testZeroArgConstructor(harness);
        this.testIntArgConstructor(harness);
        this.testIntIntArgConstructor(harness);
        this.testShapeArgConstructor(harness);
    }

    public void testZeroArgConstructor(TestHarness harness) {
        harness.checkPoint("GeneralPath()");
        java.awt.geom.GeneralPath path = new java.awt.geom.GeneralPath();
        harness.check(path.getWindingRule(), 1);
    }

    public void testIntArgConstructor(TestHarness harness) {
        harness.checkPoint("GeneralPath(int)");
        java.awt.geom.GeneralPath path = new java.awt.geom.GeneralPath(1);
        harness.check(path.getWindingRule(), 1);
        path = new java.awt.geom.GeneralPath(0);
        harness.check(path.getWindingRule(), 0);
        Exception caught = null;
        try {
            new java.awt.geom.GeneralPath(23);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof IllegalArgumentException);
    }

    public void testIntIntArgConstructor(TestHarness harness) {
        harness.checkPoint("GeneralPath(int,int)");
        java.awt.geom.GeneralPath path = new java.awt.geom.GeneralPath(1, 12);
        harness.check(path.getWindingRule(), 1);
        path = new java.awt.geom.GeneralPath(0, 12);
        harness.check(path.getWindingRule(), 0);
        Exception caught = null;
        try {
            new java.awt.geom.GeneralPath(23, 12);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof IllegalArgumentException);
    }

    public void testShapeArgConstructor(TestHarness harness) {
        java.awt.geom.GeneralPath path;
        double[] c = new double[6];
        harness.checkPoint("GeneralPath(Shape)");
        Exception caught = null;
        try {
            path = new java.awt.geom.GeneralPath(null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof NullPointerException);
        path = new java.awt.geom.GeneralPath(new Rectangle2D.Double(10.0, 20.0, 30.0, 40.0));
        PathIterator piter = path.getPathIterator(null);
        harness.check(piter.currentSegment(c), 0);
        harness.check(c[0], 10.0);
        harness.check(c[1], 20.0);
        piter.next();
        harness.check(piter.currentSegment(c), 1);
        harness.check(c[0], 40.0);
        harness.check(c[1], 20.0);
        piter.next();
        harness.check(piter.currentSegment(c), 1);
        harness.check(c[0], 40.0);
        harness.check(c[1], 60.0);
        piter.next();
        harness.check(piter.currentSegment(c), 1);
        harness.check(c[0], 10.0);
        harness.check(c[1], 60.0);
        piter.next();
        harness.check(piter.currentSegment(c), 1);
        harness.check(c[0], 10.0);
        harness.check(c[1], 20.0);
        piter.next();
        harness.check(piter.currentSegment(c), 4);
        piter.next();
        harness.check(piter.isDone());
        harness.check(piter.getWindingRule(), 1);
    }
}

