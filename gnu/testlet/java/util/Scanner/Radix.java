/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.math.BigInteger;
import java.util.Scanner;

public class Radix
extends Base {
    @Override
    protected void doTest() {
        String testStr = "5F 7FFF 4F3F3F6F 3F3F2EF3FFEE 4FFAAEEFFAA";
        Scanner s = new Scanner(testStr);
        this.myHarness.check(s.hasNextByte(16), "hasNextByte(16)");
        this.myHarness.check(s.nextByte(16), 95, "nextByte is 95");
        this.myHarness.check(s.hasNextShort(16), "hasNextShort(16)");
        this.myHarness.check(s.nextShort(16), Short.MAX_VALUE, "nextShort is 32767");
        this.myHarness.check(s.hasNextInt(16), "hasNextInt(16)");
        this.myHarness.check(s.nextInt(16), 1329545071, "nextInt is 1329545071");
        this.myHarness.check(s.hasNextLong(16), "hasNextLong(16)");
        this.myHarness.check(s.nextLong(16), 69540603232238L, "nextLong is 69540603232238");
        this.myHarness.check(s.hasNextBigInteger(16), "hasNextBigInteger(16)");
        this.myHarness.check(s.nextBigInteger(16), BigInteger.valueOf(5496130961322L), "nextBigInteger is 5496130961322");
        s = new Scanner(testStr).useRadix(16);
        this.myHarness.check(s.radix(), 16, "radix was not set to 16");
        this.myHarness.check(s.hasNextByte(), "hasNextByte()");
        this.myHarness.check(s.nextByte(), 95, "nextByte is 95");
        this.myHarness.check(s.hasNextShort(), "hasNextShort()");
        this.myHarness.check(s.nextShort(), Short.MAX_VALUE, "nextShort is 32767");
        this.myHarness.check(s.hasNextInt(), "hasNextInt()");
        this.myHarness.check(s.nextInt(), 1329545071, "nextInt is 1329545071");
        this.myHarness.check(s.hasNextLong(), "hasNextLong()");
        this.myHarness.check(s.nextLong(), 69540603232238L, "nextLong is 69540603232238");
        this.myHarness.check(s.hasNextBigInteger(), "hasNextBigInteger()");
        this.myHarness.check(s.nextBigInteger(), BigInteger.valueOf(5496130961322L), "nextBigInteger is 5496130961322");
    }
}

