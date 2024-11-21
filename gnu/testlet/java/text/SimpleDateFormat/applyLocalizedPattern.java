/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class applyLocalizedPattern
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy", Locale.CHINA);
        try {
            f.applyLocalizedPattern("j-nnn-aaaa");
        }
        catch (IllegalArgumentException iae) {
            harness.debug(iae);
            harness.check(false);
        }
        harness.check(f.toPattern(), (Object)"d-MMM-yyyy");
        try {
            f.applyLocalizedPattern("XYZ");
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            f.applyLocalizedPattern(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

