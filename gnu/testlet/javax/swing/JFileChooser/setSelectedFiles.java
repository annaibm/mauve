/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

public class setSelectedFiles
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
        this.testEmptyArray(harness);
    }

    public void testGeneral(TestHarness harness) {
        harness.checkPoint("testGeneral()");
        JFileChooser fc = new JFileChooser();
        fc.addPropertyChangeListener(this);
        File[] files = fc.getSelectedFiles();
        harness.check(files.length, 0);
        File f1 = new File("X");
        files = new File[]{f1};
        fc.setSelectedFiles(files);
        File[] ff = fc.getSelectedFiles();
        harness.check(ff[0], f1);
        harness.check(fc.getSelectedFile(), f1);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"SelectedFileChangedProperty");
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"SelectedFilesChangedProperty");
        this.events.clear();
    }

    public void testNull(TestHarness harness) {
        harness.checkPoint("testNull()");
        JFileChooser fc = new JFileChooser();
        fc.addPropertyChangeListener(this);
        File[] files = fc.getSelectedFiles();
        harness.check(files.length, 0);
        harness.check(fc.getSelectedFile(), null);
        fc.setSelectedFiles(null);
        files = fc.getSelectedFiles();
        harness.check(files.length, 0);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"SelectedFileChangedProperty");
        harness.check(e1.getOldValue(), null);
        harness.check(e1.getNewValue(), null);
        harness.check(fc.getSelectedFile(), null);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"SelectedFilesChangedProperty");
        this.events.clear();
    }

    public void testEmptyArray(TestHarness harness) {
        harness.checkPoint("testEmptyArray()");
        JFileChooser fc = new JFileChooser();
        this.events.clear();
        fc.addPropertyChangeListener(this);
        File[] files = fc.getSelectedFiles();
        harness.check(files.length, 0);
        fc.setSelectedFiles(new File[0]);
        files = fc.getSelectedFiles();
        harness.check(files.length, 0);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"SelectedFileChangedProperty");
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"SelectedFilesChangedProperty");
        this.events.clear();
    }
}

