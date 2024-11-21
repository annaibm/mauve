/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.UndoManager;

public class getLimit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UndoManager mgr = new UndoManager();
        harness.check(mgr.getLimit(), 100);
        mgr.setLimit(20);
        harness.check(mgr.getLimit(), 20);
    }
}

