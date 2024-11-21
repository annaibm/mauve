/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.AbstractUndoableEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;
import javax.swing.undo.AbstractUndoableEdit;

public class getRedoPresentationName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AbstractUndoableEdit edit = new AbstractUndoableEdit(){

            @Override
            public String getPresentationName() {
                return "Action";
            }
        };
        String oldValue = UIManager.getString("AbstractUndoableEdit.undoText");
        UIManager.put("AbstractUndoableEdit.redoText", "RedoBar");
        harness.check(edit.getRedoPresentationName(), (Object)"RedoBar Action");
        edit = new AbstractUndoableEdit();
        harness.check(edit.getRedoPresentationName(), (Object)"RedoBar");
        UIManager.put("AbstractUndoableEdit.redoText", oldValue);
    }
}

