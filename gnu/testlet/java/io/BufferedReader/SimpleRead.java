/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            int chars_read;
            String str = "My 5th grade teacher was named Mr. Thompson.  Terry\nGeorge Thompson to be precise.  He had these sideburns like\nIsaac Asimov's, only uglier.  One time he had a contest and said\nthat if any kid who could lift 50lbs worth of weights on a barbell\nall the way over their head, he would shave it off.  Nobody could\nthough.  One time I guess I made a comment about how stupid his\nsideburns worked and he not only kicked me out of class, he called\nmy mother.  Jerk.\n";
            StringReader sr = new StringReader(str);
            BufferedReader br = new BufferedReader(sr, 15);
            char[] buf = new char[12];
            int total_read = 0;
            while ((chars_read = br.read(buf)) != -1) {
                harness.debug(new String(buf, 0, chars_read), false);
                total_read += chars_read;
            }
            br.close();
            harness.check(total_read, str.length(), "total_read");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

