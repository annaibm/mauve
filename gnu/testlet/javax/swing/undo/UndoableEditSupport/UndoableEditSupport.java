/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoableEditSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.CompoundEdit;

public class UndoableEditSupport
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String foo = "foo";
        MySupport ms = new MySupport();
        harness.check(ms.getRealSource() == ms);
        harness.check(ms.getUpdateLevel(), 0);
        harness.check(ms.getCompoundEdit(), null);
        ms = new MySupport(null);
        harness.check(ms.getRealSource() == ms);
        harness.check(ms.getUpdateLevel(), 0);
        harness.check(ms.getCompoundEdit(), null);
        ms = new MySupport(foo);
        harness.check(ms.getRealSource() == foo);
        harness.check(ms.getUpdateLevel(), 0);
        harness.check(ms.getCompoundEdit(), null);
    }

    private static class MySupport
    extends javax.swing.undo.UndoableEditSupport {
        public MySupport() {
        }

        public MySupport(Object realSource) {
            super(realSource);
        }

        public Object getRealSource() {
            return this.realSource;
        }

        public CompoundEdit getCompoundEdit() {
            return this.compoundEdit;
        }
    }
}

