/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class undoTo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        harness.check(mgr.getEditToBeUndone(), null);
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(943, 4);
        harness.check(mgr.checkIDs(new int[]{943, 944, 945, 946}));
        harness.check(mgr.getEditToBeUndone() == edits[3]);
        mgr.invokeUndoTo(edits[1]);
        harness.check(mgr.checkIDs(new int[]{943, 944, 945, 946}));
        harness.check(mgr.getEditToBeUndone(), edits[0]);
    }
}

