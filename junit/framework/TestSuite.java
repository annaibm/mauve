/*
 * Decompiled with CFR 0.152.
 */
package junit.framework;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;

public class TestSuite
implements Test,
Testlet {
    private String fName;
    private Vector<Test> fTests;

    public TestSuite() {
        this.fTests = new Vector();
    }

    public TestSuite(Class<?> theClass) {
        this();
        this.fName = theClass.getName();
        Class<?> clazz = theClass;
        ArrayList<String> names = new ArrayList<String>();
        while (Test.class.isAssignableFrom(clazz)) {
            Method[] methods = clazz.getDeclaredMethods();
            for (int i = 0; i < methods.length; ++i) {
                this.addTestMethod(methods[i], names, theClass);
            }
            clazz = clazz.getSuperclass();
        }
    }

    public TestSuite(String name2) {
        this.setName(name2);
    }

    public TestSuite(Class<?> theClass, String name2) {
        this(theClass);
        this.setName(name2);
    }

    private void addTestMethod(Method method, List<String> names, Class<?> theClass) {
        String name2 = method.getName();
        if (!names.contains(name2) && this.isPublicTestMethod(method)) {
            names.add(name2);
            this.addTest(TestSuite.createTest(theClass, name2));
        }
    }

    private boolean isPublicTestMethod(Method method) {
        return this.isTestMethod(method) && Modifier.isPublic(method.getModifiers());
    }

    private boolean isTestMethod(Method method) {
        String name2 = method.getName();
        Class<?>[] params = method.getParameterTypes();
        Class<?> ret = method.getReturnType();
        return params.length == 0 && name2.startsWith("test") && ret.equals(Void.TYPE);
    }

    public static Test createTest(Class<?> theClass, String name2) {
        Constructor<?> constructor2 = null;
        Test test = null;
        try {
            constructor2 = TestSuite.getTestConstructor(theClass);
        }
        catch (NoSuchMethodException ex) {
            test = null;
        }
        if (constructor2 != null) {
            Object o = null;
            try {
                if (constructor2.getParameterTypes().length == 0) {
                    o = constructor2.newInstance(new Object[0]);
                    if (o instanceof TestCase) {
                        ((TestCase)o).setName(name2);
                    }
                } else {
                    o = constructor2.newInstance(name2);
                }
            }
            catch (InstantiationException ex) {
                test = null;
            }
            catch (InvocationTargetException ex) {
                test = null;
            }
            catch (IllegalAccessException ex) {
                test = null;
            }
            test = o;
        }
        return test;
    }

    public static Constructor<?> getTestConstructor(Class<?> theClass) throws NoSuchMethodException {
        try {
            return theClass.getConstructor(String.class);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return theClass.getConstructor(new Class[0]);
        }
    }

    @Override
    public int countTestCases() {
        int count = 0;
        for (Test test : this.fTests) {
            count += test.countTestCases();
        }
        return count;
    }

    @Override
    public void run(TestResult result) {
        Iterator<Test> i = this.fTests.iterator();
        while (i.hasNext()) {
            if (result.shouldStop()) continue;
            Test test = i.next();
            this.runTest(test, result);
        }
    }

    public void runTest(Test test, TestResult result) {
        test.run(result);
    }

    public void addTest(Test test) {
        this.fTests.add(test);
    }

    public void addTestSuite(Class<?> testClass) {
        this.fTests.add(new TestSuite(testClass));
    }

    public void setName(String name2) {
        this.fName = name2;
    }

    public String getName() {
        return this.fName;
    }

    @Override
    public void test(TestHarness harness) {
        for (Test test : this.fTests) {
            if (test instanceof TestCase) {
                ((TestCase)test).testSingle(harness);
                continue;
            }
            if (!(test instanceof Testlet)) continue;
            ((Testlet)((Object)test)).test(harness);
        }
    }
}

