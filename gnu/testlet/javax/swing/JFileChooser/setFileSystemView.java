/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JFileChooser.MyFileSystemView;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class setFileSystemView
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
        harness.check(jfc.getFileSystemView(), FileSystemView.getFileSystemView());
        MyFileSystemView fsv1 = new MyFileSystemView();
        jfc.setFileSystemView(fsv1);
        harness.check(jfc.getFileSystemView(), fsv1);
        harness.check(this.event.getPropertyName(), (Object)"FileSystemViewChanged");
        harness.check(this.event.getOldValue(), FileSystemView.getFileSystemView());
        harness.check(this.event.getNewValue(), fsv1);
        jfc.setFileSystemView(null);
        harness.check(jfc.getFileSystemView(), null);
        harness.check(this.event.getPropertyName(), (Object)"FileSystemViewChanged");
        harness.check(this.event.getOldValue(), fsv1);
        harness.check(this.event.getNewValue(), null);
    }
}

