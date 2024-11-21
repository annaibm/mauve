/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTextArea;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextArea;

public class text
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTextArea t1 = new JTextArea();
        t1.append("{a\nb\nc}");
        harness.check(t1.getLineCount(), 3, "getLineCount");
        harness.check(t1.getText(), "{a\nb\nc}", "simple getText");
        t1.setText("0123456789");
        t1.setSelectionStart(2);
        t1.setSelectionEnd(5);
        harness.check(t1.getSelectedText(), "234", "getSelectedText");
        t1.replaceRange("replacement", 3, 5);
        harness.check(t1.getText(), "012replacement56789", "replacement");
        t1.insert("insertion", 1);
        harness.check(t1.getText(), "0insertion12replacement56789", "insertion");
        t1.setSelectionStart(0);
        t1.setSelectionEnd(1);
        t1.replaceSelection("selection");
        harness.check(t1.getText(), "selectioninsertion12replacement56789", "insertion");
    }
}

