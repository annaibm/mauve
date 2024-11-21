/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class canRedo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        harness.check(!mgr.canRedo());
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(3, 3);
        harness.check(!mgr.canRedo());
        mgr.undo();
        harness.check(mgr.canRedo());
        edits[2].inhibitCanRedo();
        harness.check(!mgr.canRedo());
        mgr.end();
        harness.check(!mgr.canRedo());
    }
}

