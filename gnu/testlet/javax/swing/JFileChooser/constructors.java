/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JFileChooser.MyFileSystemView;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
        this.testConstructor6(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        JFileChooser fc = new JFileChooser();
        harness.check(fc.getCurrentDirectory(), new File(System.getProperty("user.home")));
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(File)");
        File f = new File(System.getProperty("user.home"));
        JFileChooser fc = new JFileChooser(f);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        fc = new JFileChooser((File)null);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(File, FileSystemView)");
        MyFileSystemView fsv = new MyFileSystemView();
        File f = new File(System.getProperty("user.home"));
        JFileChooser fc = new JFileChooser(f, (FileSystemView)fsv);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        harness.check(fc.getFileSystemView(), fsv);
        fc = new JFileChooser((File)null, (FileSystemView)fsv);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        harness.check(fc.getFileSystemView(), fsv);
        fc = new JFileChooser(f, null);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        harness.check(fc.getFileSystemView(), FileSystemView.getFileSystemView());
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(FileSystemView)");
        MyFileSystemView fsv = new MyFileSystemView();
        File f = new File(System.getProperty("user.home"));
        JFileChooser fc = new JFileChooser(fsv);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        harness.check(fc.getFileSystemView(), fsv);
        fc = new JFileChooser((FileSystemView)null);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        harness.check(fc.getFileSystemView(), FileSystemView.getFileSystemView());
    }

    public void testConstructor5(TestHarness harness) {
        harness.checkPoint("(String)");
        File f = new File(System.getProperty("user.home"));
        JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        fc = new JFileChooser((String)null);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
    }

    public void testConstructor6(TestHarness harness) {
        harness.checkPoint("(String, FileSystemView)");
        MyFileSystemView fsv = new MyFileSystemView();
        File f = new File(System.getProperty("user.home"));
        JFileChooser fc = new JFileChooser(System.getProperty("user.home"), (FileSystemView)fsv);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        harness.check(fc.getFileSystemView(), fsv);
        fc = new JFileChooser((String)null, (FileSystemView)fsv);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        harness.check(fc.getFileSystemView(), fsv);
        fc = new JFileChooser(System.getProperty("user.home"), null);
        harness.check(fc.getCurrentDirectory(), f);
        harness.check(fc.getSelectedFile(), null);
        harness.check(fc.getFileSystemView(), FileSystemView.getFileSystemView());
    }
}

