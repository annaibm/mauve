/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.RoundRectangle2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.RoundRectangle2D;

public class intersects
implements Testlet {
    RoundRectangle2D rr = new RoundRectangle2D.Double(0.0, 0.0, 10.0, 10.0, 6.0, 6.0);
    private static final double[] coords = new double[]{-3.0, -1.0, 0.5, 4.0, 6.0, 9.5, 11.0, 13.0};

    @Override
    public void test(TestHarness harness) {
        int ck = 0;
        for (int y = 0; y < coords.length - 1; ++y) {
            for (int x = 0; x < coords.length - 1; ++x) {
                harness.check(this.rr.intersects(coords[x], coords[y], coords[x + 1] - coords[x], coords[y + 1] - coords[y]) == this.getExpected(++ck));
            }
        }
    }

    private boolean getExpected(int check2) {
        return check2 >= 10 && check2 <= 12 || check2 >= 16 && check2 <= 20 || check2 >= 23 && check2 <= 27 || check2 >= 30 && check2 <= 34 || check2 >= 38 && check2 <= 40;
    }
}

