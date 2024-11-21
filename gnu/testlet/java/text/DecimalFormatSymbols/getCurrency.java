/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class getCurrency
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("foobar"));
            harness.check(dfs.getCurrency().toString().equals("XXX"));
        }
        catch (Exception x) {
            harness.debug(x);
            harness.check(false);
        }
    }
}

