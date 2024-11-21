/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.DriverManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            DriverManager.getDriver("NoSuchDriver");
            harness.check(false, "getDriver");
        }
        catch (SQLException e) {
            harness.check(true, "getDriver");
        }
    }
}

