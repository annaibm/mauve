/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import javax.swing.SpinnerListModel;

public class Ordering
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("z");
        list2.add("a");
        list2.add("b");
        SpinnerListModel model2 = new SpinnerListModel(list2);
        harness.check(model2.getList() != null, "Array model ordering creation check");
        harness.check(model2.getValue(), "a", "Array model ordering current value check");
        harness.check(model2.getNextValue(), "z", "Array model ordering next value check");
        harness.check(model2.getValue(), "a", "Array model ordering no change of current value after next check");
        harness.check(model2.getPreviousValue(), null, "Array model ordering previous value check");
        model2.setValue("a");
        harness.check(model2.getValue(), "a", "Array model ordering successful set check");
        harness.check(model2.getPreviousValue(), null, "Array model ordering post-set previous value check");
        harness.check(model2.getNextValue(), "z", "Array model ordering post-set next value check");
    }
}

