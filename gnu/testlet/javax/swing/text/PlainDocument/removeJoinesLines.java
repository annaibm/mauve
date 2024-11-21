/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

public class removeJoinesLines
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        PlainDocument doc = new PlainDocument();
        Element root = doc.getDefaultRootElement();
        try {
            doc.insertString(0, "Line One\n", null);
            doc.insertString(doc.getLength(), "Line Two\n", null);
            doc.insertString(doc.getLength(), "Line Three", null);
            doc.remove(5, 18);
            harness.check(root.getElementCount() == 1);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

