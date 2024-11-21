/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Object.classInfo;

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
        testedDeclaredMethods_jdk6.put("protected void java.lang.Object.finalize() throws java.lang.Throwable", "finalize");
        testedDeclaredMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedDeclaredMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedDeclaredMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Object.toString()", "toString");
        testedDeclaredMethods_jdk6.put("public int java.lang.Object.hashCode()", "hashCode");
        testedDeclaredMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedDeclaredMethods_jdk6.put("protected java.lang.Object java.lang.Object.clone() throws java.lang.CloneNotSupportedException", "clone");
        testedDeclaredMethods_jdk6.put("private static void java.lang.Object.registerNatives()", "registerNatives");
        testedDeclaredMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedDeclaredMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedDeclaredMethods_jdk7.put("protected void java.lang.Object.finalize() throws java.lang.Throwable", "finalize");
        testedDeclaredMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedDeclaredMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedDeclaredMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Object.toString()", "toString");
        testedDeclaredMethods_jdk7.put("public int java.lang.Object.hashCode()", "hashCode");
        testedDeclaredMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedDeclaredMethods_jdk7.put("protected java.lang.Object java.lang.Object.clone() throws java.lang.CloneNotSupportedException", "clone");
        testedDeclaredMethods_jdk7.put("private static void java.lang.Object.registerNatives()", "registerNatives");
        testedDeclaredMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedDeclaredMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        Object o = new Object();
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

