/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.channels.FileChannel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class offsetSingleDirectBuffer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            byte[] data = "qwertyuiopasdfghjklzxcvbnm".getBytes("UTF-8");
            ByteBuffer out = ByteBuffer.allocateDirect(50);
            out.put(data);
            out.flip();
            out.position(5);
            ByteBuffer in = ByteBuffer.allocateDirect(50);
            String tmpfile = harness.getTempDirectory() + File.separator + "mauve-offset-single-direct-buffer.tmp";
            File f = new File(tmpfile);
            FileOutputStream fOut = new FileOutputStream(f);
            FileChannel fc = fOut.getChannel();
            int numBytes = fc.write(out);
            harness.check(numBytes, data.length - 5, "Number of bytes written");
            fc.close();
            harness.check(f.length(), (long)(data.length - 5), "Resulting File size");
            in.position(5);
            FileInputStream fIn = new FileInputStream(f);
            FileChannel fcIn = fIn.getChannel();
            int numRead = fcIn.read(in);
            harness.check(numRead, data.length - 5, "Number of bytes read");
            harness.check(in.position(), data.length, "Buffer position");
            byte[] oldData = new byte[data.length - 5];
            System.arraycopy(data, 5, oldData, 0, 21);
            byte[] newData = new byte[data.length - 5];
            in.flip();
            in.position(5);
            in.get(newData);
            harness.check(Arrays.equals(newData, oldData), "File content");
            fcIn.close();
            f.delete();
        }
        catch (UnsupportedEncodingException e1) {
            harness.fail("Unsupported Encoding");
        }
        catch (SecurityException e) {
            harness.fail("Unexpected exception: " + e);
        }
        catch (FileNotFoundException e) {
            harness.fail("Unexpected exception: " + e);
        }
        catch (IOException e) {
            harness.fail("Unexpected exception: " + e);
        }
    }
}

