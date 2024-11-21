/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.SequenceInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SequenceInputStream sis;
        ByteArrayInputStream is2;
        StringBufferInputStream is1;
        String str1 = "I don't believe in going to chain restaurants.  I think\nthey are evil.  I can't believe all the suburban folks who go to \n";
        String str2 = "places like the Olive Garden.  Not only does the food make\nme want to puke, none of these chains has the slightest bit of character.\n";
        byte[] buf = new byte[10];
        try {
            int bytes_read;
            is1 = new StringBufferInputStream(str1);
            is2 = new ByteArrayInputStream(str2.getBytes());
            sis = new SequenceInputStream(is1, is2);
            harness.check(str1.length(), sis.available(), "available()");
            while ((bytes_read = sis.read(buf)) != -1) {
                harness.debug(new String(buf, 0, bytes_read), false);
            }
            sis.close();
            harness.check(true);
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            is1 = new StringBufferInputStream(str1);
            is2 = new ByteArrayInputStream(str2.getBytes());
            sis = new SequenceInputStream(is1, is2);
            sis.read(buf, 0, 5);
            harness.check(true, "read(buf, off, len)");
            sis.close();
            harness.check(sis.read(), -1, "close() test");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

