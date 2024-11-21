/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class Tests15
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(32, 32);
        harness.check((Object)123456, new Integer(123456));
        harness.checkPoint("bitCount");
        harness.check(Integer.bitCount(-1), 32);
        harness.check(Integer.bitCount(0x55555555), 16);
        harness.check(Integer.bitCount(0), 0);
        harness.check(Integer.bitCount(0x5555AAAA), 16);
        harness.check(Integer.bitCount(306742305), 8);
        harness.checkPoint("rotateLeft");
        harness.check(Integer.rotateLeft(-65536, 8), -16776961);
        harness.check(Integer.rotateLeft(305419896, 64), 305419896);
        harness.checkPoint("rotateRight");
        harness.check(Integer.rotateRight(-65536, 8), 0xFFFF00);
        harness.check(Integer.rotateRight(305419896, 64), 305419896);
        harness.checkPoint("highestOneBit");
        harness.check(Integer.highestOneBit(0xFF000FF), 0x8000000);
        harness.check(Integer.highestOneBit(-268435441), Integer.MIN_VALUE);
        harness.check(Integer.highestOneBit(0), 0);
        harness.checkPoint("numberOfLeadingZeros");
        harness.check(Integer.numberOfLeadingZeros(-268435456), 0);
        harness.check(Integer.numberOfLeadingZeros(0x5050505), 5);
        harness.check(Integer.numberOfLeadingZeros(1), 31);
        harness.check(Integer.numberOfLeadingZeros(0), 32);
        harness.checkPoint("lowestOneBit");
        harness.check(Integer.lowestOneBit(0xFF000FF), 1);
        harness.check(Integer.lowestOneBit(-268435441), 1);
        harness.check(Integer.lowestOneBit(-268431616), 256);
        harness.check(Integer.lowestOneBit(0), 0);
        harness.checkPoint("numberOfTrailingZeros");
        harness.check(Integer.numberOfTrailingZeros(5), 0);
        harness.check(Integer.numberOfTrailingZeros(240), 4);
        harness.check(Integer.numberOfTrailingZeros(Integer.MIN_VALUE), 31);
        harness.check(Integer.numberOfTrailingZeros(0), 32);
        harness.checkPoint("signum");
        harness.check(Integer.signum(0), 0);
        harness.check(Integer.signum(1), 1);
        harness.check(Integer.signum(Integer.MAX_VALUE), 1);
        harness.check(Integer.signum(Integer.MIN_VALUE), -1);
        harness.check(Integer.signum(-1), -1);
        harness.checkPoint("reverseBytes");
        harness.check(Integer.reverseBytes(0), 0);
        harness.check(Integer.reverseBytes(305419896), 2018915346);
        harness.checkPoint("reverse");
        harness.check(Integer.reverse(0), 0);
        harness.check(Integer.reverse(-1), -1);
        harness.check(Integer.reverse(0x55555555), -1431655766);
    }
}

