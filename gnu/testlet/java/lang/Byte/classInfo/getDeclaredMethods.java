/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte.classInfo;

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
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Byte.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Byte.toString()", "toString");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Byte.toString(byte)", "toString");
        testedDeclaredMethods_jdk6.put("public int java.lang.Byte.hashCode()", "hashCode");
        testedDeclaredMethods_jdk6.put("public int java.lang.Byte.compareTo(java.lang.Byte)", "compareTo");
        testedDeclaredMethods_jdk6.put("public int java.lang.Byte.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk6.put("public byte java.lang.Byte.byteValue()", "byteValue");
        testedDeclaredMethods_jdk6.put("public short java.lang.Byte.shortValue()", "shortValue");
        testedDeclaredMethods_jdk6.put("public int java.lang.Byte.intValue()", "intValue");
        testedDeclaredMethods_jdk6.put("public long java.lang.Byte.longValue()", "longValue");
        testedDeclaredMethods_jdk6.put("public float java.lang.Byte.floatValue()", "floatValue");
        testedDeclaredMethods_jdk6.put("public double java.lang.Byte.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk6.put("public static java.lang.Byte java.lang.Byte.valueOf(byte)", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Byte java.lang.Byte.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Byte java.lang.Byte.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Byte java.lang.Byte.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedDeclaredMethods_jdk6.put("public static byte java.lang.Byte.parseByte(java.lang.String,int) throws java.lang.NumberFormatException", "parseByte");
        testedDeclaredMethods_jdk6.put("public static byte java.lang.Byte.parseByte(java.lang.String) throws java.lang.NumberFormatException", "parseByte");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Byte.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Byte.toString()", "toString");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Byte.toString(byte)", "toString");
        testedDeclaredMethods_jdk7.put("public int java.lang.Byte.hashCode()", "hashCode");
        testedDeclaredMethods_jdk7.put("public int java.lang.Byte.compareTo(java.lang.Byte)", "compareTo");
        testedDeclaredMethods_jdk7.put("public int java.lang.Byte.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk7.put("public byte java.lang.Byte.byteValue()", "byteValue");
        testedDeclaredMethods_jdk7.put("public short java.lang.Byte.shortValue()", "shortValue");
        testedDeclaredMethods_jdk7.put("public int java.lang.Byte.intValue()", "intValue");
        testedDeclaredMethods_jdk7.put("public long java.lang.Byte.longValue()", "longValue");
        testedDeclaredMethods_jdk7.put("public float java.lang.Byte.floatValue()", "floatValue");
        testedDeclaredMethods_jdk7.put("public double java.lang.Byte.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk7.put("public static java.lang.Byte java.lang.Byte.valueOf(byte)", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.Byte java.lang.Byte.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.Byte java.lang.Byte.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Byte.compare(byte,byte)", "compare");
        testedDeclaredMethods_jdk7.put("public static java.lang.Byte java.lang.Byte.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedDeclaredMethods_jdk7.put("public static byte java.lang.Byte.parseByte(java.lang.String) throws java.lang.NumberFormatException", "parseByte");
        testedDeclaredMethods_jdk7.put("public static byte java.lang.Byte.parseByte(java.lang.String,int) throws java.lang.NumberFormatException", "parseByte");
        Byte o = new Byte(42);
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

