/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Locale;

public class CASE_INSENSITIVE_ORDER
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Comparator c = String.CASE_INSENSITIVE_ORDER;
        harness.check(c instanceof Serializable);
        harness.check(c.compare("abc", "abc"), 0);
        harness.check(c.compare("ABC", "ABC"), 0);
        harness.check(c.compare("aBc", "AbC"), 0);
        harness.check(c.compare("", "a") < 0);
        harness.check(c.compare("a", "") > 0);
        harness.check(c.compare("a", "b") < 0);
        harness.check(c.compare("a", "B") < 0);
        harness.check(c.compare("A", "b") < 0);
        harness.check(c.compare("A", "B") < 0);
        harness.check(c.compare("b", "a") > 0);
        harness.check(c.compare("b", "A") > 0);
        harness.check(c.compare("B", "a") > 0);
        harness.check(c.compare("B", "A") > 0);
        harness.checkPoint("unicode mappings");
        harness.check(c.compare("\u00df", "sS") != 0);
        Locale l = Locale.getDefault();
        Locale.setDefault(new Locale("tr", ""));
        harness.check(c.compare("\u0131I", "i\u0130"), 0);
        Locale.setDefault(l);
        harness.check(c.compare("\u0131I", "i\u0130"), 0);
        harness.checkPoint("bad input");
        try {
            c.compare(null, "");
            harness.fail("expected NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            c.compare("", null);
            harness.fail("expected NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            c.compare(this, "");
            harness.fail("expected ClassCastException");
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
        try {
            c.compare("", this);
            harness.fail("expected ClassCastException");
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
    }
}

