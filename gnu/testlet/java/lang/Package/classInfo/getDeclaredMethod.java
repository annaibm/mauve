/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Package.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class getDeclaredMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> methodsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk6.put("toString", new Class[0]);
        methodsThatShouldExist_jdk6.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk6.put("getName", new Class[0]);
        methodsThatShouldExist_jdk6.put("getPackages", new Class[0]);
        methodsThatShouldExist_jdk6.put("access$000", new Class[0]);
        methodsThatShouldExist_jdk6.put("getSystemPackage", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getSystemPackages", new Class[0]);
        methodsThatShouldExist_jdk6.put("access$200", new Class[0]);
        methodsThatShouldExist_jdk6.put("getPackage", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getPackage", new Class[]{Class.class});
        methodsThatShouldExist_jdk6.put("getAnnotation", new Class[]{Class.class});
        methodsThatShouldExist_jdk6.put("isAnnotationPresent", new Class[]{Class.class});
        methodsThatShouldExist_jdk6.put("getAnnotations", new Class[0]);
        methodsThatShouldExist_jdk6.put("getDeclaredAnnotations", new Class[0]);
        methodsThatShouldExist_jdk6.put("access$100", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("access$400", new Class[0]);
        methodsThatShouldExist_jdk6.put("isSealed", new Class[0]);
        methodsThatShouldExist_jdk6.put("isSealed", new Class[]{URL.class});
        methodsThatShouldExist_jdk6.put("getSpecificationTitle", new Class[0]);
        methodsThatShouldExist_jdk6.put("getSpecificationVersion", new Class[0]);
        methodsThatShouldExist_jdk6.put("getSpecificationVendor", new Class[0]);
        methodsThatShouldExist_jdk6.put("getImplementationTitle", new Class[0]);
        methodsThatShouldExist_jdk6.put("getImplementationVersion", new Class[0]);
        methodsThatShouldExist_jdk6.put("getImplementationVendor", new Class[0]);
        methodsThatShouldExist_jdk6.put("isCompatibleWith", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getPackageInfo", new Class[0]);
        methodsThatShouldExist_jdk6.put("defineSystemPackage", new Class[]{String.class, String.class});
        methodsThatShouldExist_jdk6.put("loadManifest", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getSystemPackage0", new Class[]{String.class});
        methodsThatShouldExist_jdk6.put("getSystemPackages0", new Class[0]);
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk7.put("getName", new Class[0]);
        methodsThatShouldExist_jdk7.put("access$100", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getAnnotation", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("getAnnotations", new Class[0]);
        methodsThatShouldExist_jdk7.put("getDeclaredAnnotations", new Class[0]);
        methodsThatShouldExist_jdk7.put("getPackage", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("getPackage", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("isAnnotationPresent", new Class[]{Class.class});
        methodsThatShouldExist_jdk7.put("access$000", new Class[0]);
        methodsThatShouldExist_jdk7.put("access$200", new Class[0]);
        methodsThatShouldExist_jdk7.put("getPackages", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSystemPackage", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getSystemPackages", new Class[0]);
        methodsThatShouldExist_jdk7.put("access$400", new Class[0]);
        methodsThatShouldExist_jdk7.put("isSealed", new Class[0]);
        methodsThatShouldExist_jdk7.put("isSealed", new Class[]{URL.class});
        methodsThatShouldExist_jdk7.put("getImplementationTitle", new Class[0]);
        methodsThatShouldExist_jdk7.put("defineSystemPackage", new Class[]{String.class, String.class});
        methodsThatShouldExist_jdk7.put("getImplementationVendor", new Class[0]);
        methodsThatShouldExist_jdk7.put("getImplementationVersion", new Class[0]);
        methodsThatShouldExist_jdk7.put("getPackageInfo", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSpecificationTitle", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSpecificationVendor", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSpecificationVersion", new Class[0]);
        methodsThatShouldExist_jdk7.put("getSystemPackage0", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("getSystemPackages0", new Class[0]);
        methodsThatShouldExist_jdk7.put("isCompatibleWith", new Class[]{String.class});
        methodsThatShouldExist_jdk7.put("loadManifest", new Class[]{String.class});
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        Package o = Package.getPackage("java.lang");
        Class<?> c = o.getClass();
        for (Map.Entry methodThatShouldExists : methodsThatShouldExist.entrySet()) {
            try {
                Method method = c.getDeclaredMethod((String)methodThatShouldExists.getKey(), (Class[])methodThatShouldExists.getValue());
                harness.check(method != null);
                String methodName = method.getName();
                harness.check(methodName != null);
                harness.check(methodName, methodThatShouldExists.getKey());
            }
            catch (Exception e) {
                harness.check(false);
            }
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

