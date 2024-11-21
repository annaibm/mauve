/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class canUndo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        harness.check(!mgr.canUndo());
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(3, 3);
        harness.check(mgr.canUndo());
        mgr.undo();
        harness.check(mgr.canUndo());
        edits[2].inhibitCanUndo();
        harness.check(mgr.canUndo());
        mgr.end();
        harness.check(mgr.canUndo());
    }
}

