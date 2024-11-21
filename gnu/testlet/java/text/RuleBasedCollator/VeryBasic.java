/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.RuleBasedCollator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.Collator;
import java.util.Locale;

public class VeryBasic
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Collator col = Collator.getInstance(Locale.US);
        harness.check(col.compare("foo", "bar") > 0, "foo and bar");
        harness.check(col.compare("bar", "baz") < 0, "bar and baz");
        harness.check(col.compare("FOO", "FOO") == 0, "FOO and FOO");
        harness.check(col.compare("foo", "foobar") < 0, "foo and foobar");
        col.setStrength(1);
        harness.check(col.compare("Foo", "foo") == 0, "Foo and foo");
    }
}

