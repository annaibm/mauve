/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.TimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.SimpleTimeZone;

public class setID
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("set/restore default TimeZone ID");
        String id = "MyTZ";
        String id2 = "AnotherTZ";
        SimpleTimeZone stz = new SimpleTimeZone(3600000, id);
        harness.check(stz.getID(), (Object)id);
        stz.setID(id2);
        harness.check(stz.getID(), (Object)id2);
        try {
            stz.setID(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

