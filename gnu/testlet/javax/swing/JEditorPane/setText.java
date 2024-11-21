/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JEditorPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JEditorPane;

public class setText
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JEditorPane pane = new JEditorPane();
        harness.check(pane.getText(), (Object)"");
        pane.setText(pane.getText());
        harness.check(pane.getText(), (Object)"");
        pane.setText("");
        harness.check(pane.getText(), (Object)"");
        pane.setText(null);
        harness.check(pane.getText(), (Object)"");
        pane.setText("GNU");
        harness.check(pane.getText(), (Object)"GNU");
        pane.setText(pane.getText());
        harness.check(pane.getText(), (Object)"GNU");
        pane.setText("");
        harness.check(pane.getText(), (Object)"");
        pane.setText(null);
        harness.check(pane.getText(), (Object)"");
    }
}

