/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;

public class getPathIterator
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double(1.0, 2.0, 3.0, 4.0);
        PathIterator iterator = line1.getPathIterator(null);
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
    }
}

