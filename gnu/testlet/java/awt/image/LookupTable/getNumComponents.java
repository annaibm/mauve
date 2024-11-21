/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.LookupTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ByteLookupTable;

public class getNumComponents
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ByteLookupTable t = new ByteLookupTable(0, new byte[]{-86, -69});
        harness.check(t.getNumComponents(), 1);
    }
}

