/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.channels.FileChannel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class manyopen
implements Testlet {
    private final int MANY = 1024;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        Runtime runtime = Runtime.getRuntime();
        String tmpfile = harness.getTempDirectory() + File.separator + "mauve-many.";
        int i = 0;
        try {
            for (i = 0; i < 1024; ++i) {
                File f = new File(tmpfile + i + ".in");
                f.createNewFile();
                FileInputStream fis = new FileInputStream(f);
                f = new File(tmpfile + i + ".out");
                FileOutputStream fos = new FileOutputStream(f);
                f = new File(tmpfile + i + ".raf");
                RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
            }
            harness.check(true);
        }
        catch (IOException ioe) {
            harness.fail("Unexpected exception at nr " + i + ": " + ioe);
            harness.debug(ioe);
        }
        finally {
            for (i = 0; i < 1024; ++i) {
                File f = new File(tmpfile + i + ".in");
                f.delete();
                f = new File(tmpfile + i + ".out");
                f.delete();
                f = new File(tmpfile + i + ".raf");
                f.delete();
            }
        }
    }
}

