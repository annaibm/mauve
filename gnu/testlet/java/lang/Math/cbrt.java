/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class cbrt
implements Testlet {
    private static double[] inputValues = new double[]{0.0, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.123456789, -123.456789, 1.23456789E10, -1.23456789E12, 98.7654321, -98765.4321, 9.87654321E11, -9.87654321E13, 1.234509876E-311, 9.75627236E-316, Math.PI, Math.E};
    private static double[] outputValues = new double[]{0.0, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.49793385921817446, -4.979338592181745, 2311.204240824796, -10727.659796410873, 4.622408495690158, -46.224084956901585, 9958.677214612972, -46224.08495690158, 2.3111680380625372E-104, 9.918088333941088E-106, 1.4645918875615231, 1.3956124250860895};
    private static long[] NaNValues = new long[]{9223231299366420480L, -140737488355328L, 9223232550370790895L, -139486483984913L, 9223090561878065153L, -281474976710655L, 9223220665868348875L, -151370986426933L};

    private void testInputValues(TestHarness harness) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = Math.cbrt(inputValues[i]);
            harness.check(Double.doubleToLongBits(res), Double.doubleToLongBits(outputValues[i]));
        }
    }

    private void testNaN(TestHarness harness) {
        for (int i = 0; i < NaNValues.length; ++i) {
            long bitsNaN = NaNValues[i];
            double valNaN = Double.longBitsToDouble(bitsNaN);
            harness.check(Double.doubleToRawLongBits(Math.cbrt(valNaN)), bitsNaN);
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.testInputValues(harness);
        this.testNaN(harness);
    }

    public static void main(String[] argv) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = Math.cbrt(inputValues[i]);
            System.out.println(Double.toString(res));
        }
    }
}

