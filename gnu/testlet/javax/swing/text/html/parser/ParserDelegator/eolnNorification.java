/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.ParserDelegator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.StringReader;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class eolnNorification
extends HTMLEditorKit.ParserCallback
implements Testlet {
    String eoln = null;
    int flushed = 0;

    @Override
    public void handleEndOfLineString(String end_of_line) {
        this.eoln = end_of_line;
    }

    public void parse(String html) throws Exception {
        ParserDelegator delegator = new ParserDelegator();
        delegator.parse(new StringReader(html), this, true);
    }

    @Override
    public void test(TestHarness harness) {
        try {
            this.parse("a \n b");
            harness.check(this.eoln, "\n", "bug in 1.2, fixed in 1.3");
            this.parse("a \r b");
            harness.check(this.eoln, "\r", "bug in 1.2, fixed in 1.3");
            this.parse("a \r\n b");
            harness.check(this.eoln, "\r\n", "bug in 1.2, fixed in 1.3");
        }
        catch (Exception ex) {
            harness.fail("Unexpected exception " + ex);
        }
    }
}

