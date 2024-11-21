/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.Types;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TestJdbc10
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(-7, -7, "BIT");
        harness.check(-6, -6, "TINYINT");
        harness.check(5, 5, "SMALLINT");
        harness.check(4, 4, "INTEGER");
        harness.check(-5, -5, "BIGINT");
        harness.check(6, 6, "FLOAT");
        harness.check(7, 7, "REAL");
        harness.check(8, 8, "DOUBLE");
        harness.check(2, 2, "NUMERIC");
        harness.check(3, 3, "DECIMAL");
        harness.check(1, 1, "CHAR");
        harness.check(12, 12, "VARCHAR");
        harness.check(-1, -1, "LONGVARCHAR");
        harness.check(91, 91, "DATE");
        harness.check(92, 92, "TIME");
        harness.check(93, 93, "TIMESTAMP");
        harness.check(-2, -2, "BINARY");
        harness.check(-3, -3, "VARBINARY");
        harness.check(-4, -4, "LONGVARBINARY");
        harness.check(0, 0, "NULL");
        harness.check(1111, 1111, "OTHER");
    }
}

