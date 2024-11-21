/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormat;
import java.util.Locale;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DateFormat f1 = DateFormat.getDateInstance(3, Locale.UK);
        DateFormat f2 = DateFormat.getDateInstance(3, Locale.UK);
        harness.check(f1.equals(f2));
        harness.check(f1.hashCode(), f2.hashCode());
    }
}

