/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FilterInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class MarkReset
extends FilterInputStream
implements Testlet {
    public MarkReset() {
        this(null);
    }

    public MarkReset(ByteArrayInputStream is) {
        super(is);
    }

    @Override
    public void test(TestHarness harness) {
        String str = "My sophomore year of college I moved out of the dorms. I\nmoved in with three friends into a brand new townhouse in east\nBloomington at 771 Woodbridge Drive.  To this day that was the\nnicest place I've ever lived.\n";
        byte[] str_bytes = str.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(str_bytes);
        MarkReset fis = new MarkReset(bais);
        byte[] read_buf = new byte[12];
        try {
            fis.read(read_buf);
            harness.check(fis.available(), str_bytes.length - read_buf.length, "available() 1");
            harness.check(fis.skip(5L), 5L, "skip()");
            harness.check(fis.available(), str_bytes.length - (read_buf.length + 5), "available() 2");
            harness.check(fis.markSupported(), "markSupported()");
            fis.mark(0);
            int availsave = fis.available();
            fis.read();
            fis.reset();
            harness.check(fis.available(), availsave, "mark(),reset()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

