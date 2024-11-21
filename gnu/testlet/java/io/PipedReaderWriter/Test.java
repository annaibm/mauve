/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PipedReaderWriter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.PipedReaderWriter.PipedTestWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            int chars_read;
            PipedTestWriter ptw = new PipedTestWriter(harness);
            String str = ptw.getStr();
            PipedWriter pw = ptw.getWriter();
            PipedReader pr = new PipedReader();
            pr.connect(pw);
            new Thread(ptw).start();
            char[] buf = new char[12];
            int total_read = 0;
            while ((chars_read = pr.read(buf, 0, buf.length)) != -1) {
                harness.debug(new String(buf, 0, chars_read), false);
                System.gc();
                total_read += chars_read;
            }
            pr.close();
            harness.check(total_read, str.length(), "total_read");
            PipedTestWriter ptw2 = new PipedTestWriter(harness);
            PipedWriter pw2 = ptw2.getWriter();
            PipedReader pr2 = new PipedReader();
            pw2.connect(pr2);
            harness.check(true, "writer.connect()");
        }
        catch (IOException e) {
            harness.debug("In reader: " + e);
            harness.check(false);
        }
    }
}

