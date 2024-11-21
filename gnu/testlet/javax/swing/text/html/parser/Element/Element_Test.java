/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.Element;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.html.parser.AttributeList;
import javax.swing.text.html.parser.DTD;
import javax.swing.text.html.parser.Element;

public class Element_Test
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        try {
            this.testName2type();
            this.testAttributeGetter();
        }
        catch (Throwable exc) {
            exc.printStackTrace();
            if (exc != null) {
                this.harness.fail(exc.getClass().getName() + ":" + exc.getMessage());
            }
            this.harness.fail("exception");
        }
    }

    public void testAttributeGetter() throws Exception {
        AttributeList list2;
        AttributeList head = list2 = new AttributeList("heading");
        list2.value = null;
        for (int i = 0; i < 24; ++i) {
            AttributeList a = new AttributeList("a" + i);
            a.value = "v" + i;
            list2.next = a;
            list2 = a;
        }
        Element e = DTD.getDTD("test").defineElement("e", 0, false, false, null, null, null, null);
        e.atts = head;
        for (int i = 0; i < 24; ++i) {
            this.harness.check(e.getAttribute("a" + i).toString(), (Object)("a" + i));
            this.harness.check(e.getAttribute((String)new StringBuilder().append((String)"a").append((int)i).toString()).value, (Object)("v" + i));
        }
        this.harness.check(e.getAttribute("audrius"), null);
        this.harness.check(e.getAttributeByValue("audrius"), null);
    }

    public void testName2type() {
        this.harness.check(Element.name2type("CDATA"), 1);
        this.harness.check(Element.name2type("RCDATA"), 16);
        this.harness.check(Element.name2type("EMPTY"), 17);
        this.harness.check(Element.name2type("ANY"), 19);
        this.harness.check(Element.name2type("audrius"), 0);
        this.harness.check(Element.name2type("rcdata"), 0);
    }
}

