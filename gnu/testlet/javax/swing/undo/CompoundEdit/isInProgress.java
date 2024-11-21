/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.CompoundEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.CompoundEdit;

public class isInProgress
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CompoundEdit edit = new CompoundEdit();
        harness.check(edit.isInProgress());
        edit.end();
        harness.check(!edit.isInProgress());
    }
}

