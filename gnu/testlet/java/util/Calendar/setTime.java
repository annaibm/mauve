/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Calendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.Date;

public class setTime
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(123L));
        harness.check(c.getTimeInMillis(), 123L);
        boolean pass = false;
        try {
            c.setTime(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

