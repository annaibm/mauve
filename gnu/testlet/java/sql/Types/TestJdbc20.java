/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.Types;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TestJdbc20
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(2000, 2000, "JAVA_OBJECT");
        harness.check(2001, 2001, "DISTINCT");
        harness.check(2002, 2002, "STRUCT");
        harness.check(2003, 2003, "ARRAY");
        harness.check(2004, 2004, "BLOB");
        harness.check(2005, 2005, "CLOB");
        harness.check(2006, 2006, "REF");
    }
}

