/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileView;

public class setFileView
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent event;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }

    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        jfc.addPropertyChangeListener(this);
        harness.check(jfc.getFileView(), null);
        FileView fv1 = new FileView(){};
        jfc.setFileView(fv1);
        harness.check(jfc.getFileView(), fv1);
        harness.check(this.event.getPropertyName(), (Object)"fileViewChanged");
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), fv1);
        jfc.setFileView(null);
        harness.check(jfc.getFileView(), null);
        harness.check(this.event.getPropertyName(), (Object)"fileViewChanged");
        harness.check(this.event.getOldValue(), fv1);
        harness.check(this.event.getNewValue(), null);
    }
}

