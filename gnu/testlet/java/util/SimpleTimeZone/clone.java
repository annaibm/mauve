/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.SimpleTimeZone;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int t = 0x6DDD00;
        SimpleTimeZone z1 = new SimpleTimeZone(18000000, "Zone 1", 0, 15, 0, t, 10, 11, 0, t, 3600000);
        SimpleTimeZone z2 = (SimpleTimeZone)z1.clone();
        harness.check(z1.equals(z2));
    }
}

