/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.LookupOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;

public class getTable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        byte[] bytes = new byte[]{-86, -69};
        ByteLookupTable t = new ByteLookupTable(0, bytes);
        LookupOp op = new LookupOp(t, null);
        harness.check(op.getTable() == t);
    }
}

