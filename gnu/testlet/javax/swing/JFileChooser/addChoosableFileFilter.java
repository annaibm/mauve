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

public class addChoosableFileFilter
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testNull(harness);
    }

    public void testGeneral(TestHarness harness) {
        harness.checkPoint("testGeneral()");
        JFileChooser fc = new JFileChooser();
        fc.addPropertyChangeListener(this);
        MyFileFilter f1 = new MyFileFilter(true);
        fc.addChoosableFileFilter(f1);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 2);
        harness.check(filters[0], fc.getAcceptAllFileFilter());
        harness.check(filters[1], f1);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent event1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(event1.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] oldFilters = (FileFilter[])event1.getOldValue();
        harness.check(oldFilters.length, 1);
        harness.check(oldFilters[0], fc.getAcceptAllFileFilter());
        FileFilter[] newFilters = (FileFilter[])event1.getNewValue();
        harness.check(newFilters.length, 2);
        harness.check(newFilters[0], fc.getAcceptAllFileFilter());
        harness.check(newFilters[1], f1);
        PropertyChangeEvent event2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(event2.getPropertyName(), (Object)"fileFilterChanged");
        harness.check(event2.getOldValue(), fc.getAcceptAllFileFilter());
        harness.check(event2.getNewValue(), f1);
        this.events.clear();
    }

    public void testNull(TestHarness harness) {
        harness.checkPoint("testNull()");
        JFileChooser fc = new JFileChooser();
        this.events.clear();
        fc.addPropertyChangeListener(this);
        fc.addChoosableFileFilter(null);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 1);
        harness.check(filters[0], fc.getAcceptAllFileFilter());
        harness.check(this.events.size(), 1);
        PropertyChangeEvent event1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(event1.getPropertyName(), (Object)"fileFilterChanged");
        harness.check(event1.getOldValue(), fc.getAcceptAllFileFilter());
        harness.check(event1.getNewValue(), null);
        this.events.clear();
    }
}

