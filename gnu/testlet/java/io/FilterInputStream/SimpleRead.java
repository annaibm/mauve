/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FilterInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class SimpleRead
extends FilterInputStream
implements Testlet {
    public SimpleRead() {
        this(null);
    }

    public SimpleRead(ByteArrayInputStream is) {
        super(is);
    }

    @Override
    public void test(TestHarness harness) {
        String str = "My sophomore year of college I moved out of the dorms. I\nmoved in with three friends into a brand new townhouse in east\nBloomington at 771 Woodbridge Drive.  To this day that was the\nnicest place I've ever lived.\n";
        byte[] str_bytes = str.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(str_bytes);
        SimpleRead fis = new SimpleRead(bais);
        byte[] read_buf = new byte[12];
        try {
            int bytes_read;
            int total_read = 0;
            harness.check(fis.read(), 77, "read()");
            while ((bytes_read = fis.read(read_buf, 0, read_buf.length)) != -1) {
                harness.debug(new String(read_buf, 0, bytes_read), false);
                total_read += bytes_read;
            }
            fis.close();
            harness.check(total_read, str.length() - 1, "total_read");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

