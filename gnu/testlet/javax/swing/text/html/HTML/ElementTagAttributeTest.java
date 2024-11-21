/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.HTML;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.ElementIterator;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class ElementTagAttributeTest
implements Testlet {
    TestHarness h;

    @Override
    public void test(TestHarness harness) {
        this.h = harness;
        try {
            this.testAttrs();
        }
        catch (Exception e) {
            this.h.fail("Exception caught");
        }
    }

    public void testAttrs() throws Exception {
        Element element;
        URL url = new URL("http://www.redhat.com");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        HTMLDocument htmlDoc = (HTMLDocument)htmlKit.createDefaultDocument();
        ParserDelegator parser = new ParserDelegator();
        HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
        ((HTMLEditorKit.Parser)parser).parse(br, callback, true);
        ElementIterator iterator = new ElementIterator(htmlDoc);
        while ((element = iterator.next()) != null) {
            AttributeSet attributes = element.getAttributes();
            Object name2 = attributes.getAttribute(StyleConstants.NameAttribute);
            this.h.check(name2 instanceof HTML.Tag, true, "HTML.Tag is not stored as StyleConstants.NameAttribute in the elements attributes");
        }
    }
}

