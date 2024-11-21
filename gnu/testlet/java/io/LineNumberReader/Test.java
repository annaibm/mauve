/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.LineNumberReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int chars_read;
        char[] buf;
        LineNumberReader lnr;
        StringReader sbr;
        String str;
        try {
            str = "In 6th grade I had a crush on this girl named Leanne\nDean.  I thought she was pretty hot.  I saw her at my ten year\nhigh school reunion.  I still think she's pretty hot.  (She's\nmarried to my brother's college roommate).\n";
            sbr = new StringReader(str);
            lnr = new LineNumberReader(sbr);
            lnr.setLineNumber(2);
            buf = new char[32];
            while ((chars_read = lnr.read(buf)) != -1) {
                str = new String(buf, 0, chars_read);
                if (str.indexOf("\r") != -1) {
                    harness.debug("\nFound unexpected \\r");
                    harness.check(false);
                }
                harness.debug(str, false);
            }
            harness.check(lnr.getLineNumber(), 6, "getLineNumber - first series");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            str = "Exiting off the expressway in Chicago is not an easy\nthing to do.  For example, at Fullerton you have to run a\ngauntlet of people selling flowers, begging for money, or trying\nto 'clean' your windshield for tips.";
            sbr = new StringReader(str);
            lnr = new LineNumberReader(sbr);
            buf = new char[32];
            while ((chars_read = lnr.read(buf)) != -1) {
                harness.debug(new String(buf, 0, chars_read), false);
            }
            harness.debug("");
            harness.check(lnr.getLineNumber(), 3, "getLineNumber - second test");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            str = "Exiting off the expressway in Chicago is not an easy\nthing to do.  For example, at Fullerton you have to run a\ngauntlet of people selling flowers, begging for money, or trying\nto 'clean' your windshield for tips.";
            sbr = new StringReader(str);
            lnr = new LineNumberReader(sbr);
            buf = new char[80];
            String line = lnr.readLine();
            lnr.mark(80);
            lnr.skip(14L);
            char[] buf2 = new char[3];
            lnr.read(buf2, 0, 3);
            String b2 = new String(buf2);
            harness.check(b2, "For", "skip(), read(buf, off, len)");
            lnr.reset();
            char[] buf3 = new char[5];
            lnr.read(buf3, 0, 5);
            String b3 = new String(buf3);
            harness.check(b3, "thing", "mark(), reset()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            str = "One\r\r\r\rTwo\n\n\n\nThree\r\n\r\n\r\n";
            sbr = new StringReader(str);
            lnr = new LineNumberReader(sbr);
            int c = lnr.read();
            while (c != -1) {
                c = lnr.read();
            }
            harness.check(lnr.getLineNumber(), 11, "One, Two, Three makes 11");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false, "One, Two, Three makes 11");
        }
    }
}

