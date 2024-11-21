/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.util.HashMap;

public class getFields
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedFields = null;
        HashMap<String, String> testedFields_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedFields_jdk7 = new HashMap<String, String>();
        testedFields_jdk6.put("public static final double java.lang.Math.E", "E");
        testedFields_jdk6.put("public static final double java.lang.Math.PI", "PI");
        testedFields_jdk7.put("public static final double java.lang.Math.E", "E");
        testedFields_jdk7.put("public static final double java.lang.Math.PI", "PI");
        Class<Math> c = Math.class;
        testedFields = this.getJavaVersion() < 7 ? testedFields_jdk6 : testedFields_jdk7;
        Field[] fields = c.getFields();
        int expectedNumberOfFields = testedFields.size();
        harness.check(fields.length, expectedNumberOfFields);
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldString = field.toString();
            harness.check(testedFields.containsKey(fieldString));
            harness.check(testedFields.get(fieldString), (Object)fieldName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

