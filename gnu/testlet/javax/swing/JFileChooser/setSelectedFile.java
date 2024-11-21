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

public class setSelectedFile
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
        this.events.clear();
        fc.addPropertyChangeListener(this);
        File file = fc.getSelectedFile();
        harness.check(file, null);
        File f1 = new File("X");
        fc.setSelectedFile(f1);
        harness.check(fc.getSelectedFile(), f1);
        File[] files = fc.getSelectedFiles();
        harness.check(files.length, 0);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"SelectedFileChangedProperty");
        harness.check(e1.getOldValue(), null);
        harness.check(e1.getNewValue(), f1);
        this.events.clear();
        fc.setSelectedFile(f1);
        harness.check(fc.getSelectedFile(), f1);
        files = fc.getSelectedFiles();
        harness.check(files.length, 0);
        harness.check(this.events.size(), 0);
    }

    public void testNull(TestHarness harness) {
        harness.checkPoint("testNull()");
        JFileChooser fc = new JFileChooser();
        this.events.clear();
        fc.addPropertyChangeListener(this);
        File file = fc.getSelectedFile();
        harness.check(file, null);
        fc.setSelectedFile(null);
        harness.check(fc.getSelectedFile(), null);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"SelectedFileChangedProperty");
        harness.check(e1.getOldValue(), null);
        harness.check(e1.getNewValue(), null);
        this.events.clear();
    }
}

