/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class BigDecimalInteger
extends Base {
    private static final int AMOUNT = 5000;

    public BigDecimalInteger() {
        this.isEnabled = false;
    }

    @Override
    protected void doTest() {
        int i;
        BigDecimal[] decimals = new BigDecimal[5000];
        BigInteger[] integers = new BigInteger[decimals.length];
        long runID = System.currentTimeMillis();
        Random rand = new Random(runID);
        StringBuilder sBuff = new StringBuilder(1000);
        int runsLeft = 10;
        for (i = 0; i < decimals.length; ++i) {
            decimals[i] = new BigDecimal(rand.nextDouble() - 0.5);
            integers[i] = BigInteger.valueOf(rand.nextInt());
        }
        sBuff.append(decimals[0] + " " + integers[0]);
        for (i = 1; i < decimals.length; ++i) {
            sBuff.append(" " + decimals[i] + " " + integers[i]);
        }
        String inStr = sBuff.toString();
        Scanner s = new Scanner(inStr);
        i = 0;
        while (s.hasNext() && runsLeft > 0) {
            boolean failed = false;
            boolean fund = s.hasNextBigDecimal();
            this.myHarness.check(fund, "hasNextBigDecimal()");
            BigDecimal tmpDec = s.nextBigDecimal();
            this.myHarness.check(tmpDec, decimals[i], tmpDec + " == " + decimals[i]);
            fund = s.hasNextBigInteger();
            this.myHarness.check(fund, "hasNextBigInteger()");
            BigInteger tmpInt = s.nextBigInteger();
            this.myHarness.check(tmpInt, integers[i], tmpInt + " == " + integers[i]);
            if (!fund) {
                this.myHarness.fail("\"" + s.next() + "\" is neither BigDecimal nor BigInteger");
            }
            ++i;
            if (!failed) continue;
            --runsLeft;
        }
        this.myHarness.check(i, decimals.length, "not all read (" + i + " / " + decimals.length + ")");
    }
}

