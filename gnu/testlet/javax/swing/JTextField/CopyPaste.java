/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTextField;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextField;

public class CopyPaste
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String pasteIt = "the string to paste";
        JTextField field = new JTextField();
        field.setText(pasteIt);
        harness.check(field.getText(), pasteIt, "get/setText");
        field.selectAll();
        field.copy();
        JTextField field2 = new JTextField();
        field2.paste();
        harness.check(field2.getText(), pasteIt, "paste");
        field2.paste();
        harness.check(field2.getText(), pasteIt + pasteIt, "subsequent paste");
    }
}

