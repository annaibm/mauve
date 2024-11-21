/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.FlatteningPathIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.Line2D;

public class getFlatness
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FlatteningPathIterator fpi = new FlatteningPathIterator(new Line2D.Float().getPathIterator(null), 3.141);
        harness.check(fpi.getFlatness(), 3.141);
    }
}

