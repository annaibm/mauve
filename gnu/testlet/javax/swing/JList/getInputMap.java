/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JList;
import javax.swing.KeyStroke;

public class getInputMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("()");
        JList list2 = new JList();
        InputMap m1 = list2.getInputMap();
        InputMap m2 = list2.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JList list2 = new JList();
        InputMap m1 = list2.getInputMap(0);
        harness.check(m1.keys(), null);
        InputMap m1p = m1.getParent();
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed DOWN")), (Object)"selectNextRowChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed UP")), (Object)"selectPreviousRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed RIGHT")), (Object)"selectNextColumnChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed LEFT")), (Object)"selectPreviousColumnExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed KP_UP")), (Object)"selectPreviousRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed DOWN")), (Object)"selectNextRow");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed UP")), (Object)"selectPreviousRowChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed LEFT")), (Object)"selectPreviousColumnChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed CUT")), (Object)"cut");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed END")), (Object)"selectLastRow");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed PAGE_UP")), (Object)"scrollUpExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed KP_UP")), (Object)"selectPreviousRow");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed UP")), (Object)"selectPreviousRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed HOME")), (Object)"selectFirstRowChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed LEFT")), (Object)"selectPreviousColumnExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed END")), (Object)"selectLastRowChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed PAGE_DOWN")), (Object)"scrollDownChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed RIGHT")), (Object)"selectNextColumnExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed LEFT")), (Object)"selectPreviousColumn");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed PAGE_UP")), (Object)"scrollUpChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed KP_LEFT")), (Object)"selectPreviousColumn");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed KP_RIGHT")), (Object)"selectNextColumnExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed SPACE")), (Object)"addToSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed SPACE")), (Object)"toggleAndAnchor");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed SPACE")), (Object)"extendTo");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed SPACE")), (Object)"moveSelectionTo");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed DOWN")), (Object)"selectNextRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed BACK_SLASH")), (Object)"clearSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed HOME")), (Object)"selectFirstRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed RIGHT")), (Object)"selectNextColumn");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed PAGE_UP")), (Object)"scrollUpExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed DOWN")), (Object)"selectNextRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed PAGE_DOWN")), (Object)"scrollDown");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed KP_UP")), (Object)"selectPreviousRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed KP_LEFT")), (Object)"selectPreviousColumnExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed X")), (Object)"cut");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed PAGE_DOWN")), (Object)"scrollDownExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed SLASH")), (Object)"selectAll");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed C")), (Object)"copy");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed KP_RIGHT")), (Object)"selectNextColumnChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed END")), (Object)"selectLastRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed KP_DOWN")), (Object)"selectNextRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed KP_LEFT")), (Object)"selectPreviousColumnChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed HOME")), (Object)"selectFirstRow");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed V")), (Object)"paste");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed KP_DOWN")), (Object)"selectNextRow");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed KP_DOWN")), (Object)"selectNextRowChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed RIGHT")), (Object)"selectNextColumnExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed A")), (Object)"selectAll");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed END")), (Object)"selectLastRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed COPY")), (Object)"copy");
        harness.check(m1p.get(KeyStroke.getKeyStroke("ctrl pressed KP_UP")), (Object)"selectPreviousRowChangeLead");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed KP_LEFT")), (Object)"selectPreviousColumnExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed KP_DOWN")), (Object)"selectNextRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed UP")), (Object)"selectPreviousRow");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed HOME")), (Object)"selectFirstRowExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift pressed PAGE_DOWN")), (Object)"scrollDownExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed KP_RIGHT")), (Object)"selectNextColumn");
        harness.check(m1p.get(KeyStroke.getKeyStroke("shift ctrl pressed KP_RIGHT")), (Object)"selectNextColumnExtendSelection");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed PAGE_UP")), (Object)"scrollUp");
        harness.check(m1p.get(KeyStroke.getKeyStroke("pressed PASTE")), (Object)"paste");
        InputMap m2 = list2.getInputMap(1);
        harness.check(m2.keys(), null);
        harness.check(m2.getParent(), null);
        InputMap m3 = list2.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
    }
}

