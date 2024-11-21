/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoableEditSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoableEditSupport;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyUndoableEditSupport u = new MyUndoableEditSupport("realSource");
        harness.check(u.toString(), (Object)(u.getClass().getName() + "@" + Integer.toHexString(u.hashCode()) + " updateLevel: 0 listeners: [] compoundEdit: null"));
        u.beginUpdate();
        u.beginUpdate();
        u.addUndoableEditListener(new MyListener());
        u.addUndoableEditListener(new MyListener());
        harness.check(u.toString(), (Object)(u.getClass().getName() + "@" + Integer.toHexString(u.hashCode()) + " updateLevel: 2 listeners: [lily, lily] compoundEdit: rose"));
        u = new MyUndoableEditSupport(null);
        harness.check(u.toString(), (Object)(u.getClass().getName() + "@" + Integer.toHexString(u.hashCode()) + " updateLevel: 0 listeners: [] compoundEdit: null"));
    }

    private static class MyListener
    implements UndoableEditListener {
        private MyListener() {
        }

        public String toString() {
            return "lily";
        }

        @Override
        public void undoableEditHappened(UndoableEditEvent x) {
        }
    }

    private static class MyUndoableEditSupport
    extends UndoableEditSupport {
        public MyUndoableEditSupport(Object realSource) {
            super(realSource);
        }

        @Override
        public CompoundEdit createCompoundEdit() {
            return new CompoundEdit(){

                @Override
                public String toString() {
                    return "rose";
                }
            };
        }
    }
}

