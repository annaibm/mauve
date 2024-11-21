/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StrictMath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public strictfp class tanh_strictfp
implements Testlet {
    private static double[] inputValues = new double[]{0.0, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 2.7755575615628E-16, -2.7755575615628E-16, 2.5123456789E-16, -2.5123456789E-16, 0.123456789, -0.123456789, 0.987654321, -0.987654321, 1.0, -1.0, 1.123456789, -1.123456789, 22.0, -22.0, 22.0, -22.0, 25.987654321, -25.987654321};
    private static double[] outputValues = new double[]{0.0, Double.NaN, 1.0, -1.0, 2.7755575615627996E-16, -2.7755575615627996E-16, 2.5123456789E-16, -2.5123456789E-16, 0.12283336405919822, -0.12283336405919822, 0.7563603430619676, -0.7563603430619676, 0.7615941559557649, -0.7615941559557649, 0.8087679479619252, -0.8087679479619252, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0};
    private static long[] NaNValues = new long[]{9223231299366420480L, -140737488355328L, 9223232550370790895L, -139486483984913L, 9223090561878065153L, -281474976710655L, 9223220665868348875L, -151370986426933L};

    private void testInputValues(TestHarness harness) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = StrictMath.tanh(inputValues[i]);
            harness.check(res, outputValues[i]);
        }
    }

    private void testNaN(TestHarness harness) {
        for (int i = 0; i < NaNValues.length; ++i) {
            long bitsNaN = NaNValues[i];
            double valNaN = Double.longBitsToDouble(bitsNaN);
            harness.check(Double.doubleToRawLongBits(StrictMath.tanh(valNaN)), bitsNaN);
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.testInputValues(harness);
        this.testNaN(harness);
    }

    public static void main(String[] argv) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = StrictMath.tanh(inputValues[i]);
            System.out.println(Double.toString(res));
        }
    }
}

