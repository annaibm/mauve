/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("DecimalFormat();");
        Locale original = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        DecimalFormat f = new DecimalFormat();
        harness.check(f.getPositivePrefix(), (Object)"");
        harness.check(f.getNegativePrefix(), (Object)"-");
        harness.check(f.getPositiveSuffix(), (Object)"");
        harness.check(f.getNegativeSuffix(), (Object)"");
        harness.check(f.getMultiplier(), 1);
        harness.check(f.getGroupingSize(), 3);
        harness.check(f.isDecimalSeparatorAlwaysShown(), false);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        harness.check(f.getDecimalFormatSymbols(), symbols);
        Locale.setDefault(original);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("DecimalFormat(String);");
        Locale original = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        DecimalFormat f = new DecimalFormat("0.00");
        boolean pass = false;
        try {
            f = new DecimalFormat(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            f = new DecimalFormat(";;");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        Locale.setDefault(original);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("DecimalFormat(String, DecimalFormatSymbols);");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('x');
        DecimalFormat f = new DecimalFormat("0.00", dfs);
        harness.check(f.getDecimalFormatSymbols().getDecimalSeparator(), 120);
        dfs.setDecimalSeparator('y');
        harness.check(f.getDecimalFormatSymbols().getDecimalSeparator(), 120);
        boolean pass = false;
        try {
            f = new DecimalFormat(null, new DecimalFormatSymbols());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            f = new DecimalFormat("0.00", null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

