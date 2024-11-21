/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.SimpleTimeZone;

public class getDSTSavings
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleTimeZone z1 = new SimpleTimeZone(18000000, "Zone 1", 3, 26, 0, 0x6DDD00, 9, 25, 0, 0x6DDD00, 36000000);
        z1.setDSTSavings(12345);
        harness.check(z1.getDSTSavings(), 12345);
        SimpleTimeZone z2 = new SimpleTimeZone(18000000, "Zone 2");
        z2.setDSTSavings(12345);
        harness.check(z2.getDSTSavings(), 0);
    }
}

