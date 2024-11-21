/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StrictMath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class asin
implements Testlet {
    private static double[] inputValues = new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0.0, 0.2, 0.4, 0.5, 0.6, 0.8, 1.0, 2.0, 1.0E10, 1.0E-10, -0.0, -0.2, -0.4, -0.5, -0.6, -0.8, -1.0, -2.0, -1.0E10, -1.0E-10};
    private static double[] outputValues = new double[]{Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.MIN_VALUE, 0.0, 0.2013579207903308, 0.41151684606748806, 0.5235987755982989, 0.6435011087932844, 0.9272952180016123, 1.5707963267948966, Double.NaN, Double.NaN, 1.0E-10, -0.0, -0.2013579207903308, -0.41151684606748806, -0.5235987755982989, -0.6435011087932844, -0.9272952180016123, -1.5707963267948966, Double.NaN, Double.NaN, -1.0E-10};
    private static long[] NaNValues = new long[]{9223231299366420480L, -140737488355328L, 9223232550370790895L, -139486483984913L, 9223090561878065153L, -281474976710655L, 9223220665868348875L, -151370986426933L};

    private static double testedFunction(double input) {
        return StrictMath.asin(input);
    }

    private void testInputValues(TestHarness harness) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = asin.testedFunction(inputValues[i]);
            harness.check(res, outputValues[i]);
        }
    }

    private void testNaN(TestHarness harness) {
        for (int i = 0; i < NaNValues.length; ++i) {
            long bitsNaN = NaNValues[i];
            double valNaN = Double.longBitsToDouble(bitsNaN);
            harness.check(Double.doubleToRawLongBits(asin.testedFunction(valNaN)), bitsNaN);
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
            double output = asin.testedFunction(inputValues[i]);
            System.out.println("      " + Double.toString(output) + ", // " + input);
        }
    }
}

