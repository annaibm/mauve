/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.QuadCurve2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.QuadCurve2D;

public class solveQuadratic
implements Testlet {
    private static final double EPSILON = 1.0E-6;
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.checkSolutions(0.0, 1.0, -23.2, new double[]{23.2});
        this.checkSolutions(0.0, 8.0, 8.0, new double[]{-1.0});
        this.checkSolutions(4.0, 0.0, 0.0, new double[]{0.0});
        this.checkSolutions(0.5, 0.0, -2.0, new double[]{-2.0, 2.0});
        this.checkSolutions(-1.0, 4.0, 0.0, new double[]{0.0, 4.0});
        this.checkSolutions(0.1, 20.0, 1000.0, new double[]{-100.0});
        this.checkSolutions(0.1, 2000.0, 0.2, new double[]{-19999.999899999995, -1.0000000050000002E-4});
        this.checkSolutions(10.0, 3.0, 5.0, new double[0]);
        this.checkSolutions(2.0, 1.0, 2.0, new double[0]);
        this.checkSolutions(0.0, 0.0, 0.0, null);
        this.checkSolutions(0.0, 0.0, 123.0, null);
        this.checkSolutions(4.0, -20.0, 26.0, new double[0]);
        this.checkSolutions(4.0, -20.0, 25.0, new double[]{2.5});
        this.checkSolutions(4.0, -20.0, 21.0, new double[]{1.5, 3.5});
        this.checkSolutions(4.0, 7.0, 0.0, new double[]{-1.75, 0.0});
        this.checkSolutions(5.0, 0.0, -20.0, new double[]{-2.0, 2.0});
    }

    private void checkSolutions(double c2, double c1, double c0, double[] expected) {
        double[] solutions = new double[2];
        StringBuffer buf = new StringBuffer();
        boolean ok = false;
        if (c2 != 0.0) {
            buf.append(c2);
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
        int numSols = QuadCurve2D.solveQuadratic(new double[]{c0, c1, c2}, solutions);
        ok = numSols == numExpectedSolutions;
        this.harness.check(ok);
        for (int i = 0; i < numExpectedSolutions; ++i) {
            boolean found = false;
            for (int j = 0; j < numSols; ++j) {
                if (!(Math.abs(solutions[j] - expected[i]) < 1.0E-6)) continue;
                found = true;
                break;
            }
            if (found) continue;
            this.harness.debug("solution " + expected[i] + " not found");
            ok = false;
        }
        this.harness.check(ok);
        if (!ok) {
            this.harness.debug("  got " + solveQuadratic.makeString(solutions));
            this.harness.debug("  expected " + solveQuadratic.makeString(expected));
        }
    }

    private static String makeString(double[] arr) {
        StringBuffer buf = new StringBuffer(50);
        if (arr == null) {
            return "null";
        }
        buf.append('[');
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0) {
                buf.append(", ");
            }
            buf.append(arr[i]);
        }
        buf.append(']');
        return buf.toString();
    }
}

