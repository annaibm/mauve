/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class getListCellRendererComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Dimension d;
        Component c;
        int i;
        Object[] data = new Object[]{"", null, new Integer(1), new Object(), new int[0], new String[0], new String[1]};
        JList<Object> list2 = new JList<Object>(data);
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        for (i = 0; i < data.length; ++i) {
            c = dlcr.getListCellRendererComponent(list2, data[i], i, false, false);
            d = c.getPreferredSize();
            harness.check(d.height >= 0);
            harness.check(d.width >= 0);
        }
        for (i = 0; i < data.length; ++i) {
            list2.setSelectedIndex(i);
            c = dlcr.getListCellRendererComponent(list2, data[i], i, true, false);
            d = c.getPreferredSize();
            harness.check(d.height >= 0);
            harness.check(d.width >= 0);
        }
    }
}

