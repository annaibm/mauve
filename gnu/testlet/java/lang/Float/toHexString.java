/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class toHexString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Float.toHexString(Float.NaN), (Object)"NaN");
        harness.check(Float.toHexString(Float.POSITIVE_INFINITY), (Object)"Infinity");
        harness.check(Float.toHexString(Float.NEGATIVE_INFINITY), (Object)"-Infinity");
        harness.check(Float.toHexString(0.0f), (Object)"0x0.0p0");
        harness.check(Float.toHexString(-0.0f), (Object)"-0x0.0p0");
        harness.check(Float.toHexString(0.125f), (Object)"0x1.0p-3");
        harness.check(Float.toHexString(0.25f), (Object)"0x1.0p-2");
        harness.check(Float.toHexString(0.5f), (Object)"0x1.0p-1");
        harness.check(Float.toHexString(1.0f), (Object)"0x1.0p0");
        harness.check(Float.toHexString(2.0f), (Object)"0x1.0p1");
        harness.check(Float.toHexString(4.0f), (Object)"0x1.0p2");
        harness.check(Float.toHexString(8.0f), (Object)"0x1.0p3");
        harness.check(Float.toHexString(65536.0f), (Object)"0x1.0p16");
        harness.check(Float.toHexString(1024.0f), (Object)"0x1.0p10");
        harness.check(Float.toHexString(1048576.0f), (Object)"0x1.0p20");
        harness.check(Float.toHexString(1.0737418E9f), (Object)"0x1.0p30");
        harness.check(Float.toHexString(Float.intBitsToFloat(0x800000)), (Object)"0x1.0p-126");
        harness.check(Float.toHexString(-Float.intBitsToFloat(0x800000)), (Object)"-0x1.0p-126");
        harness.check(Float.toHexString(Float.MAX_VALUE), (Object)"0x1.fffffep127");
        harness.check(Float.toHexString(Float.MIN_VALUE), (Object)"0x0.000002p-126");
    }
}

