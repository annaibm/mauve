/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoableEditSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoableEditSupport;

public class beginUpdate
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyUES ues = new MyUES();
        harness.check(ues.getCompoundEdit(), null);
        harness.check(ues.getUpdateLevel(), 0);
        ues.beginUpdate();
        CompoundEdit cedit = ues.getCompoundEdit();
        harness.check(ues.getCompoundEdit() instanceof MyCompoundEdit);
        harness.check(ues.getUpdateLevel(), 1);
        ues.beginUpdate();
        harness.check(ues.getCompoundEdit() == cedit);
        harness.check(ues.getUpdateLevel(), 2);
        ues.beginUpdate();
        harness.check(ues.getCompoundEdit() == cedit);
        harness.check(ues.getUpdateLevel(), 3);
        ues.endUpdate();
        harness.check(ues.getUpdateLevel(), 2);
        ues.endUpdate();
        harness.check(ues.getUpdateLevel(), 1);
        ues.beginUpdate();
        harness.check(ues.getCompoundEdit() == cedit);
        harness.check(ues.getUpdateLevel(), 2);
        ues.endUpdate();
        harness.check(ues.getUpdateLevel(), 1);
        ues.endUpdate();
        harness.check(ues.getCompoundEdit(), null);
        harness.check(ues.getUpdateLevel(), 0);
        ues.beginUpdate();
        harness.check(ues.getUpdateLevel(), 1);
        harness.check(ues.getCompoundEdit() != cedit);
    }

    private static class MyCompoundEdit
    extends CompoundEdit {
        private MyCompoundEdit() {
        }
    }

    private static class MyUES
    extends UndoableEditSupport {
        private MyUES() {
        }

        @Override
        protected CompoundEdit createCompoundEdit() {
            return new MyCompoundEdit();
        }

        public CompoundEdit getCompoundEdit() {
            return this.compoundEdit;
        }
    }
}

