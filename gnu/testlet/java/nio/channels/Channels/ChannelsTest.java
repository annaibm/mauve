/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.channels.Channels;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelsTest
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        String tmpfile = h.getTempDirectory() + File.separator + "mauve-channels.tst";
        File f = new File(tmpfile);
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            FileChannel fch = raf.getChannel();
            ByteArrayChannel bac = new ByteArrayChannel();
            h.checkPoint("newInputStream");
            InputStream in = Channels.newInputStream(bac);
            h.check(in != null);
            in = Channels.newInputStream(fch);
            h.check(in != null);
            h.checkPoint("newOutputStream");
            OutputStream out = Channels.newOutputStream(bac);
            h.check(out != null);
            out = Channels.newOutputStream(fch);
            h.check(out != null);
        }
        catch (FileNotFoundException e) {
            h.debug(e);
            h.fail("cannot create temporary file");
        }
        finally {
            f.delete();
        }
    }

    class ByteArrayChannel
    implements ReadableByteChannel,
    WritableByteChannel {
        @Override
        public boolean isOpen() {
            return true;
        }

        @Override
        public void close() throws IOException {
        }

        @Override
        public int read(ByteBuffer dst) throws IOException {
            return 0;
        }

        @Override
        public int write(ByteBuffer src) throws IOException {
            return 0;
        }
    }
}

