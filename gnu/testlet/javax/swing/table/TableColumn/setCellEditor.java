/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

public class setCellEditor
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        harness.check(c.getCellEditor(), null);
        c.addPropertyChangeListener(this);
        DefaultCellEditor editor = new DefaultCellEditor(new JTextField());
        c.setCellEditor(editor);
        harness.check(c.getCellEditor(), editor);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"cellEditor");
        harness.check(e.getOldValue(), null);
        harness.check(e.getNewValue(), editor);
        this.events.clear();
        c.setCellEditor(null);
        e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"cellEditor");
        harness.check(e.getOldValue(), editor);
        harness.check(e.getNewValue(), null);
    }
}

