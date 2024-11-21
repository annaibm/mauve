/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Package.classInfo;

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
        testedDeclaredFields_jdk6.put("private static java.util.Map java.lang.Package.pkgs", "pkgs");
        testedDeclaredFields_jdk6.put("private static java.util.Map java.lang.Package.urls", "urls");
        testedDeclaredFields_jdk6.put("private static java.util.Map java.lang.Package.mans", "mans");
        testedDeclaredFields_jdk6.put("private final java.lang.String java.lang.Package.pkgName", "pkgName");
        testedDeclaredFields_jdk6.put("private final java.lang.String java.lang.Package.specTitle", "specTitle");
        testedDeclaredFields_jdk6.put("private final java.lang.String java.lang.Package.specVersion", "specVersion");
        testedDeclaredFields_jdk6.put("private final java.lang.String java.lang.Package.specVendor", "specVendor");
        testedDeclaredFields_jdk6.put("private final java.lang.String java.lang.Package.implTitle", "implTitle");
        testedDeclaredFields_jdk6.put("private final java.lang.String java.lang.Package.implVersion", "implVersion");
        testedDeclaredFields_jdk6.put("private final java.lang.String java.lang.Package.implVendor", "implVendor");
        testedDeclaredFields_jdk6.put("private final java.net.URL java.lang.Package.sealBase", "sealBase");
        testedDeclaredFields_jdk6.put("private final transient java.lang.ClassLoader java.lang.Package.loader", "loader");
        testedDeclaredFields_jdk6.put("private transient java.lang.Class java.lang.Package.packageInfo", "packageInfo");
        testedDeclaredFields_jdk7.put("private static java.util.Map java.lang.Package.pkgs", "pkgs");
        testedDeclaredFields_jdk7.put("private static java.util.Map java.lang.Package.urls", "urls");
        testedDeclaredFields_jdk7.put("private static java.util.Map java.lang.Package.mans", "mans");
        testedDeclaredFields_jdk7.put("private final java.lang.String java.lang.Package.pkgName", "pkgName");
        testedDeclaredFields_jdk7.put("private final java.lang.String java.lang.Package.specTitle", "specTitle");
        testedDeclaredFields_jdk7.put("private final java.lang.String java.lang.Package.specVersion", "specVersion");
        testedDeclaredFields_jdk7.put("private final java.lang.String java.lang.Package.specVendor", "specVendor");
        testedDeclaredFields_jdk7.put("private final java.lang.String java.lang.Package.implTitle", "implTitle");
        testedDeclaredFields_jdk7.put("private final java.lang.String java.lang.Package.implVersion", "implVersion");
        testedDeclaredFields_jdk7.put("private final java.lang.String java.lang.Package.implVendor", "implVendor");
        testedDeclaredFields_jdk7.put("private final java.net.URL java.lang.Package.sealBase", "sealBase");
        testedDeclaredFields_jdk7.put("private final transient java.lang.ClassLoader java.lang.Package.loader", "loader");
        testedDeclaredFields_jdk7.put("private transient java.lang.Class java.lang.Package.packageInfo", "packageInfo");
        Package o = Package.getPackage("java.lang");
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

