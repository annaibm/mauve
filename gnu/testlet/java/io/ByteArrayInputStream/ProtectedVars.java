/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ByteArrayInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ProtectedVars
extends ByteArrayInputStream
implements Testlet {
    public ProtectedVars(byte[] b) {
        super(b);
    }

    public ProtectedVars() {
        super(new byte[1]);
    }

    @Override
    public void test(TestHarness harness) {
        String str = "My sophomore year of college I moved out of the dorms. I\nmoved in with three friends into a brand new townhouse in east\nBloomington at 771 Woodbridge Drive.  To this day that was the\nnicest place I've ever lived.\n";
        byte[] str_bytes = str.getBytes();
        ProtectedVars bais = new ProtectedVars(str_bytes);
        byte[] read_buf = new byte[12];
        try {
            bais.read(read_buf);
            bais.mark(0);
            harness.check(bais.mark, read_buf.length, "mark");
            bais.read(read_buf);
            harness.check(bais.pos, read_buf.length * 2, "pos");
            harness.check(bais.count, str_bytes.length, "count");
            harness.check(bais.buf, str_bytes, "buf");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

