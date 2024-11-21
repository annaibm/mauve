/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PipedStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.PipedStream.PipedStreamTestWriter;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            int bytes_read;
            PipedStreamTestWriter pstw = new PipedStreamTestWriter(harness);
            String str = pstw.getStr();
            PipedOutputStream pos = pstw.getStream();
            PipedInputStream pis = new PipedInputStream();
            pis.connect(pos);
            new Thread(pstw).start();
            pstw.waitTillReady();
            harness.check(pis.available() > 0, "available()");
            byte[] buf = new byte[12];
            int total_read = 0;
            while ((bytes_read = pis.read(buf)) != -1) {
                harness.debug(new String(buf, 0, bytes_read), false);
                System.gc();
                total_read += bytes_read;
            }
            harness.check(total_read, str.length(), "total_read");
        }
        catch (IOException e) {
            harness.debug("In input: " + e);
            harness.check(false);
        }
        try {
            PipedStreamTestWriter pstw2 = new PipedStreamTestWriter(harness);
            String str2 = pstw2.getStr();
            PipedOutputStream pos2 = pstw2.getStream();
            PipedInputStream pis2 = new PipedInputStream();
            pos2.connect(pis2);
            harness.check(true, "output.connect(input)");
        }
        catch (IOException e) {
            harness.check(false);
        }
    }
}

