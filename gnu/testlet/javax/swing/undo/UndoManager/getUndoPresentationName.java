/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;
import javax.swing.UIManager;

public class getUndoPresentationName
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(1, 2);
        harness.check(mgr.getUndoPresentationName(), (Object)"UndoPres2");
        mgr.undo();
        harness.check(mgr.getUndoPresentationName(), (Object)"UndoPres1");
        mgr.undo();
        Object oldText = UIManager.get("AbstractUndoableEdit.undoText");
        try {
            UIManager.put("AbstractUndoableEdit.undoText", "Foondo");
            harness.check(mgr.getUndoPresentationName(), (Object)"Foondo");
        }
        finally {
            UIManager.put("AbstractUndoableEdit.undoText", oldText);
        }
        mgr.redo();
        harness.check(mgr.getUndoPresentationName(), (Object)"UndoPres1");
        mgr.end();
        harness.check(mgr.getUndoPresentationName(), (Object)"UndoPres1");
    }
}

