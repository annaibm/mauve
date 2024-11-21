/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import javax.swing.SpinnerListModel;

public class ListModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean threwException = false;
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("GNU");
        list2.add("Classpath");
        SpinnerListModel model2 = new SpinnerListModel(list2);
        harness.check(model2.getList() != null, "List model creation check");
        harness.check(model2.getValue(), "GNU", "List model current value check");
        harness.check(model2.getNextValue(), "Classpath", "List model next value check");
        harness.check(model2.getValue(), "GNU", "List model no change of current value after next check");
        harness.check(model2.getPreviousValue(), null, "List model previous value check");
        list2.set(0, "GNU's Not UNIX");
        harness.check(model2.getValue(), "GNU's Not UNIX", "List model backing list change check");
        model2.setValue("Classpath");
        harness.check(model2.getValue(), "Classpath", "List model successful set check");
        try {
            model2.setValue("Sun");
        }
        catch (IllegalArgumentException exception) {
            threwException = true;
        }
        harness.check(threwException, "List model non-existant value exception check.");
    }
}

