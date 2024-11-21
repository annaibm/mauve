/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.StateEdit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Hashtable;
import javax.swing.undo.StateEdit;
import javax.swing.undo.StateEditable;

public class getPresentationName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StateEditable edited = new StateEditable(){

            public void storeState(Hashtable state) {
            }

            public void restoreState(Hashtable state) {
            }
        };
        StateEdit edit = new StateEdit(edited, "Ostracize");
        harness.check(edit.getPresentationName(), (Object)"Ostracize");
        edit = new StateEdit(edited);
        harness.check(edit.getPresentationName() == null);
    }
}

