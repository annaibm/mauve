/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Calendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class getInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
        this.testMethod3(harness);
        this.testMethod4(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("()");
        Calendar c = Calendar.getInstance();
        harness.check(c.getTimeZone(), TimeZone.getDefault());
        Calendar c2 = Calendar.getInstance();
        harness.check(c != c2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(TimeZone)");
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        harness.check(c.getTimeZone(), TimeZone.getTimeZone("GMT"));
        Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        harness.check(c != c2);
        boolean pass = false;
        try {
            Calendar.getInstance((TimeZone)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod3(TestHarness harness) {
        harness.checkPoint("(Locale)");
        Calendar c = Calendar.getInstance(Locale.UK);
        Calendar c2 = Calendar.getInstance(Locale.UK);
        harness.check(c != c2);
        boolean pass = false;
        try {
            Calendar.getInstance((Locale)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod4(TestHarness harness) {
        harness.checkPoint("(TimeZone, Locale)");
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.UK);
        Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.UK);
        harness.check(c != c2);
        boolean pass = false;
        try {
            Calendar.getInstance(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Calendar.getInstance(TimeZone.getDefault(), null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

