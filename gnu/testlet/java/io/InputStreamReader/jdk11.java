/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InputStreamReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

public class jdk11
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            InputStreamReader isr = new InputStreamReader(new StringBufferInputStream("zardoz has spoken"));
            harness.check(isr.ready(), "ready()");
            harness.check(isr.getEncoding() != null, "non-null getEncoding");
            char[] cbuf = new char[10];
            isr.read(cbuf, 0, cbuf.length);
            String tst = new String(cbuf);
            harness.check(tst, "zardoz has", "read(buf[], off, len)");
            harness.check(isr.read(), 32, "read()");
            isr.close();
            harness.check(isr.getEncoding(), null, "null encoding after close");
        }
        catch (IOException e) {
            harness.check(false, "IOException unexpected");
        }
    }
}

