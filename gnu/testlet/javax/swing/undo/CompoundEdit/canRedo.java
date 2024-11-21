/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.CompoundEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CompoundEdit;

public class canRedo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CompoundEdit edit = new CompoundEdit();
        edit.addEdit(new AbstractUndoableEdit());
        harness.check(!edit.canRedo());
        edit.end();
        harness.check(!edit.canRedo());
        edit.undo();
        harness.check(edit.canRedo());
        edit.redo();
        harness.check(!edit.canRedo());
        edit.die();
        harness.check(!edit.canRedo());
    }
}

