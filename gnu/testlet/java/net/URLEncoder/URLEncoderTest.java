/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLEncoder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.URLEncoder;

public class URLEncoderTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        String str1 = URLEncoder.encode("abcdefghijklmnopqrstuvwxyz");
        harness.check(str1, "abcdefghijklmnopqrstuvwxyz", "Error : test_Basics - 1  String returned is not encoded properly");
        String str2 = URLEncoder.encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        harness.check(str2, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "Error : test_Basics - 2  String returned is not encoded properly");
        String str3 = URLEncoder.encode("hi there buddy");
        harness.check(str3, "hi+there+buddy", "Error : test_Basics - 3  String returned is not encoded properly");
        String str4 = URLEncoder.encode("0123456789:;<");
        harness.check(str4, "0123456789%3A%3B%3C", "Error : test_Basics - 4  String returned is not encoded properly");
        String str5 = URLEncoder.encode("\n");
        harness.check(str5, "%0A", "test encoding of \\n");
    }

    public void testall() {
        this.test_Basics();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

