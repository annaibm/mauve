/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class addEdit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        mgr.setLimit(3);
        mgr.addTestEdits(10, 3);
        harness.check(mgr.checkIDs(new int[]{10, 11, 12}));
        mgr = new TestUndoManager();
        mgr.setLimit(2);
        mgr.addTestEdits(10, 3);
        harness.check(mgr.checkIDs(new int[]{11, 12}));
        mgr = new TestUndoManager();
        mgr.setLimit(3);
        mgr.addTestEdits(10, 4);
        mgr.undo();
        mgr.addTestEdits(100, 1);
        harness.check(mgr.checkIDs(new int[]{11, 12, 100}));
        mgr.undo();
        mgr.redo();
        mgr.undo();
        mgr.undo();
        mgr.addTestEdits(200, 1);
        harness.check(mgr.checkIDs(new int[]{11, 200}));
        mgr.undo();
        mgr.undo();
        mgr.addTestEdits(300, 1);
        harness.check(mgr.checkIDs(new int[]{300}));
    }
}

