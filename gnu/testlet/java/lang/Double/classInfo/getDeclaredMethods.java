/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double.classInfo;

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
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Double.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Double.toString(double)", "toString");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Double.toString()", "toString");
        testedDeclaredMethods_jdk6.put("public int java.lang.Double.hashCode()", "hashCode");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Double.doubleToRawLongBits(double)", "doubleToRawLongBits");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Double.doubleToLongBits(double)", "doubleToLongBits");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Double.longBitsToDouble(long)", "longBitsToDouble");
        testedDeclaredMethods_jdk6.put("public int java.lang.Double.compareTo(java.lang.Double)", "compareTo");
        testedDeclaredMethods_jdk6.put("public int java.lang.Double.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk6.put("public byte java.lang.Double.byteValue()", "byteValue");
        testedDeclaredMethods_jdk6.put("public short java.lang.Double.shortValue()", "shortValue");
        testedDeclaredMethods_jdk6.put("public int java.lang.Double.intValue()", "intValue");
        testedDeclaredMethods_jdk6.put("public long java.lang.Double.longValue()", "longValue");
        testedDeclaredMethods_jdk6.put("public float java.lang.Double.floatValue()", "floatValue");
        testedDeclaredMethods_jdk6.put("public double java.lang.Double.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk6.put("public static java.lang.Double java.lang.Double.valueOf(double)", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Double java.lang.Double.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Double.toHexString(double)", "toHexString");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Double.compare(double,double)", "compare");
        testedDeclaredMethods_jdk6.put("public static boolean java.lang.Double.isNaN(double)", "isNaN");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Double.isNaN()", "isNaN");
        testedDeclaredMethods_jdk6.put("public static boolean java.lang.Double.isInfinite(double)", "isInfinite");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Double.isInfinite()", "isInfinite");
        testedDeclaredMethods_jdk6.put("public static double java.lang.Double.parseDouble(java.lang.String) throws java.lang.NumberFormatException", "parseDouble");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Double.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Double.toString(double)", "toString");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Double.toString()", "toString");
        testedDeclaredMethods_jdk7.put("public int java.lang.Double.hashCode()", "hashCode");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Double.doubleToRawLongBits(double)", "doubleToRawLongBits");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Double.doubleToLongBits(double)", "doubleToLongBits");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Double.longBitsToDouble(long)", "longBitsToDouble");
        testedDeclaredMethods_jdk7.put("public int java.lang.Double.compareTo(java.lang.Double)", "compareTo");
        testedDeclaredMethods_jdk7.put("public int java.lang.Double.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk7.put("public byte java.lang.Double.byteValue()", "byteValue");
        testedDeclaredMethods_jdk7.put("public short java.lang.Double.shortValue()", "shortValue");
        testedDeclaredMethods_jdk7.put("public int java.lang.Double.intValue()", "intValue");
        testedDeclaredMethods_jdk7.put("public long java.lang.Double.longValue()", "longValue");
        testedDeclaredMethods_jdk7.put("public float java.lang.Double.floatValue()", "floatValue");
        testedDeclaredMethods_jdk7.put("public double java.lang.Double.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk7.put("public static java.lang.Double java.lang.Double.valueOf(double)", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.Double java.lang.Double.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Double.toHexString(double)", "toHexString");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Double.compare(double,double)", "compare");
        testedDeclaredMethods_jdk7.put("public static boolean java.lang.Double.isNaN(double)", "isNaN");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Double.isNaN()", "isNaN");
        testedDeclaredMethods_jdk7.put("public static boolean java.lang.Double.isInfinite(double)", "isInfinite");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Double.isInfinite()", "isInfinite");
        testedDeclaredMethods_jdk7.put("public static double java.lang.Double.parseDouble(java.lang.String) throws java.lang.NumberFormatException", "parseDouble");
        Double o = new Double(42.0);
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

