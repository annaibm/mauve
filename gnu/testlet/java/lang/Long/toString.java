/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Long(0L).toString(), (Object)"0");
        harness.check(new Long(-1L).toString(), (Object)"-1");
        harness.check(new Long(1L).toString(), (Object)"1");
        harness.check(new Long(127L).toString(), (Object)"127");
        harness.check(new Long(-128L).toString(), (Object)"-128");
        harness.check(new Long(Integer.MAX_VALUE).toString(), (Object)"2147483647");
        harness.check(new Long(Integer.MIN_VALUE).toString(), (Object)"-2147483648");
        harness.check(new Long(Long.MAX_VALUE).toString(), (Object)"9223372036854775807");
        harness.check(new Long(Long.MIN_VALUE).toString(), (Object)"-9223372036854775808");
        harness.check(Long.toString(0L), (Object)"0");
        harness.check(Long.toString(-1L), (Object)"-1");
        harness.check(Long.toString(1L), (Object)"1");
        harness.check(Long.toString(127L), (Object)"127");
        harness.check(Long.toString(-128L), (Object)"-128");
        harness.check(Long.toString(Integer.MAX_VALUE), (Object)"2147483647");
        harness.check(Long.toString(Integer.MIN_VALUE), (Object)"-2147483648");
        harness.check(Long.toString(Long.MAX_VALUE), (Object)"9223372036854775807");
        harness.check(Long.toString(Long.MIN_VALUE), (Object)"-9223372036854775808");
    }
}

