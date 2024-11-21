/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTextField;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.Document;

public class setDocument
implements Testlet {
    static TestHarness h2;

    @Override
    public void test(TestHarness harness) {
        h2 = harness;
        TestTextField tf = new TestTextField();
        tf.setUI(new TestUI());
        Document doc = tf.createDefaultModel();
        tf.setDocument(doc);
    }

    static class TestTextField
    extends JTextField {
        TestTextField() {
        }

        @Override
        public void setDocument(Document doc) {
            h2.check(doc.getProperty("filterNewlines") == null);
            super.setDocument(doc);
            h2.check(doc.getProperty("filterNewlines") != null);
        }

        @Override
        public Document createDefaultModel() {
            return super.createDefaultModel();
        }
    }

    class TestUI
    extends BasicTextFieldUI {
        TestUI() {
        }

        @Override
        protected void propertyChange(PropertyChangeEvent evt) {
            Document doc = ((JTextField)this.getComponent()).getDocument();
            h2.check(doc.getProperty("filterNewlines"), Boolean.TRUE);
            super.propertyChange(evt);
            h2.check(doc.getProperty("filterNewlines"), Boolean.TRUE);
        }
    }
}

