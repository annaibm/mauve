/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.HTML;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTML;

public class HTML_Test
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        this.testConstructor();
        this.testGetAttributeKey();
        this.testGetTag();
        this.testGetIntegerAttributeValue();
    }

    void assertNotNull(String about, Object notNull) {
        if (notNull == null) {
            this.harness.fail(about);
        }
    }

    void testConstructor() {
        this.harness.checkPoint("constructor");
        new HTML();
    }

    void testGetAttributeKey() {
        this.harness.checkPoint("getAttributeKey");
        String[] mine = this.toStrings(HTML.getAllAttributeKeys());
        for (int i = 0; i < mine.length; ++i) {
            this.assertNotNull(HTML.getAttributeKey(mine[i]) + " must be found", mine[i]);
        }
        this.harness.check(HTML.getTag("audrius"), null, "surely unknown HTML attribute");
    }

    void testGetIntegerAttributeValue() {
        this.harness.checkPoint("getIntegerAttributeValue");
        SimpleAttributeSet ase = new SimpleAttributeSet();
        ase.addAttribute(HTML.getAttributeKey("size"), "222");
        this.harness.check(222, HTML.getIntegerAttributeValue(ase, HTML.getAttributeKey("size"), 333), "attribute must be found");
        this.harness.check(333, HTML.getIntegerAttributeValue(ase, HTML.getAttributeKey("href"), 333), "the default value must be returned");
    }

    void testGetTag() {
        this.harness.checkPoint("getTag");
        String[] mine = this.toStrings(HTML.getAllTags());
        for (int i = 0; i < mine.length; ++i) {
            this.assertNotNull(mine[i] + " tag must be found", HTML.getTag(mine[i]));
        }
        this.harness.check(HTML.getTag("audrius"), null, "surely unknown  HTML tag");
    }

    private String[] toStrings(Object[] objs) {
        String[] a = new String[objs.length];
        for (int i = 0; i < a.length; ++i) {
            a[i] = objs[i].toString();
        }
        return a;
    }
}

