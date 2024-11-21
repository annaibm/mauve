/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.Statement;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.Statement;

public class check
implements Testlet {
    public static int x = 0;

    public static void test1(int y) {
        x = y;
    }

    @Override
    public void test(TestHarness harness) {
        dummy d = new dummy();
        Object[] arg1 = new Object[]{"test"};
        Statement stmt = new Statement(d, "method", arg1);
        harness.check(stmt != null);
        harness.check(stmt.getTarget() == d);
        harness.check(stmt.getMethodName().equals("method"));
        try {
            stmt.execute();
        }
        catch (Exception e) {
            harness.fail("Statement execute");
        }
        harness.check(d.s.equals("test"));
        harness.check(d.x == 5);
        Object[] arg2 = new Object[]{"test", new Integer(6)};
        stmt = new Statement(d, "method", arg2);
        harness.check(stmt != null);
        Object[] stmtArgs = stmt.getArguments();
        harness.check(stmtArgs.length == arg2.length && stmtArgs[0] == arg2[0] && stmtArgs[1] == arg2[1]);
        try {
            stmt.execute();
        }
        catch (Exception e) {
            harness.fail("Statement execute");
        }
        harness.check(d.s.equals("test"));
        harness.check(d.x == 7);
        Object[] arg3 = new Object[]{new Integer(1)};
        stmt = new Statement(this, "test1", arg3);
        try {
            stmt.execute();
        }
        catch (Exception e) {
            harness.fail("Static method execute " + e.toString());
        }
        harness.check(x == 1);
        int[] iarray = new int[]{1, 2, 3, 4, 5};
        Object[] arg4 = new Object[]{new Integer(2), new Integer(6)};
        stmt = new Statement(iarray, "set", arg4);
        try {
            stmt.execute();
        }
        catch (Exception e) {
            harness.fail("Array set");
        }
        Object[] arg5 = new Object[]{new Integer(2)};
        stmt = new Statement(iarray, "get", arg5);
        try {
            stmt.execute();
        }
        catch (Exception e) {
            harness.fail("Array get");
        }
        harness.check(iarray[2] == 6);
    }

    public class dummy {
        public String s = "";
        public int x = 5;

        public String method(String s) {
            this.s = s;
            return this.s + " " + this.x;
        }

        public String method(String s, int y) {
            this.s = s;
            this.x = y + 1;
            return this.s + " " + this.x;
        }

        public String method1(String s, Integer y) {
            this.s = s;
            this.x = y;
            return this.s + " " + this.x;
        }
    }
}

