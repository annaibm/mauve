/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicEditorPaneUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicEditorPaneUI.MyBasicEditorPaneUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicEditorPaneUI ui = new MyBasicEditorPaneUI();
        harness.check(ui.getPropertyPrefix(), (Object)"EditorPane");
    }
}

