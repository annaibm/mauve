/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.ParserDelegator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.StringReader;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.TreeSet;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class SimpleParsing
extends HTMLEditorKit.ParserCallback
implements Testlet {
    StringBuffer out = new StringBuffer();
    AttributeSet atts = new SimpleAttributeSet();
    TestHarness harness;
    public boolean hideImplied = false;

    @Override
    public void handleComment(char[] parm1, int position2) {
        this.out.append("{" + new String(parm1) + "}");
    }

    @Override
    public void handleEndTag(HTML.Tag tag, int position2) {
        if (tag.toString().equals("tbody")) {
            return;
        }
        this.out.append("</" + tag + ">");
    }

    @Override
    public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int position2) {
        if (tag.toString().equals("#pcdata")) {
            return;
        }
        this.out.append("<" + tag);
        this.dumpAttributes(attributes);
        this.out.append("/>");
    }

    @Override
    public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position2) {
        if (tag.toString().equals("tbody")) {
            return;
        }
        this.out.append("<" + tag);
        this.dumpAttributes(attributes);
        this.out.append('>');
    }

    @Override
    public void handleText(char[] chars, int position2) {
        this.out.append("'" + new String(chars) + "'");
    }

    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        this.testHTMLParsing();
    }

    public void testHTMLParsing() {
        this.verify("eqdec: &#61; ampnamed: &amp;", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'>'eqdec: = ampnamed: &'</body></html>", "Named and numeric entities");
        this.verify("<hr id = 1 class = c<hr id=2>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><hr class='c' id='1'/><hr id='2'/></body></html>", "Error tolerance (unclosed tags)");
        this.verify("<hr id='i' TITLE=\"tit\" clAss=cl><hr><hr id = 2>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><hr class='cl' id='i' title='tit'/><hr/><hr id='2'/></body></html>", "Attributes");
        this.verify("<hr audrius title=\"tit\">", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><hr audrius='#DEFAULT' title='tit'/></body></html>", "surely unknown attribute 'audrius' without value");
        this.verify("<table><tr><td>a</td><tr><td>a</td>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><table><tr><td>'a'</td></tr><tr><td>'a'</td></tr></table></body></html>", "Table with implied row closing tags 1");
        this.verify("<table><tr><td>a<td>b<tr><td>a<td>b<td>c", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><table><tr><td>'a'</td><td>'b'</td></tr><tr><td>'a'</td><td>'b'</td><td>'c'</td></tr></table></body></html>", "Table with implied row closing tags 2");
        this.verify("<table><tr><td>a<td>b<td>c</tr>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><table><tr><td>'a'</td><td>'b'</td><td>'c'</td></tr></table></body></html>", "Table with implied row and column closing tags");
        this.verify("<table>a</table>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><table><tr _implied_='true'><td _implied_='true'>'a'</td></tr></table></body></html>", "Table with implied tags");
        this.verify("<table><caption>cap</caption>a</table>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><table><caption>'cap'</caption><tr _implied_='true'><td _implied_='true'>'a'</td></tr></table></body></html>", "Table with caption");
        this.verify("<TABLE><tr><td>x</td><td>y</td><td>z</td></table>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><table><tr><td>'x'</td><td>'y'</td><td>'z'</td></tr></table></body></html>", "Simple table");
        this.verify("<table><tr><td><table>nested</table>x</td><td>y</td><td>z</td></table>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><table><tr><td><table><tr _implied_='true'><td _implied_='true'>'nested'</td></tr></table>'x'</td><td>'y'</td><td>'z'</td></tr></table></body></html>", "nested table");
        this.verify("<ul><li>a</li><ul><li>na</li><li>nb</li></ul><li>b</li></ul>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><ul><li>'a'</li><ul><li>'na'</li><li>'nb'</li></ul><li>'b'</li></ul></body></html>", "Nested list");
        this.verify("<ul><li>a</li><lI>na</li><li>nb</li><li>b</li></Ul>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><ul><li>'a'</li><li>'na'</li><li>'nb'</li><li>'b'</li></ul></body></html>", "Simple list");
        this.verify("<ul><li>a<li>na<li>nb<li>b</ul>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><ul><li>'a'</li><li>'na'</li><li>'nb'</li><li>'b'</li></ul></body></html>", "List with implied closing tags");
        this.verify("<ul><li>a<ul><li>na<li>nb</ul><li>b</ul>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><ul><li>'a'<ul><li>'na'</li><li>'nb'</li></ul></li><li>'b'</li></ul></body></html>", "List with implied closing tags");
        this.verify("<html>text</html>", "<html><head _implied_='true'></head><body _implied_='true'>'text'</body></html>", "Global document content model 1");
        this.verify("<head></head>text", "<html _implied_='true'><head></head><body _implied_='true'>'text'</body></html>", "Global document content model 2");
        this.verify("<head><title>ti</title></head><body>text", "<html _implied_='true'><head><title>'ti'</title></head><body>'text'</body></html>", "Global document content model 3");
        this.verify("<title>title</title>text", "<html _implied_='true'><head _implied_='true'><title>'title'</title></head><body _implied_='true'>'text'</body></html>", "Global document content model 4");
        this.verify("<html>text</html>", "<html><head _implied_='true'></head><body _implied_='true'>'text'</body></html>", "Global document content model 5");
        this.verify("<body>text</body>", "<html _implied_='true'><head _implied_='true'></head><body>'text'</body></html>", "Global document content model 6");
        this.verify("<dl><dt>ha<dd>a<dt>hb<dd>b", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><dl><dt>'ha'</dt><dd>'a'</dd><dt>'hb'</dt><dd>'b'</dd></dl></body></html>", "Definition list without closing tags");
        this.verify("<html><head></head><body><dl><dt>'ha'</dt><dd>'a'</dd><dt>'hb'</dt><dd>'b'</dd></dl></body></html>", "<html><head></head><body><dl><dt>''ha''</dt><dd>''a''</dd><dt>''hb''</dt><dd>''b''</dd></dl></body></html>", "Definition list");
        this.verify("<p>b<p>c<p>d", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><p>'b'</p><p>'c'</p><p>'d'</p></body></html>", "Paragraphs without closing tags");
        this.verify("<p>'b'</p><p>'c'</p><p>'d'</p>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><p>''b''</p><p>''c''</p><p>''d''</p></body></html>", "Paragraphs");
        this.verify("<form><select><option value='hi'>a<option selected>b<option>normal", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><form><select><option value='hi'>'a'</option><option selected='selected'>'b'</option><option>'normal'</option></select></form></body></html>", "Forms, options without closing tags, bug in 1.3, fixed in 1.4");
        this.verify("<form><select><option>'a'</option><option SeLeCtEd='selected'>'b'</option></select></form>", "<html _implied_='true'><head _implied_='true'></head><body _implied_='true'><form><select><option>''a''</option><option selected='selected'>''b''</option></select></form></body></html>", "Forms, bug in 1.3, fixed in 1.4");
    }

    public String verify(String html, String expected, String about) {
        this.out.setLength(0);
        SimpleParsing callback = this;
        ParserDelegator delegator = new ParserDelegator();
        try {
            delegator.parse(new StringReader(html), callback, true);
        }
        catch (IOException ex) {
            this.harness.fail("Unexpected exception " + ex.getMessage() + " while parsing " + html);
        }
        String result = this.out.toString();
        this.harness.check(result, expected, about);
        return result;
    }

    protected void dumpAttributes(AttributeSet atts) {
        Enumeration<?> enumeration = atts.getAttributeNames();
        TreeSet t = new TreeSet(new Comparator(){

            public int compare(Object a, Object b) {
                return a.toString().compareTo(b.toString());
            }
        });
        while (enumeration.hasMoreElements()) {
            t.add(enumeration.nextElement());
        }
        for (Object a : t) {
            Object av = atts.getAttribute(a);
            if (this.hideImplied && a.toString().equalsIgnoreCase(HTMLEditorKit.ParserCallback.IMPLIED.toString())) continue;
            String v = av != null ? av.toString() : "~null";
            this.out.append(" " + a + "='" + v + "'");
        }
    }
}

