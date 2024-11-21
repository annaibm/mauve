/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTree;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTree;

public class getCellRenderer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testDefault(harness);
    }

    private void testDefault(TestHarness h) {
        JTree t = new JTree();
        h.check(t.getCellRenderer() != null);
    }
}

