/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.ChoiceFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ChoiceFormat;

public class next
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String oneplus = "1.0000000000000002";
        harness.check(ChoiceFormat.nextDouble(1.0) + "", (Object)oneplus);
        harness.check(ChoiceFormat.nextDouble(1.0, true) + "", (Object)oneplus);
    }
}

