/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float.classInfo;

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
        testedMethods_jdk6.put("public boolean java.lang.Float.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Float.toString(float)", "toString");
        testedMethods_jdk6.put("public java.lang.String java.lang.Float.toString()", "toString");
        testedMethods_jdk6.put("public int java.lang.Float.hashCode()", "hashCode");
        testedMethods_jdk6.put("public static int java.lang.Float.floatToRawIntBits(float)", "floatToRawIntBits");
        testedMethods_jdk6.put("public static int java.lang.Float.floatToIntBits(float)", "floatToIntBits");
        testedMethods_jdk6.put("public static float java.lang.Float.intBitsToFloat(int)", "intBitsToFloat");
        testedMethods_jdk6.put("public int java.lang.Float.compareTo(java.lang.Float)", "compareTo");
        testedMethods_jdk6.put("public int java.lang.Float.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk6.put("public byte java.lang.Float.byteValue()", "byteValue");
        testedMethods_jdk6.put("public short java.lang.Float.shortValue()", "shortValue");
        testedMethods_jdk6.put("public int java.lang.Float.intValue()", "intValue");
        testedMethods_jdk6.put("public long java.lang.Float.longValue()", "longValue");
        testedMethods_jdk6.put("public float java.lang.Float.floatValue()", "floatValue");
        testedMethods_jdk6.put("public double java.lang.Float.doubleValue()", "doubleValue");
        testedMethods_jdk6.put("public static java.lang.Float java.lang.Float.valueOf(float)", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Float java.lang.Float.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Float.toHexString(float)", "toHexString");
        testedMethods_jdk6.put("public static int java.lang.Float.compare(float,float)", "compare");
        testedMethods_jdk6.put("public static boolean java.lang.Float.isNaN(float)", "isNaN");
        testedMethods_jdk6.put("public boolean java.lang.Float.isNaN()", "isNaN");
        testedMethods_jdk6.put("public static float java.lang.Float.parseFloat(java.lang.String) throws java.lang.NumberFormatException", "parseFloat");
        testedMethods_jdk6.put("public static boolean java.lang.Float.isInfinite(float)", "isInfinite");
        testedMethods_jdk6.put("public boolean java.lang.Float.isInfinite()", "isInfinite");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public boolean java.lang.Float.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Float.toString(float)", "toString");
        testedMethods_jdk7.put("public java.lang.String java.lang.Float.toString()", "toString");
        testedMethods_jdk7.put("public int java.lang.Float.hashCode()", "hashCode");
        testedMethods_jdk7.put("public static int java.lang.Float.floatToRawIntBits(float)", "floatToRawIntBits");
        testedMethods_jdk7.put("public static int java.lang.Float.floatToIntBits(float)", "floatToIntBits");
        testedMethods_jdk7.put("public static float java.lang.Float.intBitsToFloat(int)", "intBitsToFloat");
        testedMethods_jdk7.put("public int java.lang.Float.compareTo(java.lang.Float)", "compareTo");
        testedMethods_jdk7.put("public int java.lang.Float.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk7.put("public byte java.lang.Float.byteValue()", "byteValue");
        testedMethods_jdk7.put("public short java.lang.Float.shortValue()", "shortValue");
        testedMethods_jdk7.put("public int java.lang.Float.intValue()", "intValue");
        testedMethods_jdk7.put("public long java.lang.Float.longValue()", "longValue");
        testedMethods_jdk7.put("public float java.lang.Float.floatValue()", "floatValue");
        testedMethods_jdk7.put("public double java.lang.Float.doubleValue()", "doubleValue");
        testedMethods_jdk7.put("public static java.lang.Float java.lang.Float.valueOf(float)", "valueOf");
        testedMethods_jdk7.put("public static java.lang.Float java.lang.Float.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Float.toHexString(float)", "toHexString");
        testedMethods_jdk7.put("public static int java.lang.Float.compare(float,float)", "compare");
        testedMethods_jdk7.put("public static boolean java.lang.Float.isNaN(float)", "isNaN");
        testedMethods_jdk7.put("public boolean java.lang.Float.isNaN()", "isNaN");
        testedMethods_jdk7.put("public static boolean java.lang.Float.isInfinite(float)", "isInfinite");
        testedMethods_jdk7.put("public boolean java.lang.Float.isInfinite()", "isInfinite");
        testedMethods_jdk7.put("public static float java.lang.Float.parseFloat(java.lang.String) throws java.lang.NumberFormatException", "parseFloat");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        Float o = new Float(42.0f);
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

