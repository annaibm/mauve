/*
 * Decompiled with CFR 0.152.
 */
package junit.framework;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public abstract class TestCase
extends Assert
implements Test,
Testlet {
    private String fName;

    public TestCase() {
        this.fName = null;
    }

    public TestCase(String name2) {
        this.fName = name2;
    }

    @Override
    public int countTestCases() {
        return 1;
    }

    protected TestResult createResult() {
        return new TestResult();
    }

    public TestResult run() {
        TestResult result = this.createResult();
        this.run(result);
        return result;
    }

    @Override
    public void run(TestResult result) {
        result.run(this);
    }

    public void runBare() throws Throwable {
        Throwable t = null;
        this.setUp();
        try {
            this.runTest();
        }
        catch (Throwable ex) {
            t = ex;
        }
        finally {
            block13: {
                try {
                    this.tearDown();
                }
                catch (Throwable ex2) {
                    if (t != null) break block13;
                    t = ex2;
                }
            }
        }
        if (t != null) {
            throw t;
        }
    }

    protected void runTest() throws Throwable {
        Method method = null;
        try {
            method = this.getClass().getMethod(this.fName, null);
        }
        catch (NoSuchMethodException ex) {
            TestCase.fail("Method " + this.fName + " not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            TestCase.fail("Method " + this.fName + " must be public");
        }
        try {
            method.invoke((Object)this, new Object[0]);
        }
        catch (InvocationTargetException ex) {
            ex.fillInStackTrace();
            throw ex.getTargetException();
        }
        catch (IllegalAccessException ex) {
            ex.fillInStackTrace();
            throw ex;
        }
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public String getName() {
        return this.fName;
    }

    public void setName(String name2) {
        this.fName = name2;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append(this.getName());
        str.append('(');
        str.append(this.getClass().getName());
        str.append(')');
        return str.toString();
    }

    @Override
    public void test(TestHarness harness) {
        Test test = this.getTest();
        if (test instanceof TestSuite) {
            TestSuite suite = (TestSuite)test;
            suite.test(harness);
        }
    }

    void testSingle(TestHarness harness) {
        TestCase.harness = harness;
        try {
            this.runBare();
        }
        catch (Throwable ex) {
            harness.fail(ex.getMessage());
            harness.debug(ex);
        }
        TestCase.harness = null;
    }

    private Test getTest() {
        Class<?> clazz = this.getClass();
        Method suiteMethod = null;
        Test test = null;
        try {
            suiteMethod = clazz.getMethod("suite", new Class[0]);
        }
        catch (Exception ex) {
            test = new TestSuite(clazz);
        }
        if (test == null && suiteMethod != null) {
            try {
                test = (Test)suiteMethod.invoke(null, (Object[])new Class[0]);
            }
            catch (InvocationTargetException ex) {
                test = null;
            }
            catch (IllegalAccessException ex) {
                test = null;
            }
        }
        return test;
    }
}

