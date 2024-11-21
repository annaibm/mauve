/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DateFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

public class SanityCheck
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Locale[] locales = Locale.getAvailableLocales();
        for (int a = 0; a < locales.length; ++a) {
            DateFormatSymbols dfs = DateFormatSymbols.getInstance(locales[a]);
            this.checkArray(harness, locales[a], "AM/PM", dfs.getAmPmStrings(), 2);
            this.checkArray(harness, locales[a], "Eras", dfs.getEras(), 2);
            this.checkArray(harness, locales[a], "Months", dfs.getMonths(), 13);
            this.checkArray(harness, locales[a], "Short months", dfs.getShortMonths(), 13);
            this.checkArray(harness, locales[a], "Weekdays", dfs.getWeekdays(), 8);
            this.checkArray(harness, locales[a], "Short weekdays", dfs.getShortWeekdays(), 8);
        }
    }

    private void checkArray(TestHarness harness, Locale locale, String type, String[] array, int size2) {
        harness.check(array.length == size2, type + "check (" + locale + ")");
        harness.debug(locale + ": " + type + "=" + Arrays.toString(array));
        for (int a = 0; a < array.length; ++a) {
            harness.check(array[a] != null, type + "[" + a + "] null check (" + locale + ")");
            if (type.contains("onths") && a == 12 || type.contains("days") && a == 0) continue;
            harness.check(!array[a].isEmpty(), type + "[" + a + "] empty check (" + locale + ")");
        }
    }
}

