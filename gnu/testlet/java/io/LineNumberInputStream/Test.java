/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.LineNumberInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.io.StringBufferInputStream;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int bytes_read;
        byte[] buf;
        LineNumberInputStream lnis;
        StringBufferInputStream sbis;
        String str;
        try {
            str = "I grew up by a small town called Laconia, Indiana\rwhich has a population of about 64 people.  But I didn't live\r\nin town.  I lived on a gravel road about 4 miles away.\nThey paved that road\n";
            sbis = new StringBufferInputStream(str);
            lnis = new LineNumberInputStream(sbis);
            lnis.setLineNumber(2);
            buf = new byte[32];
            while ((bytes_read = lnis.read(buf)) != -1) {
                str = new String(buf, 0, bytes_read);
                if (str.indexOf("\r") != -1) {
                    harness.debug("\nFound an unexpected \\r\n");
                    harness.check(false);
                }
                harness.debug(str, false);
            }
            harness.check(lnis.getLineNumber(), 6, "getLineNumber - first test");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            str = "One time I was playing kickball on the playground\nin 4th grade and my friends kept talking about how they smelled\npot.  I kept asking them what they smelled because I couldn't\nfigure out how a pot could have a smell";
            sbis = new StringBufferInputStream(str);
            lnis = new LineNumberInputStream(sbis);
            buf = new byte[32];
            while ((bytes_read = lnis.read(buf)) != -1) {
                harness.debug(new String(buf, 0, bytes_read), false);
            }
            harness.debug("");
            harness.check(lnis.getLineNumber(), 3, "getLineNumber - second test");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

