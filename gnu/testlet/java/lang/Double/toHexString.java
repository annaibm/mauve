/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class toHexString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Double.toHexString(Double.NaN), (Object)"NaN");
        harness.check(Double.toHexString(Double.NEGATIVE_INFINITY), (Object)"-Infinity");
        harness.check(Double.toHexString(Double.POSITIVE_INFINITY), (Object)"Infinity");
        harness.check(Double.toHexString(0.0), (Object)"0x0.0p0");
        harness.check(Double.toHexString(-0.0), (Object)"-0x0.0p0");
        harness.check(Double.toHexString(0.125), (Object)"0x1.0p-3");
        harness.check(Double.toHexString(0.25), (Object)"0x1.0p-2");
        harness.check(Double.toHexString(0.5), (Object)"0x1.0p-1");
        harness.check(Double.toHexString(1.0), (Object)"0x1.0p0");
        harness.check(Double.toHexString(2.0), (Object)"0x1.0p1");
        harness.check(Double.toHexString(4.0), (Object)"0x1.0p2");
        harness.check(Double.toHexString(8.0), (Object)"0x1.0p3");
        harness.check(Double.toHexString(65536.0), (Object)"0x1.0p16");
        harness.check(Double.toHexString(1024.0), (Object)"0x1.0p10");
        harness.check(Double.toHexString(1048576.0), (Object)"0x1.0p20");
        harness.check(Double.toHexString(1.073741824E9), (Object)"0x1.0p30");
        harness.check(Double.toHexString(Double.longBitsToDouble(0x10000000000000L)), (Object)"0x1.0p-1022");
        harness.check(Double.toHexString(-Double.longBitsToDouble(0x10000000000000L)), (Object)"-0x1.0p-1022");
        harness.check(Double.toHexString(Double.MAX_VALUE), (Object)"0x1.fffffffffffffp1023");
        harness.check(Double.toHexString(-1.7976931348623157E308), (Object)"-0x1.fffffffffffffp1023");
        harness.check(Double.toHexString(Double.MIN_VALUE), (Object)"0x0.0000000000001p-1022");
        harness.check(Double.toHexString(-1.7976931348623157E308), (Object)"-0x1.fffffffffffffp1023");
    }
}

