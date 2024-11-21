/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Dictionary;
import javax.swing.text.PlainDocument;

public class getDocumentProperties
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testDefault(harness);
    }

    private void testDefault(TestHarness h) {
        PlainDocument doc = new PlainDocument();
        Dictionary<Object, Object> props = doc.getDocumentProperties();
        h.check(props.size(), 2);
        h.check(props.get("i18n"), Boolean.FALSE);
        h.check(props.get("tabSize"), new Integer(8));
    }
}

