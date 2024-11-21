/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class editToBeRedone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        harness.check(mgr.getEditToBeRedone(), null);
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(47, 4);
        edits[2].setSignificant(false);
        edits[1].setSignificant(false);
        harness.check(mgr.getEditToBeRedone(), null);
        mgr.undo();
        harness.check(mgr.getEditToBeRedone(), edits[3]);
        mgr.undo();
        harness.check(mgr.getEditToBeRedone(), edits[0]);
        mgr.redo();
        harness.check(mgr.getEditToBeRedone(), edits[3]);
        mgr.redo();
        harness.check(mgr.getEditToBeRedone(), null);
    }
}

