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
import javax.swing.filechooser.FileSystemView;

public class changeToParentDirectory
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
        FileSystemView fsv = fc.getFileSystemView();
        File[] roots = fsv.getRoots();
        File root = roots[0];
        fc.setCurrentDirectory(root);
        fc.addPropertyChangeListener(this);
        fc.changeToParentDirectory();
        harness.check(fc.getCurrentDirectory(), new File(System.getProperty("user.home")));
        harness.check(this.events.size(), 1);
    }
}

