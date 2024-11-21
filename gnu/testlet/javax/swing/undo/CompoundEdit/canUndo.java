/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.CompoundEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CompoundEdit;

public class canUndo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CompoundEdit edit = new CompoundEdit();
        edit.addEdit(new AbstractUndoableEdit());
        harness.check(!edit.canUndo());
        edit.end();
        harness.check(edit.canUndo());
        edit.undo();
        harness.check(!edit.canUndo());
        edit.redo();
        harness.check(edit.canUndo());
        edit.die();
        harness.check(!edit.canUndo());
    }
}

