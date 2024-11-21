/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;
import java.awt.geom.PathIterator;

public class getPathIterator
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        double[] c = new double[6];
        Arc2D.Double arc1 = new Arc2D.Double(1.0, 2.0, 3.0, 4.0, 0.0, 90.0, 2);
        PathIterator iterator = arc1.getPathIterator(null);
        harness.check(!iterator.isDone());
        int segType = iterator.currentSegment(c);
        harness.check(segType == 0);
        harness.check(c[0], 4.0);
        harness.check(c[1], 4.0);
        harness.check(!iterator.isDone());
        iterator.next();
        segType = iterator.currentSegment(c);
        harness.check(segType == 3);
        harness.check(c[0], 4.0);
        harness.check(c[1], 2.8954305003384135);
        harness.check(c[2], 3.3284271247461903);
        harness.check(c[3], 2.0);
        harness.check(c[4], 2.5);
        harness.check(c[5], 2.0);
        iterator.next();
        segType = iterator.currentSegment(c);
        harness.check(segType == 1);
        harness.check(c[0], 2.5);
        harness.check(c[1], 4.0);
        iterator.next();
        segType = iterator.currentSegment(c);
        harness.check(segType == 4);
        iterator.next();
        harness.check(iterator.isDone());
    }
}

