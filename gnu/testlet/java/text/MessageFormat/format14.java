/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.MessageFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class format14
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testStaticFormat(harness);
    }

    private void testStaticFormat(TestHarness harness) {
        harness.checkPoint("static (String, Object[])");
        String s = MessageFormat.format("{0}", "ABC");
        harness.check(s, (Object)"ABC");
        s = MessageFormat.format("-{0}-", "ABC");
        harness.check(s, (Object)"-ABC-");
        harness.checkPoint("number");
        s = MessageFormat.format("{0,number}", new Integer(9999));
        String expected = NumberFormat.getInstance(Locale.getDefault()).format(9999L);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,number,integer}", new Integer(9999));
        expected = NumberFormat.getIntegerInstance(Locale.getDefault()).format(9999L);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,number,currency}", new Integer(9999));
        expected = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(9999L);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,number,percent}", new Integer(9999));
        expected = NumberFormat.getPercentInstance(Locale.getDefault()).format(9999L);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,number,#,##0.00}", new Integer(9999));
        expected = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.getDefault())).format(9999L);
        harness.check(s, (Object)expected);
        harness.checkPoint("date");
        Date t = new Date();
        s = MessageFormat.format("{0,date}", t);
        expected = DateFormat.getDateInstance(2, Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,date,short}", t);
        expected = DateFormat.getDateInstance(3, Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        try {
            s = MessageFormat.format("{0,date,medium}", t);
            expected = DateFormat.getDateInstance(2, Locale.getDefault()).format(t);
            harness.check(s, (Object)expected);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        s = MessageFormat.format("{0,date,long}", t);
        expected = DateFormat.getDateInstance(1, Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,date,full}", t);
        expected = DateFormat.getDateInstance(0, Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,date,dd-MMM-yyyy}", t);
        expected = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        harness.checkPoint("time");
        s = MessageFormat.format("{0,time}", t);
        expected = DateFormat.getTimeInstance(2, Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,time,short}", t);
        expected = DateFormat.getTimeInstance(3, Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        try {
            s = MessageFormat.format("{0,time,medium}", t);
            expected = DateFormat.getTimeInstance(2, Locale.getDefault()).format(t);
            harness.check(s, (Object)expected);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        s = MessageFormat.format("{0,time,long}", t);
        expected = DateFormat.getTimeInstance(1, Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,time,full}", t);
        expected = DateFormat.getTimeInstance(0, Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        s = MessageFormat.format("{0,time,hh:mm}", t);
        expected = new SimpleDateFormat("hh:mm", Locale.getDefault()).format(t);
        harness.check(s, (Object)expected);
        harness.checkPoint("choice");
        try {
            s = MessageFormat.format("{0,choice,0#zero|1#one|1<many}", new Double(2.0));
            expected = new ChoiceFormat("0#zero|1#one|1<many").format(new Double(2.0));
            harness.check(s, (Object)expected);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        harness.checkPoint("miscellaneous");
        try {
            MessageFormat.format(null, "X");
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        s = MessageFormat.format("{0}", null);
        harness.check(s, (Object)"{0}");
        s = MessageFormat.format("{0}", new Object[]{null});
        harness.check(s, (Object)"null");
        try {
            s = MessageFormat.format("{0,number}", "X");
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        harness.checkPoint("quoting");
        s = MessageFormat.format("new {0}() '{..'}", "bob");
        harness.check(s, (Object)"new bob() {..}");
        s = MessageFormat.format("new {0}() '{..}", "bob");
        harness.check(s, (Object)"new bob() {..}");
    }
}

