/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Permission;
import java.security.Security;

public class security
implements Testlet {
    private static String[] modifiers = new String[]{"", "static"};
    private static Class[][] methodtypes = new Class[][]{{Short.TYPE}, new Class[0], {Integer.TYPE}, {String.class, Boolean.TYPE}};
    private static Class[][] constructortypes = new Class[][]{{Short.TYPE}, {Integer.TYPE}, {String.class, Integer.TYPE}, {Integer.TYPE, Integer.TYPE}, {Byte.TYPE}, {String.class}, {Integer.TYPE, String.class}, {Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Class[0]};
    private boolean field1;
    byte field2;
    protected int field3;
    public String field4;
    private static boolean staticfield1;
    static byte staticfield2;
    protected static int staticfield3;
    public static String staticfield4;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("setup");
            Class<?> testClass = new URLClassLoader(new URL[]{new File(harness.getBuildDirectory()).toURL()}, null).loadClass(this.getClass().getName());
            harness.check(this.getClass().getClassLoader() != testClass.getClassLoader());
            testClass.getDeclaredClasses();
            testClass.getDeclaredMethods();
            String oldrestrictions = Security.getProperty("package.access");
            Security.setProperty("package.access", "gnu.testlet.java.lang.Class.");
            try {
                Permission[] noChecks = new Permission[]{};
                Permission[] getClassLoader = new Permission[]{new RuntimePermission("getClassLoader")};
                Permission[] accessDeclaredMembers = new Permission[]{new RuntimePermission("accessDeclaredMembers"), new RuntimePermission("accessClassInPackage.gnu.testlet.java.lang.Class")};
                Permission[] accessPublicMembers = new Permission[]{new RuntimePermission(TestSecurityManager3.publicPerm), new RuntimePermission("accessClassInPackage.gnu.testlet.java.lang.Class")};
                Permission[] getProtectionDomain = new Permission[]{new RuntimePermission("getProtectionDomain")};
                TestSecurityManager sm = new TestSecurityManager(harness);
                try {
                    sm.install();
                    harness.checkPoint("forName");
                    try {
                        sm.prepareChecks(getClassLoader);
                        Class.forName("java.lang.Class", false, null);
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        harness.debug(ex);
                        harness.check(false, "unexpected check");
                    }
                    harness.checkPoint("getClassLoader");
                    try {
                        sm.prepareChecks(getClassLoader);
                        testClass.getClassLoader();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        harness.debug(ex);
                        harness.check(false, "unexpected check");
                    }
                    try {
                        sm.prepareChecks(noChecks);
                        Thread.class.getClassLoader();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        harness.debug(ex);
                        harness.check(false, "unexpected check");
                    }
                    this.getMemberChecks(harness, sm, testClass, true, accessDeclaredMembers);
                    harness.checkPoint("getProtectionDomain");
                    try {
                        sm.prepareChecks(getProtectionDomain);
                        testClass.getProtectionDomain();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        harness.debug(ex);
                        harness.check(false, "unexpected check");
                    }
                    try {
                        sm.prepareChecks(getProtectionDomain);
                        this.getClass().getProtectionDomain();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        harness.debug(ex);
                        harness.check(false, "unexpected check");
                    }
                }
                finally {
                    sm.uninstall();
                }
                sm = new TestSecurityManager3(harness);
                try {
                    sm.install();
                    this.getMemberChecks(harness, sm, testClass, false, accessPublicMembers);
                }
                finally {
                    sm.uninstall();
                }
            }
            finally {
                if (oldrestrictions != null) {
                    Security.setProperty("package.access", oldrestrictions);
                }
            }
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
    }

    private void getMemberChecks(TestHarness harness, TestSecurityManager sm, Class testClass, boolean declared, Permission[] mustCheck) {
        int j;
        int level;
        if (declared) {
            harness.checkPoint("getDeclaredClasses");
        } else {
            harness.checkPoint("getClasses");
        }
        try {
            sm.prepareChecks(mustCheck);
            if (declared) {
                testClass.getDeclaredClasses();
            } else {
                testClass.getClasses();
            }
            sm.checkAllChecked();
        }
        catch (SecurityException ex) {
            harness.debug(ex);
            harness.check(false, "unexpected check");
        }
        if (declared) {
            harness.checkPoint("getDeclaredFields");
        } else {
            harness.checkPoint("getFields");
        }
        try {
            sm.prepareChecks(mustCheck);
            if (declared) {
                testClass.getDeclaredFields();
            } else {
                testClass.getFields();
            }
            sm.checkAllChecked();
        }
        catch (SecurityException ex) {
            harness.debug(ex);
            harness.check(false, "unexpected check");
        }
        if (declared) {
            harness.checkPoint("getDeclaredMethods");
        } else {
            harness.checkPoint("getMethods");
        }
        try {
            sm.prepareChecks(mustCheck);
            if (declared) {
                testClass.getDeclaredMethods();
            } else {
                testClass.getMethods();
            }
            sm.checkAllChecked();
        }
        catch (SecurityException ex) {
            harness.debug(ex);
            harness.check(false, "unexpected check");
        }
        if (declared) {
            harness.checkPoint("getDeclaredConstructors");
        } else {
            harness.checkPoint("getConstructors");
        }
        try {
            sm.prepareChecks(mustCheck);
            if (declared) {
                testClass.getDeclaredConstructors();
            } else {
                testClass.getConstructors();
            }
            sm.checkAllChecked();
        }
        catch (SecurityException ex) {
            harness.debug(ex);
            harness.check(false, "unexpected check");
        }
        if (declared) {
            harness.checkPoint("getDeclaredField");
            level = 0;
        } else {
            harness.checkPoint("getField");
            level = 3;
        }
        try {
            for (int i = 0; i < modifiers.length; ++i) {
                for (j = 0; j < 5; ++j) {
                    boolean exists;
                    sm.prepareChecks(mustCheck);
                    try {
                        String name2 = modifiers[i] + "field" + j;
                        if (declared) {
                            testClass.getDeclaredField(name2);
                        } else {
                            testClass.getField(name2);
                        }
                        exists = true;
                    }
                    catch (NoSuchFieldException e) {
                        exists = false;
                    }
                    sm.checkAllChecked();
                    harness.check(exists == j > level);
                }
            }
        }
        catch (SecurityException ex) {
            harness.debug(ex);
            harness.check(false, "unexpected check");
        }
        if (declared) {
            harness.checkPoint("getDeclaredMethod");
        } else {
            harness.checkPoint("getMethod");
        }
        try {
            for (int i = 0; i < modifiers.length; ++i) {
                for (j = 0; j < 5; ++j) {
                    for (int k = 0; k < methodtypes.length; ++k) {
                        boolean exists;
                        sm.prepareChecks(mustCheck);
                        try {
                            String name3 = modifiers[i] + "method" + j;
                            if (declared) {
                                testClass.getDeclaredMethod(name3, methodtypes[k]);
                            } else {
                                testClass.getMethod(name3, methodtypes[k]);
                            }
                            exists = true;
                        }
                        catch (NoSuchMethodException e) {
                            exists = false;
                        }
                        sm.checkAllChecked();
                        harness.check(exists == (j > level && k > 0));
                    }
                }
            }
        }
        catch (SecurityException ex) {
            harness.debug(ex);
            harness.check(false, "unexpected check");
        }
        if (declared) {
            harness.checkPoint("getDeclaredConstructor");
            level = 0;
        } else {
            harness.checkPoint("getConstructor");
            level = 6;
        }
        try {
            for (int i = 0; i < constructortypes.length; ++i) {
                boolean exists;
                sm.prepareChecks(mustCheck);
                try {
                    if (declared) {
                        testClass.getDeclaredConstructor(constructortypes[i]);
                    } else {
                        testClass.getConstructor(constructortypes[i]);
                    }
                    exists = true;
                }
                catch (NoSuchMethodException e) {
                    exists = false;
                }
                sm.checkAllChecked();
                harness.check(exists == i > level);
            }
        }
        catch (SecurityException ex) {
            harness.debug(ex);
            harness.check(false, "unexpected check");
        }
    }

    private void method1() {
    }

    private void method1(int a) {
    }

    private void method1(String b, boolean c) {
    }

    char method2() {
        return 'a';
    }

    char method2(int a) {
        return 'b';
    }

    char method2(String b, boolean c) {
        return '1';
    }

    protected String method3() {
        return "x0x";
    }

    protected String method3(int a) {
        return "y";
    }

    protected String method3(String b, boolean c) {
        return "z";
    }

    public int method4() {
        return 1;
    }

    public int method4(int a) {
        return 0;
    }

    public int method4(String b, boolean c) {
        return -5;
    }

    private static void staticmethod1() {
    }

    private static void staticmethod1(int a) {
    }

    private static void staticmethod1(String b, boolean c) {
    }

    static char staticmethod2() {
        return 'a';
    }

    static char staticmethod2(int a) {
        return 'b';
    }

    static char staticmethod2(String b, boolean c) {
        return '1';
    }

    protected static String staticmethod3() {
        return "x0x";
    }

    protected static String staticmethod3(int a) {
        return "y";
    }

    protected static String staticmethod3(String b, boolean c) {
        return "z";
    }

    public static int staticmethod4() {
        return 1;
    }

    public static int staticmethod4(int a) {
        return 0;
    }

    public static int staticmethod4(String b, boolean c) {
        return -5;
    }

    private security(int a) {
    }

    private security(String a, int b) {
    }

    security(int a, int b) {
    }

    security(byte a) {
    }

    protected security(String a) {
    }

    protected security(int a, String b) {
    }

    public security(int a, int b, int c) {
    }

    public security() {
    }

    public void shutUp() {
        staticfield1 = false;
        this.field1 = false;
        new security(5).method1();
        new security("hello", 5).method1(5);
        this.method1("4", this.field1);
        security.staticmethod1();
        security.staticmethod1(5);
        security.staticmethod1("4", staticfield1);
    }

    private static class TestSecurityManager3
    extends TestSecurityManager {
        static String publicPerm = "gnuAccessPublicMembers";

        TestSecurityManager3(TestHarness harness) {
            super(harness);
        }

        public void checkMemberAccess(Class c, int memberType) {
            if (c == null) {
                throw new NullPointerException();
            }
            if (memberType == 0) {
                this.checkPermission(new RuntimePermission(publicPerm));
            }
        }
    }
}

