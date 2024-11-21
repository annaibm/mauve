/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.SimpleDateFormat;

public class Cloning
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat format1 = new SimpleDateFormat();
        SimpleDateFormat format2 = (SimpleDateFormat)format1.clone();
        harness.check(format1.getDateFormatSymbols() != format2.getDateFormatSymbols(), "Cloned symbols");
        harness.check(format1.get2DigitYearStart().equals(format2.get2DigitYearStart()), "Cloned 2 digit year start date");
    }
}

