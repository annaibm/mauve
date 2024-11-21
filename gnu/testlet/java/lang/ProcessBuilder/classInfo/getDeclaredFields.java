/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ProcessBuilder.classInfo;

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
        testedDeclaredFields_jdk6.put("private java.util.List java.lang.ProcessBuilder.command", "command");
        testedDeclaredFields_jdk6.put("private java.io.File java.lang.ProcessBuilder.directory", "directory");
        testedDeclaredFields_jdk6.put("private java.util.Map java.lang.ProcessBuilder.environment", "environment");
        testedDeclaredFields_jdk6.put("private boolean java.lang.ProcessBuilder.redirectErrorStream", "redirectErrorStream");
        testedDeclaredFields_jdk6.put("static final boolean java.lang.ProcessBuilder.$assertionsDisabled", "$assertionsDisabled");
        testedDeclaredFields_jdk7.put("private java.util.List java.lang.ProcessBuilder.command", "command");
        testedDeclaredFields_jdk7.put("private java.io.File java.lang.ProcessBuilder.directory", "directory");
        testedDeclaredFields_jdk7.put("private java.util.Map java.lang.ProcessBuilder.environment", "environment");
        testedDeclaredFields_jdk7.put("private boolean java.lang.ProcessBuilder.redirectErrorStream", "redirectErrorStream");
        testedDeclaredFields_jdk7.put("private java.lang.ProcessBuilder$Redirect[] java.lang.ProcessBuilder.redirects", "redirects");
        testedDeclaredFields_jdk7.put("static final boolean java.lang.ProcessBuilder.$assertionsDisabled", "$assertionsDisabled");
        ProcessBuilder o = new ProcessBuilder("");
        Class<?> c = o.getClass();
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

