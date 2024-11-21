/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.LookupTable;

import gnu.testlet.TestHarness;
import java.awt.image.ByteLookupTable;

public class getOffset {
    public void test(TestHarness harness) {
        ByteLookupTable t = new ByteLookupTable(99, new byte[]{-86, -69});
        harness.check(t.getOffset(), 99);
    }
}

