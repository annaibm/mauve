/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SpinnerListModel;

public class ArrayModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object[] array = new Object[]{"GNU", "Classpath"};
        SpinnerListModel model2 = new SpinnerListModel(array);
        harness.check(model2.getList() != null, "Array model creation check");
        harness.check(model2.getValue(), "GNU", "Array model current value check");
        harness.check(model2.getNextValue(), "Classpath", "Array model next value check");
        harness.check(model2.getValue(), "GNU", "Array model no change of current value after next check");
        harness.check(model2.getPreviousValue(), null, "Array model previous value check");
        array[0] = "GNU's Not UNIX";
        harness.check(model2.getValue(), "GNU's Not UNIX", "Array model backing list change check");
        model2.setValue("Classpath");
        harness.check(model2.getValue(), "Classpath", "Array model successful set check");
        boolean threwException = false;
        try {
            model2.setValue("Sun");
        }
        catch (IllegalArgumentException exception) {
            threwException = true;
        }
        harness.check(threwException, "Array model non-existant value exception check");
    }
}

