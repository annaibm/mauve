/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long.classInfo;

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
        testedDeclaredMethods_jdk6.put("public static int java.lang.Long.numberOfLeadingZeros(long)", "numberOfLeadingZeros");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Long.numberOfTrailingZeros(long)", "numberOfTrailingZeros");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Long.bitCount(long)", "bitCount");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Long.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Long.toString()", "toString");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Long.toString(long,int)", "toString");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Long.toString(long)", "toString");
        testedDeclaredMethods_jdk6.put("public int java.lang.Long.hashCode()", "hashCode");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Long.reverseBytes(long)", "reverseBytes");
        testedDeclaredMethods_jdk6.put("public int java.lang.Long.compareTo(java.lang.Long)", "compareTo");
        testedDeclaredMethods_jdk6.put("public int java.lang.Long.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk6.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String)", "getLong");
        testedDeclaredMethods_jdk6.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String,java.lang.Long)", "getLong");
        testedDeclaredMethods_jdk6.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String,long)", "getLong");
        testedDeclaredMethods_jdk6.put("public byte java.lang.Long.byteValue()", "byteValue");
        testedDeclaredMethods_jdk6.put("public short java.lang.Long.shortValue()", "shortValue");
        testedDeclaredMethods_jdk6.put("public int java.lang.Long.intValue()", "intValue");
        testedDeclaredMethods_jdk6.put("public long java.lang.Long.longValue()", "longValue");
        testedDeclaredMethods_jdk6.put("public float java.lang.Long.floatValue()", "floatValue");
        testedDeclaredMethods_jdk6.put("public double java.lang.Long.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk6.put("public static java.lang.Long java.lang.Long.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Long java.lang.Long.valueOf(long)", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Long java.lang.Long.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Long.toHexString(long)", "toHexString");
        testedDeclaredMethods_jdk6.put("static void java.lang.Long.getChars(long,int,char[])", "getChars");
        testedDeclaredMethods_jdk6.put("public static java.lang.Long java.lang.Long.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Long.reverse(long)", "reverse");
        testedDeclaredMethods_jdk6.put("static int java.lang.Long.stringSize(long)", "stringSize");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Long.toOctalString(long)", "toOctalString");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Long.toBinaryString(long)", "toBinaryString");
        testedDeclaredMethods_jdk6.put("private static java.lang.String java.lang.Long.toUnsignedString(long,int)", "toUnsignedString");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Long.highestOneBit(long)", "highestOneBit");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Long.lowestOneBit(long)", "lowestOneBit");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Long.rotateLeft(long,int)", "rotateLeft");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Long.rotateRight(long,int)", "rotateRight");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Long.signum(long)", "signum");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Long.parseLong(java.lang.String) throws java.lang.NumberFormatException", "parseLong");
        testedDeclaredMethods_jdk6.put("public static long java.lang.Long.parseLong(java.lang.String,int) throws java.lang.NumberFormatException", "parseLong");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Long.numberOfLeadingZeros(long)", "numberOfLeadingZeros");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Long.numberOfTrailingZeros(long)", "numberOfTrailingZeros");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Long.bitCount(long)", "bitCount");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Long.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Long.toString()", "toString");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Long.toString(long,int)", "toString");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Long.toString(long)", "toString");
        testedDeclaredMethods_jdk7.put("public int java.lang.Long.hashCode()", "hashCode");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Long.reverseBytes(long)", "reverseBytes");
        testedDeclaredMethods_jdk7.put("public int java.lang.Long.compareTo(java.lang.Long)", "compareTo");
        testedDeclaredMethods_jdk7.put("public int java.lang.Long.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk7.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String)", "getLong");
        testedDeclaredMethods_jdk7.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String,java.lang.Long)", "getLong");
        testedDeclaredMethods_jdk7.put("public static java.lang.Long java.lang.Long.getLong(java.lang.String,long)", "getLong");
        testedDeclaredMethods_jdk7.put("public byte java.lang.Long.byteValue()", "byteValue");
        testedDeclaredMethods_jdk7.put("public short java.lang.Long.shortValue()", "shortValue");
        testedDeclaredMethods_jdk7.put("public int java.lang.Long.intValue()", "intValue");
        testedDeclaredMethods_jdk7.put("public long java.lang.Long.longValue()", "longValue");
        testedDeclaredMethods_jdk7.put("public float java.lang.Long.floatValue()", "floatValue");
        testedDeclaredMethods_jdk7.put("public double java.lang.Long.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk7.put("public static java.lang.Long java.lang.Long.valueOf(long)", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.Long java.lang.Long.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.Long java.lang.Long.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Long.toHexString(long)", "toHexString");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Long.compare(long,long)", "compare");
        testedDeclaredMethods_jdk7.put("public static java.lang.Long java.lang.Long.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedDeclaredMethods_jdk7.put("static void java.lang.Long.getChars(long,int,char[])", "getChars");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Long.reverse(long)", "reverse");
        testedDeclaredMethods_jdk7.put("static int java.lang.Long.stringSize(long)", "stringSize");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Long.highestOneBit(long)", "highestOneBit");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Long.lowestOneBit(long)", "lowestOneBit");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Long.rotateLeft(long,int)", "rotateLeft");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Long.rotateRight(long,int)", "rotateRight");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Long.signum(long)", "signum");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Long.toBinaryString(long)", "toBinaryString");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Long.toOctalString(long)", "toOctalString");
        testedDeclaredMethods_jdk7.put("private static java.lang.String java.lang.Long.toUnsignedString(long,int)", "toUnsignedString");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Long.parseLong(java.lang.String) throws java.lang.NumberFormatException", "parseLong");
        testedDeclaredMethods_jdk7.put("public static long java.lang.Long.parseLong(java.lang.String,int) throws java.lang.NumberFormatException", "parseLong");
        Long o = new Long(42L);
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

