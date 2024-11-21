/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JFileChooser.MyFileFilter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class setAcceptAllFileFilterUsed
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        FileFilter acceptAllFilter = fc.getAcceptAllFileFilter();
        fc.addPropertyChangeListener(this);
        harness.check(fc.isAcceptAllFileFilterUsed(), true);
        MyFileFilter f1 = new MyFileFilter(true);
        fc.addChoosableFileFilter(f1);
        this.events.clear();
        fc.setAcceptAllFileFilterUsed(false);
        harness.check(fc.isAcceptAllFileFilterUsed(), false);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] oldFilters = (FileFilter[])e1.getOldValue();
        harness.check(oldFilters.length, 2);
        harness.check(oldFilters[0], acceptAllFilter);
        harness.check(oldFilters[1], f1);
        FileFilter[] newFilters = (FileFilter[])e1.getNewValue();
        harness.check(newFilters.length, 1);
        harness.check(newFilters[0], f1);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"acceptAllFileFilterUsedChanged");
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 1);
        harness.check(filters[0], f1);
        this.events.clear();
        MyFileFilter ff = new MyFileFilter(false);
        fc.addChoosableFileFilter(ff);
        this.events.clear();
        harness.check(fc.getFileFilter(), ff);
        fc.setAcceptAllFileFilterUsed(true);
        harness.check(fc.isAcceptAllFileFilterUsed(), true);
        harness.check(fc.getFileFilter(), fc.getAcceptAllFileFilter());
        harness.check(this.events.size(), 3);
        e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"fileFilterChanged");
        PropertyChangeEvent e3 = (PropertyChangeEvent)this.events.get(2);
        harness.check(e3.getPropertyName(), (Object)"acceptAllFileFilterUsedChanged");
        filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 3);
    }
}

