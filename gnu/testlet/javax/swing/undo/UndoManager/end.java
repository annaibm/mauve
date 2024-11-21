/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class end
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(0, 4);
        mgr.undo();
        mgr.undo();
        harness.check(edits[0].isAlive());
        harness.check(edits[1].isAlive());
        harness.check(edits[2].isAlive());
        harness.check(edits[3].isAlive());
        mgr.end();
        harness.check(edits[0].isAlive());
        harness.check(edits[1].isAlive());
        harness.check(!edits[2].isAlive());
        harness.check(!edits[3].isAlive());
    }
}

