/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.AbstractUndoableEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.undo.AbstractUndoableEdit;

public class getPresentationName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AbstractUndoableEdit edit = new AbstractUndoableEdit();
        harness.check(edit.getPresentationName(), (Object)"");
    }
}

