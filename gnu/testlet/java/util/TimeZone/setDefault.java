/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.TimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class setDefault
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("set/restore default TimeZone");
        SimpleTimeZone stz = new SimpleTimeZone(3600000, "MyTZ");
        TimeZone old = TimeZone.getDefault();
        TimeZone.setDefault(stz);
        harness.check(TimeZone.getDefault().getID(), (Object)stz.getID());
        TimeZone.setDefault(null);
        harness.check(TimeZone.getDefault().getID(), (Object)old.getID());
    }
}

