/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.FlatteningPathIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.Line2D;

public class getRecursionLimit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FlatteningPathIterator fpi = new FlatteningPathIterator(new Line2D.Float().getPathIterator(null), 9.2, 17);
        harness.check(fpi.getRecursionLimit(), 17);
        fpi = new FlatteningPathIterator(new Line2D.Float().getPathIterator(null), 2.1, 4);
        harness.check(fpi.getRecursionLimit(), 4);
    }
}

