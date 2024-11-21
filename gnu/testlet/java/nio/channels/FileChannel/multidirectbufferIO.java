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
import java.util.Arrays;

public class multidirectbufferIO
implements Testlet {
    private void initBuffer(ByteBuffer[] bs, byte[] data) {
        for (int i = 0; i < bs.length; ++i) {
            bs[i] = ByteBuffer.allocateDirect(data.length);
            bs[i].put(data);
            bs[i].flip();
        }
    }

    @Override
    public void test(TestHarness harness) {
        int BUF_LEN = 17;
        int MAX_BUFFERS = 16;
        byte[] data = "qwertyuiopasdfghjklzxcvbnm".getBytes();
        ByteBuffer[] out = new ByteBuffer[17];
        ByteBuffer[] in = new ByteBuffer[17];
        this.initBuffer(out, data);
        this.initBuffer(in, new byte[data.length]);
        String tmpfile = harness.getTempDirectory() + File.separator + "mauve-multibuffer.tmp";
        try {
            File f = new File(tmpfile);
            f.createNewFile();
            FileChannel fcOut = new FileOutputStream(f).getChannel();
            long numWritten = fcOut.write(out);
            fcOut.close();
            harness.check(numWritten, multidirectbufferIO.conformToJDK17_u8() ? (long)(17 * data.length) : (long)(16 * data.length));
            for (int i = 0; i < 16; ++i) {
                harness.check(out[i].position() == out[i].limit(), "Position - Limit mismatch");
            }
            FileChannel fcIn = new FileInputStream(f).getChannel();
            long numRead = fcIn.read(in);
            harness.check(numRead, multidirectbufferIO.conformToJDK17_u8() ? (long)(17 * data.length) : (long)(16 * data.length));
            for (int i = 0; i < 16; ++i) {
                byte[] dIn = new byte[data.length];
                byte[] dOut = new byte[data.length];
                in[i].flip();
                out[i].flip();
                in[i].get(dIn);
                out[i].get(dOut);
                harness.check(Arrays.equals(dIn, dOut));
            }
            f.delete();
        }
        catch (IOException e) {
            harness.fail("Unexpected exception: " + e);
        }
    }

    private static boolean conformToJDK17_u8() {
        String[] javaVersion = System.getProperty("java.version").split("\\.");
        String vendorID = System.getProperty("java.vendor");
        if ("Sun Microsystems Inc.".equals(vendorID) || "Oracle Corporation".equals(vendorID)) {
            int version = Integer.parseInt(javaVersion[1]);
            if (version > 7) {
                return true;
            }
            if (version == 7) {
                String[] splitstr = javaVersion[2].split("_");
                int update2 = Integer.parseInt(splitstr[1]);
                return update2 >= 8;
            }
        }
        return false;
    }
}

