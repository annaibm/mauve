/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double.classInfo;

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
        testedMethods_jdk6.put("public boolean java.lang.Double.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Double.toString(double)", "toString");
        testedMethods_jdk6.put("public java.lang.String java.lang.Double.toString()", "toString");
        testedMethods_jdk6.put("public int java.lang.Double.hashCode()", "hashCode");
        testedMethods_jdk6.put("public static long java.lang.Double.doubleToRawLongBits(double)", "doubleToRawLongBits");
        testedMethods_jdk6.put("public static long java.lang.Double.doubleToLongBits(double)", "doubleToLongBits");
        testedMethods_jdk6.put("public static double java.lang.Double.longBitsToDouble(long)", "longBitsToDouble");
        testedMethods_jdk6.put("public int java.lang.Double.compareTo(java.lang.Double)", "compareTo");
        testedMethods_jdk6.put("public int java.lang.Double.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk6.put("public byte java.lang.Double.byteValue()", "byteValue");
        testedMethods_jdk6.put("public short java.lang.Double.shortValue()", "shortValue");
        testedMethods_jdk6.put("public int java.lang.Double.intValue()", "intValue");
        testedMethods_jdk6.put("public long java.lang.Double.longValue()", "longValue");
        testedMethods_jdk6.put("public float java.lang.Double.floatValue()", "floatValue");
        testedMethods_jdk6.put("public double java.lang.Double.doubleValue()", "doubleValue");
        testedMethods_jdk6.put("public static java.lang.Double java.lang.Double.valueOf(double)", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Double java.lang.Double.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Double.toHexString(double)", "toHexString");
        testedMethods_jdk6.put("public static int java.lang.Double.compare(double,double)", "compare");
        testedMethods_jdk6.put("public static boolean java.lang.Double.isNaN(double)", "isNaN");
        testedMethods_jdk6.put("public boolean java.lang.Double.isNaN()", "isNaN");
        testedMethods_jdk6.put("public static boolean java.lang.Double.isInfinite(double)", "isInfinite");
        testedMethods_jdk6.put("public boolean java.lang.Double.isInfinite()", "isInfinite");
        testedMethods_jdk6.put("public static double java.lang.Double.parseDouble(java.lang.String) throws java.lang.NumberFormatException", "parseDouble");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public boolean java.lang.Double.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Double.toString(double)", "toString");
        testedMethods_jdk7.put("public java.lang.String java.lang.Double.toString()", "toString");
        testedMethods_jdk7.put("public int java.lang.Double.hashCode()", "hashCode");
        testedMethods_jdk7.put("public static long java.lang.Double.doubleToRawLongBits(double)", "doubleToRawLongBits");
        testedMethods_jdk7.put("public static long java.lang.Double.doubleToLongBits(double)", "doubleToLongBits");
        testedMethods_jdk7.put("public static double java.lang.Double.longBitsToDouble(long)", "longBitsToDouble");
        testedMethods_jdk7.put("public int java.lang.Double.compareTo(java.lang.Double)", "compareTo");
        testedMethods_jdk7.put("public int java.lang.Double.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk7.put("public byte java.lang.Double.byteValue()", "byteValue");
        testedMethods_jdk7.put("public short java.lang.Double.shortValue()", "shortValue");
        testedMethods_jdk7.put("public int java.lang.Double.intValue()", "intValue");
        testedMethods_jdk7.put("public long java.lang.Double.longValue()", "longValue");
        testedMethods_jdk7.put("public float java.lang.Double.floatValue()", "floatValue");
        testedMethods_jdk7.put("public double java.lang.Double.doubleValue()", "doubleValue");
        testedMethods_jdk7.put("public static java.lang.Double java.lang.Double.valueOf(double)", "valueOf");
        testedMethods_jdk7.put("public static java.lang.Double java.lang.Double.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Double.toHexString(double)", "toHexString");
        testedMethods_jdk7.put("public static int java.lang.Double.compare(double,double)", "compare");
        testedMethods_jdk7.put("public static boolean java.lang.Double.isNaN(double)", "isNaN");
        testedMethods_jdk7.put("public boolean java.lang.Double.isNaN()", "isNaN");
        testedMethods_jdk7.put("public static boolean java.lang.Double.isInfinite(double)", "isInfinite");
        testedMethods_jdk7.put("public boolean java.lang.Double.isInfinite()", "isInfinite");
        testedMethods_jdk7.put("public static double java.lang.Double.parseDouble(java.lang.String) throws java.lang.NumberFormatException", "parseDouble");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        Double o = new Double(42.0);
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

