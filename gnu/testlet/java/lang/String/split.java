/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class split
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String[] s2;
        String[] s1;
        String fullPath = "test.txt";
        String text2 = "A\tB\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tC\nA\t\tB\t\t\t\t\t\t\t\t\tC\t\n";
        try {
            StringReader sr = new StringReader(text2);
            BufferedReader r = new BufferedReader(sr);
            String row1 = r.readLine();
            s1 = row1.split("\t");
            String row2 = r.readLine();
            s2 = row2.split("\t");
            r.close();
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.check(false, ioe.toString());
            return;
        }
        harness.check(s1.length, 18);
        harness.check(s1[0], (Object)"A");
        harness.check(s1[1], (Object)"B");
        harness.check(s1[2], (Object)"");
        harness.check(s1[3], (Object)"");
        harness.check(s1[4], (Object)"");
        harness.check(s1[5], (Object)"");
        harness.check(s1[6], (Object)"");
        harness.check(s1[7], (Object)"");
        harness.check(s1[8], (Object)"");
        harness.check(s1[9], (Object)"");
        harness.check(s1[10], (Object)"");
        harness.check(s1[11], (Object)"");
        harness.check(s1[12], (Object)"");
        harness.check(s1[13], (Object)"");
        harness.check(s1[14], (Object)"");
        harness.check(s1[15], (Object)"");
        harness.check(s1[16], (Object)"");
        harness.check(s1[17], (Object)"C");
        harness.check(s2.length, 12);
        harness.check(s2[0], (Object)"A");
        harness.check(s2[1], (Object)"");
        harness.check(s2[2], (Object)"B");
        harness.check(s2[3], (Object)"");
        harness.check(s2[4], (Object)"");
        harness.check(s2[5], (Object)"");
        harness.check(s2[6], (Object)"");
        harness.check(s2[7], (Object)"");
        harness.check(s2[8], (Object)"");
        harness.check(s2[9], (Object)"");
        harness.check(s2[10], (Object)"");
        harness.check(s2[11], (Object)"C");
        String[] s3 = "hello, world".split("\uffff");
        harness.check(s3.length, 1);
        harness.check(s3[0], (Object)"hello, world");
    }
}

