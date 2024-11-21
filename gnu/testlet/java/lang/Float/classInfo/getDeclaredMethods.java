/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float.classInfo;

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
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Float.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Float.toString(float)", "toString");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Float.toString()", "toString");
        testedDeclaredMethods_jdk6.put("public int java.lang.Float.hashCode()", "hashCode");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Float.floatToRawIntBits(float)", "floatToRawIntBits");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Float.floatToIntBits(float)", "floatToIntBits");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Float.intBitsToFloat(int)", "intBitsToFloat");
        testedDeclaredMethods_jdk6.put("public int java.lang.Float.compareTo(java.lang.Float)", "compareTo");
        testedDeclaredMethods_jdk6.put("public int java.lang.Float.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk6.put("public byte java.lang.Float.byteValue()", "byteValue");
        testedDeclaredMethods_jdk6.put("public short java.lang.Float.shortValue()", "shortValue");
        testedDeclaredMethods_jdk6.put("public int java.lang.Float.intValue()", "intValue");
        testedDeclaredMethods_jdk6.put("public long java.lang.Float.longValue()", "longValue");
        testedDeclaredMethods_jdk6.put("public float java.lang.Float.floatValue()", "floatValue");
        testedDeclaredMethods_jdk6.put("public double java.lang.Float.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk6.put("public static java.lang.Float java.lang.Float.valueOf(float)", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Float java.lang.Float.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Float.toHexString(float)", "toHexString");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Float.compare(float,float)", "compare");
        testedDeclaredMethods_jdk6.put("public static boolean java.lang.Float.isNaN(float)", "isNaN");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Float.isNaN()", "isNaN");
        testedDeclaredMethods_jdk6.put("public static float java.lang.Float.parseFloat(java.lang.String) throws java.lang.NumberFormatException", "parseFloat");
        testedDeclaredMethods_jdk6.put("public static boolean java.lang.Float.isInfinite(float)", "isInfinite");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Float.isInfinite()", "isInfinite");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Float.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Float.toString(float)", "toString");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Float.toString()", "toString");
        testedDeclaredMethods_jdk7.put("public int java.lang.Float.hashCode()", "hashCode");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Float.floatToRawIntBits(float)", "floatToRawIntBits");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Float.floatToIntBits(float)", "floatToIntBits");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Float.intBitsToFloat(int)", "intBitsToFloat");
        testedDeclaredMethods_jdk7.put("public int java.lang.Float.compareTo(java.lang.Float)", "compareTo");
        testedDeclaredMethods_jdk7.put("public int java.lang.Float.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk7.put("public byte java.lang.Float.byteValue()", "byteValue");
        testedDeclaredMethods_jdk7.put("public short java.lang.Float.shortValue()", "shortValue");
        testedDeclaredMethods_jdk7.put("public int java.lang.Float.intValue()", "intValue");
        testedDeclaredMethods_jdk7.put("public long java.lang.Float.longValue()", "longValue");
        testedDeclaredMethods_jdk7.put("public float java.lang.Float.floatValue()", "floatValue");
        testedDeclaredMethods_jdk7.put("public double java.lang.Float.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk7.put("public static java.lang.Float java.lang.Float.valueOf(float)", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.Float java.lang.Float.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Float.toHexString(float)", "toHexString");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Float.compare(float,float)", "compare");
        testedDeclaredMethods_jdk7.put("public static boolean java.lang.Float.isNaN(float)", "isNaN");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Float.isNaN()", "isNaN");
        testedDeclaredMethods_jdk7.put("public static boolean java.lang.Float.isInfinite(float)", "isInfinite");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Float.isInfinite()", "isInfinite");
        testedDeclaredMethods_jdk7.put("public static float java.lang.Float.parseFloat(java.lang.String) throws java.lang.NumberFormatException", "parseFloat");
        Float o = new Float(42.0f);
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

