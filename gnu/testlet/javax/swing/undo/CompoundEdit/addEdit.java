/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.CompoundEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Vector;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoableEdit;

public class addEdit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyCompoundEdit edit = new MyCompoundEdit();
        harness.check(edit.addEdit(new E1()) && edit.getEdits().size() == 1);
        harness.check(edit.addEdit(new E2()) && edit.getEdits().size() == 2);
        harness.check(edit.addEdit(new E1()) && edit.getEdits().size() == 2 && edit.getLast() instanceof E2);
        harness.check(edit.addEdit(new E3()) && edit.getEdits().size() == 2 && edit.getLast() instanceof E3);
        harness.check(edit.addEdit(new E1()) && edit.getEdits().size() == 3 && edit.getLast() instanceof E1);
        harness.check(edit.addEdit(new E3()) && edit.getEdits().size() == 4 && edit.getLast() instanceof E3);
        Exception caught = null;
        try {
            edit.addEdit(null);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught != null);
        edit.end();
        harness.check(!edit.addEdit(new E1()) && edit.getEdits().size() == 4);
    }

    private class MyCompoundEdit
    extends CompoundEdit {
        private MyCompoundEdit() {
        }

        public Vector getEdits() {
            return this.edits;
        }

        public UndoableEdit getLast() {
            return this.lastEdit();
        }
    }

    private class E3
    extends AbstractUndoableEdit {
        private E3() {
        }

        @Override
        public boolean replaceEdit(UndoableEdit edit) {
            return edit instanceof E2;
        }
    }

    private class E2
    extends AbstractUndoableEdit {
        private E2() {
        }

        @Override
        public boolean addEdit(UndoableEdit edit) {
            return edit instanceof E1;
        }
    }

    private class E1
    extends AbstractUndoableEdit {
        private E1() {
        }
    }
}

