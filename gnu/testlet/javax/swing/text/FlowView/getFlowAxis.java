/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.FlowView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.FlowView.TestFlowView;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DefaultStyledDocument;

public class getFlowAxis
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultStyledDocument doc;
        DefaultStyledDocument defaultStyledDocument = doc = new DefaultStyledDocument();
        defaultStyledDocument.getClass();
        AbstractDocument.BranchElement el = new AbstractDocument.BranchElement(defaultStyledDocument, null, null);
        TestFlowView v = new TestFlowView(el, 0);
        harness.check(v.getFlowAxis(), 1);
        v = new TestFlowView(el, 1);
        harness.check(v.getFlowAxis(), 0);
    }
}

