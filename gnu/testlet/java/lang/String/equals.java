/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String s1 = "Hello World";
        String s2 = s1.substring(0, 4);
        String s3 = s1.substring(6, 10);
        harness.check(!s1.equals(s2));
        harness.check(!s2.equals(s1));
        harness.check(!s1.equals(s3));
        harness.check(!s3.equals(s1));
        harness.check(!s2.equals(s3));
        harness.check(!s3.equals(s2));
    }
}

