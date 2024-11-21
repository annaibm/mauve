/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;
import javax.swing.undo.AbstractUndoableEdit;

public class trimEdits
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        TestEdit[] e = new TestEdit[6];
        for (int i = 0; i < e.length; ++i) {
            e[i] = new TestEdit();
            mgr.addEdit(e[i]);
        }
        harness.check(mgr.getEdits().size(), 6);
        mgr.invokeTrimEdits(2, 3);
        harness.check(mgr.getEdits().size(), 4);
        harness.check(mgr.getEdits().get(0) == e[0]);
        harness.check(mgr.getEdits().get(1) == e[1]);
        harness.check(mgr.getEdits().get(2) == e[4]);
        harness.check(mgr.getEdits().get(3) == e[5]);
        harness.check(e[0].isAlive());
        harness.check(e[1].isAlive());
        harness.check(!e[2].isAlive());
        harness.check(!e[3].isAlive());
        harness.check(e[4].isAlive());
        harness.check(e[5].isAlive());
        harness.check(mgr.getEditToBeUndone() == e[5]);
        mgr.invokeTrimEdits(0, 0);
        harness.check(mgr.getEdits().size(), 3);
        harness.check(mgr.getEdits().get(0) == e[1]);
        harness.check(mgr.getEdits().get(1) == e[4]);
        harness.check(mgr.getEdits().get(2) == e[5]);
        harness.check(!e[0].isAlive());
        harness.check(e[1].isAlive());
        harness.check(!e[2].isAlive());
        harness.check(!e[3].isAlive());
        harness.check(e[4].isAlive());
        harness.check(e[5].isAlive());
        harness.check(mgr.getEditToBeUndone() == e[5]);
        mgr.invokeTrimEdits(1, 0);
        mgr.invokeTrimEdits(2222, -100);
        harness.check(mgr.getEdits().size(), 3);
        harness.check(mgr.getEdits().get(0) == e[1]);
        harness.check(mgr.getEdits().get(1) == e[4]);
        harness.check(mgr.getEdits().get(2) == e[5]);
        harness.check(mgr.getEditToBeUndone() == e[5]);
        mgr.undo();
        mgr.invokeTrimEdits(0, 1);
        harness.check(mgr.getEdits().size(), 1);
        harness.check(mgr.getEdits().get(0) == e[5]);
        harness.check(mgr.getEditToBeUndone() == null);
    }

    private static class TestEdit
    extends AbstractUndoableEdit {
        private TestEdit() {
        }

        public boolean isAlive() {
            return this.canUndo() || this.canRedo();
        }
    }
}

