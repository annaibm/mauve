/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.DocFlavor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.charset.Charset;
import javax.print.DocFlavor;

public class hostEncoding
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.check(DocFlavor.hostEncoding.equals(Charset.defaultCharset().name()));
        String value2 = null;
        value2 = DocFlavor.URL.TEXT_HTML_HOST.getParameter("charset");
        h.check(value2.equals(DocFlavor.hostEncoding.toLowerCase()));
        value2 = DocFlavor.URL.TEXT_PLAIN_HOST.getParameter("charset");
        h.check(value2.equals(DocFlavor.hostEncoding.toLowerCase()));
    }
}

