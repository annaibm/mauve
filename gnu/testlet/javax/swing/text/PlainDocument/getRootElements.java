/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

public class getRootElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        PlainDocument d = new PlainDocument();
        Element[] e = d.getRootElements();
        harness.check(e.length, 2);
        harness.check(e[0], d.getDefaultRootElement());
    }
}

