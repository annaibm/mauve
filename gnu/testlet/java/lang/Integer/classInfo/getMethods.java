/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer.classInfo;

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
        testedMethods_jdk6.put("public static int java.lang.Integer.numberOfLeadingZeros(int)", "numberOfLeadingZeros");
        testedMethods_jdk6.put("public static int java.lang.Integer.numberOfTrailingZeros(int)", "numberOfTrailingZeros");
        testedMethods_jdk6.put("public static int java.lang.Integer.bitCount(int)", "bitCount");
        testedMethods_jdk6.put("public boolean java.lang.Integer.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public java.lang.String java.lang.Integer.toString()", "toString");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Integer.toString(int,int)", "toString");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Integer.toString(int)", "toString");
        testedMethods_jdk6.put("public int java.lang.Integer.hashCode()", "hashCode");
        testedMethods_jdk6.put("public static int java.lang.Integer.reverseBytes(int)", "reverseBytes");
        testedMethods_jdk6.put("public int java.lang.Integer.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk6.put("public int java.lang.Integer.compareTo(java.lang.Integer)", "compareTo");
        testedMethods_jdk6.put("public byte java.lang.Integer.byteValue()", "byteValue");
        testedMethods_jdk6.put("public short java.lang.Integer.shortValue()", "shortValue");
        testedMethods_jdk6.put("public int java.lang.Integer.intValue()", "intValue");
        testedMethods_jdk6.put("public long java.lang.Integer.longValue()", "longValue");
        testedMethods_jdk6.put("public float java.lang.Integer.floatValue()", "floatValue");
        testedMethods_jdk6.put("public double java.lang.Integer.doubleValue()", "doubleValue");
        testedMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.valueOf(int)", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Integer.toHexString(int)", "toHexString");
        testedMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedMethods_jdk6.put("public static int java.lang.Integer.reverse(int)", "reverse");
        testedMethods_jdk6.put("public static int java.lang.Integer.parseInt(java.lang.String,int) throws java.lang.NumberFormatException", "parseInt");
        testedMethods_jdk6.put("public static int java.lang.Integer.parseInt(java.lang.String) throws java.lang.NumberFormatException", "parseInt");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Integer.toOctalString(int)", "toOctalString");
        testedMethods_jdk6.put("public static java.lang.String java.lang.Integer.toBinaryString(int)", "toBinaryString");
        testedMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String)", "getInteger");
        testedMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,int)", "getInteger");
        testedMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,java.lang.Integer)", "getInteger");
        testedMethods_jdk6.put("public static int java.lang.Integer.highestOneBit(int)", "highestOneBit");
        testedMethods_jdk6.put("public static int java.lang.Integer.lowestOneBit(int)", "lowestOneBit");
        testedMethods_jdk6.put("public static int java.lang.Integer.rotateLeft(int,int)", "rotateLeft");
        testedMethods_jdk6.put("public static int java.lang.Integer.rotateRight(int,int)", "rotateRight");
        testedMethods_jdk6.put("public static int java.lang.Integer.signum(int)", "signum");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public static int java.lang.Integer.numberOfLeadingZeros(int)", "numberOfLeadingZeros");
        testedMethods_jdk7.put("public static int java.lang.Integer.numberOfTrailingZeros(int)", "numberOfTrailingZeros");
        testedMethods_jdk7.put("public static int java.lang.Integer.bitCount(int)", "bitCount");
        testedMethods_jdk7.put("public boolean java.lang.Integer.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public java.lang.String java.lang.Integer.toString()", "toString");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Integer.toString(int,int)", "toString");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Integer.toString(int)", "toString");
        testedMethods_jdk7.put("public int java.lang.Integer.hashCode()", "hashCode");
        testedMethods_jdk7.put("public static int java.lang.Integer.reverseBytes(int)", "reverseBytes");
        testedMethods_jdk7.put("public int java.lang.Integer.compareTo(java.lang.Object)", "compareTo");
        testedMethods_jdk7.put("public int java.lang.Integer.compareTo(java.lang.Integer)", "compareTo");
        testedMethods_jdk7.put("public byte java.lang.Integer.byteValue()", "byteValue");
        testedMethods_jdk7.put("public short java.lang.Integer.shortValue()", "shortValue");
        testedMethods_jdk7.put("public int java.lang.Integer.intValue()", "intValue");
        testedMethods_jdk7.put("public long java.lang.Integer.longValue()", "longValue");
        testedMethods_jdk7.put("public float java.lang.Integer.floatValue()", "floatValue");
        testedMethods_jdk7.put("public double java.lang.Integer.doubleValue()", "doubleValue");
        testedMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.valueOf(int)", "valueOf");
        testedMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Integer.toHexString(int)", "toHexString");
        testedMethods_jdk7.put("public static int java.lang.Integer.compare(int,int)", "compare");
        testedMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedMethods_jdk7.put("public static int java.lang.Integer.reverse(int)", "reverse");
        testedMethods_jdk7.put("public static int java.lang.Integer.parseInt(java.lang.String) throws java.lang.NumberFormatException", "parseInt");
        testedMethods_jdk7.put("public static int java.lang.Integer.parseInt(java.lang.String,int) throws java.lang.NumberFormatException", "parseInt");
        testedMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String)", "getInteger");
        testedMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,int)", "getInteger");
        testedMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,java.lang.Integer)", "getInteger");
        testedMethods_jdk7.put("public static int java.lang.Integer.highestOneBit(int)", "highestOneBit");
        testedMethods_jdk7.put("public static int java.lang.Integer.lowestOneBit(int)", "lowestOneBit");
        testedMethods_jdk7.put("public static int java.lang.Integer.rotateLeft(int,int)", "rotateLeft");
        testedMethods_jdk7.put("public static int java.lang.Integer.rotateRight(int,int)", "rotateRight");
        testedMethods_jdk7.put("public static int java.lang.Integer.signum(int)", "signum");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Integer.toBinaryString(int)", "toBinaryString");
        testedMethods_jdk7.put("public static java.lang.String java.lang.Integer.toOctalString(int)", "toOctalString");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        Integer o = new Integer(42);
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

