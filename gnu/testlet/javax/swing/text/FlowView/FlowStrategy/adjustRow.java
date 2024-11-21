/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.FlowView.FlowStrategy;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.FlowView.TestFlowView;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.View;

public class adjustRow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testUnbreakable(harness);
        this.testGoodBreakable(harness);
        this.testExcellentBreakable(harness);
        this.testForceBreakable(harness);
    }

    private void testUnbreakable(TestHarness h) {
        DefaultStyledDocument doc;
        DefaultStyledDocument defaultStyledDocument = doc = new DefaultStyledDocument();
        defaultStyledDocument.getClass();
        AbstractDocument.BranchElement el = new AbstractDocument.BranchElement(defaultStyledDocument, null, null);
        TestFlowView fv = new TestFlowView(el, 1);
        TestFlowView.TestRow row = (TestFlowView.TestRow)fv.createRow();
        fv.replace(0, 0, new View[]{row});
        row.preferred = 200;
        fv.getFlowStragy().adjustRow(fv, 0, 150, 0);
        h.check(fv.getView(0), row);
    }

    private void testGoodBreakable(TestHarness h) {
        DefaultStyledDocument doc;
        DefaultStyledDocument defaultStyledDocument = doc = new DefaultStyledDocument();
        defaultStyledDocument.getClass();
        AbstractDocument.BranchElement el = new AbstractDocument.BranchElement(defaultStyledDocument, null, null);
        TestFlowView fv = new TestFlowView(el, 1);
        TestFlowView.TestRow row = (TestFlowView.TestRow)fv.createRow();
        fv.replace(0, 0, new View[]{row});
        row.breakWeight = 1000;
        row.preferred = 200;
        fv.getFlowStragy().adjustRow(fv, 0, 150, 0);
        h.check(fv.getView(0), row);
    }

    private void testExcellentBreakable(TestHarness h) {
        DefaultStyledDocument doc;
        DefaultStyledDocument defaultStyledDocument = doc = new DefaultStyledDocument();
        defaultStyledDocument.getClass();
        AbstractDocument.BranchElement el = new AbstractDocument.BranchElement(defaultStyledDocument, null, null);
        TestFlowView fv = new TestFlowView(el, 1);
        TestFlowView.TestRow row = (TestFlowView.TestRow)fv.createRow();
        fv.replace(0, 0, new View[]{row});
        row.breakWeight = 2000;
        row.preferred = 200;
        fv.getFlowStragy().adjustRow(fv, 0, 150, 0);
        h.check(fv.getView(0), row);
    }

    private void testForceBreakable(TestHarness h) {
        DefaultStyledDocument doc;
        DefaultStyledDocument defaultStyledDocument = doc = new DefaultStyledDocument();
        defaultStyledDocument.getClass();
        AbstractDocument.BranchElement el = new AbstractDocument.BranchElement(defaultStyledDocument, null, null);
        TestFlowView fv = new TestFlowView(el, 1);
        TestFlowView.TestRow row = (TestFlowView.TestRow)fv.createRow();
        fv.replace(0, 0, new View[]{row});
        row.breakWeight = 3000;
        row.preferred = 200;
        fv.getFlowStragy().adjustRow(fv, 0, 150, 0);
        h.check(fv.getView(0), row);
    }
}

