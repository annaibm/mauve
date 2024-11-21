/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.RoundRectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.RoundRectangle2D;

public class contains
implements Testlet {
    RoundRectangle2D rr = new RoundRectangle2D.Double(0.0, 0.0, 10.0, 10.0, 6.0, 6.0);
    private static final double[] coords = new double[]{-1.0, 0.5, 5.0, 9.5, 11.0};

    @Override
    public void test(TestHarness harness) {
        for (int y = 0; y < coords.length; ++y) {
            for (int x = 0; x < coords.length; ++x) {
                harness.check(this.rr.contains(coords[x], coords[y]) == this.getExpected(coords[x], coords[y]));
            }
        }
    }

    private boolean getExpected(double x, double y) {
        if (x == 0.5 && y == 5.0) {
            return true;
        }
        if (x == 5.0 && (y == 0.5 || y == 5.0 || y == 9.5)) {
            return true;
        }
        return x == 9.5 && y == 5.0;
    }
}

