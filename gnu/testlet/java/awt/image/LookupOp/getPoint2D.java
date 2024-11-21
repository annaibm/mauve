/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.LookupOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Point2D;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;

public class getPoint2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        byte[] bytes = new byte[]{-86, -69};
        ByteLookupTable t = new ByteLookupTable(0, bytes);
        LookupOp op = new LookupOp(t, null);
        Point2D.Double p = new Point2D.Double(1.0, 2.0);
        Point2D.Double pp = new Point2D.Double();
        Point2D p1 = op.getPoint2D(p, pp);
        harness.check(p1, p);
        harness.check(p1 == pp);
        harness.check(p1 != p);
        p1 = op.getPoint2D(p, null);
        harness.check(p1, p);
        harness.check(p1 != p);
        p1 = op.getPoint2D(p, p);
        harness.check(p1, p);
        harness.check(p1 == p);
    }
}

