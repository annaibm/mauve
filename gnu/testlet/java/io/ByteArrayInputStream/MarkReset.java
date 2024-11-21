/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ByteArrayInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MarkReset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str = "My sophomore year of college I moved out of the dorms. I\nmoved in with three friends into a brand new townhouse in east\nBloomington at 771 Woodbridge Drive.  To this day that was the\nnicest place I've ever lived.\n";
        byte[] str_bytes = str.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(str_bytes);
        byte[] read_buf = new byte[12];
        try {
            bais.read(read_buf);
            harness.check(bais.available(), str_bytes.length - read_buf.length, "available() 1");
            harness.check(bais.skip(5L), 5L, "skip()");
            harness.check(bais.available(), str_bytes.length - (read_buf.length + 5), "available() 2");
            harness.check(bais.markSupported(), "markSupported()");
            bais.mark(0);
            int availsave = bais.available();
            bais.read();
            bais.reset();
            harness.check(bais.available(), availsave, "reset");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

