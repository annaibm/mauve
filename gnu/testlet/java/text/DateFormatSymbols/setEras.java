/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DateFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormatSymbols;
import java.util.Locale;

public class setEras
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.UK);
        try {
            dfs.setEras(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

