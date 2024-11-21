/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class applyPattern
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy", Locale.FRENCH);
        f.applyPattern("d-MMM-yyyy");
        harness.check(f.toPattern(), (Object)"d-MMM-yyyy");
        try {
            f.applyPattern("QYZ");
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            f.applyPattern(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

