/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicHTML;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.basic.BasicHTML;

public class isHTMLString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(BasicHTML.isHTMLString(""), false);
        harness.check(BasicHTML.isHTMLString("A"), false);
        harness.check(BasicHTML.isHTMLString("<b>A</b>"), false);
        harness.check(BasicHTML.isHTMLString("<html>A</html>"), true);
        harness.check(BasicHTML.isHTMLString(null), false);
        harness.check(BasicHTML.isHTMLString(" <html>A</html> "), false);
        harness.check(BasicHTML.isHTMLString("<html>A..."), true);
        harness.check(BasicHTML.isHTMLString("<HtMl>"), true);
    }
}

