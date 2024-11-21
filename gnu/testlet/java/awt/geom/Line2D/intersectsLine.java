/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Line2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Line2D;

public class intersectsLine
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Line2D.Double line1 = new Line2D.Double(0.0, 0.0, 1.0, 0.0);
        harness.check(line1.intersectsLine(0.0, 0.0, 1.0, 0.0));
        harness.check(line1.intersectsLine(0.0, 0.0, 1.0, 1.0));
        harness.check(line1.intersectsLine(1.0, 1.0, 1.0, 0.0));
        harness.check(line1.intersectsLine(0.5, 0.5, 0.5, -0.5));
        harness.check(!line1.intersectsLine(0.0, 1.0, 1.0, 1.0));
        harness.check(line1.intersectsLine(new Line2D.Double(0.0, 0.0, 1.0, 0.0)));
        harness.check(line1.intersectsLine(new Line2D.Double(0.0, 0.0, 1.0, 1.0)));
        harness.check(line1.intersectsLine(new Line2D.Double(1.0, 1.0, 1.0, 0.0)));
        harness.check(line1.intersectsLine(new Line2D.Double(0.5, 0.5, 0.5, -0.5)));
        harness.check(!line1.intersectsLine(new Line2D.Double(0.0, 1.0, 1.0, 1.0)));
        boolean pass = false;
        try {
            line1.intersectsLine(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

