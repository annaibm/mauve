/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.util.Random;
import java.util.Scanner;

public class DoubleFloat
extends Base {
    private static final int AMOUNT = 10000;

    public DoubleFloat() {
        this.isEnabled = false;
    }

    @Override
    protected void doTest() {
        int i;
        double[] doubleZ = new double[10000];
        float[] floatZ = new float[doubleZ.length];
        long runID = System.currentTimeMillis();
        Random rand = new Random(runID);
        StringBuffer tmpStr = new StringBuffer(1000);
        for (i = 0; i < doubleZ.length; ++i) {
            doubleZ[i] = rand.nextDouble() - 0.5;
            floatZ[i] = rand.nextFloat() - 0.5f;
        }
        tmpStr.append(doubleZ[0] + " " + floatZ[0]);
        for (i = 1; i < doubleZ.length; ++i) {
            tmpStr.append(" " + doubleZ[i] + " " + floatZ[i]);
        }
        String inStr = tmpStr.toString();
        Scanner s = new Scanner(inStr);
        for (i = 0; s.hasNext() && i < doubleZ.length; ++i) {
            if (s.hasNextDouble()) {
                double aktDouble = s.nextDouble();
                this.myHarness.check(aktDouble, doubleZ[i], "#" + i + " : bad nextDouble() (" + aktDouble + " != " + doubleZ[i]);
            } else {
                this.myHarness.fail("#" + i + " : not double... (" + s.next() + ")");
            }
            if (s.hasNextFloat()) {
                float aktFloat = s.nextFloat();
                this.myHarness.check((double)aktFloat, (double)floatZ[i], "#" + i + " : bad nextFloat() (" + aktFloat + " != " + floatZ[i]);
                continue;
            }
            this.myHarness.fail("#" + i + " : not float... (" + s.next() + ")");
        }
        if (i != doubleZ.length) {
            this.myHarness.fail("not all (" + i + " / " + doubleZ.length);
        }
    }
}

