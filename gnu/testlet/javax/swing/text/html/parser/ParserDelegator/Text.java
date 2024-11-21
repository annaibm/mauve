/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.ParserDelegator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.html.parser.ParserDelegator.parsingTester;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;

public class Text
extends parsingTester
implements Testlet {
    @Override
    public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int position2) {
        this.out.append("<" + tag + ">");
    }

    @Override
    public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int position2) {
        this.out.append("<" + tag + ">");
    }

    @Override
    public void handleText(char[] chars, int position2) {
        for (int i = 0; i < chars.length; ++i) {
            this.out.append(Integer.toHexString(chars[i]));
            if (chars[i] > ' ') {
                this.out.append("'" + chars[i]);
            }
            this.out.append(" ");
        }
    }

    @Override
    public void handleEndTag(HTML.Tag tag, int position2) {
        this.out.append("</" + tag + ">");
    }

    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        this.hideImplied = true;
        this.verify("\r \n \t {abc      r\rn\nt}\t \r\n \r \t", "<html><head></head><body>7b'{ 61'a 62'b 63'c 20 72'r 20 6e'n 20 74't 7d'} </body></html>", "normal");
        this.verify("   abba   ", "<html><head></head><body>61'a 62'b 62'b 61'a </body></html>", "single word");
        this.verify("  \r ab  \t \r \n  ba   ", "<html><head></head><body>61'a 62'b 20 62'b 61'a </body></html>", "line breaks");
        this.verify("<pre>\n\n\n\n   abba   \r\t \r\n</pre>", "<html><head></head><body><pre>a a a 20 20 20 61'a 62'b 62'b 61'a 20 20 20 a 9 20 </pre></body></html>", "pre");
        this.verify("<pre>   abba   </pre>", "<html><head></head><body><pre>20 20 20 61'a 62'b 62'b 61'a 20 20 20 </pre></body></html>", "pre");
        this.verify("<pre>\r\n   abba   </pre>", "<html><head></head><body><pre>20 20 20 61'a 62'b 62'b 61'a 20 20 20 </pre></body></html>", "pre, single word");
        this.verify("<pre>\r\n\r\n   abba   \r\n</pre>", "<html><head></head><body><pre>a 20 20 20 61'a 62'b 62'b 61'a 20 20 20 </pre></body></html>", "pre, single word with line breaks around");
        this.verify("<pre> \r ab  \t \r \n  ba   </pre>", "<html><head></head><body><pre>20 a 20 61'a 62'b 20 20 9 20 a 20 a 20 20 62'b 61'a 20 20 20 </pre></body></html>", "pre, line breaks");
        this.verify("<pre> \r\n ab  \t \r\n \n  ba   </pre>", "<html><head></head><body><pre>20 a 20 61'a 62'b 20 20 9 20 a 20 a 20 20 62'b 61'a 20 20 20 </pre></body></html>", "pre");
        this.verify("<textarea>\n\n\n\n   abba \r\n</textarea>", "<html><head></head><body><textarea>a a a 20 20 20 61'a 62'b 62'b 61'a 20 </textarea></body></html>", "textarea, single word with line breaks around");
        this.verify("<textarea>   abba   </textarea>", "<html><head></head><body><textarea>20 20 20 61'a 62'b 62'b 61'a 20 20 20 </textarea></body></html>", "textarea, singe word");
        this.verify("<textarea> \r ab  \t \r \n  ba   </textarea>", "<html><head></head><body><textarea>20 a 20 61'a 62'b 20 20 9 20 a 20 a 20 20 62'b 61'a 20 20 20 </textarea></body></html>", " textarea");
    }
}

