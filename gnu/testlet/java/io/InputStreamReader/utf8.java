/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InputStreamReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;

public class utf8
implements Testlet,
Runnable {
    TestHarness harness;
    boolean ok = false;

    @Override
    public void test(TestHarness h) {
        this.harness = h;
        Thread t = new Thread(this);
        t.start();
        try {
            t.join(3000L);
        }
        catch (InterruptedException ie) {
            this.harness.debug("Interrupted: " + ie);
        }
        this.harness.check(this.ok, "UTF-8 decoder finished");
        if (!this.ok) {
            t.interrupt();
        }
    }

    @Override
    public void run() {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter((OutputStream)pos, "UTF-8");
            PrintWriter ps = new PrintWriter(osw);
            PipedInputStream pis = new PipedInputStream(pos);
            InputStreamReader isr = new InputStreamReader((InputStream)pis, "UTF-8");
            char[] buf = new char[256];
            ps.print("0123456789ABCDEF");
            ps.flush();
            int read2 = isr.read(buf, 0, 256);
            this.harness.check(read2, 16, "16 characters read");
            this.ok = true;
        }
        catch (IOException ioe) {
            this.harness.debug(ioe);
            this.harness.check(false, "IOException in run()");
        }
    }
}

