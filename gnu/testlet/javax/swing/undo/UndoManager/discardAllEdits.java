/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class discardAllEdits
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(10, 3);
        mgr.discardAllEdits();
        harness.check(mgr.getEdits().size(), 0);
        harness.check(mgr.getEditToBeUndone(), null);
        harness.check(mgr.getEditToBeRedone(), null);
        boolean foundLive = false;
        for (int i = 0; i < edits.length; ++i) {
            foundLive |= edits[i].isAlive();
        }
        harness.check(!foundLive);
    }
}

