/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Package.classInfo;

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
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Package.toString()", "toString");
        testedDeclaredMethods_jdk6.put("public int java.lang.Package.hashCode()", "hashCode");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Package.getName()", "getName");
        testedDeclaredMethods_jdk6.put("public static java.lang.Package[] java.lang.Package.getPackages()", "getPackages");
        testedDeclaredMethods_jdk6.put("static java.util.Map java.lang.Package.access$000()", "access$000");
        testedDeclaredMethods_jdk6.put("static java.lang.Package java.lang.Package.getSystemPackage(java.lang.String)", "getSystemPackage");
        testedDeclaredMethods_jdk6.put("static java.lang.Package[] java.lang.Package.getSystemPackages()", "getSystemPackages");
        testedDeclaredMethods_jdk6.put("static java.util.Map java.lang.Package.access$200()", "access$200");
        testedDeclaredMethods_jdk6.put("public static java.lang.Package java.lang.Package.getPackage(java.lang.String)", "getPackage");
        testedDeclaredMethods_jdk6.put("static java.lang.Package java.lang.Package.getPackage(java.lang.Class)", "getPackage");
        testedDeclaredMethods_jdk6.put("public java.lang.annotation.Annotation java.lang.Package.getAnnotation(java.lang.Class)", "getAnnotation");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Package.isAnnotationPresent(java.lang.Class)", "isAnnotationPresent");
        testedDeclaredMethods_jdk6.put("public java.lang.annotation.Annotation[] java.lang.Package.getAnnotations()", "getAnnotations");
        testedDeclaredMethods_jdk6.put("public java.lang.annotation.Annotation[] java.lang.Package.getDeclaredAnnotations()", "getDeclaredAnnotations");
        testedDeclaredMethods_jdk6.put("static java.util.jar.Manifest java.lang.Package.access$100(java.lang.String)", "access$100");
        testedDeclaredMethods_jdk6.put("static java.util.Map java.lang.Package.access$400()", "access$400");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Package.isSealed()", "isSealed");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Package.isSealed(java.net.URL)", "isSealed");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Package.getSpecificationTitle()", "getSpecificationTitle");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Package.getSpecificationVersion()", "getSpecificationVersion");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Package.getSpecificationVendor()", "getSpecificationVendor");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Package.getImplementationTitle()", "getImplementationTitle");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Package.getImplementationVersion()", "getImplementationVersion");
        testedDeclaredMethods_jdk6.put("public java.lang.String java.lang.Package.getImplementationVendor()", "getImplementationVendor");
        testedDeclaredMethods_jdk6.put("public boolean java.lang.Package.isCompatibleWith(java.lang.String) throws java.lang.NumberFormatException", "isCompatibleWith");
        testedDeclaredMethods_jdk6.put("private java.lang.Class java.lang.Package.getPackageInfo()", "getPackageInfo");
        testedDeclaredMethods_jdk6.put("private static java.lang.Package java.lang.Package.defineSystemPackage(java.lang.String,java.lang.String)", "defineSystemPackage");
        testedDeclaredMethods_jdk6.put("private static java.util.jar.Manifest java.lang.Package.loadManifest(java.lang.String)", "loadManifest");
        testedDeclaredMethods_jdk6.put("private static java.lang.String java.lang.Package.getSystemPackage0(java.lang.String)", "getSystemPackage0");
        testedDeclaredMethods_jdk6.put("private static java.lang.String[] java.lang.Package.getSystemPackages0()", "getSystemPackages0");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Package.toString()", "toString");
        testedDeclaredMethods_jdk7.put("public int java.lang.Package.hashCode()", "hashCode");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Package.getName()", "getName");
        testedDeclaredMethods_jdk7.put("static java.util.jar.Manifest java.lang.Package.access$100(java.lang.String)", "access$100");
        testedDeclaredMethods_jdk7.put("public java.lang.annotation.Annotation java.lang.Package.getAnnotation(java.lang.Class)", "getAnnotation");
        testedDeclaredMethods_jdk7.put("public java.lang.annotation.Annotation[] java.lang.Package.getAnnotations()", "getAnnotations");
        testedDeclaredMethods_jdk7.put("public java.lang.annotation.Annotation[] java.lang.Package.getDeclaredAnnotations()", "getDeclaredAnnotations");
        testedDeclaredMethods_jdk7.put("static java.lang.Package java.lang.Package.getPackage(java.lang.Class)", "getPackage");
        testedDeclaredMethods_jdk7.put("public static java.lang.Package java.lang.Package.getPackage(java.lang.String)", "getPackage");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Package.isAnnotationPresent(java.lang.Class)", "isAnnotationPresent");
        testedDeclaredMethods_jdk7.put("static java.util.Map java.lang.Package.access$000()", "access$000");
        testedDeclaredMethods_jdk7.put("static java.util.Map java.lang.Package.access$200()", "access$200");
        testedDeclaredMethods_jdk7.put("public static java.lang.Package[] java.lang.Package.getPackages()", "getPackages");
        testedDeclaredMethods_jdk7.put("static java.lang.Package java.lang.Package.getSystemPackage(java.lang.String)", "getSystemPackage");
        testedDeclaredMethods_jdk7.put("static java.lang.Package[] java.lang.Package.getSystemPackages()", "getSystemPackages");
        testedDeclaredMethods_jdk7.put("static java.util.Map java.lang.Package.access$400()", "access$400");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Package.isSealed()", "isSealed");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Package.isSealed(java.net.URL)", "isSealed");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Package.getImplementationTitle()", "getImplementationTitle");
        testedDeclaredMethods_jdk7.put("private static java.lang.Package java.lang.Package.defineSystemPackage(java.lang.String,java.lang.String)", "defineSystemPackage");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Package.getImplementationVendor()", "getImplementationVendor");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Package.getImplementationVersion()", "getImplementationVersion");
        testedDeclaredMethods_jdk7.put("private java.lang.Class java.lang.Package.getPackageInfo()", "getPackageInfo");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Package.getSpecificationTitle()", "getSpecificationTitle");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Package.getSpecificationVendor()", "getSpecificationVendor");
        testedDeclaredMethods_jdk7.put("public java.lang.String java.lang.Package.getSpecificationVersion()", "getSpecificationVersion");
        testedDeclaredMethods_jdk7.put("private static java.lang.String java.lang.Package.getSystemPackage0(java.lang.String)", "getSystemPackage0");
        testedDeclaredMethods_jdk7.put("private static java.lang.String[] java.lang.Package.getSystemPackages0()", "getSystemPackages0");
        testedDeclaredMethods_jdk7.put("public boolean java.lang.Package.isCompatibleWith(java.lang.String) throws java.lang.NumberFormatException", "isCompatibleWith");
        testedDeclaredMethods_jdk7.put("private static java.util.jar.Manifest java.lang.Package.loadManifest(java.lang.String)", "loadManifest");
        Package o = Package.getPackage("java.lang");
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

