/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("SimpleDateFormat()");
        SimpleDateFormat f = new SimpleDateFormat();
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("SimpleDateFormat(String)");
        try {
            new SimpleDateFormat(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            new SimpleDateFormat("ZYXWVUT");
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("SimpleDateFormat(String, DateFormatSymbols)");
        DateFormatSymbols s = new DateFormatSymbols(Locale.FRANCE);
        SimpleDateFormat f = new SimpleDateFormat("yyyy", s);
        harness.check(f.getDateFormatSymbols() != s);
        harness.check(f.getDateFormatSymbols().equals(s));
        try {
            new SimpleDateFormat(null, new DateFormatSymbols());
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            new SimpleDateFormat("yyyy", (DateFormatSymbols)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            new SimpleDateFormat("ZYXWVUT", new DateFormatSymbols());
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("SimpleDateFormat(String, Locale)");
        try {
            new SimpleDateFormat(null, Locale.UK);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            new SimpleDateFormat("yyyy", (Locale)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            new SimpleDateFormat("ZYXWVUT", Locale.UK);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

