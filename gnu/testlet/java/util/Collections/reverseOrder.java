/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.Collections;

public class reverseOrder
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String[] a = new String[]{"A", "B", "C"};
        Arrays.sort(a, Collections.reverseOrder());
        harness.check(a[0].equals("C"));
        harness.check(a[1].equals("B"));
        harness.check(a[2].equals("A"));
    }
}

