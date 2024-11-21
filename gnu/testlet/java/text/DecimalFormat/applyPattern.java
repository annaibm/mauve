/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.util.Locale;

public class applyPattern
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Locale orig = Locale.getDefault();
        Locale.setDefault(Locale.US);
        DecimalFormat f1 = new DecimalFormat();
        harness.checkPoint("negativePrefix");
        f1.applyPattern("0.00");
        harness.check(f1.getNegativePrefix(), (Object)"-");
        f1.applyPattern("0.00;-0.00");
        harness.check(f1.getNegativePrefix(), (Object)"-");
        harness.checkPoint("minimumIntegerDigits");
        f1.applyPattern("0.00");
        harness.check(f1.getMinimumIntegerDigits(), 1);
        f1.applyPattern("#0.00");
        harness.check(f1.getMinimumIntegerDigits(), 1);
        f1.applyPattern("00.00");
        harness.check(f1.getMinimumIntegerDigits(), 2);
        harness.checkPoint("minimumFractionDigits");
        f1.applyPattern("0.0");
        harness.check(f1.getMinimumFractionDigits(), 1);
        f1.applyPattern("0.0#");
        harness.check(f1.getMinimumFractionDigits(), 1);
        f1.applyPattern("0.00");
        harness.check(f1.getMinimumFractionDigits(), 2);
        harness.checkPoint("grouping");
        f1.applyPattern("0.00");
        harness.check(f1.getGroupingSize(), 0);
        f1.applyPattern("#0.00");
        harness.check(f1.getGroupingSize(), 0);
        f1.applyPattern(",#0.00");
        harness.check(f1.getGroupingSize(), 2);
        f1.applyPattern("#,##0.00");
        harness.check(f1.getGroupingSize(), 3);
        f1.applyPattern("#,#,##0.00");
        harness.checkPoint("null pattern");
        f1.applyPattern("");
        harness.check(f1.format(1.2345678912345679E8), (Object)"123,456,789.12345679");
        harness.checkPoint("invalid pattern");
        boolean pass = false;
        try {
            f1.applyPattern(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            f1.applyPattern(";;");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        Locale.setDefault(orig);
    }
}

