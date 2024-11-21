/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class sizeWidthToFit
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.events.add(event);
    }

    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        harness.check(c.getHeaderRenderer(), null);
        c.addPropertyChangeListener(this);
        c.sizeWidthToFit();
        harness.check(c.getMinWidth(), 15);
        harness.check(c.getMaxWidth(), Integer.MAX_VALUE);
        harness.check(c.getPreferredWidth(), 75);
        harness.check(c.getWidth(), 75);
        JTable t = new JTable();
        JTableHeader h = t.getTableHeader();
        JComponent r = (JComponent)((Object)h.getDefaultRenderer());
        r.setMinimumSize(new Dimension(13, 5));
        r.setMaximumSize(new Dimension(999, 99));
        r.setPreferredSize(new Dimension(34, 21));
        c.setHeaderRenderer((TableCellRenderer)((Object)r));
        harness.check(c.getMinWidth(), 15);
        harness.check(c.getMaxWidth(), Integer.MAX_VALUE);
        harness.check(c.getPreferredWidth(), 75);
        harness.check(c.getWidth(), 75);
        c.sizeWidthToFit();
        harness.check(c.getMinWidth(), 13);
        harness.check(c.getMaxWidth(), 999);
        harness.check(c.getPreferredWidth(), 34);
        harness.check(c.getWidth(), 34);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getPropertyName(), (Object)"headerRenderer");
        harness.check(e0.getOldValue(), null);
        harness.check(e0.getNewValue(), r);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e1.getPropertyName(), (Object)"minWidth");
        harness.check(e1.getOldValue(), new Integer(15));
        harness.check(e1.getNewValue(), new Integer(13));
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(2);
        harness.check(e2.getPropertyName(), (Object)"maxWidth");
        harness.check(e2.getOldValue(), new Integer(Integer.MAX_VALUE));
        harness.check(e2.getNewValue(), new Integer(999));
        PropertyChangeEvent e3 = (PropertyChangeEvent)this.events.get(3);
        harness.check(e3.getPropertyName(), (Object)"preferredWidth");
        harness.check(e3.getOldValue(), new Integer(75));
        harness.check(e3.getNewValue(), new Integer(34));
        PropertyChangeEvent e4 = (PropertyChangeEvent)this.events.get(4);
        harness.check(e4.getPropertyName(), (Object)"width");
        harness.check(e4.getOldValue(), new Integer(75));
        harness.check(e4.getNewValue(), new Integer(34));
    }
}

