/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;
import javax.swing.UIManager;

public class getRedoPresentationName
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        TestUndoManager.TestEdit[] edits = mgr.addTestEdits(1, 2);
        Object oldText = UIManager.get("AbstractUndoableEdit.redoText");
        try {
            UIManager.put("AbstractUndoableEdit.redoText", "Fooredo");
            harness.check(mgr.getRedoPresentationName(), (Object)"Fooredo");
        }
        finally {
            UIManager.put("AbstractUndoableEdit.redoText", oldText);
        }
        mgr.undo();
        harness.check(mgr.getRedoPresentationName(), (Object)"RedoPres2");
        mgr.undo();
        harness.check(mgr.getRedoPresentationName(), (Object)"RedoPres1");
        mgr.redo();
        harness.check(mgr.getRedoPresentationName(), (Object)"RedoPres2");
        mgr.end();
        harness.check(mgr.getRedoPresentationName(), (Object)"RedoPres1");
    }
}

