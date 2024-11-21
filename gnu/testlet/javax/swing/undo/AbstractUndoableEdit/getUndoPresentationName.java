/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.AbstractUndoableEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIManager;
import javax.swing.undo.AbstractUndoableEdit;

public class getUndoPresentationName
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
        UIManager.put("AbstractUndoableEdit.undoText", "UndoFoo");
        harness.check(edit.getUndoPresentationName(), (Object)"UndoFoo Action");
        edit = new AbstractUndoableEdit();
        harness.check(edit.getUndoPresentationName(), (Object)"UndoFoo");
        UIManager.put("AbstractUndoableEdit.undoText", oldValue);
    }
}

