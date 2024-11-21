/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.SimpleTimeZone;

public class setRawOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleTimeZone z1 = new SimpleTimeZone(0, "Zone 1");
        harness.check(z1.getRawOffset(), 0);
        z1.setRawOffset(12345);
        harness.check(z1.getRawOffset(), 12345);
    }
}

