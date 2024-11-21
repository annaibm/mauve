/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(10, 1);
        harness.check(mgr.toString(), (Object)("gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager@" + Integer.toHexString(mgr.hashCode()) + " hasBeenDone: true alive: true inProgress: true edits: [" + edits[0] + "] limit: 100 indexOfNextAdd: 1"));
    }
}

