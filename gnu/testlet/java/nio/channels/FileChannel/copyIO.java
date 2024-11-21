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
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class copyIO
implements Testlet {
    private static final byte[] source = "abcdefghijklmnopqrstuvwxyz".getBytes();
    private static final int BUFSIZE = 10;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        File tmpf1 = null;
        File tmpf2 = null;
        try {
            byte[] source = "abcdefghijklmnopqrstuvwxyz".getBytes();
            String tmpfile = harness.getTempDirectory() + File.separator + "mauve-copyIO.";
            tmpf1 = new File(tmpfile + "TEST1");
            tmpf2 = new File(tmpfile + "TEST2");
            FileOutputStream fos = new FileOutputStream(tmpf1);
            fos.write(source);
            fos.close();
            FileInputStream tmpin = new FileInputStream(tmpf1);
            FileOutputStream tmpout = new FileOutputStream(tmpf2);
            FileChannel in = tmpin.getChannel();
            FileChannel out = tmpout.getChannel();
            copyIO.copyIO(10, in, out);
            tmpin.close();
            tmpout.close();
            FileInputStream fis = new FileInputStream(tmpf2);
            byte[] result = new byte[source.length + 1];
            int l = fis.read(result, 0, result.length);
            if (l == source.length) {
                harness.check(new String(source).equals(new String(result, 0, l)));
            } else if (l >= 0) {
                harness.fail("Unexpected result: source=" + new String(source) + ", result=" + new String(result, 0, l));
            } else {
                harness.fail("Unexpected EOF");
            }
        }
        catch (Exception e) {
            harness.fail("Unexpected exception: " + e);
            harness.debug(e);
        }
        finally {
            if (tmpf1 != null) {
                tmpf1.delete();
            }
            if (tmpf2 != null) {
                tmpf2.delete();
            }
        }
    }

    private static void copyIO(int bufsize, FileChannel in, FileChannel out) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(bufsize);
        boolean eof = false;
        while (!eof) {
            int i;
            buffer.clear();
            int pos = buffer.position();
            int limit = buffer.limit();
            for (i = pos + 1; i <= limit; ++i) {
                buffer.limit(i);
                int l = in.read(buffer);
                if (l >= 0) continue;
                eof = true;
                break;
            }
            buffer.flip();
            pos = buffer.position();
            limit = buffer.limit();
            for (i = pos + 1; i <= limit; ++i) {
                buffer.limit(i);
                out.write(buffer);
            }
        }
    }
}

