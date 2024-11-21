/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import javax.swing.SpinnerListModel;

public class SetList
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SpinnerListModel model2 = new SpinnerListModel();
        boolean threwException = false;
        try {
            model2.setList(null);
            harness.fail("Null list supplied to setList failed to throw an exception.");
        }
        catch (IllegalArgumentException exception) {
            threwException = true;
        }
        harness.check(threwException, "setList null list exception check.");
        threwException = false;
        try {
            model2.setList(new ArrayList());
        }
        catch (IllegalArgumentException exception) {
            threwException = true;
        }
        harness.check(threwException, "setList empty list exception check.");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("GNU");
        model2.setList(list2);
        harness.check(model2.getList(), list2, "Model allowed successful change of list.");
    }
}

