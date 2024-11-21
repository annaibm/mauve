/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import javax.swing.SpinnerListModel;

public class Constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SpinnerListModel model2;
        boolean threwException = false;
        try {
            model2 = new SpinnerListModel((Object[])null);
        }
        catch (IllegalArgumentException exception) {
            threwException = true;
        }
        harness.check(threwException, "Null array to constructor exception check");
        threwException = false;
        try {
            model2 = new SpinnerListModel(new ArrayList());
        }
        catch (IllegalArgumentException exception) {
            threwException = true;
        }
        harness.check(threwException, "Empty list to constructor exception check");
        threwException = false;
        try {
            model2 = new SpinnerListModel(new Object[0]);
            harness.fail("Empty array supplied to constructor failed to throw an exception.");
        }
        catch (IllegalArgumentException exception) {
            threwException = true;
        }
        harness.check(threwException, "Empty array to constructor exception check");
        model2 = new SpinnerListModel();
        harness.check(model2.getList() != null, "Default list construction check.");
        harness.check(model2.getValue(), "empty", "Default list current value check.");
        harness.check(model2.getNextValue(), null, "Default list next value check.");
        harness.check(model2.getPreviousValue(), null, "Default list previous value check.");
    }
}

