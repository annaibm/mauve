/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.AbstractDocument.TestAbstractDocument;
import java.util.Dictionary;
import java.util.Enumeration;

public class getDocumentProperties
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testDefault(harness);
    }

    private void testDefault(TestHarness h) {
        TestAbstractDocument doc = new TestAbstractDocument();
        Dictionary<Object, Object> props = doc.getDocumentProperties();
        Enumeration<Object> keys2 = props.keys();
        while (keys2.hasMoreElements()) {
            Object object = keys2.nextElement();
        }
        h.check(props.size(), 1);
        h.check(props.get("i18n"), Boolean.FALSE);
    }
}

