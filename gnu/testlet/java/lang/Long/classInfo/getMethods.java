/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long.classInfo;

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
        testedMethods_jdk6.put("public static int java.lang.Long.numberOfLeadingZeros(long)", "numberOfLeadingZeros");
        testedMethods_jdk6.put("public static int java.lang.Long.numberOfTrailingZeros(long)", "numberOfTrailingZeros");
        testedMethods_jdk6.put("public static int java.lang.Long.bitCount(long)", "bitCount");
        testedMethods_jdk6.put("public boolean java.lang.Long.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public java.lang.String java.lang.Long.toString()", "toString");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Long.toString(long,int)", "toString");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Long.toString(long)", "toString");
        testedMethods_jdk6.put("public int java.lang.Long.hashCode()", "hashCode");
        testedMethods_jdk6.put("public static long java.lang.Long.reverseBytes(long)", "reverseBytes");
        testedMethods_jdk6.put("public int java.lang.Long.compareTo(java.lang.Long)", "compareTo");
        testedMethods_jdk6.put("public int java.lang.Long.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk6.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String)", "getLong");
        testedMethods_jdk6.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String,java.lang.Long)", "getLong");
        testedMethods_jdk6.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String,long)", "getLong");
        testedMethods_jdk6.put("public byte java.lang.Long.byteValue()", "byteValue");
        testedMethods_jdk6.put("public short java.lang.Long.shortValue()", "shortValue");
        testedMethods_jdk6.put("public int java.lang.Long.intValue()", "intValue");
        testedMethods_jdk6.put("public long java.lang.Long.longValue()", "longValue");
        testedMethods_jdk6.put("public float java.lang.Long.floatValue()", "floatValue");
        testedMethods_jdk6.put("public double java.lang.Long.doubleValue()", "doubleValue");
        testedMethods_jdk6.put("public static java.lang.Long java.lang.Long.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Long java.lang.Long.valueOf(long)", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Long java.lang.Long.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Long.toHexString(long)", "toHexString");
        testedMethods_jdk6.put("public static java.lang.Long java.lang.Long.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedMethods_jdk6.put("public static long java.lang.Long.reverse(long)", "reverse");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Long.toOctalString(long)", "toOctalString");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Long.toBinaryString(long)", "toBinaryString");
        testedMethods_jdk6.put("public static long java.lang.Long.highestOneBit(long)", "highestOneBit");
        testedMethods_jdk6.put("public static long java.lang.Long.lowestOneBit(long)", "lowestOneBit");
        testedMethods_jdk6.put("public static long java.lang.Long.rotateLeft(long,int)", "rotateLeft");
        testedMethods_jdk6.put("public static long java.lang.Long.rotateRight(long,int)", "rotateRight");
        testedMethods_jdk6.put("public static int java.lang.Long.signum(long)", "signum");
        testedMethods_jdk6.put("public static long java.lang.Long.parseLong(java.lang.String) throws java.lang.NumberFormatException", "parseLong");
        testedMethods_jdk6.put("public static long java.lang.Long.parseLong(java.lang.String,int) throws java.lang.NumberFormatException", "parseLong");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public static int java.lang.Long.numberOfLeadingZeros(long)", "numberOfLeadingZeros");
        testedMethods_jdk7.put("public static int java.lang.Long.numberOfTrailingZeros(long)", "numberOfTrailingZeros");
        testedMethods_jdk7.put("public static int java.lang.Long.bitCount(long)", "bitCount");
        testedMethods_jdk7.put("public boolean java.lang.Long.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public java.lang.String java.lang.Long.toString()", "toString");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Long.toString(long,int)", "toString");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Long.toString(long)", "toString");
        testedMethods_jdk7.put("public int java.lang.Long.hashCode()", "hashCode");
        testedMethods_jdk7.put("public static long java.lang.Long.reverseBytes(long)", "reverseBytes");
        testedMethods_jdk7.put("public int java.lang.Long.compareTo(java.lang.Long)", "compareTo");
        testedMethods_jdk7.put("public int java.lang.Long.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk7.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String)", "getLong");
        testedMethods_jdk7.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String,java.lang.Long)", "getLong");
        testedMethods_jdk7.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String,long)", "getLong");
        testedMethods_jdk7.put("public byte java.lang.Long.byteValue()", "byteValue");
        testedMethods_jdk7.put("public short java.lang.Long.shortValue()", "shortValue");
        testedMethods_jdk7.put("public int java.lang.Long.intValue()", "intValue");
        testedMethods_jdk7.put("public long java.lang.Long.longValue()", "longValue");
        testedMethods_jdk7.put("public float java.lang.Long.floatValue()", "floatValue");
        testedMethods_jdk7.put("public double java.lang.Long.doubleValue()", "doubleValue");
        testedMethods_jdk7.put("public static java.lang.Long java.lang.Long.valueOf(long)", "valueOf");
        testedMethods_jdk7.put("public static java.lang.Long java.lang.Long.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk7.put("public static java.lang.Long java.lang.Long.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Long.toHexString(long)", "toHexString");
        testedMethods_jdk7.put("public static int java.lang.Long.compare(long,long)", "compare");
        testedMethods_jdk7.put("public static java.lang.Long java.lang.Long.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedMethods_jdk7.put("public static long java.lang.Long.reverse(long)", "reverse");
        testedMethods_jdk7.put("public static long java.lang.Long.highestOneBit(long)", "highestOneBit");
        testedMethods_jdk7.put("public static long java.lang.Long.lowestOneBit(long)", "lowestOneBit");
        testedMethods_jdk7.put("public static long java.lang.Long.rotateLeft(long,int)", "rotateLeft");
        testedMethods_jdk7.put("public static long java.lang.Long.rotateRight(long,int)", "rotateRight");
        testedMethods_jdk7.put("public static int java.lang.Long.signum(long)", "signum");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Long.toBinaryString(long)", "toBinaryString");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Long.toOctalString(long)", "toOctalString");
        testedMethods_jdk7.put("public static long java.lang.Long.parseLong(java.lang.String) throws java.lang.NumberFormatException", "parseLong");
        testedMethods_jdk7.put("public static long java.lang.Long.parseLong(java.lang.String,int) throws java.lang.NumberFormatException", "parseLong");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        Long o = new Long(42L);
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

