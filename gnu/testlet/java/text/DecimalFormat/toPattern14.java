/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class toPattern14
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    public void test1(TestHarness harness) {
        Locale loc = Locale.US;
        Locale.setDefault(loc);
        DecimalFormat df = new DecimalFormat("0.##");
        harness.check(df.toPattern(), (Object)"#0.##");
        harness.check(df.toLocalizedPattern(), (Object)"#0.##");
        DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setZeroDigit('1');
        dfs.setDigit('X');
        dfs.setGroupingSeparator('!');
        df.setDecimalFormatSymbols(dfs);
        harness.check(df.toLocalizedPattern(), (Object)"X1,XX");
        df.applyPattern("Fr #,##0.##");
        String x1 = df.toPattern();
        String x2 = df.toLocalizedPattern();
        harness.check(x1.length(), x2.length());
        boolean ok = x1.length() == x2.length();
        for (int i = 0; i < x1.length(); ++i) {
            int c = x1.charAt(i);
            if (c == 48) {
                c = 49;
            } else if (c == 35) {
                c = 88;
            } else if (c == 46) {
                c = 44;
            } else if (c == 44) {
                c = 33;
            }
            if (c == x2.charAt(i)) continue;
            ok = false;
            harness.debug("failure at char " + i);
            harness.debug("x1 = " + x1 + "\nx2 = " + x2);
            break;
        }
        harness.check(ok);
    }

    public void test2(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat("#0.00;(#0.00)");
        harness.check(f1.toPattern(), (Object)"#0.00;(#0.00)");
        DecimalFormat f2 = new DecimalFormat("'#'1'.' ''nessuno ci capisce niente qui #0.00;(#0.00)");
        harness.check(f2.toPattern(), (Object)"'#1. '''nessuno ci capisce niente qui #0.00;(#0.00)");
    }

    public void test3(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat("0.00");
        harness.check(f1.toPattern(), (Object)"#0.00");
        f1.setMinimumIntegerDigits(0);
        harness.check(f1.toPattern(), (Object)"#.00");
        f1.setMaximumIntegerDigits(0);
        harness.check(f1.toPattern(), (Object)"#.00");
        DecimalFormat f2 = new DecimalFormat("#0.#E0");
        harness.check(f2.toPattern(), (Object)"#0.#E0");
        DecimalFormat f3 = new DecimalFormat("0.#E0");
        harness.check(f3.toPattern(), (Object)"0.#E0");
    }
}

