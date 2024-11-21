/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileSystemView;

public class MyFileSystemView
extends FileSystemView {
    @Override
    public File createNewFolder(File containingDir) throws IOException {
        return null;
    }
}

