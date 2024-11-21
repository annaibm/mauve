/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassCastException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.util.HashMap;

public class getMethods
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedMethods = null;
        HashMap<String, String> testedMethods_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedMethods_jdk7 = new HashMap<String, String>();
        testedMethods_jdk6.put("public void java.lang.Throwable.printStackTrace()", "printStackTrace");
        testedMethods_jdk6.put("public void java.lang.Throwable.printStackTrace(java.io.PrintStream)", "printStackTrace");
        testedMethods_jdk6.put("public void java.lang.Throwable.printStackTrace(java.io.PrintWriter)", "printStackTrace");
        testedMethods_jdk6.put("public synchronized java.lang.Throwable java.lang.Throwable.fillInStackTrace()", "fillInStackTrace");
        testedMethods_jdk6.put("public java.lang.Throwable java.lang.Throwable.getCause()", "getCause");
        testedMethods_jdk6.put("public synchronized java.lang.Throwable java.lang.Throwable.initCause(java.lang.Throwable)", "initCause");
        testedMethods_jdk6.put("public java.lang.String java.lang.Throwable.toString()", "toString");
        testedMethods_jdk6.put("public java.lang.String java.lang.Throwable.getMessage()", "getMessage");
        testedMethods_jdk6.put("public java.lang.String java.lang.Throwable.getLocalizedMessage()", "getLocalizedMessage");
        testedMethods_jdk6.put("public java.lang.StackTraceElement[] java.lang.Throwable.getStackTrace()", "getStackTrace");
        testedMethods_jdk6.put("public void java.lang.Throwable.setStackTrace(java.lang.StackTraceElement[])", "setStackTrace");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public int java.lang.Object.hashCode()", "hashCode");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public void java.lang.Throwable.printStackTrace()", "printStackTrace");
        testedMethods_jdk7.put("public void java.lang.Throwable.printStackTrace(java.io.PrintWriter)", "printStackTrace");
        testedMethods_jdk7.put("public void java.lang.Throwable.printStackTrace(java.io.PrintStream)", "printStackTrace");
        testedMethods_jdk7.put("public synchronized java.lang.Throwable java.lang.Throwable.fillInStackTrace()", "fillInStackTrace");
        testedMethods_jdk7.put("public synchronized java.lang.Throwable java.lang.Throwable.getCause()", "getCause");
        testedMethods_jdk7.put("public synchronized java.lang.Throwable java.lang.Throwable.initCause(java.lang.Throwable)", "initCause");
        testedMethods_jdk7.put("public java.lang.String java.lang.Throwable.toString()", "toString");
        testedMethods_jdk7.put("public java.lang.String java.lang.Throwable.getMessage()", "getMessage");
        testedMethods_jdk7.put("public java.lang.String java.lang.Throwable.getLocalizedMessage()", "getLocalizedMessage");
        testedMethods_jdk7.put("public java.lang.StackTraceElement[] java.lang.Throwable.getStackTrace()", "getStackTrace");
        testedMethods_jdk7.put("public void java.lang.Throwable.setStackTrace(java.lang.StackTraceElement[])", "setStackTrace");
        testedMethods_jdk7.put("public final synchronized void java.lang.Throwable.addSuppressed(java.lang.Throwable)", "addSuppressed");
        testedMethods_jdk7.put("public final synchronized java.lang.Throwable[] java.lang.Throwable.getSuppressed()", "getSuppressed");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public int java.lang.Object.hashCode()", "hashCode");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        ClassCastException o = new ClassCastException("java.lang.ClassCastException");
        Class<?> c = o.getClass();
        testedMethods = this.getJavaVersion() < 7 ? testedMethods_jdk6 : testedMethods_jdk7;
        Method[] methods = c.getMethods();
        int expectedNumberOfMethods = testedMethods.size();
        harness.check(methods.length, expectedNumberOfMethods);
        for (Method method : methods) {
            String methodName = method.getName();
            String methodString = method.toString().replaceAll(" native ", " ");
            harness.check(testedMethods.containsKey(methodString));
            harness.check(testedMethods.get(methodString), (Object)methodName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

