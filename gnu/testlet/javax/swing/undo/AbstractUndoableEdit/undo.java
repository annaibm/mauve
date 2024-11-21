/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.AbstractUndoableEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotUndoException;

public class undo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Exception caught;
        MyEdit edit = new MyEdit();
        edit.undoable = true;
        edit.undo();
        edit.redo();
        harness.check(true);
        edit.undoable = false;
        try {
            edit.undo();
            caught = null;
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof CannotUndoException);
        AbstractUndoableEdit aue = new AbstractUndoableEdit();
        aue.die();
        try {
            aue.undo();
            caught = null;
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof CannotUndoException);
    }

    private class MyEdit
    extends AbstractUndoableEdit {
        public boolean undoable;

        private MyEdit() {
        }

        @Override
        public boolean canUndo() {
            return this.undoable;
        }
    }
}

