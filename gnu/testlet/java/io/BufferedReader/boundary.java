/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class boundary
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            String str = "abcd\r\nefghijklm\r\n";
            StringReader sr = new StringReader(str);
            BufferedReader br = new BufferedReader(sr, 5);
            String l1 = br.readLine();
            harness.check(l1, (Object)"abcd");
            br.mark(1);
            char c = (char)br.read();
            harness.check(c, 101);
            br.reset();
            String l2 = br.readLine();
            harness.check(l2, (Object)"efghijklm");
            sr = new StringReader("efghijklm\n");
            br = new BufferedReader(sr);
            harness.check(br.ready(), "ready()");
            br.skip(2L);
            l2 = br.readLine();
            harness.check(l2, (Object)"ghijklm");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

