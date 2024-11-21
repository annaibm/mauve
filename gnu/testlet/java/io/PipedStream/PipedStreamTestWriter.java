/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PipedStream;

import gnu.testlet.TestHarness;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.StringBufferInputStream;

class PipedStreamTestWriter
implements Runnable {
    String str;
    StringBufferInputStream sbis;
    PipedOutputStream out;
    TestHarness harness;
    private boolean isReady = false;

    public PipedStreamTestWriter(TestHarness harness) {
        this.harness = harness;
        this.str = "I went to work for Andersen Consulting after I graduated\nfrom college.  They sent me to their training facility in St. Charles,\nIllinois and tried to teach me COBOL.  I didn't want to learn it.\nThe instructors said I had a bad attitude and I got a green sheet\nwhich is a nasty note in your file saying what a jerk you are.\n";
        this.sbis = new StringBufferInputStream(this.str);
        this.out = new PipedOutputStream();
    }

    public PipedOutputStream getStream() {
        return this.out;
    }

    public String getStr() {
        return this.str;
    }

    public synchronized void waitTillReady() {
        while (!this.isReady) {
            try {
                this.wait();
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        byte[] buf = new byte[32];
        try {
            int bytes_read;
            int b = this.sbis.read();
            this.out.write(b);
            PipedStreamTestWriter pipedStreamTestWriter = this;
            synchronized (pipedStreamTestWriter) {
                this.isReady = true;
                this.notify();
            }
            while ((bytes_read = this.sbis.read(buf)) != -1) {
                this.out.write(buf, 0, bytes_read);
            }
            this.out.flush();
            this.out.close();
        }
        catch (IOException e) {
            this.harness.debug("In writer: " + e);
            this.harness.check(false);
        }
    }
}

