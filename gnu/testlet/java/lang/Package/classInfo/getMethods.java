/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Package.classInfo;

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
        testedMethods_jdk6.put("public java.lang.String java.lang.Package.toString()", "toString");
        testedMethods_jdk6.put("public int java.lang.Package.hashCode()", "hashCode");
        testedMethods_jdk6.put("public java.lang.String java.lang.Package.getName()", "getName");
        testedMethods_jdk6.put("public static java.lang.Package[] java.lang.Package.getPackages()", "getPackages");
        testedMethods_jdk6.put("public static java.lang.Package java.lang.Package.getPackage(java.lang.String)", "getPackage");
        testedMethods_jdk6.put("public java.lang.annotation.Annotation java.lang.Package.getAnnotation(java.lang.Class)", "getAnnotation");
        testedMethods_jdk6.put("public boolean java.lang.Package.isAnnotationPresent(java.lang.Class)", "isAnnotationPresent");
        testedMethods_jdk6.put("public java.lang.annotation.Annotation[] java.lang.Package.getAnnotations()", "getAnnotations");
        testedMethods_jdk6.put("public java.lang.annotation.Annotation[] java.lang.Package.getDeclaredAnnotations()", "getDeclaredAnnotations");
        testedMethods_jdk6.put("public boolean java.lang.Package.isSealed()", "isSealed");
        testedMethods_jdk6.put("public boolean java.lang.Package.isSealed(java.net.URL)", "isSealed");
        testedMethods_jdk6.put("public java.lang.String java.lang.Package.getSpecificationTitle()", "getSpecificationTitle");
        testedMethods_jdk6.put("public java.lang.String java.lang.Package.getSpecificationVersion()", "getSpecificationVersion");
        testedMethods_jdk6.put("public java.lang.String java.lang.Package.getSpecificationVendor()", "getSpecificationVendor");
        testedMethods_jdk6.put("public java.lang.String java.lang.Package.getImplementationTitle()", "getImplementationTitle");
        testedMethods_jdk6.put("public java.lang.String java.lang.Package.getImplementationVersion()", "getImplementationVersion");
        testedMethods_jdk6.put("public java.lang.String java.lang.Package.getImplementationVendor()", "getImplementationVendor");
        testedMethods_jdk6.put("public boolean java.lang.Package.isCompatibleWith(java.lang.String) throws java.lang.NumberFormatException", "isCompatibleWith");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk6.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedMethods_jdk6.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk6.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk6.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        testedMethods_jdk7.put("public java.lang.String java.lang.Package.toString()", "toString");
        testedMethods_jdk7.put("public int java.lang.Package.hashCode()", "hashCode");
        testedMethods_jdk7.put("public java.lang.String java.lang.Package.getName()", "getName");
        testedMethods_jdk7.put("public java.lang.annotation.Annotation java.lang.Package.getAnnotation(java.lang.Class)", "getAnnotation");
        testedMethods_jdk7.put("public java.lang.annotation.Annotation[] java.lang.Package.getAnnotations()", "getAnnotations");
        testedMethods_jdk7.put("public java.lang.annotation.Annotation[] java.lang.Package.getDeclaredAnnotations()", "getDeclaredAnnotations");
        testedMethods_jdk7.put("public static java.lang.Package java.lang.Package.getPackage(java.lang.String)", "getPackage");
        testedMethods_jdk7.put("public boolean java.lang.Package.isAnnotationPresent(java.lang.Class)", "isAnnotationPresent");
        testedMethods_jdk7.put("public static java.lang.Package[] java.lang.Package.getPackages()", "getPackages");
        testedMethods_jdk7.put("public boolean java.lang.Package.isSealed()", "isSealed");
        testedMethods_jdk7.put("public boolean java.lang.Package.isSealed(java.net.URL)", "isSealed");
        testedMethods_jdk7.put("public java.lang.String java.lang.Package.getImplementationTitle()", "getImplementationTitle");
        testedMethods_jdk7.put("public java.lang.String java.lang.Package.getImplementationVendor()", "getImplementationVendor");
        testedMethods_jdk7.put("public java.lang.String java.lang.Package.getImplementationVersion()", "getImplementationVersion");
        testedMethods_jdk7.put("public java.lang.String java.lang.Package.getSpecificationTitle()", "getSpecificationTitle");
        testedMethods_jdk7.put("public java.lang.String java.lang.Package.getSpecificationVendor()", "getSpecificationVendor");
        testedMethods_jdk7.put("public java.lang.String java.lang.Package.getSpecificationVersion()", "getSpecificationVersion");
        testedMethods_jdk7.put("public boolean java.lang.Package.isCompatibleWith(java.lang.String) throws java.lang.NumberFormatException", "isCompatibleWith");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait(long) throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public final void java.lang.Object.wait() throws java.lang.InterruptedException", "wait");
        testedMethods_jdk7.put("public boolean java.lang.Object.equals(java.lang.Object)", "equals");
        testedMethods_jdk7.put("public final java.lang.Class java.lang.Object.getClass()", "getClass");
        testedMethods_jdk7.put("public final void java.lang.Object.notify()", "notify");
        testedMethods_jdk7.put("public final void java.lang.Object.notifyAll()", "notifyAll");
        Package o = Package.getPackage("java.lang");
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

