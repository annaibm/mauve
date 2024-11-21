/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StrictMath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public strictfp class atan_strictfp
implements Testlet {
    private static double[] inputValues = new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0.0, 0.2, 0.4, 0.5, 0.6, 0.8, 1.0, 2.0, 1.0E10, 1.0E-10, -0.0, -0.2, -0.4, -0.5, -0.6, -0.8, -1.0, -2.0, -1.0E10, -1.0E-10};
    private static double[] outputValues = new double[]{Double.NaN, 1.5707963267948966, -1.5707963267948966, 1.5707963267948966, Double.MIN_VALUE, 0.0, 0.19739555984988078, 0.3805063771123649, 0.4636476090008061, 0.5404195002705842, 0.6747409422235527, 0.7853981633974483, 1.1071487177940904, 1.5707963266948965, 1.0E-10, -0.0, -0.19739555984988078, -0.3805063771123649, -0.4636476090008061, -0.5404195002705842, -0.6747409422235527, -0.7853981633974483, -1.1071487177940904, -1.5707963266948965, -1.0E-10};
    private static long[] NaNValues = new long[]{9223231299366420480L, -140737488355328L, 9223232550370790895L, -139486483984913L, 9223090561878065153L, -281474976710655L, 9223220665868348875L, -151370986426933L};

    private static double testedFunction(double input) {
        return StrictMath.atan(input);
    }

    private void testInputValues(TestHarness harness) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = atan_strictfp.testedFunction(inputValues[i]);
            harness.check(res, outputValues[i]);
        }
    }

    private void testNaN(TestHarness harness) {
        for (int i = 0; i < NaNValues.length; ++i) {
            long bitsNaN = NaNValues[i];
            double valNaN = Double.longBitsToDouble(bitsNaN);
            harness.check(Double.doubleToRawLongBits(atan_strictfp.testedFunction(valNaN)), bitsNaN);
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.testInputValues(harness);
        this.testNaN(harness);
    }

    public static void main(String[] argv) {
        for (int i = 0; i < inputValues.length; ++i) {
            double input = inputValues[i];
            double output = atan_strictfp.testedFunction(inputValues[i]);
            System.out.println("      " + Double.toString(output) + ", // " + input);
        }
    }
}

