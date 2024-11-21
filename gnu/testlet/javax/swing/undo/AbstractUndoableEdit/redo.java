/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.AbstractUndoableEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;

public class redo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Exception caught;
        MyEdit edit = new MyEdit();
        edit.redoable = true;
        edit.undo();
        edit.redo();
        harness.check(true);
        edit.redoable = false;
        try {
            edit.undo();
            edit.redo();
            caught = null;
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof CannotRedoException);
        AbstractUndoableEdit aue = new AbstractUndoableEdit();
        aue.undo();
        aue.die();
        try {
            aue.redo();
            caught = null;
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof CannotRedoException);
    }

    private class MyEdit
    extends AbstractUndoableEdit {
        public boolean redoable;

        private MyEdit() {
        }

        @Override
        public boolean canRedo() {
            return this.redoable;
        }
    }
}

