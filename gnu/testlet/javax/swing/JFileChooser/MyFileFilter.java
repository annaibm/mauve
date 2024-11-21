/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class MyFileFilter
extends FileFilter {
    private boolean directories;

    public MyFileFilter(boolean acceptDirectories) {
        this.directories = acceptDirectories;
    }

    @Override
    public boolean accept(File file) {
        if (file == null) {
            return false;
        }
        if (this.directories) {
            return file.isDirectory();
        }
        return !file.isDirectory();
    }

    @Override
    public String getDescription() {
        return "Test filter";
    }
}

