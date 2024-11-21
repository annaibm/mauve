/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.AssertionError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class getMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> methodsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk6.put("printStackTrace", new Class[0]);
        methodsThatShouldExist_jdk6.put("printStackTrace", new Class[]{PrintStream.class});
        methodsThatShouldExist_jdk6.put("printStackTrace", new Class[]{PrintWriter.class});
        methodsThatShouldExist_jdk6.put("fillInStackTrace", new Class[0]);
        methodsThatShouldExist_jdk6.put("getCause", new Class[0]);
        methodsThatShouldExist_jdk6.put("initCause", new Class[]{Throwable.class});
        methodsThatShouldExist_jdk6.put("toString", new Class[0]);
        methodsThatShouldExist_jdk6.put("getMessage", new Class[0]);
        methodsThatShouldExist_jdk6.put("getLocalizedMessage", new Class[0]);
        methodsThatShouldExist_jdk6.put("getStackTrace", new Class[0]);
        methodsThatShouldExist_jdk6.put("setStackTrace", new Class[]{new StackTraceElement[0].getClass()});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("wait", new Class[0]);
        methodsThatShouldExist_jdk6.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk6.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk6.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("notify", new Class[0]);
        methodsThatShouldExist_jdk6.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("printStackTrace", new Class[0]);
        methodsThatShouldExist_jdk7.put("printStackTrace", new Class[]{PrintWriter.class});
        methodsThatShouldExist_jdk7.put("printStackTrace", new Class[]{PrintStream.class});
        methodsThatShouldExist_jdk7.put("fillInStackTrace", new Class[0]);
        methodsThatShouldExist_jdk7.put("getCause", new Class[0]);
        methodsThatShouldExist_jdk7.put("initCause", new Class[]{Throwable.class});
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("getMessage", new Class[0]);
        methodsThatShouldExist_jdk7.put("getLocalizedMessage", new Class[0]);
        methodsThatShouldExist_jdk7.put("getStackTrace", new Class[0]);
        methodsThatShouldExist_jdk7.put("setStackTrace", new Class[]{new StackTraceElement[0].getClass()});
        methodsThatShouldExist_jdk7.put("addSuppressed", new Class[]{Throwable.class});
        methodsThatShouldExist_jdk7.put("getSuppressed", new Class[0]);
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[]{Long.TYPE});
        methodsThatShouldExist_jdk7.put("wait", new Class[0]);
        methodsThatShouldExist_jdk7.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk7.put("getClass", new Class[0]);
        methodsThatShouldExist_jdk7.put("notify", new Class[0]);
        methodsThatShouldExist_jdk7.put("notifyAll", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        AssertionError o = new AssertionError();
        Class<?> c = o.getClass();
        for (Map.Entry methodThatShouldExists : methodsThatShouldExist.entrySet()) {
            try {
                Method method = c.getMethod((String)methodThatShouldExists.getKey(), (Class[])methodThatShouldExists.getValue());
                harness.check(method != null);
                String methodName = method.getName();
                harness.check(methodName != null);
                harness.check(methodName, methodThatShouldExists.getKey());
            }
            catch (Exception e) {
                harness.check(false);
            }
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

