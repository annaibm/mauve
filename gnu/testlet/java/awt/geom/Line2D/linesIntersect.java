/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;

public class linesIntersect
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Line2D.linesIntersect(0.0, 0.0, 100.0, 50.0, 0.0, 50.0, 100.0, 0.0));
        harness.check(Line2D.linesIntersect(0.0, 0.0, 100.0, 100.0, 0.0, 100.0, 100.0, 0.0));
        harness.check(Line2D.linesIntersect(0.0, 10.0, 100.0, 10.0, 50.0, 0.0, 50.0, 50.0));
        harness.check(Line2D.linesIntersect(10.0, 10.0, 10.0, 90.0, 10.0, 0.0, 10.0, 100.0));
        harness.check(!Line2D.linesIntersect(10.0, 10.0, 10.0, 90.0, 10.0, 91.0, 10.0, 100.0));
        harness.check(Line2D.linesIntersect(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0));
        harness.check(Line2D.linesIntersect(0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0));
    }
}

