/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class mark
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            byte[] bs = new byte[]{97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
            ByteArrayInputStream bais = new ByteArrayInputStream(bs);
            InputStreamReader isr = new InputStreamReader((InputStream)bais, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            char[] cs = new char[4];
            br.mark(4);
            br.read(cs);
            harness.check(97, cs[0]);
            harness.check(98, cs[1]);
            harness.check(99, cs[2]);
            harness.check(100, cs[3]);
            br.reset();
            br.mark(12);
            harness.check(97, br.read());
            harness.check(98, br.read());
            harness.check(99, br.read());
            harness.check(100, br.read());
            harness.check(101, br.read());
            harness.check(102, br.read());
            harness.check(103, br.read());
            harness.check(104, br.read());
            harness.check(105, br.read());
            harness.check(106, br.read());
            harness.check(107, br.read());
            harness.check(108, br.read());
            harness.check(109, br.read());
            harness.check(110, br.read());
            harness.check(-1, br.read());
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

