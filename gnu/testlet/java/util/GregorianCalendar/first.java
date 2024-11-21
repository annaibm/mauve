/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.GregorianCalendar;

public class first
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.testYears(1400);
        this.testYears(2000);
    }

    private void testYears(int startYear) {
        for (int year = startYear; year <= startYear + 5; ++year) {
            for (int month = 0; month < 12; ++month) {
                GregorianCalendar cal = new GregorianCalendar(year, month, 1);
                this.harness.check(cal.get(5), 1, "day 1-" + month + "-" + year);
            }
        }
    }
}

