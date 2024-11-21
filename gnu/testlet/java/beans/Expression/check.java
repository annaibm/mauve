/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.Expression;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.Expression;

public class check
implements Testlet {
    public static int x = 0;

    public static int test1(int y) {
        x = y;
        return x;
    }

    @Override
    public void test(TestHarness harness) {
        dummy d = new dummy();
        Object[] arg1 = new Object[]{"test"};
        Expression expr = new Expression(d, "method", arg1);
        harness.check(expr != null, "Construct an Expression");
        harness.check(expr.getTarget() == d);
        harness.check(expr.getMethodName().equals("method"));
        String res1 = "";
        try {
            res1 = (String)expr.getValue();
        }
        catch (Exception e) {
            harness.fail("Expression getValue failed");
        }
        harness.check(d.s.equals("test"), "Test getValue with method of single arg");
        harness.check(d.x == 5);
        harness.check(res1.equals("test 5"));
        Object[] arg2 = new Object[]{"test", new Integer(6)};
        expr = new Expression(d, "method", arg2);
        harness.check(expr != null, "Construct an Expression with 2 args");
        Object[] exprArgs = expr.getArguments();
        harness.check(exprArgs.length == arg2.length && exprArgs[0] == arg2[0] && exprArgs[1] == arg2[1]);
        String res2 = "";
        try {
            res2 = (String)expr.getValue();
        }
        catch (Exception e) {
            harness.fail("Expression getValue failed");
        }
        harness.check(d.s.equals("test"), "Test getValue with method of single arg");
        harness.check(d.x == 7);
        harness.check(res2.equals("test 7"));
        Object[] arg3 = new Object[]{new Integer(1)};
        expr = new Expression(this, "test1", arg3);
        int res3 = 0;
        try {
            res3 = (Integer)expr.getValue();
        }
        catch (Exception e) {
            harness.fail("Static method getValue " + e.toString());
        }
        harness.check(res3 == 1, "Test Expression with static method");
        int[] iarray = new int[]{1, 2, 3, 4, 5};
        Object[] arg4 = new Object[]{new Integer(2), new Integer(6)};
        expr = new Expression(iarray, "set", arg4);
        Object res4 = new Object();
        try {
            res4 = expr.getValue();
        }
        catch (Exception e) {
            harness.fail("Expression set failed");
        }
        harness.check(res4 == null);
        harness.check(iarray[2] == 6);
        Object[] arg5 = new Object[]{new Integer(2)};
        expr = new Expression(iarray, "get", arg5);
        int res5 = 0;
        try {
            res5 = (Integer)expr.getValue();
        }
        catch (Exception e) {
            harness.fail("Expression get failed");
        }
        harness.check(res5 == 6, "Test Expression of array and method named get");
        Object[] arg6 = new Object[]{this};
        expr = new Expression(d.getClass(), "new", arg6);
        dummy d1 = null;
        try {
            d1 = (dummy)expr.getValue();
        }
        catch (Exception e) {
            harness.debug(e);
            harness.fail("Expression using new failed");
        }
        harness.check(d1 != d, "Test expr using new");
        expr = new Expression(d, d, "new", arg6);
        d1 = null;
        try {
            d1 = (dummy)expr.getValue();
        }
        catch (Exception e) {
            harness.fail("Constructor failed");
        }
        harness.check(d1 == d, "Test expr constructor with value");
        String s1 = "t";
        expr.setValue(s1);
        String s2 = "";
        try {
            s2 = (String)expr.getValue();
        }
        catch (Exception e) {
            harness.fail("Constructor failed");
        }
        harness.check(s1 == s2, "Test expr setValue and getValue");
        String s3 = expr.toString();
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

