/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;

public class initializeLocalVars
implements Testlet {
    boolean hasModel;
    boolean hasColumnModel;

    @Override
    public void test(TestHarness harness) {
        this.testPreconditions(harness);
    }

    void testPreconditions(TestHarness harness) {
        TestTable table2 = new TestTable();
        harness.check(this.hasModel, true);
        harness.check(this.hasColumnModel, true);
    }

    class TestTable
    extends JTable {
        TestTable() {
        }

        @Override
        protected void initializeLocalVars() {
            initializeLocalVars.this.hasModel = this.getModel() != null;
            initializeLocalVars.this.hasColumnModel = this.getColumnModel() != null;
            super.initializeLocalVars();
        }
    }
}

