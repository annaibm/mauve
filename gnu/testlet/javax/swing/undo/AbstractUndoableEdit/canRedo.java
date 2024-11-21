/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.AbstractUndoableEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.AbstractUndoableEdit;

public class canRedo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AbstractUndoableEdit edit = new AbstractUndoableEdit();
        harness.check(!edit.canRedo());
        edit.undo();
        harness.check(edit.canRedo());
        edit.redo();
        harness.check(!edit.canRedo());
        edit.undo();
        harness.check(edit.canRedo());
        edit.die();
        harness.check(!edit.canRedo());
    }
}

