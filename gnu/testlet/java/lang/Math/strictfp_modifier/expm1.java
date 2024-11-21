/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math.strictfp_modifier;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public strictfp class expm1
implements Testlet {
    private static double[] inputValues = new double[]{0.0, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 2.7755575615628914E-17, -2.7755575615628914E-17, 0.46588830833596717, -0.46588830833596717, 0.20328679513998632, -0.20328679513998632, 0.44, -0.44, 1.644238515287874, -1.644238515287874, 4.882030263919617, -6.268324625039508, 20.131268236238416, -18.744973875118525, 709.782712893384, 709.782747123384, 709.782678663384, -709.782712893384, -709.782747123384, -709.782678663384};
    private static double[] outputValues = new double[]{0.0, Double.NaN, Double.POSITIVE_INFINITY, -1.0, 2.7755575615628914E-17, -2.7755575615628914E-17, 0.5934290166706889, -0.3724226247056801, 0.22542386346433524, -0.1839558296400811, 0.5527072185113361, -0.35596357891685865, 4.177066148857307, -0.806840405116183, 130.89818034605017, -0.9981045985672881, 5.532210644181606E8, -0.9999999927696174, 1.7976931348622732E308, Double.POSITIVE_INFINITY, 1.7976316008794578E308, -1.0, -1.0, -1.0};
    private static long[] NaNValues = new long[]{9223231299366420480L, -140737488355328L, 9223232550370790895L, -139486483984913L, 9223090561878065153L, -281474976710655L, 9223220665868348875L, -151370986426933L};

    private static double testedFunction(double input) {
        return Math.expm1(input);
    }

    private void testInputValues(TestHarness harness) {
        for (int i = 0; i < inputValues.length; ++i) {
            double res = expm1.testedFunction(inputValues[i]);
            harness.check(Double.doubleToLongBits(res), Double.doubleToLongBits(outputValues[i]));
        }
    }

    private void testNaN(TestHarness harness) {
        for (int i = 0; i < NaNValues.length; ++i) {
            long bitsNaN = NaNValues[i];
            double valNaN = Double.longBitsToDouble(bitsNaN);
            harness.check(Double.doubleToRawLongBits(expm1.testedFunction(valNaN)), bitsNaN);
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
            double output = expm1.testedFunction(inputValues[i]);
            System.out.println("      " + Double.toString(output) + ", // " + input);
        }
    }
}

