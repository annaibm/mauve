/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.channels.FileChannel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class truncate
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        String tmpfile = harness.getTempDirectory() + File.separator + "mauve-trunc.tst";
        File f = new File(tmpfile);
        f.delete();
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            FileChannel fc = raf.getChannel();
            harness.check(fc.size(), 0L);
            harness.check(fc.position(), 0L);
            ByteBuffer bb = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5, 6, 7, 8});
            harness.check(fc.write(bb), 8);
            harness.check(fc.size(), 8L);
            harness.check(fc.position(), 8L);
            fc.truncate(3L);
            harness.check(fc.size(), 3L);
            harness.check(fc.position(), 3L);
            harness.check(fc.read(ByteBuffer.allocate(1)), -1);
            harness.check(3L, fc.size());
            bb = ByteBuffer.allocate(1);
            bb.put((byte)10);
            bb.flip();
            harness.check(fc.write(bb), 1);
            harness.check(fc.size(), 4L);
            harness.check(fc.position(), 4L);
            fc.truncate(10L);
            harness.check(fc.size(), 4L);
            harness.check(fc.position(), 4L);
            fc.position(3L);
            fc.truncate(4L);
            harness.check(fc.size(), 4L);
            harness.check(fc.position(), 3L);
            fc.truncate(1L);
            harness.check(fc.size(), 1L);
            harness.check(fc.position(), 1L);
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

