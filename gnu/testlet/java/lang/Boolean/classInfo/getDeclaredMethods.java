/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean.classInfo;

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
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Boolean.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Boolean.toString()", "toString");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Boolean.toString(boolean)", "toString");
        testedDeclaredMethods_jdk6.put("public int java.lang.Boolean.hashCode()", "hashCode");
        testedDeclaredMethods_jdk6.put("public int java.lang.Boolean.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk6.put("public int java.lang.Boolean.compareTo(java.lang.Boolean)", "compareTo");
        testedDeclaredMethods_jdk6.put("public static boolean java.lang.Boolean.getBoolean(java.lang.String)", "getBoolean");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Boolean.booleanValue()", "booleanValue");
        testedDeclaredMethods_jdk6.put("public static java.lang.Boolean java.lang.Boolean.valueOf(java.lang.String)", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Boolean java.lang.Boolean.valueOf(boolean)", "valueOf");
        testedDeclaredMethods_jdk6.put("public static boolean java.lang.Boolean.parseBoolean(java.lang.String)", "parseBoolean");
        testedDeclaredMethods_jdk6.put("private static boolean java.lang.Boolean.toBoolean(java.lang.String)", "toBoolean");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Boolean.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Boolean.toString(boolean)", "toString");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Boolean.toString()", "toString");
        testedDeclaredMethods_jdk7.put("public int java.lang.Boolean.hashCode()", "hashCode");
        testedDeclaredMethods_jdk7.put("public int java.lang.Boolean.compareTo(java.lang.Boolean)", "compareTo");
        testedDeclaredMethods_jdk7.put("public int java.lang.Boolean.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk7.put("public static boolean java.lang.Boolean.getBoolean(java.lang.String)", "getBoolean");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Boolean.booleanValue()", "booleanValue");
        testedDeclaredMethods_jdk7.put("public static java.lang.Boolean java.lang.Boolean.valueOf(java.lang.String)", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.Boolean java.lang.Boolean.valueOf(boolean)", "valueOf");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Boolean.compare(boolean,boolean)", "compare");
        testedDeclaredMethods_jdk7.put("public static boolean java.lang.Boolean.parseBoolean(java.lang.String)", "parseBoolean");
        testedDeclaredMethods_jdk7.put("private static boolean java.lang.Boolean.toBoolean(java.lang.String)", "toBoolean");
        Boolean o = new Boolean(true);
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

