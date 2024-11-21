/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.zip.Adler32;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.zip.Adler32;

public class checksum
implements Testlet {
    private final long[] someMore = new long[]{486795068L, 1525910894L, 3543032800L, 2483946130L, 4150712693L, 3878123687L, 3650897945L, 1682829244L, 1842395054L, 460416992L, 3287492690L, 479453429L, 3960773095L, 2008242969L, 4130540683L, 1021367854L, 4065361952L, 2081116754L, 4033606837L, 1162071911L};

    @Override
    public void test(TestHarness harness) {
        for (int i = 0; i < 20; ++i) {
            int length2 = i * 5000 + 1000;
            byte[] bs = new byte[length2];
            for (int j = 0; j < bs.length; ++j) {
                bs[j] = (byte)j;
            }
            this.test(harness, bs, this.someMore[i]);
        }
    }

    private void test(TestHarness harness, byte[] bs, long result) {
        int i;
        Adler32 adler = new Adler32();
        harness.check(adler.getValue(), 1L);
        adler.update(bs);
        harness.check(adler.getValue(), result);
        adler.reset();
        harness.check(adler.getValue(), 1L);
        for (i = 0; i < bs.length; i += 1000) {
            adler.update(bs, i, 1000);
        }
        harness.check(adler.getValue(), result);
        adler.reset();
        harness.check(adler.getValue(), 1L);
        for (i = 0; i < bs.length; ++i) {
            adler.update(bs[i]);
        }
        harness.check(adler.getValue(), result);
        adler.reset();
        harness.check(adler.getValue(), 1L);
        for (i = 0; i < 250; ++i) {
            adler.update(bs[i]);
        }
        for (i = 250; i < bs.length - 250; i += 250) {
            adler.update(bs, i, 250);
        }
        for (i = bs.length - 250; i < bs.length; ++i) {
            adler.update(bs[i]);
        }
        harness.check(adler.getValue(), result);
    }
}

