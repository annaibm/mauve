/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat f1 = new SimpleDateFormat();
        SimpleDateFormat f2 = new SimpleDateFormat();
        harness.check(f1.equals(f2));
        f1 = new SimpleDateFormat("yyyy");
        harness.check(!f1.equals(f2));
        f2 = new SimpleDateFormat("yyyy");
        harness.check(f1.equals(f2));
        DateFormatSymbols dfs1 = new DateFormatSymbols(Locale.GERMAN);
        DateFormatSymbols dfs2 = new DateFormatSymbols(Locale.ENGLISH);
        f1 = new SimpleDateFormat("yyyy", dfs1);
        f2 = new SimpleDateFormat("yyyy", dfs2);
        harness.check(!f1.equals(f2));
        f2.setDateFormatSymbols(dfs1);
        harness.check(f1.equals(f2));
        Date d1 = new Date();
        harness.check(!d1.equals(null));
        harness.check(!d1.equals("Not a SimpleDateFormat"));
    }
}

