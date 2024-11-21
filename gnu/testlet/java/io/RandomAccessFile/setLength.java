/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.RandomAccessFile;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class setLength
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        String tmpfile = harness.getTempDirectory() + File.separator + "mauve-raf.tst";
        File f = new File(tmpfile);
        f.delete();
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            harness.check(raf.length(), 0L);
            harness.check(raf.getFilePointer(), 0L);
            raf.write(new byte[]{1, 2, 3, 4, 5, 6, 7, 8});
            harness.check(raf.length(), 8L);
            harness.check(raf.getFilePointer(), 8L);
            raf.setLength(3L);
            harness.check(raf.length(), 3L);
            harness.check(raf.getFilePointer(), 3L);
            harness.check(raf.read(), -1);
            harness.check(3L, raf.length());
            raf.write(10);
            harness.check(raf.length(), 4L);
            harness.check(raf.getFilePointer(), 4L);
            raf.setLength(10L);
            harness.check(raf.length(), 10L);
            harness.check(raf.getFilePointer(), 4L);
            raf.setLength(5L);
            harness.check(raf.length(), 5L);
            harness.check(raf.getFilePointer(), 4L);
            raf.setLength(1L);
            harness.check(raf.length(), 1L);
            harness.check(raf.getFilePointer(), 1L);
        }
        catch (IOException ioe) {
            harness.fail("Unexpected: " + ioe);
            harness.debug(ioe);
        }
        finally {
            f.delete();
        }
    }
}

