/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean.classInfo;

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
        testedMethods_jdk6.put("public boolean java.lang.Boolean.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public java.lang.String java.lang.Boolean.toString()", "toString");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Boolean.toString(boolean)", "toString");
        testedMethods_jdk6.put("public int java.lang.Boolean.hashCode()", "hashCode");
        testedMethods_jdk6.put("public int java.lang.Boolean.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk6.put("public int java.lang.Boolean.compareTo(java.lang.Boolean)", "compareTo");
        testedMethods_jdk6.put("public static boolean java.lang.Boolean.getBoolean(java.lang.String)", "getBoolean");
        testedMethods_jdk6.put("public boolean java.lang.Boolean.booleanValue()", "booleanValue");
        testedMethods_jdk6.put("public static java.lang.Boolean java.lang.Boolean.valueOf(java.lang.String)", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Boolean java.lang.Boolean.valueOf(boolean)", "valueOf");
        testedMethods_jdk6.put("public static boolean java.lang.Boolean.parseBoolean(java.lang.String)", "parseBoolean");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public boolean java.lang.Boolean.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Boolean.toString(boolean)", "toString");
        testedMethods_jdk7.put("public java.lang.String java.lang.Boolean.toString()", "toString");
        testedMethods_jdk7.put("public int java.lang.Boolean.hashCode()", "hashCode");
        testedMethods_jdk7.put("public int java.lang.Boolean.compareTo(java.lang.Boolean)", "compareTo");
        testedMethods_jdk7.put("public int java.lang.Boolean.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk7.put("public static boolean java.lang.Boolean.getBoolean(java.lang.String)", "getBoolean");
        testedMethods_jdk7.put("public boolean java.lang.Boolean.booleanValue()", "booleanValue");
        testedMethods_jdk7.put("public static java.lang.Boolean java.lang.Boolean.valueOf(java.lang.String)", "valueOf");
        testedMethods_jdk7.put("public static java.lang.Boolean java.lang.Boolean.valueOf(boolean)", "valueOf");
        testedMethods_jdk7.put("public static int java.lang.Boolean.compare(boolean,boolean)", "compare");
        testedMethods_jdk7.put("public static boolean java.lang.Boolean.parseBoolean(java.lang.String)", "parseBoolean");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        Boolean o = new Boolean(true);
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

