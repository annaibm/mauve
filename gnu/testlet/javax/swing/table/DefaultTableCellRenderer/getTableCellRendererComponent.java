/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class getTableCellRendererComponent
implements Testlet {
    Object value;

    @Override
    public void test(TestHarness harness) {
        this.testSetValue(harness);
        this.testTextField(harness);
    }

    private void testSetValue(TestHarness h) {
        TestCellRenderer r = new TestCellRenderer();
        this.value = null;
        JTable t = new JTable();
        String v = "Hello";
        r.getTableCellRendererComponent(t, v, false, false, 0, 0);
        h.check(this.value == v);
    }

    private void testTextField(TestHarness h) {
        TestCellRenderer r = new TestCellRenderer();
        JTable t = new JTable();
        JTextField v = new JTextField("Hello");
        Component c = r.getTableCellRendererComponent(t, v, false, false, 0, 0);
        h.check(c == r);
    }

    class TestCellRenderer
    extends DefaultTableCellRenderer {
        TestCellRenderer() {
        }

        @Override
        protected void setValue(Object v) {
            super.setValue(v);
            getTableCellRendererComponent.this.value = v;
        }
    }
}

