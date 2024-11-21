/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class valueOfByte
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Byte(0).equals((byte)0));
        harness.check(new Byte(-1).equals((byte)-1));
        harness.check(new Byte(1).equals((byte)1));
        harness.check(new Byte(127).equals((byte)127));
        harness.check(new Byte(-128).equals((byte)-128));
    }
}

