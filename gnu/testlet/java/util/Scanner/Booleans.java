/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.util.Random;
import java.util.Scanner;

public class Booleans
extends Base {
    private static final int AMOUNT = 100;

    @Override
    protected void doTest() {
        int i;
        boolean[] values2 = new boolean[100];
        Random rand = new Random(System.currentTimeMillis());
        for (i = 0; i < values2.length; ++i) {
            values2[i] = rand.nextBoolean();
        }
        String inStr = "" + values2[0];
        for (i = 1; i < values2.length; ++i) {
            inStr = inStr + " " + values2[i];
        }
        Scanner s = new Scanner(inStr);
        i = 0;
        boolean hasNext = s.hasNextBoolean();
        while (hasNext) {
            boolean aktValue = s.nextBoolean();
            this.myHarness.check(aktValue, values2[i], "nextBoolean() is wrong : " + aktValue + " != " + values2[i]);
            ++i;
            hasNext = s.hasNextBoolean();
        }
        this.myHarness.check(i, values2.length, "not all values (" + i + " / " + values2.length + ")");
    }
}

