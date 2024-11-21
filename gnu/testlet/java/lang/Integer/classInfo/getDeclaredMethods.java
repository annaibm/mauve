/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer.classInfo;

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
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.numberOfLeadingZeros(int)", "numberOfLeadingZeros");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.numberOfTrailingZeros(int)", "numberOfTrailingZeros");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.bitCount(int)", "bitCount");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Integer.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Integer.toString()", "toString");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Integer.toString(int,int)", "toString");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Integer.toString(int)", "toString");
        testedDeclaredMethods_jdk6.put("public int java.lang.Integer.hashCode()", "hashCode");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.reverseBytes(int)", "reverseBytes");
        testedDeclaredMethods_jdk6.put("public int java.lang.Integer.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk6.put("public int java.lang.Integer.compareTo(java.lang.Integer)", "compareTo");
        testedDeclaredMethods_jdk6.put("public byte java.lang.Integer.byteValue()", "byteValue");
        testedDeclaredMethods_jdk6.put("public short java.lang.Integer.shortValue()", "shortValue");
        testedDeclaredMethods_jdk6.put("public int java.lang.Integer.intValue()", "intValue");
        testedDeclaredMethods_jdk6.put("public long java.lang.Integer.longValue()", "longValue");
        testedDeclaredMethods_jdk6.put("public float java.lang.Integer.floatValue()", "floatValue");
        testedDeclaredMethods_jdk6.put("public double java.lang.Integer.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.valueOf(int)", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Integer.toHexString(int)", "toHexString");
        testedDeclaredMethods_jdk6.put("static void java.lang.Integer.getChars(int,int,char[])", "getChars");
        testedDeclaredMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.reverse(int)", "reverse");
        testedDeclaredMethods_jdk6.put("static int java.lang.Integer.stringSize(int)", "stringSize");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.parseInt(java.lang.String,int) throws java.lang.NumberFormatException", "parseInt");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.parseInt(java.lang.String) throws java.lang.NumberFormatException", "parseInt");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Integer.toOctalString(int)", "toOctalString");
        testedDeclaredMethods_jdk6.put("public static java.lang.String java.lang.Integer.toBinaryString(int)", "toBinaryString");
        testedDeclaredMethods_jdk6.put("private static java.lang.String java.lang.Integer.toUnsignedString(int,int)", "toUnsignedString");
        testedDeclaredMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String)", "getInteger");
        testedDeclaredMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,int)", "getInteger");
        testedDeclaredMethods_jdk6.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,java.lang.Integer)", "getInteger");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.highestOneBit(int)", "highestOneBit");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.lowestOneBit(int)", "lowestOneBit");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.rotateLeft(int,int)", "rotateLeft");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.rotateRight(int,int)", "rotateRight");
        testedDeclaredMethods_jdk6.put("public static int java.lang.Integer.signum(int)", "signum");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.numberOfLeadingZeros(int)", "numberOfLeadingZeros");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.numberOfTrailingZeros(int)", "numberOfTrailingZeros");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.bitCount(int)", "bitCount");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Integer.equals(java.lang.Object)", "equals");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Integer.toString()", "toString");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Integer.toString(int,int)", "toString");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Integer.toString(int)", "toString");
        testedDeclaredMethods_jdk7.put("public int java.lang.Integer.hashCode()", "hashCode");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.reverseBytes(int)", "reverseBytes");
        testedDeclaredMethods_jdk7.put("public int java.lang.Integer.compareTo(java.lang.Object)", "compareTo");
        testedDeclaredMethods_jdk7.put("public int java.lang.Integer.compareTo(java.lang.Integer)", "compareTo");
        testedDeclaredMethods_jdk7.put("public byte java.lang.Integer.byteValue()", "byteValue");
        testedDeclaredMethods_jdk7.put("public short java.lang.Integer.shortValue()", "shortValue");
        testedDeclaredMethods_jdk7.put("public int java.lang.Integer.intValue()", "intValue");
        testedDeclaredMethods_jdk7.put("public long java.lang.Integer.longValue()", "longValue");
        testedDeclaredMethods_jdk7.put("public float java.lang.Integer.floatValue()", "floatValue");
        testedDeclaredMethods_jdk7.put("public double java.lang.Integer.doubleValue()", "doubleValue");
        testedDeclaredMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.valueOf(int)", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String,int) throws java.lang.NumberFormatException", "valueOf");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Integer.toHexString(int)", "toHexString");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.compare(int,int)", "compare");
        testedDeclaredMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.decode(java.lang.String) throws java.lang.NumberFormatException", "decode");
        testedDeclaredMethods_jdk7.put("static void java.lang.Integer.getChars(int,int,char[])", "getChars");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.reverse(int)", "reverse");
        testedDeclaredMethods_jdk7.put("static int java.lang.Integer.stringSize(int)", "stringSize");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.parseInt(java.lang.String) throws java.lang.NumberFormatException", "parseInt");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.parseInt(java.lang.String,int) throws java.lang.NumberFormatException", "parseInt");
        testedDeclaredMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String)", "getInteger");
        testedDeclaredMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,int)", "getInteger");
        testedDeclaredMethods_jdk7.put("public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,java.lang.Integer)", "getInteger");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.highestOneBit(int)", "highestOneBit");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.lowestOneBit(int)", "lowestOneBit");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.rotateLeft(int,int)", "rotateLeft");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.rotateRight(int,int)", "rotateRight");
        testedDeclaredMethods_jdk7.put("public static int java.lang.Integer.signum(int)", "signum");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Integer.toBinaryString(int)", "toBinaryString");
        testedDeclaredMethods_jdk7.put("public static java.lang.String java.lang.Integer.toOctalString(int)", "toOctalString");
        testedDeclaredMethods_jdk7.put("private static java.lang.String java.lang.Integer.toUnsignedString(int,int)", "toUnsignedString");
        Integer o = new Integer(42);
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

