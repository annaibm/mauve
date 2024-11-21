/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class Tests15
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(64, 64);
        harness.check((Object)123456L, new Long(123456L));
        harness.checkPoint("bitCount");
        harness.check(Long.bitCount(-1L), 64);
        harness.check(Long.bitCount(0x5555555555555555L), 32);
        harness.check(Long.bitCount(0L), 0);
        harness.check(Long.bitCount(0x55555555AAAAAAAAL), 32);
        harness.check(Long.bitCount(1317448168880243265L), 16);
        harness.checkPoint("rotateLeft");
        harness.check(Long.rotateLeft(-4294967296L, 16), -281474976645121L);
        harness.check(Long.rotateLeft(1311768467463790320L, 128), 1311768467463790320L);
        harness.checkPoint("rotateRight");
        harness.check(Long.rotateRight(-4294967296L, 16), 0xFFFFFFFF0000L);
        harness.check(Long.rotateRight(1311768467463790320L, 128), 1311768467463790320L);
        harness.checkPoint("highestOneBit");
        harness.check(Long.highestOneBit(0xFF0000000000FFL), 0x80000000000000L);
        harness.check(Long.highestOneBit(-1152921504606846961L), Long.MIN_VALUE);
        harness.check(Long.highestOneBit(0L), 0L);
        harness.checkPoint("numberOfLeadingZeros");
        harness.check(Long.numberOfLeadingZeros(-1152921504606846976L), 0);
        harness.check(Long.numberOfLeadingZeros(0x505050505050505L), 5);
        harness.check(Long.numberOfLeadingZeros(1L), 63);
        harness.check(Long.numberOfLeadingZeros(0L), 64);
        harness.checkPoint("lowestOneBit");
        harness.check(Long.lowestOneBit(0xFF0000000000FFL), 1L);
        harness.check(Long.lowestOneBit(-1152921504606846961L), 1L);
        harness.check(Long.lowestOneBit(-1152921504606843136L), 256L);
        harness.check(Long.lowestOneBit(0L), 0L);
        harness.checkPoint("numberOfTrailingZeros");
        harness.check(Long.numberOfTrailingZeros(5L), 0);
        harness.check(Long.numberOfTrailingZeros(240L), 4);
        harness.check(Long.numberOfTrailingZeros(Long.MIN_VALUE), 63);
        harness.check(Long.numberOfTrailingZeros(0L), 64);
        harness.checkPoint("signum");
        harness.check(Long.signum(0L), 0);
        harness.check(Long.signum(1L), 1);
        harness.check(Long.signum(Long.MAX_VALUE), 1);
        harness.check(Long.signum(Long.MIN_VALUE), -1);
        harness.check(Long.signum(-1L), -1);
        harness.checkPoint("reverseBytes");
        harness.check(Long.reverseBytes(0L), 0L);
        harness.check(Long.reverseBytes(1311768467463790320L), -1090226688147180526L);
        harness.checkPoint("reverse");
        harness.check(Long.reverse(0L), 0L);
        harness.check(Long.reverse(-1L), -1L);
        harness.check(Long.reverse(0x5555555555555555L), -6148914691236517206L);
    }
}

