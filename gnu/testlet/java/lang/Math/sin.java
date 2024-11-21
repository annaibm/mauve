/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class sin
implements Testlet {
    private static double[] inputValues = new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0.0, 0.7853981633974483, 1.5707963267948966, Math.PI, Math.PI * 2, Math.PI * 4, 314.1592653589793, 1.0E10, 1.0E-10, -0.0, -0.7853981633974483, -1.5707963267948966, -Math.PI, Math.PI * -2, Math.PI * -4, -314.1592653589793, -1.0E10, -1.0E-10};
    private static double[] outputValues = new double[]{Double.NaN, Double.NaN, Double.NaN, 0.004961954789184062, Double.MIN_VALUE, 0.0, 0.7071067811865475, 1.0, 1.2246467991473532E-16, -2.4492935982947064E-16, -4.898587196589413E-16, 1.964386723728472E-15, -0.4875060250875107, 1.0E-10, -0.0, -0.7071067811865475, -1.0, -1.2246467991473532E-16, 2.4492935982947064E-16, 4.898587196589413E-16, -1.964386723728472E-15, 0.4875060250875107, -1.0E-10};
    private static long[] NaNValues = new long[]{9223231299366420480L, -140737488355328L, 9223232550370790895L, -139486483984913L, 9223090561878065153L, -281474976710655L, 9223220665868348875L, -151370986426933L};

    private static double testedFunction(double input) {
        return Math.sin(input);
    }

    private void testInputValues(TestHarness harness) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = sin.testedFunction(inputValues[i]);
            harness.check(Double.doubleToLongBits(res), Double.doubleToLongBits(outputValues[i]));
        }
    }

    private void testNaN(TestHarness harness) {
        for (int i = 0; i < NaNValues.length; ++i) {
            long bitsNaN = NaNValues[i];
            double valNaN = Double.longBitsToDouble(bitsNaN);
            harness.check(Double.doubleToRawLongBits(sin.testedFunction(valNaN)), bitsNaN);
        }
    }

    @Override
    public void test(TestHarness harness) {
        harness.check(new Double(Math.sin(1.0E50)).toString(), (Object)"-0.4805001434937588");
        this.testInputValues(harness);
        this.testNaN(harness);
    }
}

