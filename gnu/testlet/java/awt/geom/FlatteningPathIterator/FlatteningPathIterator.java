/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.FlatteningPathIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;

public class FlatteningPathIterator
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        java.awt.geom.FlatteningPathIterator fpi = new java.awt.geom.FlatteningPathIterator(new Line2D.Float().getPathIterator(null), 0.0, 0);
        harness.check(fpi.getFlatness(), 0.0);
        harness.check(fpi.getRecursionLimit(), 0);
        fpi = new java.awt.geom.FlatteningPathIterator(new Line2D.Float().getPathIterator(null), 0.0);
        harness.check(fpi.getFlatness(), 0.0);
        Exception caught = null;
        try {
            fpi = new java.awt.geom.FlatteningPathIterator(new Line2D.Float().getPathIterator(null), -0.1, 4);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof IllegalArgumentException);
        caught = null;
        try {
            fpi = new java.awt.geom.FlatteningPathIterator(new Line2D.Float().getPathIterator(null), 10.0, -1);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof IllegalArgumentException);
    }
}

