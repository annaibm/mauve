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
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

public class removeChoosableFileFilter
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
        this.test5(harness);
        this.test6(harness);
        this.test7(harness);
        this.test8(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("test1");
        JFileChooser fc = new JFileChooser();
        FileFilter acceptAllFilter = fc.getAcceptAllFileFilter();
        fc.addPropertyChangeListener(this);
        fc.removeChoosableFileFilter(acceptAllFilter);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 0);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"fileFilterChanged");
        harness.check(e1.getOldValue(), acceptAllFilter);
        harness.check(e1.getNewValue(), null);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] ff1 = (FileFilter[])e2.getOldValue();
        FileFilter[] ff2 = (FileFilter[])e2.getNewValue();
        harness.check(ff1.length, 1);
        harness.check(ff2.length, 0);
        this.events.clear();
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("test2");
        JFileChooser fc = new JFileChooser();
        FileFilter acceptAllFilter = fc.getAcceptAllFileFilter();
        MyFileFilter f1 = new MyFileFilter(true);
        fc.addChoosableFileFilter(f1);
        fc.setFileFilter(acceptAllFilter);
        fc.addPropertyChangeListener(this);
        boolean removed = fc.removeChoosableFileFilter(acceptAllFilter);
        harness.check(removed);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 1);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"fileFilterChanged");
        harness.check(e1.getOldValue(), acceptAllFilter);
        harness.check(e1.getNewValue(), null);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] ff1 = (FileFilter[])e2.getOldValue();
        FileFilter[] ff2 = (FileFilter[])e2.getNewValue();
        harness.check(ff1.length, 2);
        harness.check(ff2.length, 1);
        harness.check(fc.getFileFilter(), null);
        this.events.clear();
    }

    public void test3(TestHarness harness) {
        harness.checkPoint("test3");
        JFileChooser fc = new JFileChooser();
        FileFilter acceptAllFilter = fc.getAcceptAllFileFilter();
        MyFileFilter f1 = new MyFileFilter(true);
        fc.addChoosableFileFilter(f1);
        fc.setFileFilter(acceptAllFilter);
        fc.addPropertyChangeListener(this);
        boolean removed = fc.removeChoosableFileFilter(f1);
        harness.check(removed);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 1);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] ff1 = (FileFilter[])e1.getOldValue();
        FileFilter[] ff2 = (FileFilter[])e1.getNewValue();
        harness.check(ff1.length, 2);
        harness.check(ff2.length, 1);
        harness.check(fc.getFileFilter(), acceptAllFilter);
        this.events.clear();
    }

    public void test4(TestHarness harness) {
        harness.checkPoint("test4");
        JFileChooser fc = new JFileChooser();
        FileFilter acceptAllFilter = fc.getAcceptAllFileFilter();
        MyFileFilter f1 = new MyFileFilter(true);
        fc.addChoosableFileFilter(f1);
        fc.addPropertyChangeListener(this);
        boolean removed = fc.removeChoosableFileFilter(acceptAllFilter);
        harness.check(removed);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 1);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] ff1 = (FileFilter[])e1.getOldValue();
        FileFilter[] ff2 = (FileFilter[])e1.getNewValue();
        harness.check(ff1.length, 2);
        harness.check(ff2.length, 1);
        harness.check(fc.getFileFilter(), f1);
        this.events.clear();
    }

    public void test5(TestHarness harness) {
        harness.checkPoint("test5");
        JFileChooser fc = new JFileChooser();
        MyFileFilter f1 = new MyFileFilter(true);
        fc.addChoosableFileFilter(f1);
        fc.addPropertyChangeListener(this);
        boolean removed = fc.removeChoosableFileFilter(f1);
        harness.check(removed);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 1);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"fileFilterChanged");
        harness.check(e1.getOldValue(), f1);
        harness.check(e1.getNewValue(), null);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] ff1 = (FileFilter[])e2.getOldValue();
        FileFilter[] ff2 = (FileFilter[])e2.getNewValue();
        harness.check(ff1.length, 2);
        harness.check(ff2.length, 1);
        harness.check(fc.getFileFilter(), null);
        this.events.clear();
    }

    public void test6(TestHarness harness) {
        harness.checkPoint("test6");
        JFileChooser fc = new JFileChooser();
        MyFileFilter f1 = new MyFileFilter(true);
        fc.addChoosableFileFilter(f1);
        fc.setAcceptAllFileFilterUsed(false);
        fc.addPropertyChangeListener(this);
        boolean removed = fc.removeChoosableFileFilter(f1);
        harness.check(removed);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 0);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"fileFilterChanged");
        harness.check(e1.getOldValue(), f1);
        harness.check(e1.getNewValue(), null);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] ff1 = (FileFilter[])e2.getOldValue();
        FileFilter[] ff2 = (FileFilter[])e2.getNewValue();
        harness.check(ff1.length, 1);
        harness.check(ff2.length, 0);
        harness.check(fc.getFileFilter(), null);
        this.events.clear();
    }

    public void test7(TestHarness harness) {
        harness.checkPoint("test7");
        JFileChooser fc = new JFileChooser();
        MyFileFilter f1 = new MyFileFilter(true);
        MyFileFilter f2 = new MyFileFilter(false);
        fc.addChoosableFileFilter(f1);
        fc.addChoosableFileFilter(f2);
        fc.setAcceptAllFileFilterUsed(false);
        fc.addPropertyChangeListener(this);
        boolean removed = fc.removeChoosableFileFilter(f2);
        harness.check(removed);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 1);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"fileFilterChanged");
        harness.check(e1.getOldValue(), f2);
        harness.check(e1.getNewValue(), null);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] ff1 = (FileFilter[])e2.getOldValue();
        FileFilter[] ff2 = (FileFilter[])e2.getNewValue();
        harness.check(ff1.length, 2);
        harness.check(ff2.length, 1);
        harness.check(fc.getFileFilter(), null);
        this.events.clear();
    }

    public void test8(TestHarness harness) {
        harness.checkPoint("test8");
        JFileChooser fc = new JFileChooser();
        MyFileFilter f1 = new MyFileFilter(true);
        MyFileFilter f2 = new MyFileFilter(false);
        fc.addChoosableFileFilter(f1);
        fc.addChoosableFileFilter(f2);
        fc.setAcceptAllFileFilterUsed(false);
        fc.addPropertyChangeListener(this);
        boolean removed = fc.removeChoosableFileFilter(f1);
        harness.check(removed);
        FileFilter[] filters = fc.getChoosableFileFilters();
        harness.check(filters.length, 1);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"ChoosableFileFilterChangedProperty");
        FileFilter[] ff1 = (FileFilter[])e1.getOldValue();
        FileFilter[] ff2 = (FileFilter[])e1.getNewValue();
        harness.check(ff1.length, 2);
        harness.check(ff2.length, 1);
        harness.check(fc.getFileFilter(), f2);
        this.events.clear();
    }
}

