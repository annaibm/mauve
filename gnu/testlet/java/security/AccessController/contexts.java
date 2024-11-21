/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.AccessController;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public class contexts
implements Testlet {
    private String base = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        if (System.getProperty("gnu.classpath.version") == null) {
            return;
        }
        File[] jars = new File[]{null, null, null};
        try {
            harness.checkPoint("setup");
            String base = new File(harness.getTempDirectory(), "ac").getCanonicalPath();
            jars[0] = new File(base + "1.jar");
            JarOutputStream jos = new JarOutputStream(new FileOutputStream(jars[0]));
            contexts.copyClass(harness.getBuildDirectory(), jos, this.getClass());
            contexts.copyClass(harness.getBuildDirectory(), jos, TestHarness.class);
            jos.close();
            for (int i = 1; i < jars.length; ++i) {
                jars[i] = new File(base + (i + 1) + ".jar");
                contexts.copyFile(jars[0], jars[i]);
            }
            TestObject[] testObjects = new TestObject[jars.length];
            for (int i = 0; i < jars.length; ++i) {
                Class<?> testClass = new URLClassLoader(new URL[]{jars[i].toURL()}, null).loadClass(this.getClass().getName());
                harness.check(this.getClass().getClassLoader() != testClass.getClassLoader());
                Constructor<?> c = testClass.getConstructor(String.class);
                testObjects[i] = new TestObject(c.newInstance(base));
            }
            contexts.test(harness, testObjects);
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
        finally {
            for (int i = 0; i < jars.length; ++i) {
                if (!jars[i].exists()) continue;
                jars[i].delete();
            }
        }
    }

    private static void copyClass(String srcdir, JarOutputStream jos, Class cls) throws Exception {
        Class superclass;
        File root = new File(srcdir, cls.getName().replace(".", File.separator));
        final String rootpath = root.getPath();
        int chop = srcdir.length() + File.separator.length();
        File dir = root.getParentFile();
        if (dir.isDirectory()) {
            File[] files = dir.listFiles(new FileFilter(){

                @Override
                public boolean accept(File file) {
                    String path = file.getPath();
                    if (path.endsWith(".class")) {
                        if ((path = path.substring(0, path.length() - 6)).equals(rootpath)) {
                            return true;
                        }
                        if (path.startsWith(rootpath + "$")) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            for (int i = 0; i < files.length; ++i) {
                byte[] bytes = new byte[(int)files[i].length()];
                FileInputStream fis = new FileInputStream(files[i]);
                fis.read(bytes);
                fis.close();
                jos.putNextEntry(new JarEntry(files[i].getPath().substring(chop)));
                jos.write(bytes, 0, bytes.length);
            }
        }
        if ((superclass = cls.getSuperclass()) != null) {
            contexts.copyClass(srcdir, jos, superclass);
        }
        Class<?>[] interfaces = cls.getInterfaces();
        for (int i = 0; i < interfaces.length; ++i) {
            contexts.copyClass(srcdir, jos, interfaces[i]);
        }
    }

    private static void copyFile(File src, File dst) throws Exception {
        byte[] bytes = new byte[(int)src.length()];
        FileInputStream fis = new FileInputStream(src);
        fis.read(bytes);
        fis.close();
        FileOutputStream fos = new FileOutputStream(dst);
        fos.write(bytes);
        fos.close();
    }

    public contexts() {
    }

    public contexts(String base) {
        this.base = base;
    }

    public String[] listJarsOf(Object object) throws Exception {
        Method method = object.getClass().getMethod("listJars", new Class[0]);
        return (String[])method.invoke(object, new Object[0]);
    }

    public String[] callListJarsOf(Object caller, Object callee) throws Exception {
        Method method = caller.getClass().getMethod("listJarsOf", Object.class);
        return (String[])method.invoke(caller, callee);
    }

    public String[] callPrivilegedListJarsOf(Object caller, Object callee) throws Exception {
        Method method = caller.getClass().getMethod("privilegedListJarsOf", Object.class);
        return (String[])method.invoke(caller, callee);
    }

    public String[] privilegedListJarsOf(final Object object) throws Exception {
        final Method method = object.getClass().getMethod("listJars", new Class[0]);
        return (String[])AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                try {
                    return method.invoke(object, new Object[0]);
                }
                catch (Exception e) {
                    return e;
                }
            }
        });
    }

    public String[] listJars() throws Exception {
        AccessControlContext ctx = AccessController.getContext();
        Field field = ctx.getClass().getDeclaredField("protectionDomains");
        field.setAccessible(true);
        ProtectionDomain[] domains = (ProtectionDomain[])field.get(ctx);
        LinkedList<String> jars = new LinkedList<String>();
        for (int i = 0; i < domains.length; ++i) {
            PermissionCollection perms = domains[i].getPermissions();
            Enumeration<Permission> e = perms.elements();
            while (e.hasMoreElements()) {
                String path;
                Permission p = e.nextElement();
                if (!(p instanceof FilePermission) || (path = p.getName()).length() != this.base.length() + 5 || !path.startsWith(this.base) || !Character.isDigit(path.charAt(this.base.length())) || !path.endsWith(".jar")) continue;
                jars.add(path);
            }
        }
        return jars.toArray(new String[jars.size()]);
    }

    private static void test(TestHarness harness, TestObject[] objects) throws Exception {
        int j;
        int i;
        int i2;
        harness.checkPoint("self-listing");
        String[] jars = new String[objects.length];
        for (i2 = 0; i2 < objects.length; ++i2) {
            String[] result = objects[i2].listJarsOf(objects[i2]);
            harness.check(result.length == 1);
            jars[i2] = result[0];
        }
        for (i2 = 0; i2 < objects.length; ++i2) {
            for (int j2 = i2 + 1; j2 < objects.length; ++j2) {
                harness.check(!jars[i2].equals(jars[j2]));
            }
        }
        harness.checkPoint("straight other-listing");
        boolean[] seen = new boolean[jars.length];
        String[] result = objects[0].listJarsOf(objects[1]);
        harness.check(result.length == 2);
        for (i = 0; i < seen.length; ++i) {
            seen[i] = false;
            for (j = 0; j < result.length; ++j) {
                if (!result[j].equals(jars[i])) continue;
                harness.check(!seen[i]);
                seen[i] = true;
            }
        }
        harness.check(seen[0] && seen[1] && !seen[2]);
        harness.checkPoint("straight other-other-listing");
        result = objects[0].callListJarsOf(objects[1], objects[2]);
        harness.check(result.length == 3);
        for (i = 0; i < seen.length; ++i) {
            seen[i] = false;
            for (j = 0; j < result.length; ++j) {
                if (!result[j].equals(jars[i])) continue;
                harness.check(!seen[i]);
                seen[i] = true;
            }
        }
        harness.check(seen[0] && seen[1] && seen[2]);
        harness.checkPoint("privileged other-other-listing");
        result = objects[0].callPrivilegedListJarsOf(objects[1], objects[2]);
        harness.check(result.length == 2);
        for (i = 0; i < seen.length; ++i) {
            seen[i] = false;
            for (j = 0; j < result.length; ++j) {
                if (!result[j].equals(jars[i])) continue;
                harness.check(!seen[i]);
                seen[i] = true;
            }
        }
        harness.check(!seen[0] && seen[1] && seen[2]);
    }

    private static class TestObject {
        private Object object;

        public TestObject(Object object) {
            this.object = object;
        }

        public String[] listJarsOf(TestObject other) throws Exception {
            Method method = this.object.getClass().getMethod("listJarsOf", Object.class);
            return (String[])method.invoke(this.object, other.object);
        }

        public String[] callListJarsOf(TestObject caller, TestObject callee) throws Exception {
            Method method = this.object.getClass().getMethod("callListJarsOf", Object.class, Object.class);
            return (String[])method.invoke(this.object, caller.object, callee.object);
        }

        public String[] callPrivilegedListJarsOf(TestObject caller, TestObject callee) throws Exception {
            Method method = this.object.getClass().getMethod("callPrivilegedListJarsOf", Object.class, Object.class);
            return (String[])method.invoke(this.object, caller.object, callee.object);
        }
    }
}

