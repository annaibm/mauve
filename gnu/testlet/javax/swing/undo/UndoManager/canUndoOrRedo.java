/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class canUndoOrRedo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        mgr.setLimit(1);
        harness.check(!mgr.canUndoOrRedo());
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(1, 1);
        harness.check(mgr.canUndoOrRedo());
        mgr.undo();
        harness.check(mgr.canUndoOrRedo());
        edits[0].inhibitCanRedo();
        harness.check(!mgr.canUndoOrRedo());
        mgr.end();
        harness.check(mgr.canUndoOrRedo());
    }
}

