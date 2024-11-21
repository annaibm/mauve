/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.InputStream;

public class Test
extends InputStream
implements Testlet {
    private String s;
    private int index;

    public Test() {
    }

    Test(String str) {
        this.s = str;
        this.index = 0;
    }

    @Override
    public int read() throws IOException {
        return this.index == this.s.length() ? -1 : (int)this.s.charAt(this.index++);
    }

    @Override
    public void test(TestHarness harness) {
        try {
            Test tis = new Test("zardoz has spoken");
            byte[] cbuf = new byte[10];
            tis.read(cbuf, 0, cbuf.length);
            String tst = new String(cbuf);
            harness.check(tst, "zardoz has", "read(buf[], off, len)");
            harness.check(tis.read(), 32, "read()");
            tis.close();
            harness.check(true, "close()");
        }
        catch (IOException e) {
            harness.check(false, "IOException unexpected");
        }
    }
}

