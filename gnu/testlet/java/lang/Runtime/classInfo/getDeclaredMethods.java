/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Runtime.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.util.HashMap;

public class getDeclaredMethods
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredMethods = null;
        HashMap<String, String> testedDeclaredMethods_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedDeclaredMethods_jdk7 = new HashMap<String, String>();
        testedDeclaredMethods_jdk6.put("public void java.lang.Runtime.exit(int)", "exit");
        testedDeclaredMethods_jdk6.put("public void java.lang.Runtime.runFinalization()", "runFinalization");
        testedDeclaredMethods_jdk6.put("public static void java.lang.Runtime.runFinalizersOnExit(boolean)", "runFinalizersOnExit");
        testedDeclaredMethods_jdk6.put("public void java.lang.Runtime.loadLibrary(java.lang.String)", "loadLibrary");
        testedDeclaredMethods_jdk6.put("synchronized void java.lang.Runtime.loadLibrary0(java.lang.Class,java.lang.String)", "loadLibrary0");
        testedDeclaredMethods_jdk6.put("public void java.lang.Runtime.load(java.lang.String)", "load");
        testedDeclaredMethods_jdk6.put("public void java.lang.Runtime.gc()", "gc");
        testedDeclaredMethods_jdk6.put("public static java.lang.Runtime java.lang.Runtime.getRuntime()", "getRuntime");
        testedDeclaredMethods_jdk6.put("synchronized void java.lang.Runtime.load0(java.lang.Class,java.lang.String)", "load0");
        testedDeclaredMethods_jdk6.put("public long java.lang.Runtime.freeMemory()", "freeMemory");
        testedDeclaredMethods_jdk6.put("public long java.lang.Runtime.maxMemory()", "maxMemory");
        testedDeclaredMethods_jdk6.put("private static void java.lang.Runtime.runFinalization0()", "runFinalization0");
        testedDeclaredMethods_jdk6.put("public long java.lang.Runtime.totalMemory()", "totalMemory");
        testedDeclaredMethods_jdk6.put("public void java.lang.Runtime.addShutdownHook(java.lang.Thread)", "addShutdownHook");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Runtime.removeShutdownHook(java.lang.Thread)", "removeShutdownHook");
        testedDeclaredMethods_jdk6.put("public void java.lang.Runtime.halt(int)", "halt");
        testedDeclaredMethods_jdk6.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String[]) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk6.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk6.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String,java.lang.String[],java.io.File) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk6.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String,java.lang.String[]) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk6.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String[],java.lang.String[],java.io.File) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk6.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String[],java.lang.String[]) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk6.put("public int java.lang.Runtime.availableProcessors()", "availableProcessors");
        testedDeclaredMethods_jdk6.put("public void java.lang.Runtime.traceInstructions(boolean)", "traceInstructions");
        testedDeclaredMethods_jdk6.put("public void java.lang.Runtime.traceMethodCalls(boolean)", "traceMethodCalls");
        testedDeclaredMethods_jdk6.put("public java.io.InputStream java.lang.Runtime.getLocalizedInputStream(java.io.InputStream)", "getLocalizedInputStream");
        testedDeclaredMethods_jdk6.put("public java.io.OutputStream java.lang.Runtime.getLocalizedOutputStream(java.io.OutputStream)", "getLocalizedOutputStream");
        testedDeclaredMethods_jdk7.put("public void java.lang.Runtime.exit(int)", "exit");
        testedDeclaredMethods_jdk7.put("public void java.lang.Runtime.runFinalization()", "runFinalization");
        testedDeclaredMethods_jdk7.put("public static void java.lang.Runtime.runFinalizersOnExit(boolean)", "runFinalizersOnExit");
        testedDeclaredMethods_jdk7.put("public void java.lang.Runtime.load(java.lang.String)", "load");
        testedDeclaredMethods_jdk7.put("public void java.lang.Runtime.loadLibrary(java.lang.String)", "loadLibrary");
        testedDeclaredMethods_jdk7.put("synchronized void java.lang.Runtime.loadLibrary0(java.lang.Class,java.lang.String)", "loadLibrary0");
        testedDeclaredMethods_jdk7.put("public void java.lang.Runtime.gc()", "gc");
        testedDeclaredMethods_jdk7.put("public static java.lang.Runtime java.lang.Runtime.getRuntime()", "getRuntime");
        testedDeclaredMethods_jdk7.put("synchronized void java.lang.Runtime.load0(java.lang.Class,java.lang.String)", "load0");
        testedDeclaredMethods_jdk7.put("public long java.lang.Runtime.freeMemory()", "freeMemory");
        testedDeclaredMethods_jdk7.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String[]) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk7.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk7.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String,java.lang.String[]) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk7.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String[],java.lang.String[],java.io.File) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk7.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String,java.lang.String[],java.io.File) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk7.put("public java.lang.Process java.lang.Runtime.exec(java.lang.String[],java.lang.String[]) throws java.io.IOException", "exec");
        testedDeclaredMethods_jdk7.put("public long java.lang.Runtime.maxMemory()", "maxMemory");
        testedDeclaredMethods_jdk7.put("public void java.lang.Runtime.addShutdownHook(java.lang.Thread)", "addShutdownHook");
        testedDeclaredMethods_jdk7.put("public int java.lang.Runtime.availableProcessors()", "availableProcessors");
        testedDeclaredMethods_jdk7.put("public java.io.InputStream java.lang.Runtime.getLocalizedInputStream(java.io.InputStream)", "getLocalizedInputStream");
        testedDeclaredMethods_jdk7.put("public java.io.OutputStream java.lang.Runtime.getLocalizedOutputStream(java.io.OutputStream)", "getLocalizedOutputStream");
        testedDeclaredMethods_jdk7.put("public void java.lang.Runtime.halt(int)", "halt");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Runtime.removeShutdownHook(java.lang.Thread)", "removeShutdownHook");
        testedDeclaredMethods_jdk7.put("private static void java.lang.Runtime.runFinalization0()", "runFinalization0");
        testedDeclaredMethods_jdk7.put("public long java.lang.Runtime.totalMemory()", "totalMemory");
        testedDeclaredMethods_jdk7.put("public void java.lang.Runtime.traceInstructions(boolean)", "traceInstructions");
        testedDeclaredMethods_jdk7.put("public void java.lang.Runtime.traceMethodCalls(boolean)", "traceMethodCalls");
        Runtime o = Runtime.getRuntime();
        Class<?> c = o.getClass();
        testedDeclaredMethods = this.getJavaVersion() < 7 ? testedDeclaredMethods_jdk6 : testedDeclaredMethods_jdk7;
        Method[] declaredMethods = c.getDeclaredMethods();
        int expectedNumberOfDeclaredMethods = testedDeclaredMethods.size();
        harness.check(declaredMethods.length, expectedNumberOfDeclaredMethods);
        for (Method declaredMethod : declaredMethods) {
            String methodName = declaredMethod.getName();
            String methodString = declaredMethod.toString().replaceAll(" native ", " ");
            harness.check(testedDeclaredMethods.containsKey(methodString));
            harness.check(testedDeclaredMethods.get(methodString), (Object)methodName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

