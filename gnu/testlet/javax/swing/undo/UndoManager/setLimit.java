/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.undo.UndoManager.TestUndoManager;

public class setLimit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestUndoManager mgr = new TestUndoManager();
        mgr.setLimit(25);
        harness.check(mgr.getLimit(), 25);
        mgr.setLimit(0);
        harness.check(mgr.getLimit(), 0);
        mgr.setLimit(-10);
        harness.check(mgr.getLimit(), -10);
        harness.check(mgr.numTrimForLimitCalls, 3);
        mgr.setLimit(20);
        mgr.addTestEdits(10, 5);
        harness.check(mgr.checkIDs(new int[]{10, 11, 12, 13, 14}));
        mgr.undo();
        mgr.undo();
        mgr.setLimit(2);
        harness.check(mgr.checkIDs(new int[]{12, 13}));
        mgr.end();
        Exception caught = null;
        try {
            mgr.setLimit(2);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught != null);
    }
}

