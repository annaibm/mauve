/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.ParserDelegator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.html.parser.ParserDelegator.SimpleParsing;

public class Entities
extends SimpleParsing
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        super.test(harness);
    }

    public void verify(String html, String trace) {
        this.verify(html, trace, html);
    }

    @Override
    public void testHTMLParsing() {
        this.verify("hex: &#x55; eqdec: &#61; ampnamed: &amp;", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'>'hex: U eqdec: = ampnamed: &'</body></html>", "Entities");
    }
}

