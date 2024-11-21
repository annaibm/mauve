/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class parse
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", Locale.UK);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        HashMap<String, Date> toTest = new HashMap<String, Date>();
        toTest.put("august 1978", new Date(270777600000L));
        toTest.put("August 1978", new Date(270777600000L));
        toTest.put("December 1978", new Date(281318400000L));
        parse.doParse(harness, sdf, toTest);
        sdf.applyPattern("EEEE MMMM yyyy");
        toTest.clear();
        toTest.put("Saturday November 2004", new Date(1099699200000L));
        parse.doParse(harness, sdf, toTest);
        sdf.applyPattern("yyyy-MM-dd HH:mm z");
        toTest.clear();
        toTest.put("2004-08-11 10:42 GMT", new Date(1092220920000L));
        toTest.put("2004-08-11 10:42 GMT+00:00", new Date(1092220920000L));
        toTest.put("2004-08-11 10:42 GMT-00:00", new Date(1092220920000L));
        toTest.put("2004-08-11 12:42 CEST", new Date(1092220920000L));
        toTest.put("2004-08-11 12:42 GMT+02:00", new Date(1092220920000L));
        toTest.put("2004-08-11 12:42 +0200", new Date(1092220920000L));
        parse.doParse(harness, sdf, toTest);
        sdf.applyPattern("yyyy-MM-dd HH:mm Z");
        parse.doParse(harness, sdf, toTest);
        sdf = new SimpleDateFormat("EEE MMM", Locale.UK);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        toTest.clear();
        toTest.put("Sat Jun", new Date(13478400000L));
        toTest.put("Saturday June", new Date(13478400000L));
        parse.doParse(harness, sdf, toTest);
        sdf.applyPattern("EEEE MMMM");
        parse.doParse(harness, sdf, toTest);
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd, yyyy", Locale.UK);
        sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
        toTest = new HashMap();
        toTest.put("dec 31, 2004", new Date(1104451200000L));
        parse.doParse(harness, sdf1, toTest);
        harness.checkPoint("Bug 13058");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzzzz", Locale.US);
        Date d = null;
        try {
            d = sdf2.parse("2004-07-18 17:42:25 +0000 GMT");
        }
        catch (ParseException parseException) {
            // empty catch block
        }
        harness.check(new Date(1090172545000L).equals(d));
        harness.checkPoint("Null arguments");
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        boolean pass = false;
        try {
            df.parse(null, new ParsePosition(0));
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            df.parse("17-May-2005", null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private static void doParse(TestHarness h, SimpleDateFormat sdf, Map toTest) {
        h.checkPoint("parse pattern " + sdf.toPattern());
        for (String dateString : toTest.keySet()) {
            try {
                h.check(sdf.parse(dateString), toTest.get(dateString));
            }
            catch (Exception e) {
                h.check(false, e.getClass().getName() + ": ");
                h.debug(e);
            }
        }
    }
}

