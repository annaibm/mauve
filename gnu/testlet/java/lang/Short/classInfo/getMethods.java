/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Short.classInfo;

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
        testedMethods_jdk6.put("public boolean java.lang.Short.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public java.lang.String java.lang.Short.toString()", "toString");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Short.toString(short)", "toString");
        testedMethods_jdk6.put("public int java.lang.Short.hashCode()", "hashCode");
        testedMethods_jdk6.put("public static short java.lang.Short.reverseBytes(short)", "reverseBytes");
        testedMethods_jdk6.put("public int java.lang.Short.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk6.put("public int java.lang.Short.compareTo(java.lang.Short)", "compareTo");
        testedMethods_jdk6.put("public byte java.lang.Short.byteValue()", "byteValue");
        testedMethods_jdk6.put("public short java.lang.Short.shortValue()", "shortValue");
        testedMethods_jdk6.put("public int java.lang.Short.intValue()", "intValue");
        testedMethods_jdk6.put("public long java.lang.Short.longValue()", "longValue");
        testedMethods_jdk6.put("public float java.lang.Short.floatValue()", "floatValue");
        testedMethods_jdk6.put("public double java.lang.Short.doubleValue()", "doubleValue");
        testedMethods_jdk6.put("public static java.lang.Short java.lang.Short.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Short java.lang.Short.valueOf(short)", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Short java.lang.Short.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Short java.lang.Short.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedMethods_jdk6.put("public static short java.lang.Short.parseShort(java.lang.String,int) throws java.lang.NumberFormatException", "parseShort");
        testedMethods_jdk6.put("public static short java.lang.Short.parseShort(java.lang.String) throws java.lang.NumberFormatException", "parseShort");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public boolean java.lang.Short.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public java.lang.String java.lang.Short.toString()", "toString");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Short.toString(short)", "toString");
        testedMethods_jdk7.put("public int java.lang.Short.hashCode()", "hashCode");
        testedMethods_jdk7.put("public static short java.lang.Short.reverseBytes(short)", "reverseBytes");
        testedMethods_jdk7.put("public int java.lang.Short.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk7.put("public int java.lang.Short.compareTo(java.lang.Short)", "compareTo");
        testedMethods_jdk7.put("public byte java.lang.Short.byteValue()", "byteValue");
        testedMethods_jdk7.put("public short java.lang.Short.shortValue()", "shortValue");
        testedMethods_jdk7.put("public int java.lang.Short.intValue()", "intValue");
        testedMethods_jdk7.put("public long java.lang.Short.longValue()", "longValue");
        testedMethods_jdk7.put("public float java.lang.Short.floatValue()", "floatValue");
        testedMethods_jdk7.put("public double java.lang.Short.doubleValue()", "doubleValue");
        testedMethods_jdk7.put("public static java.lang.Short java.lang.Short.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk7.put("public static java.lang.Short java.lang.Short.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk7.put("public static java.lang.Short java.lang.Short.valueOf(short)", "valueOf");
        testedMethods_jdk7.put("public static int java.lang.Short.compare(short,short)", "compare");
        testedMethods_jdk7.put("public static java.lang.Short java.lang.Short.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedMethods_jdk7.put("public static short java.lang.Short.parseShort(java.lang.String,int) throws java.lang.NumberFormatException", "parseShort");
        testedMethods_jdk7.put("public static short java.lang.Short.parseShort(java.lang.String) throws java.lang.NumberFormatException", "parseShort");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        Short o = new Short("42");
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

