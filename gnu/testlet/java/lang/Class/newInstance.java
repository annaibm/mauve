/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;

public class newInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean thrown;
        test1.check(harness);
        test2.check(harness);
        test3.check(harness);
        test4.check(harness);
        test5.check(harness);
        newInstance.checkSuccess(harness, test1.class);
        newInstance.checkSuccess(harness, test2.class);
        newInstance.checkSuccess(harness, test3.class);
        newInstance.checkSuccess(harness, test4.class);
        new test5();
        newInstance.checkFail(harness, test5.class);
        newInstance.checkSuccess(harness, test1.inner.class);
        try {
            newInstance.checkFail(harness, Class.forName("gnu.testlet.java.lang.Class.pkg.test1"));
            newInstance.checkSuccess(harness, Class.forName("gnu.testlet.java.lang.Class.pkg.test2"));
            newInstance.checkFail(harness, Class.forName("gnu.testlet.java.lang.Class.pkg.test3"));
            newInstance.checkFail(harness, Class.forName("gnu.testlet.java.lang.Class.pkg.test4"));
        }
        catch (ClassNotFoundException x) {
            harness.debug(x);
            harness.fail("test configuration failure");
        }
        test6.check(harness);
        try {
            Runnable.class.newInstance();
            thrown = false;
        }
        catch (IllegalAccessException iae) {
            thrown = false;
        }
        catch (InstantiationException ie) {
            thrown = true;
        }
        harness.check(thrown);
        try {
            Number.class.newInstance();
            thrown = false;
        }
        catch (IllegalAccessException iae) {
            thrown = false;
        }
        catch (InstantiationException ie) {
            thrown = true;
        }
        harness.check(thrown);
        try {
            new Object[1].getClass().newInstance();
            thrown = false;
        }
        catch (IllegalAccessException iae) {
            thrown = false;
        }
        catch (InstantiationException ie) {
            thrown = true;
        }
        harness.check(thrown);
        try {
            Byte.TYPE.newInstance();
            thrown = false;
        }
        catch (IllegalAccessException iae) {
            thrown = false;
        }
        catch (InstantiationException ie) {
            thrown = true;
        }
        harness.check(thrown);
        try {
            Void.TYPE.newInstance();
            thrown = false;
        }
        catch (IllegalAccessException iae) {
            thrown = false;
        }
        catch (InstantiationException ie) {
            thrown = true;
        }
        harness.check(thrown);
        try {
            Integer.class.newInstance();
            thrown = false;
        }
        catch (IllegalAccessException iae) {
            thrown = false;
        }
        catch (InstantiationException ie) {
            thrown = true;
        }
        harness.check(thrown);
    }

    static void checkSuccess(TestHarness harness, Class c) {
        try {
            harness.check(c.isInstance(c.newInstance()));
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.check(false);
        }
    }

    static void checkFail(TestHarness harness, Class c) {
        try {
            c.newInstance();
            harness.check(false);
        }
        catch (IllegalAccessException x) {
            harness.check(true);
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.check(false);
        }
    }

    public static class test6 {
        public test6() throws IOException {
            throw new IOException("hi bob");
        }

        static void check(TestHarness harness) {
            boolean ok = false;
            try {
                test6.class.newInstance();
            }
            catch (Throwable t) {
                harness.debug(t);
                ok = t instanceof IOException;
            }
            harness.check(ok);
        }
    }

    public static class test5 {
        private test5() {
        }

        static void check(TestHarness harness) {
            try {
                harness.check(test5.class.isInstance(test5.class.newInstance()));
            }
            catch (Throwable t) {
                harness.debug(t);
                harness.check(false);
            }
        }
    }

    public static class test4 {
        test4() {
        }

        static void check(TestHarness harness) {
            try {
                harness.check(test4.class.isInstance(test4.class.newInstance()));
            }
            catch (Throwable t) {
                harness.debug(t);
                harness.check(false);
            }
        }
    }

    static class test3 {
        static void check(TestHarness harness) {
            try {
                harness.check(test3.class.isInstance(test3.class.newInstance()));
            }
            catch (Throwable t) {
                harness.debug(t);
                harness.check(false);
            }
        }
    }

    public static class test2 {
        static void check(TestHarness harness) {
            try {
                harness.check(test2.class.isInstance(test2.class.newInstance()));
            }
            catch (Throwable t) {
                harness.debug(t);
                harness.check(false);
            }
        }
    }

    static class test1 {
        test1() {
        }

        static void check(TestHarness harness) {
            try {
                harness.check(test1.class.isInstance(test1.class.newInstance()));
            }
            catch (Throwable t) {
                harness.debug(t);
                harness.check(false);
            }
        }

        private static class inner {
        }
    }
}

