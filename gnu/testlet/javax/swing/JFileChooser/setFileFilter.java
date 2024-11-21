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

public class setFileFilter
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("test1");
        JFileChooser fc = new JFileChooser();
        FileFilter acceptAllFilter = fc.getAcceptAllFileFilter();
        fc.addPropertyChangeListener(this);
        harness.check(fc.getFileFilter(), acceptAllFilter);
        MyFileFilter ff1 = new MyFileFilter(true);
        fc.setFileFilter(ff1);
        harness.check(fc.getFileFilter(), ff1);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] filters1 = (FileFilter[])e1.getOldValue();
        harness.check(filters1.length, 1);
        FileFilter[] filters2 = (FileFilter[])e1.getNewValue();
        harness.check(filters2.length, 2);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"fileFilterChanged");
        harness.check(e2.getOldValue(), acceptAllFilter);
        harness.check(e2.getNewValue(), ff1);
        this.events.clear();
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("test2");
        JFileChooser fc = new JFileChooser();
        FileFilter acceptAllFilter = fc.getAcceptAllFileFilter();
        fc.addPropertyChangeListener(this);
        harness.check(fc.getFileFilter(), acceptAllFilter);
        fc.setFileFilter(null);
        harness.check(fc.getFileFilter(), null);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent event = (PropertyChangeEvent)this.events.get(0);
        harness.check(event.getPropertyName(), (Object)"fileFilterChanged");
        harness.check(event.getOldValue(), acceptAllFilter);
        harness.check(event.getNewValue(), null);
    }
}

