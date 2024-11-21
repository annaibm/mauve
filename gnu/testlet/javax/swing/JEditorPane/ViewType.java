/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JEditorPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JEditorPane;
import javax.swing.text.WrappedPlainView;

public class ViewType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JEditorPane pane = new JEditorPane();
        harness.check(pane.getUI().getRootView(pane).getView(0).getClass() == WrappedPlainView.class);
    }
}

