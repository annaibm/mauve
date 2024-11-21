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

public class singlebufferIO
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        byte[] data = "qwertyuiopasdfghjklzxcvbnm".getBytes();
        ByteBuffer out = ByteBuffer.wrap(data);
        ByteBuffer in = ByteBuffer.wrap(new byte[data.length]);
        String tmpfile = harness.getTempDirectory() + File.separator + "mauve-singlebuffer.tmp";
        try {
            File f = new File(tmpfile);
            f.createNewFile();
            FileChannel fcOut = new FileOutputStream(f).getChannel();
            fcOut.write(out);
            fcOut.close();
            harness.check(out.position() == out.limit(), "Position - Limit mismatch");
            FileChannel fcIn = new FileInputStream(f).getChannel();
            fcIn.read(in);
            System.out.println("Position: " + in.position() + ", Limit: " + in.limit());
            System.out.println("Position: " + out.position() + ", Limit: " + out.limit());
            harness.check(Arrays.equals(out.array(), in.array()));
        }
        catch (IOException e) {
            harness.fail("Unexpected exception: " + e);
        }
        finally {
            if (tmpfile != null) {
                new File(tmpfile).delete();
            }
        }
    }
}

