/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTextField;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextField;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class createDefaultModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestTextField tf = new TestTextField();
        Document doc = tf.createDefaultModel();
        harness.check(doc.getClass(), PlainDocument.class);
        harness.check(doc.getProperty("filterNewlines"), null);
    }

    static class TestTextField
    extends JTextField {
        TestTextField() {
        }

        @Override
        public Document createDefaultModel() {
            return super.createDefaultModel();
        }
    }
}

