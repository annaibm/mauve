/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoableEditSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoableEditSupport;

public class createCompoundEdit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyUES ues = new MyUES();
        CompoundEdit c1 = ues.cce();
        CompoundEdit c2 = ues.cce();
        harness.check(c1 != null);
        harness.check(c2 != null);
        harness.check(c1 != c2);
    }

    private static class MyUES
    extends UndoableEditSupport {
        private MyUES() {
        }

        public CompoundEdit cce() {
            return this.createCompoundEdit();
        }
    }
}

