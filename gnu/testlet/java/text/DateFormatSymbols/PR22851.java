/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DateFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormatSymbols;
import java.util.Locale;

public class PR22851
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String[][] zstrings = DateFormatSymbols.getInstance(Locale.UK).getZoneStrings();
        boolean checked = false;
        for (int a = 0; a < zstrings.length; ++a) {
            harness.check(zstrings[a].length >= 5, zstrings[a][0] + " has less than 5 strings.");
            if (!zstrings[a][0].equals("Europe/London")) continue;
            if (checked) {
                harness.fail("Europe/London appears twice.");
            }
            harness.check(zstrings[a][1], (Object)"Greenwich Mean Time");
            harness.check(zstrings[a][2], (Object)"GMT");
            harness.check(zstrings[a][3], (Object)"British Summer Time");
            harness.check(zstrings[a][4], (Object)"BST");
            checked = true;
        }
        if (!checked) {
            harness.fail("Europe/London doesn't appear");
        }
    }
}

