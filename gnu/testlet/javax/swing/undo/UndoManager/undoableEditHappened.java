/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.AbstractUndoableEdit;

public class undoableEditHappened
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        AbstractUndoableEdit edit = new AbstractUndoableEdit();
        mgr.undoableEditHappened(new UndoableEditEvent(this, edit));
        harness.check(mgr.getEditToBeUndone() == edit);
    }
}

