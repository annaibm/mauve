/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.CubicCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.CubicCurve2D;

public class solveCubic
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.checkSolutions(1.0, 0.0, 0.0, -1.0, new double[]{1.0});
        this.checkSolutions(5.0, 6.0, 1.0, 0.0, new double[]{0.0, -1.0, -0.2});
        this.checkSolutions(8.0, 2.0, -1.0, 0.0, new double[]{0.0, -0.5, 0.25});
        this.checkSolutions(9.0, -6.0, 0.5, -1.0, new double[]{0.7785994720166718});
        this.checkSolutions(0.25, -1.0, 0.0, 0.0, new double[]{0.0, 4.0});
        this.checkSolutions(1.0, 1.0, 0.0, 0.0, new double[]{-1.0, 0.0});
        this.checkSolutions(1.0, 0.5, 0.0, 0.0, new double[]{-0.5, 0.0});
        this.checkSolutions(0.0, 0.0, 1.0, -23.0, new double[]{23.0});
        this.checkSolutions(0.0, 0.0, 0.0, 1968.5, null);
        this.checkSolutions(0.0, 0.0, 0.0, 0.0, null);
        this.checkSolutions(0.0, 0.0, 8.0, 8.0, new double[]{-1.0});
        this.checkSolutions(0.0, 0.5, 0.0, -2.0, new double[]{-2.0, 2.0});
        this.checkSolutions(0.0, 10.0, 3.0, 5.0, new double[0]);
        this.checkSolutions(0.0, 4.0, 0.0, 0.0, new double[]{0.0});
        this.checkSolutions(1.0, 0.0, 0.0, -27.0, new double[]{3.0});
        this.checkSolutions(1.0, -51.0, 867.0, -4913.0, new double[]{17.0});
        this.checkSolutions(1.0, -57.0, 1071.0, -6647.0, new double[]{17.0, 23.0});
        this.checkSolutions(1.0, -11.0, -493.0, 6647.0, new double[]{17.0, -23.0});
        this.checkSolutions(1.0, -143.0, 5087.0, -50065.0, new double[]{17.0, 31.0, 95.0});
        this.checkSolutions(1.0, -109.0, 803.0, 50065.0, new double[]{-17.0, 31.0, 95.0});
    }

    private void checkSolutions(double c3, double c2, double c1, double c0, double[] expected) {
        double[] solutions = new double[4];
        StringBuffer buf = new StringBuffer();
        if (c3 != 0.0) {
            buf.append(c3);
            buf.append("x^3");
        }
        if (c2 != 0.0) {
            buf.append(c2 > 0.0 ? " + " : " - ");
            buf.append(Math.abs(c2));
            buf.append("x^2");
        }
        if (c1 != 0.0) {
            buf.append(c1 > 0.0 ? " + " : " - ");
            buf.append(Math.abs(c1));
            buf.append("x");
        }
        if (c0 != 0.0) {
            buf.append(c0 > 0.0 ? " + " : " - ");
            buf.append(Math.abs(c0));
        }
        buf.append(" = 0");
        this.harness.checkPoint(buf.toString());
        int numExpectedSolutions = expected == null ? -1 : expected.length;
        int numSols = CubicCurve2D.solveCubic(new double[]{c0, c1, c2, c3}, solutions);
        this.harness.check(numSols, numExpectedSolutions);
        for (int i = 0; i < numExpectedSolutions; ++i) {
            boolean found = false;
            for (int j = 0; j < numSols; ++j) {
                if (!(Math.abs(solutions[j] - expected[i]) < 1.0E-6)) continue;
                found = true;
                break;
            }
            this.harness.check(found);
            if (found) continue;
            this.harness.debug("solution " + expected[i] + " not found");
        }
    }
}

