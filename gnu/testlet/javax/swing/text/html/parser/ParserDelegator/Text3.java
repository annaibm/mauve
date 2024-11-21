/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.ParserDelegator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.html.parser.ParserDelegator.Text;

public class Text3
extends Text
implements Testlet {
    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        this.hideImplied = true;
        this.verify("abc<b>def</b>ghi", "<html><head></head><body>61'a 62'b 63'c <b>64'd 65'e 66'f </b>67'g 68'h 69'i </body></html>", "no ws");
        this.verify("abc <b>def</b>ghi", "<html><head></head><body>61'a 62'b 63'c 20 <b>64'd 65'e 66'f </b>67'g 68'h 69'i </body></html>", "ws before b");
        this.verify("abc  <b>def</b>ghi", "<html><head></head><body>61'a 62'b 63'c 20 <b>64'd 65'e 66'f </b>67'g 68'h 69'i </body></html>", "ws before b 2");
        this.verify("abc<b> def</b>ghi", "<html><head></head><body>61'a 62'b 63'c <b>20 64'd 65'e 66'f </b>67'g 68'h 69'i </body></html>", "ws after b");
        this.verify("abc<b>  def</b>ghi", "<html><head></head><body>61'a 62'b 63'c <b>20 64'd 65'e 66'f </b>67'g 68'h 69'i </body></html>", "ws after b 2");
        this.verify("abc<b>def </b>ghi", "<html><head></head><body>61'a 62'b 63'c <b>64'd 65'e 66'f 20 </b>67'g 68'h 69'i </body></html>", "ws before end of b");
        this.verify("abc<b>def  </b>ghi", "<html><head></head><body>61'a 62'b 63'c <b>64'd 65'e 66'f 20 </b>67'g 68'h 69'i </body></html>", "ws before end of b 2");
        this.verify("abc<b>def</b> ghi", "<html><head></head><body>61'a 62'b 63'c <b>64'd 65'e 66'f </b>20 67'g 68'h 69'i </body></html>", "ws after end of b");
        this.verify("abc<b>def</b> ghi", "<html><head></head><body>61'a 62'b 63'c <b>64'd 65'e 66'f </b>20 67'g 68'h 69'i </body></html>", "ws after end of b 2");
        this.verify("abc<b>def </b> ghi", "<html><head></head><body>61'a 62'b 63'c <b>64'd 65'e 66'f 20 </b>67'g 68'h 69'i </body></html>", "whitespace clash 1");
        this.verify("abc <b> def</b>ghi", "<html><head></head><body>61'a 62'b 63'c 20 <b>64'd 65'e 66'f </b>67'g 68'h 69'i </body></html>", "whitespace clash 1");
    }
}

