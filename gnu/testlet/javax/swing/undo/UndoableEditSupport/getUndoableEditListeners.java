/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoableEditSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEditSupport;

public class getUndoableEditListeners
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UndoableEditSupport ues = new UndoableEditSupport();
        TestListener t1 = new TestListener();
        TestListener t2 = new TestListener();
        UndoableEditListener[] l = ues.getUndoableEditListeners();
        harness.check(l != null && l.length == 0);
        ues.addUndoableEditListener(t1);
        l = ues.getUndoableEditListeners();
        harness.check(l != null && l.length == 1 && l[0] == t1);
        ues.addUndoableEditListener(t2);
        l = ues.getUndoableEditListeners();
        harness.check(l != null && l.length == 2 && l[0] == t1 && l[1] == t2);
        ues.removeUndoableEditListener(t1);
        l = ues.getUndoableEditListeners();
        harness.check(l != null && l.length == 1 && l[0] == t2);
    }

    private static class TestListener
    implements UndoableEditListener {
        private TestListener() {
        }

        @Override
        public void undoableEditHappened(UndoableEditEvent evt) {
        }
    }
}

