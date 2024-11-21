/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class append
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        String tmpfile = harness.getTempDirectory() + File.separator + "mauve-fos-append.tst";
        File f = new File(tmpfile);
        f.delete();
        try {
            FileOutputStream fos = new FileOutputStream(f, false);
            BufferedOutputStream bos = new BufferedOutputStream(fos, 2048);
            DataOutputStream dos = new DataOutputStream(bos);
            for (int i = 0; i < 50; ++i) {
                dos.writeInt(i);
            }
            dos.close();
            long len1 = f.length();
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            harness.check(raf.length(), len1);
            raf.close();
            dos.close();
            fos = new FileOutputStream(f, false);
            bos = new BufferedOutputStream(fos, 2048);
            dos = new DataOutputStream(bos);
            for (int i = 0; i < 25; ++i) {
                dos.writeInt(i);
            }
            dos.close();
            long len2 = f.length();
            raf = new RandomAccessFile(f, "rw");
            harness.check(raf.length(), len2);
            raf.close();
            dos.close();
            fos = new FileOutputStream(f, true);
            bos = new BufferedOutputStream(fos, 2048);
            dos = new DataOutputStream(bos);
            for (int i = 0; i < 50; ++i) {
                dos.writeInt(i);
            }
            dos.close();
            long len3 = f.length();
            harness.check(len1 + len2, len3);
            raf = new RandomAccessFile(f, "rw");
            harness.check(raf.length(), len3);
            raf.close();
            fos = new FileOutputStream(f, false);
            bos = new BufferedOutputStream(fos, 2048);
            dos = new DataOutputStream(bos);
            for (int i = 0; i < 25; ++i) {
                dos.writeInt(i);
            }
            dos.close();
            long len4 = f.length();
            harness.check(len2, len4);
            raf = new RandomAccessFile(f, "rw");
            harness.check(raf.length(), len4);
            raf.close();
            dos.close();
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

