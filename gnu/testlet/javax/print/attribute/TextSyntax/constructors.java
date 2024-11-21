/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.TextSyntax;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Locale;
import javax.print.attribute.TextSyntax;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("constructors");
        try {
            new TestTextSyntax(null, Locale.GERMANY);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        TestTextSyntax defaultLocale = new TestTextSyntax("Text", null);
        harness.check(defaultLocale.getLocale().equals(Locale.getDefault()));
    }

    public class TestTextSyntax
    extends TextSyntax {
        public TestTextSyntax(String v, Locale l) {
            super(v, l);
        }
    }
}

