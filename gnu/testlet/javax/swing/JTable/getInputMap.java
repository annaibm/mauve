/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;
import javax.swing.JTable;
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
        JTable t = new JTable();
        InputMap m1 = t.getInputMap();
        InputMap m2 = t.getInputMap(0);
        harness.check(m1 == m2);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        JTable t = new JTable();
        InputMap m1 = t.getInputMap(0);
        harness.check(m1.keys(), null);
        harness.check(m1.getParent(), null);
        InputMap m2 = t.getInputMap(1);
        harness.check(m2.keys(), null);
        InputMap m2p = m2.getParent();
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed DOWN")), (Object)"selectNextRowChangeLead");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed UP")), (Object)"selectPreviousRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed RIGHT")), (Object)"selectNextColumnChangeLead");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed LEFT")), (Object)"selectPreviousColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed KP_UP")), (Object)"selectPreviousRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed DOWN")), (Object)"selectNextRow");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed UP")), (Object)"selectPreviousRowChangeLead");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed LEFT")), (Object)"selectPreviousColumnChangeLead");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed CUT")), (Object)"cut");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed END")), (Object)"selectLastColumn");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed PAGE_UP")), (Object)"scrollUpExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_UP")), (Object)"selectPreviousRow");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed UP")), (Object)"selectPreviousRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed HOME")), (Object)"selectFirstRow");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed LEFT")), (Object)"selectPreviousColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed END")), (Object)"selectLastRow");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed PAGE_DOWN")), (Object)"scrollRightChangeSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed RIGHT")), (Object)"selectNextColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed LEFT")), (Object)"selectPreviousColumn");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed PAGE_UP")), (Object)"scrollLeftChangeSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_LEFT")), (Object)"selectPreviousColumn");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed KP_RIGHT")), (Object)"selectNextColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed SPACE")), (Object)"addToSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed SPACE")), (Object)"toggleAndAnchor");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed SPACE")), (Object)"extendTo");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed SPACE")), (Object)"moveSelectionTo");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed DOWN")), (Object)"selectNextRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed BACK_SLASH")), (Object)"clearSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed ESCAPE")), (Object)"cancel");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed HOME")), (Object)"selectFirstColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed ENTER")), (Object)"selectNextRowCell");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed ENTER")), (Object)"selectPreviousRowCell");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed RIGHT")), (Object)"selectNextColumn");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed PAGE_UP")), (Object)"scrollLeftExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed DOWN")), (Object)"selectNextRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed PAGE_DOWN")), (Object)"scrollDownChangeSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed KP_UP")), (Object)"selectPreviousRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed KP_LEFT")), (Object)"selectPreviousColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed X")), (Object)"cut");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed PAGE_DOWN")), (Object)"scrollRightExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed SLASH")), (Object)"selectAll");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed C")), (Object)"copy");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed KP_RIGHT")), (Object)"selectNextColumnChangeLead");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed END")), (Object)"selectLastColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed KP_DOWN")), (Object)"selectNextRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed TAB")), (Object)"selectPreviousColumnCell");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed KP_LEFT")), (Object)"selectPreviousColumnChangeLead");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed HOME")), (Object)"selectFirstColumn");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed V")), (Object)"paste");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_DOWN")), (Object)"selectNextRow");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed KP_DOWN")), (Object)"selectNextRowChangeLead");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed RIGHT")), (Object)"selectNextColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed A")), (Object)"selectAll");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed END")), (Object)"selectLastRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed COPY")), (Object)"copy");
        harness.check(m2p.get(KeyStroke.getKeyStroke("ctrl pressed KP_UP")), (Object)"selectPreviousRowChangeLead");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed KP_LEFT")), (Object)"selectPreviousColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed KP_DOWN")), (Object)"selectNextRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed TAB")), (Object)"selectNextColumnCell");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed UP")), (Object)"selectPreviousRow");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed HOME")), (Object)"selectFirstRowExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift pressed PAGE_DOWN")), (Object)"scrollDownExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed KP_RIGHT")), (Object)"selectNextColumn");
        harness.check(m2p.get(KeyStroke.getKeyStroke("shift ctrl pressed KP_RIGHT")), (Object)"selectNextColumnExtendSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed F2")), (Object)"startEditing");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed PAGE_UP")), (Object)"scrollUpChangeSelection");
        harness.check(m2p.get(KeyStroke.getKeyStroke("pressed PASTE")), (Object)"paste");
        InputMap m3 = t.getInputMap(2);
        harness.check(m3.keys(), null);
        harness.check(m3.getParent(), null);
    }
}

