/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Runtime.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class getDeclaredMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> methodsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk6.put("exit", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("runFinalization", new Class[0]);
        methodsThatShouldExist_jdk6.put("runFinalizersOnExit", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk6.put("loadLibrary", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("loadLibrary0", new Class[]{Class.class, String.class});
        methodsThatShouldExist_jdk6.put("load", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("gc", new Class[0]);
        methodsThatShouldExist_jdk6.put("getRuntime", new Class[0]);
        methodsThatShouldExist_jdk6.put("load0", new Class[]{Class.class, String.class});
        methodsThatShouldExist_jdk6.put("freeMemory", new Class[0]);
        methodsThatShouldExist_jdk6.put("maxMemory", new Class[0]);
        methodsThatShouldExist_jdk6.put("runFinalization0", new Class[0]);
        methodsThatShouldExist_jdk6.put("totalMemory", new Class[0]);
        methodsThatShouldExist_jdk6.put("addShutdownHook", new Class[]{Thread.class});
        methodsThatShouldExist_jdk6.put("removeShutdownHook", new Class[]{Thread.class});
        methodsThatShouldExist_jdk6.put("halt", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("exec", new Class[]{new String[0].getClass()});
        methodsThatShouldExist_jdk6.put("exec", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("exec", new Class[]{String.class, new String[0].getClass(), File.class});
        methodsThatShouldExist_jdk6.put("exec", new Class[]{String.class, new String[0].getClass()});
        methodsThatShouldExist_jdk6.put("exec", new Class[]{new String[0].getClass(), new String[0].getClass(), File.class});
        methodsThatShouldExist_jdk6.put("exec", new Class[]{new String[0].getClass(), new String[0].getClass()});
        methodsThatShouldExist_jdk6.put("availableProcessors", new Class[0]);
        methodsThatShouldExist_jdk6.put("traceInstructions", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk6.put("traceMethodCalls", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk6.put("getLocalizedInputStream", new Class[]{InputStream.class});
        methodsThatShouldExist_jdk6.put("getLocalizedOutputStream", new Class[]{OutputStream.class});
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("exit", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("runFinalization", new Class[0]);
        methodsThatShouldExist_jdk7.put("runFinalizersOnExit", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("load", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("loadLibrary", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("loadLibrary0", new Class[]{Class.class, String.class});
        methodsThatShouldExist_jdk7.put("gc", new Class[0]);
        methodsThatShouldExist_jdk7.put("getRuntime", new Class[0]);
        methodsThatShouldExist_jdk7.put("load0", new Class[]{Class.class, String.class});
        methodsThatShouldExist_jdk7.put("freeMemory", new Class[0]);
        methodsThatShouldExist_jdk7.put("exec", new Class[]{new String[0].getClass()});
        methodsThatShouldExist_jdk7.put("exec", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("exec", new Class[]{String.class, new String[0].getClass()});
        methodsThatShouldExist_jdk7.put("exec", new Class[]{new String[0].getClass(), new String[0].getClass(), File.class});
        methodsThatShouldExist_jdk7.put("exec", new Class[]{String.class, new String[0].getClass(), File.class});
        methodsThatShouldExist_jdk7.put("exec", new Class[]{new String[0].getClass(), new String[0].getClass()});
        methodsThatShouldExist_jdk7.put("maxMemory", new Class[0]);
        methodsThatShouldExist_jdk7.put("addShutdownHook", new Class[]{Thread.class});
        methodsThatShouldExist_jdk7.put("availableProcessors", new Class[0]);
        methodsThatShouldExist_jdk7.put("getLocalizedInputStream", new Class[]{InputStream.class});
        methodsThatShouldExist_jdk7.put("getLocalizedOutputStream", new Class[]{OutputStream.class});
        methodsThatShouldExist_jdk7.put("halt", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("removeShutdownHook", new Class[]{Thread.class});
        methodsThatShouldExist_jdk7.put("runFinalization0", new Class[0]);
        methodsThatShouldExist_jdk7.put("totalMemory", new Class[0]);
        methodsThatShouldExist_jdk7.put("traceInstructions", new Class[]{Boolean.TYPE});
        methodsThatShouldExist_jdk7.put("traceMethodCalls", new Class[]{Boolean.TYPE});
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        Runtime o = Runtime.getRuntime();
        Class<?> c = o.getClass();
        for (Map.Entry methodThatShouldExists : methodsThatShouldExist.entrySet()) {
            try {
                Method method = c.getDeclaredMethod((String)methodThatShouldExists.getKey(), (Class[])methodThatShouldExists.getValue());
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

