/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.ParserDelegator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.html.parser.ParserDelegator.parsingTester;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;

public class tokenLocations
extends parsingTester
implements Testlet {
    @Override
    public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int position2) {
        if (tag.toString().equals("#pcdata")) {
            return;
        }
        this.out.append("<" + tag + "[" + position2 + "]");
        this.dumpAttributes(attributes);
        this.out.append("/>");
    }

    @Override
    public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position2) {
        if (tag.toString().equalsIgnoreCase("tbody")) {
            return;
        }
        this.out.append("<" + tag + "[" + position2 + "]");
        this.dumpAttributes(attributes);
        this.out.append('>');
    }

    @Override
    public void handleText(char[] chars, int position2) {
        this.out.append("'" + new String(chars) + "[" + position2 + "]'");
    }

    @Override
    public void handleEndTag(HTML.Tag tag, int position2) {
        if (tag.toString().equalsIgnoreCase("tbody")) {
            return;
        }
        this.out.append("</" + tag + ">");
    }

    @Override
    public void handleComment(char[] parm1, int position2) {
        this.out.append("{" + new String(parm1) + "[" + position2 + "]}");
    }

    @Override
    public void testHTMLParsing() {
        this.hideImplied = true;
        this.verify("a<!-- comment -->b<!-- comment2 -->", "<html[0]><head[0]></head><body[0]>'a[0]'{ comment [1]}'b[17]'{ comment2 [18]}</body></html>", "comment");
        this.verify("<table><tr><td>a<td>b<td></tr>", "<html[0]><head[0]></head><body[0]><table[0]><tr[7]><td[11]>'a[15]'</td><td[16]>'b[20]'</td><td[21]></td></tr></table></body></html>", "table");
        this.verify("<p>b<p>c<p>d", "<html[0]><head[0]></head><body[0]><p[0]>'b[3]'</p><p[4]>'c[7]'</p><p[8]>'d[11]'</p></body></html>", "paragraphs");
        this.verify("<! the sgml construct >sgml", "<html[23]><head[23]></head><body[23]>'sgml[23]'</body></html>", "SGML insertion");
    }

    @Override
    public void test(TestHarness a_harness) {
        super.test(a_harness);
    }
}

