/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoableEditSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.UndoableEditSupport;

public class getUpdateLevel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UndoableEditSupport ues = new UndoableEditSupport();
        harness.check(ues.getUpdateLevel(), 0);
        ues.beginUpdate();
        harness.check(ues.getUpdateLevel(), 1);
        ues.beginUpdate();
        harness.check(ues.getUpdateLevel(), 2);
        ues.endUpdate();
        harness.check(ues.getUpdateLevel(), 1);
        ues.beginUpdate();
        harness.check(ues.getUpdateLevel(), 2);
        ues.endUpdate();
        harness.check(ues.getUpdateLevel(), 1);
        ues.endUpdate();
        harness.check(ues.getUpdateLevel(), 0);
    }
}

