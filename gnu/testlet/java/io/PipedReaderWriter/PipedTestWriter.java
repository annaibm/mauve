/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PipedReaderWriter;

import gnu.testlet.TestHarness;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.StringReader;

class PipedTestWriter
implements Runnable {
    String str;
    StringReader sbr;
    PipedWriter out;
    TestHarness harness;

    public PipedTestWriter(TestHarness harness) {
        this.harness = harness;
        this.str = "In college, there was a tradition going for a while that people\nwould get together and hang out at Showalter Fountain - in the center\nof Indiana University's campus - around midnight.  It was mostly folks\nfrom the computer lab and just people who liked to use the Forum\nbbs system on the VAX.  IU pulled the plug on the Forum after I left\ndespite its huge popularity.  Now they claim they are just giving\nstudents what they want by cutting deals to make the campus all\nMicrosoft.\n";
        this.sbr = new StringReader(this.str);
        this.out = new PipedWriter();
    }

    public PipedWriter getWriter() {
        return this.out;
    }

    public String getStr() {
        return this.str;
    }

    @Override
    public void run() {
        char[] buf = new char[32];
        try {
            int chars_read;
            int b = this.sbr.read();
            this.out.write(b);
            while ((chars_read = this.sbr.read(buf)) != -1) {
                this.out.write(buf, 0, chars_read);
            }
            this.out.flush();
            this.out.close();
        }
        catch (IOException e) {
            this.harness.debug("In Writer: " + e);
            this.harness.check(false);
        }
    }
}

