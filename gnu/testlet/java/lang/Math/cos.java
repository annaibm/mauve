/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class cos
implements Testlet {
    private static double[] inputValues = new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0.0, 0.7853981633974483, 1.5707963267948966, Math.PI, Math.PI * 2, Math.PI * 4, 314.1592653589793, 1.0E10, 1.0E-10, -0.0, -0.7853981633974483, -1.5707963267948966, -Math.PI, Math.PI * -2, Math.PI * -4, -314.1592653589793, -1.0E10, -1.0E-10};
    private static double[] outputValues = new double[]{Double.NaN, Double.NaN, Double.NaN, -0.9999876894265599, 1.0, 1.0, 0.7071067811865476, 6.123233995736766E-17, -1.0, 1.0, 1.0, 1.0, 0.873119622676856, 1.0, 1.0, 0.7071067811865476, 6.123233995736766E-17, -1.0, 1.0, 1.0, 1.0, 0.873119622676856, 1.0};
    private static long[] NaNValues = new long[]{9223231299366420480L, -140737488355328L, 9223232550370790895L, -139486483984913L, 9223090561878065153L, -281474976710655L, 9223220665868348875L, -151370986426933L};

    private static double testedFunction(double input) {
        return Math.cos(input);
    }

    private void testInputValues(TestHarness harness) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = cos.testedFunction(inputValues[i]);
            harness.check(Double.doubleToLongBits(res), Double.doubleToLongBits(outputValues[i]));
        }
    }

    private void testNaN(TestHarness harness) {
        for (int i = 0; i < NaNValues.length; ++i) {
            long bitsNaN = NaNValues[i];
            double valNaN = Double.longBitsToDouble(bitsNaN);
            harness.check(Double.doubleToRawLongBits(cos.testedFunction(valNaN)), bitsNaN);
        }
    }

    @Override
    public void test(TestHarness harness) {
        harness.check(new Double(Math.cos(0.0)).toString(), (Object)"1.0");
        harness.check(new Double(Math.cos(Math.PI)).toString(), (Object)"-1.0");
        harness.check(Math.abs(Math.cos(1.5707963267948966)) <= (double)1.110223E-16f);
        this.testInputValues(harness);
        this.testNaN(harness);
    }
}

