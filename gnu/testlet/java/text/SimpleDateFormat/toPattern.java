/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class toPattern
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy", Locale.FRENCH);
        harness.check(f.toPattern(), (Object)"yyyy");
        f.applyPattern("d-MMM-yyyy");
        harness.check(f.toPattern(), (Object)"d-MMM-yyyy");
    }
}

