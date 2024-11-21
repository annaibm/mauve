/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ProcessBuilder.classInfo;

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
        testedMethods_jdk6.put("public java.lang.Process java.lang.ProcessBuilder.start() throws java.io.IOException", "start");
        testedMethods_jdk6.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.command(java.util.List)", "command");
        testedMethods_jdk6.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.command(java.lang.String[])", "command");
        testedMethods_jdk6.put("public java.util.List java.lang.ProcessBuilder.command()", "command");
        testedMethods_jdk6.put("public java.util.Map java.lang.ProcessBuilder.environment()", "environment");
        testedMethods_jdk6.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.directory(java.io.File)", "directory");
        testedMethods_jdk6.put("public java.io.File java.lang.ProcessBuilder.directory()", "directory");
        testedMethods_jdk6.put("public boolean java.lang.ProcessBuilder.redirectErrorStream()", "redirectErrorStream");
        testedMethods_jdk6.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectErrorStream(boolean)", "redirectErrorStream");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public java.lang.String java.lang.Object.toString()", "toString");
        testedMethods_jdk6.put("public int java.lang.Object.hashCode()", "hashCode");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public java.lang.Process java.lang.ProcessBuilder.start() throws java.io.IOException", "start");
        testedMethods_jdk7.put("public java.io.File java.lang.ProcessBuilder.directory()", "directory");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.directory(java.io.File)", "directory");
        testedMethods_jdk7.put("public java.util.Map java.lang.ProcessBuilder.environment()", "environment");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.command(java.util.List)", "command");
        testedMethods_jdk7.put("public java.util.List java.lang.ProcessBuilder.command()", "command");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.command(java.lang.String[])", "command");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.inheritIO()", "inheritIO");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectError(java.io.File)", "redirectError");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder$Redirect java.lang.ProcessBuilder.redirectError()", "redirectError");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectError(java.lang.ProcessBuilder$Redirect)", "redirectError");
        testedMethods_jdk7.put("public boolean java.lang.ProcessBuilder.redirectErrorStream()", "redirectErrorStream");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectErrorStream(boolean)", "redirectErrorStream");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectInput(java.io.File)", "redirectInput");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder$Redirect java.lang.ProcessBuilder.redirectInput()", "redirectInput");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectInput(java.lang.ProcessBuilder$Redirect)", "redirectInput");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectOutput(java.io.File)", "redirectOutput");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectOutput(java.lang.ProcessBuilder$Redirect)", "redirectOutput");
        testedMethods_jdk7.put("public java.lang.ProcessBuilder$Redirect java.lang.ProcessBuilder.redirectOutput()", "redirectOutput");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public java.lang.String java.lang.Object.toString()", "toString");
        testedMethods_jdk7.put("public int java.lang.Object.hashCode()", "hashCode");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        ProcessBuilder o = new ProcessBuilder("");
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

