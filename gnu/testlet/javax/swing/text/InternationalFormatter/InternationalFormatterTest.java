/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.InternationalFormatter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.InternationalFormatter;

public class InternationalFormatterTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InternationalFormatter formatter = new InternationalFormatter();
        harness.check(!formatter.getCommitsOnValidEdit());
        harness.check(formatter.getAllowsInvalid());
        harness.check(!formatter.getOverwriteMode());
    }
}

