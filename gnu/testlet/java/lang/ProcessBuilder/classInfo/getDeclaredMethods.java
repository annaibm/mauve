/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ProcessBuilder.classInfo;

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
        testedDeclaredMethods_jdk6.put("public java.lang.Process java.lang.ProcessBuilder.start() throws java.io.IOException", "start");
        testedDeclaredMethods_jdk6.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.command(java.util.List)", "command");
        testedDeclaredMethods_jdk6.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.command(java.lang.String[])", "command");
        testedDeclaredMethods_jdk6.put("public java.util.List java.lang.ProcessBuilder.command()", "command");
        testedDeclaredMethods_jdk6.put("java.lang.ProcessBuilder java.lang.ProcessBuilder.environment(java.lang.String[])", "environment");
        testedDeclaredMethods_jdk6.put("public java.util.Map java.lang.ProcessBuilder.environment()", "environment");
        testedDeclaredMethods_jdk6.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.directory(java.io.File)", "directory");
        testedDeclaredMethods_jdk6.put("public java.io.File java.lang.ProcessBuilder.directory()", "directory");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.ProcessBuilder.redirectErrorStream()", "redirectErrorStream");
        testedDeclaredMethods_jdk6.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectErrorStream(boolean)", "redirectErrorStream");
        testedDeclaredMethods_jdk7.put("public java.lang.Process java.lang.ProcessBuilder.start() throws java.io.IOException", "start");
        testedDeclaredMethods_jdk7.put("public java.io.File java.lang.ProcessBuilder.directory()", "directory");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.directory(java.io.File)", "directory");
        testedDeclaredMethods_jdk7.put("public java.util.Map java.lang.ProcessBuilder.environment()", "environment");
        testedDeclaredMethods_jdk7.put("java.lang.ProcessBuilder java.lang.ProcessBuilder.environment(java.lang.String[])", "environment");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.command(java.util.List)", "command");
        testedDeclaredMethods_jdk7.put("public java.util.List java.lang.ProcessBuilder.command()", "command");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.command(java.lang.String[])", "command");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.inheritIO()", "inheritIO");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectError(java.io.File)", "redirectError");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder$Redirect java.lang.ProcessBuilder.redirectError()", "redirectError");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectError(java.lang.ProcessBuilder$Redirect)", "redirectError");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.ProcessBuilder.redirectErrorStream()", "redirectErrorStream");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectErrorStream(boolean)", "redirectErrorStream");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectInput(java.io.File)", "redirectInput");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder$Redirect java.lang.ProcessBuilder.redirectInput()", "redirectInput");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectInput(java.lang.ProcessBuilder$Redirect)", "redirectInput");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectOutput(java.io.File)", "redirectOutput");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder java.lang.ProcessBuilder.redirectOutput(java.lang.ProcessBuilder$Redirect)", "redirectOutput");
        testedDeclaredMethods_jdk7.put("public java.lang.ProcessBuilder$Redirect java.lang.ProcessBuilder.redirectOutput()", "redirectOutput");
        testedDeclaredMethods_jdk7.put("private java.lang.ProcessBuilder$Redirect[] java.lang.ProcessBuilder.redirects()", "redirects");
        ProcessBuilder o = new ProcessBuilder("");
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

