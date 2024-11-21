/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class toLocalizedPattern
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy", Locale.CHINA);
        harness.check(f.toLocalizedPattern(), (Object)"aaaa");
        f.applyPattern("d-MMM-yyyy");
        harness.check(f.toLocalizedPattern(), (Object)"j-nnn-aaaa");
    }
}

