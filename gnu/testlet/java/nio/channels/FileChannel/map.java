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
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.NonReadableChannelException;

public class map
implements Testlet {
    private static final byte[] msg = "Hello, World!".getBytes();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        String filename = null;
        try {
            filename = harness.getTempDirectory() + File.separator + "mauvemap.txt";
            FileOutputStream fos = new FileOutputStream(filename);
            FileChannel chan = fos.getChannel();
            try {
                chan.map(FileChannel.MapMode.READ_WRITE, 0L, msg.length);
                harness.check(false);
            }
            catch (NonReadableChannelException x) {
                harness.check(true);
            }
            fos.close();
            RandomAccessFile ras = new RandomAccessFile(filename, "rw");
            chan = ras.getChannel();
            MappedByteBuffer mbb = chan.map(FileChannel.MapMode.READ_WRITE, 0L, msg.length);
            mbb.put(msg);
            mbb.force();
            this.verifyContent(harness, filename);
            MappedByteBuffer mbb2 = chan.map(FileChannel.MapMode.PRIVATE, 0L, msg.length);
            mbb2.put(new byte[msg.length]);
            boolean ok = true;
            for (int i = 0; i < msg.length; ++i) {
                ok &= mbb2.get(i) == 0;
            }
            harness.check(ok);
            mbb.force();
            ras.close();
            this.verifyContent(harness, filename);
            if (filename != null) {
                harness.check(new File(filename).delete());
            }
        }
        catch (Exception x) {
            try {
                harness.debug(x);
                harness.check(false);
                if (filename != null) {
                    harness.check(new File(filename).delete());
                }
            }
            catch (Throwable throwable) {
                if (filename != null) {
                    harness.check(new File(filename).delete());
                }
                throw throwable;
            }
        }
    }

    private void verifyContent(TestHarness harness, String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        FileChannel chan = fis.getChannel();
        MappedByteBuffer mbb = chan.map(FileChannel.MapMode.READ_ONLY, 0L, msg.length);
        byte[] buf = new byte[msg.length];
        mbb.get(buf);
        boolean ok = true;
        for (int i = 0; i < msg.length; ++i) {
            ok &= msg[i] == buf[i];
        }
        harness.check(ok);
        fis.close();
    }
}

