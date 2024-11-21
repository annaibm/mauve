/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.util.HashMap;

public class getDeclaredFields
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredFields = null;
        HashMap<String, String> testedDeclaredFields_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedDeclaredFields_jdk7 = new HashMap<String, String>();
        testedDeclaredFields_jdk6.put("public static final double java.lang.Math.E", "E");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Math.PI", "PI");
        testedDeclaredFields_jdk6.put("private static java.util.Random java.lang.Math.randomNumberGenerator", "randomNumberGenerator");
        testedDeclaredFields_jdk6.put("private static long java.lang.Math.negativeZeroFloatBits", "negativeZeroFloatBits");
        testedDeclaredFields_jdk6.put("private static long java.lang.Math.negativeZeroDoubleBits", "negativeZeroDoubleBits");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Math.E", "E");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Math.PI", "PI");
        testedDeclaredFields_jdk7.put("private static java.util.Random java.lang.Math.randomNumberGenerator", "randomNumberGenerator");
        testedDeclaredFields_jdk7.put("private static long java.lang.Math.negativeZeroFloatBits", "negativeZeroFloatBits");
        testedDeclaredFields_jdk7.put("private static long java.lang.Math.negativeZeroDoubleBits", "negativeZeroDoubleBits");
        Class<Math> c = Math.class;
        testedDeclaredFields = this.getJavaVersion() < 7 ? testedDeclaredFields_jdk6 : testedDeclaredFields_jdk7;
        Field[] declaredFields = c.getDeclaredFields();
        int expectedNumberOfDeclaredFields = testedDeclaredFields.size();
        harness.check(declaredFields.length, expectedNumberOfDeclaredFields);
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            String fieldString = declaredField.toString();
            harness.check(testedDeclaredFields.containsKey(fieldString));
            harness.check(testedDeclaredFields.get(fieldString), (Object)fieldName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

