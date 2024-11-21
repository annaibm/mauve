/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InputStreamReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

public class except
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean ok = false;
        try {
            InputStreamReader isr = new InputStreamReader(new StringBufferInputStream("zardoz has spoken"));
            char[] cbuf = new char[10];
            isr.close();
            isr.read(cbuf, 0, 9);
        }
        catch (IOException _1) {
            ok = true;
        }
        catch (Throwable _2) {
            harness.debug(_2);
        }
        harness.check(ok);
    }
}

