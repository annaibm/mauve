/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class getMinimum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testX(harness);
    }

    private void testX(TestHarness harness) {
        GregorianCalendar c1 = new GregorianCalendar();
        harness.check(((Calendar)c1).getMinimum(11), 0);
        harness.check(((Calendar)c1).getMinimum(12), 0);
        harness.check(((Calendar)c1).getMinimum(13), 0);
        harness.check(((Calendar)c1).getMinimum(14), 0);
    }
}

