/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.OutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.OutputStream;

public class Test
extends OutputStream
implements Testlet {
    private static final int LEN = 100;
    private byte[] buf = new byte[100];
    private int index = 0;

    @Override
    public final void write(int c) throws IOException {
        this.buf[this.index++] = (byte)c;
    }

    public String toString() {
        return new String(this.buf, 0, this.index);
    }

    @Override
    public void test(TestHarness harness) {
        try {
            String tstr = "ABCDEFGH";
            Test ts = new Test();
            ts.write(tstr.charAt(0));
            harness.check(true, "write(int)");
            byte[] cbuf = new byte[8];
            tstr.getBytes(0, 8, cbuf, 0);
            ts.write(cbuf, 0, 4);
            harness.check(true, "write(byte[], off, len)");
            ts.write(cbuf);
            ts.flush();
            harness.check(true, "flush()");
            harness.check(ts.toString(), "AABCDABCDEFGH", "Wrote all characters okay");
            ts.close();
            harness.check(true, "close()");
        }
        catch (IOException e) {
            harness.check(false, "IOException unexpected");
        }
    }
}

