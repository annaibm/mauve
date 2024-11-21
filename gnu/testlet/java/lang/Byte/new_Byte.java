/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class new_Byte
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Byte a = new Byte(0);
        Byte b = new Byte(1);
        Byte c = new Byte(127);
        Byte d = new Byte(-1);
        Byte e = new Byte(-128);
        harness.check(a.hashCode(), 0);
        harness.check(b.hashCode(), 1);
        harness.check(c.hashCode(), 127);
        harness.check(d.hashCode(), -1);
        harness.check(e.hashCode(), -128);
    }
}

