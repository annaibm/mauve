/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.Connection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TestJdbc
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0, 0, "TRANSACTION_NONE");
        harness.check(1, 1, "TRANSACTION_READ_UNCOMMITTED");
        harness.check(2, 2, "TRANSACTION_READ_COMMITTED");
        harness.check(4, 4, "TRANSACTION_REPEATABLE_READ");
        harness.check(8, 8, "TRANSACTION_SERIALIZABLE");
    }
}

