/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class cosh
implements Testlet {
    private static double[] inputValues = new double[]{0.0, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.123456789, -0.123456789, 0.234242656456, -0.234242656456, 1.23456789, -1.23456789, 9.87654321, -9.87654321, 21.9999, -21.9999, 567.891234, -567.891234, 708.742342, -708.742342, 709.7827128, -709.7827128, 710.475860073943, 710.4755859375, 723.6787676346, -723.6787676346};
    private static double[] outputValues = new double[]{1.0, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0076304736991977, 1.0076304736991977, 1.0275604855232756, 1.0275604855232756, 1.8639267730274125, 1.8639267730274125, 9734.154204183918, 9734.154204183918, 1.792277186385473E9, 1.792277186385473E9, 2.1428869091881118E246, 2.1428869091881118E246, 3.1758371607555525E307, 3.1758371607555525E307, 8.988464834932886E307, 8.988464834932886E307, 1.7976931348605396E308, 1.7972003892018829E308, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    private static long[] NaNValues = new long[]{9223231299366420480L, -140737488355328L, 9223232550370790895L, -139486483984913L, 9223090561878065153L, -281474976710655L, 9223220665868348875L, -151370986426933L};

    private void testInputValues(TestHarness harness) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = Math.cosh(inputValues[i]);
            harness.check(Double.doubleToLongBits(res), Double.doubleToLongBits(outputValues[i]));
        }
    }

    private void testNaN(TestHarness harness) {
        for (int i = 0; i < NaNValues.length; ++i) {
            long bitsNaN = NaNValues[i];
            double valNaN = Double.longBitsToDouble(bitsNaN);
            harness.check(Double.doubleToRawLongBits(Math.cosh(valNaN)), bitsNaN);
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.testInputValues(harness);
        this.testNaN(harness);
    }

    public static void main(String[] argv) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = Math.cosh(inputValues[i]);
            System.out.println(Double.toString(res));
        }
    }
}

