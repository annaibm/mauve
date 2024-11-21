/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.CompoundEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoableEdit;

public class lastEdit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyCompoundEdit edit = new MyCompoundEdit();
        harness.check(edit.getLast() == null);
        AbstractUndoableEdit e1 = new AbstractUndoableEdit();
        edit.addEdit(e1);
        harness.check(edit.getLast() == e1);
        AbstractUndoableEdit e2 = new AbstractUndoableEdit();
        edit.addEdit(e2);
        harness.check(edit.getLast() == e2);
    }

    private static class MyCompoundEdit
    extends CompoundEdit {
        private MyCompoundEdit() {
        }

        public UndoableEdit getLast() {
            return this.lastEdit();
        }
    }
}

