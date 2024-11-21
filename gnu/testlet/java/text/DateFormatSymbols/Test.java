/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DateFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.MissingResourceException;

public class Test
implements Testlet {
    private String[] my_eras = new String[]{"XX", "YY"};
    private String[] my_months = new String[]{"A", "B", "C", "D"};
    private String[] my_short_months = new String[]{"a", "a", "b", "c"};
    private String[] my_weekdays = new String[]{"S", "M", "T"};
    private String[] my_short_weekdays = new String[]{"s", "m", "t"};
    private String[] my_ampms = new String[]{"aa", "pp"};
    private String[][] my_zonestrings = new String[][]{{"A", "B"}};
    private String my_patternchars = "123456789012345678";

    private static boolean arrayEquals(Object[] o1, Object[] o2) {
        if (o1 == null) {
            if (o2 != null) {
                return false;
            }
        } else if (o2 == null) {
            return true;
        }
        for (int i = 0; i < o1.length; ++i) {
            if (o1[i] instanceof Object[]) {
                if (o2[i] instanceof Object[]) {
                    if (Test.arrayEquals((Object[])o1[i], (Object[])o2[i])) continue;
                    return false;
                }
                return false;
            }
            if (o1[i].equals(o2[i])) continue;
            return false;
        }
        return true;
    }

    private static void arrayDump(TestHarness harness, Object[] o, String desc) {
        harness.debug("Dumping Object Array: " + desc);
        if (o == null) {
            harness.debug("null");
            return;
        }
        for (int i = 0; i < o.length; ++i) {
            if (o[i] instanceof Object[]) {
                Test.arrayDump(harness, (Object[])o[i], desc + " element " + i);
                continue;
            }
            harness.debug("  Element " + i + ": " + o[i]);
        }
    }

    @Override
    public void test(TestHarness harness) {
        try {
            DateFormatSymbols dfs = new DateFormatSymbols(Locale.US);
            harness.debug("Dumping default symbol information");
            Test.arrayDump(harness, dfs.getEras(), "eras");
            Test.arrayDump(harness, dfs.getMonths(), "months");
            Test.arrayDump(harness, dfs.getShortMonths(), "short months");
            Test.arrayDump(harness, dfs.getWeekdays(), "weekdays");
            Test.arrayDump(harness, dfs.getShortWeekdays(), "short weekdays");
            Test.arrayDump(harness, dfs.getAmPmStrings(), "am/pm strings");
            Test.arrayDump(harness, (Object[])dfs.getZoneStrings(), "zone string array");
            harness.debug("local pattern chars: " + dfs.getLocalPatternChars());
            dfs.setEras(this.my_eras);
            harness.check(Test.arrayEquals(dfs.getEras(), this.my_eras), "eras");
            dfs.setMonths(this.my_months);
            harness.check(Test.arrayEquals(dfs.getMonths(), this.my_months), "months");
            dfs.setShortMonths(this.my_short_months);
            harness.check(Test.arrayEquals(dfs.getShortMonths(), this.my_short_months), "short months");
            dfs.setWeekdays(this.my_weekdays);
            harness.check(Test.arrayEquals(dfs.getWeekdays(), this.my_weekdays), "weekdays");
            dfs.setShortWeekdays(this.my_short_weekdays);
            harness.check(Test.arrayEquals(dfs.getShortWeekdays(), this.my_short_weekdays), "short weekdays");
            dfs.setAmPmStrings(this.my_ampms);
            harness.check(Test.arrayEquals(dfs.getAmPmStrings(), this.my_ampms), "am/pm");
            dfs.setLocalPatternChars(this.my_patternchars);
            harness.check(dfs.getLocalPatternChars(), this.my_patternchars, "patterns");
            boolean fail = false;
            try {
                dfs.setZoneStrings(this.my_zonestrings);
            }
            catch (IllegalArgumentException e) {
                fail = true;
            }
            harness.check(fail, true, "InvalidArgumentException is thrown.");
        }
        catch (MissingResourceException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

