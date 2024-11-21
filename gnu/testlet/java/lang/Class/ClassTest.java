/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.Vector;

public class ClassTest
implements Cloneable,
Serializable,
Testlet {
    final int ACC_PUBLIC = 1;
    final int ACC_PRIVATE = 2;
    final int ACC_PROTECTED = 4;
    final int ACC_STATIC = 8;
    final int ACC_FINAL = 16;
    final int ACC_INTERFACE = 512;
    final int ACC_ABSTRACT = 1024;
    protected static TestHarness harness;

    public void test_toString() {
        harness.checkPoint("test_toString");
        harness.check(this.getClass().toString().equals(this.getClass().isInterface() ? "interface " : "class " + this.getClass().getName()));
        harness.check(new Object().getClass().toString().equals("class java.lang.Object"));
    }

    public void test_getName() {
        harness.checkPoint("test_getName");
        harness.check(new Vector().getClass().getName().equals("java.util.Vector"));
        harness.check(new Object[3].getClass().getName().equals("[Ljava.lang.Object;"));
        harness.check(new int[6][7][8].getClass().getName().equals("[[[I"));
        harness.check(Void.TYPE.getName().equals("void"));
        harness.check(Boolean.TYPE.getName().equals("boolean"));
        harness.check(Byte.TYPE.getName().equals("byte"));
        harness.check(Character.TYPE.getName().equals("char"));
        harness.check(Short.TYPE.getName().equals("short"));
        harness.check(Integer.TYPE.getName().equals("int"));
        harness.check(Long.TYPE.getName().equals("long"));
        harness.check(Float.TYPE.getName().equals("float"));
        harness.check(Double.TYPE.getName().equals("double"));
    }

    public void test_isInterface() {
        harness.checkPoint("test_isInterface");
        harness.check(!new Object().getClass().isInterface());
        harness.check(!this.getClass().isInterface());
        try {
            harness.check(Class.forName("java.lang.Cloneable").isInterface());
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }

    public void test_getSuperclass() {
        Class<Object> clss;
        harness.checkPoint("test_getSuperclass (superclass of Boolean is Object)");
        try {
            harness.check(new Boolean(true).getClass().getSuperclass() == Class.forName("java.lang.Object"));
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        harness.checkPoint("test_getSuperclass (superclass of java.lang.Boolean.TYPE is null)");
        try {
            harness.check(Boolean.TYPE.getSuperclass() == null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        harness.checkPoint("test_getSuperclass (superclass of Object is null)");
        harness.check(new Object().getClass().getSuperclass() == null);
        harness.checkPoint("test_getSuperclass (superclass of [[I is Object)");
        try {
            clss = Class.forName("[[I");
            harness.check(clss.getSuperclass() == Class.forName("java.lang.Object"));
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        harness.checkPoint("test_getSuperclass (superclass of [D is Object)");
        try {
            clss = Class.forName("[D");
            harness.check(clss.getSuperclass() == Class.forName("java.lang.Object"));
            harness.debug("superclass of " + clss + " is " + clss.getSuperclass());
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        harness.checkPoint("test_getSuperclass (superclass of Cloneable is null)");
        try {
            clss = Class.forName("java.lang.Cloneable");
            harness.check(clss.getSuperclass() == null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            clss = Void.TYPE;
            harness.check(clss.getSuperclass() == null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            clss = Double.TYPE;
            harness.check(clss.getSuperclass() == null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }

    public void test_primitiveTypes() {
        harness.checkPoint("test_primitiveTypes java.lang.Boolean.TYPE is primitive");
        Class<Object> cls = Boolean.TYPE;
        harness.check(cls.isPrimitive());
        harness.checkPoint("test_primitiveTypes java.lang.Double.TYPE is primitive");
        cls = Double.TYPE;
        harness.check(cls.isPrimitive());
        harness.checkPoint("test_primitiveTypes java.lang.Void.TYPE is primitive");
        cls = Void.TYPE;
        harness.check(cls.isPrimitive());
        harness.checkPoint("test_primitiveTypes java.lang.Object is not primitive");
        try {
            cls = Class.forName("java.lang.Object");
            harness.check(!cls.isPrimitive());
        }
        catch (Exception e) {
            harness.check(false);
        }
        harness.checkPoint("test_primitiveTypes java.lang.Integer is not primitive");
        try {
            cls = Class.forName("java.lang.Integer");
            harness.check(!cls.isPrimitive());
        }
        catch (Exception e) {
            harness.check(false);
        }
        try {
            harness.checkPoint("test_primitiveTypes [I is not primitive");
            cls = Class.forName("[I");
            harness.check(!cls.isPrimitive());
        }
        catch (Exception e) {
            harness.check(false);
        }
    }

    public void test_Modifiers() {
        harness.checkPoint("test_Modifiers java.lang.Boolean.TYPE modifiers");
        Class<Boolean> cls = Boolean.TYPE;
        harness.check(cls.getModifiers() & 0x217, 17);
        harness.checkPoint("test_Modifiers java.lang.Boolean modifiers");
        try {
            cls = Class.forName("java.lang.Boolean");
            harness.check(cls.getModifiers() & 0x217, 17);
        }
        catch (Exception e) {
            harness.check(false);
        }
        harness.checkPoint("test_Modifiers [I modifiers");
        try {
            cls = Class.forName("[I");
            harness.check(cls.getModifiers() & 0x217, 17);
        }
        catch (Exception e) {
            harness.check(false);
        }
        harness.checkPoint("test_Modifiers private modifier");
        PrivateType foo = new PrivateType();
        cls = foo.getClass();
        harness.check(cls.getModifiers() & 2, 2);
        harness.checkPoint("test_Modifiers array modifiers");
        harness.checkPoint("test_Modifiers java.lang.Boolean modifiers");
        cls = Boolean.TYPE;
        harness.check((cls.getModifiers() & 0x11) != 0);
    }

    public void test_getInterfaces() {
        Class<?> clsss;
        harness.checkPoint("test_getInterfaces");
        Class<?>[] clss = this.getClass().getInterfaces();
        Class<?> clclass = null;
        Class<?> clclass1 = null;
        try {
            clclass = Class.forName("java.lang.Cloneable");
            clclass1 = Class.forName("java.io.Serializable");
            harness.check(true);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        harness.check(clss != null && clss.length == 3 && clss[0] == clclass && clss[1] == clclass1);
        if (clss != null && clss.length == 3 && (clss[0] != clclass || clss[1] != clclass1)) {
            for (int i = 0; i < clss.length; ++i) {
                harness.debug("" + clss[i], false);
                harness.debug(" ", false);
            }
            harness.debug("");
        }
        try {
            clsss = Class.forName("[[I");
            harness.check(clsss.getInterfaces().length, 2);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            clsss = Class.forName("[D");
            harness.check(clsss.getInterfaces().length, 2);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }

    public void test_newInstance() {
        harness.checkPoint("test_newInstance");
        Class<?> clss = this.getClass();
        try {
            Object obj = clss.newInstance();
            obj = clss.newInstance();
            obj = clss.newInstance();
            obj = clss.newInstance();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error: newInstance failed");
            harness.debug(e);
        }
        catch (Error e) {
            harness.fail("Error: newInstance failed with an Error");
            harness.debug(e);
        }
    }

    public void test_forName() {
        harness.checkPoint("test_forName");
        try {
            Class<?> obj = Class.forName("java.lang.Object");
            harness.check(obj != null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        this.checkClassNotFoundException("ab.cd.ef");
        this.checkClassNotFoundException("I");
        this.checkClassNotFoundException("int");
        this.checkClassNotFoundException("[");
        this.checkClassNotFoundException("[int");
        this.checkClassNotFoundException("[II");
        this.checkClassNotFoundException("[L");
        this.checkClassNotFoundException("[L;");
        this.checkClassNotFoundException("[L[I;");
        this.checkClassNotFoundException("[Ljava.lang.Object");
        this.checkClassNotFoundException("[Ljava.lang.Objectx");
        this.checkClassNotFoundException("[Ljava.lang.Object;x");
        this.checkClassNotFoundException("java/lang/Object");
    }

    private void checkClassNotFoundException(String className) {
        try {
            Class<?> c = Class.forName(className);
            harness.debug("class: " + c);
            harness.debug("classloader: " + c.getClassLoader());
            if (c.isArray()) {
                Class<?> ct = c.getComponentType();
                harness.debug("component type: " + ct);
                harness.debug("component type classloader: " + ct.getClassLoader());
            }
            harness.check(false);
        }
        catch (ClassNotFoundException e) {
            harness.check(true);
        }
        catch (Exception x) {
            harness.debug(x);
            harness.check(false);
        }
    }

    public void test_getClassloader() {
        harness.checkPoint("test_getClassloader");
        try {
            Class<?> obj2 = Class.forName("gnu.testlet.java.lang.Class.ClassTest");
            ClassLoader ldr1 = obj2.getClassLoader();
            harness.check(ldr1 != null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }

    public void test_ComponentType() {
        Class<?> arrclass;
        harness.checkPoint("test_ComponentType");
        try {
            Class<?> obj1 = Class.forName("java.lang.String");
            harness.check(obj1.getComponentType() == null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            Class<?> obj2 = Class.forName("java.lang.Exception");
            harness.check(obj2.getComponentType() == null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            arrclass = Class.forName("[I");
            harness.check(arrclass.getComponentType() != null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            arrclass = Class.forName("[[[[I");
            harness.check(arrclass.getComponentType() != null);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }

    public void test_isMethods() {
        Class<?> cls1;
        harness.checkPoint("test_isMethods");
        try {
            Class<?> obj1 = Class.forName("java.lang.String");
            harness.check(obj1.isInstance("babu"));
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            Class<?> obj2 = Class.forName("java.lang.Integer");
            harness.check(obj2.isInstance(new Integer(10)));
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            int[] arr = new int[3];
            Class<?> arrclass = Class.forName("[I");
            harness.check(arrclass.isInstance(arr));
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            cls1 = Class.forName("java.lang.String");
            Class<?> supercls = Class.forName("java.lang.Object");
            harness.check(supercls.isAssignableFrom(cls1) && !cls1.isAssignableFrom(supercls));
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            cls1 = Class.forName("java.lang.String");
            Class<?> cls2 = Class.forName("java.lang.String");
            harness.check(cls2.isAssignableFrom(cls1));
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            Class<?> arrclass = Class.forName("[I");
            Class<?> arrclass1 = Class.forName("[[[I");
            Class<?> arrclass2 = Class.forName("[[D");
            harness.check(arrclass.isArray() && arrclass1.isArray() && arrclass2.isArray());
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }

    public void test_getResource() {
        harness.checkPoint("test_getResource");
        try {
            int i;
            FileInputStream is = new FileInputStream("ClassTest.class");
            URL url = this.getClass().getResource("ClassTest.class");
            harness.check(url != null);
            if (url == null) {
                return;
            }
            InputStream uis = url.openStream();
            byte[] b1 = new byte[100];
            byte[] b2 = new byte[100];
            int ret = is.read(b1);
            harness.check(ret == 100);
            ret = uis.read(b2);
            harness.check(ret == 100);
            for (i = 0; i < 100; ++i) {
                if (b1[i] != b2[i]) {
                    harness.check(false);
                    break;
                }
                if (i != 99) continue;
                harness.check(true);
            }
            harness.check((uis = this.getClass().getResourceAsStream("ClassTest.class")) != null);
            if (uis == null) {
                return;
            }
            ret = uis.read(b2);
            harness.check(ret == 100);
            for (i = 0; i < 100; ++i) {
                if (b1[i] != b2[i]) {
                    harness.check(false);
                    break;
                }
                if (i != 99) continue;
                harness.check(true);
            }
        }
        catch (IOException ex) {
            harness.debug(ex);
            harness.fail("IOException in test_getResource");
        }
    }

    public void test_getResourceAsStream() {
        harness.checkPoint("test_getResourceAsStream");
        InputStream in = Class.class.getResourceAsStream("Class.class");
        harness.check(in != null);
        in = Class.class.getResourceAsStream("/java/lang/Class.class");
        harness.check(in != null);
        in = InputStream.class.getResourceAsStream("Class.class");
        harness.check(in == null);
    }

    public void testall() {
        this.test_toString();
        this.test_getName();
        this.test_isInterface();
        this.test_getSuperclass();
        this.test_primitiveTypes();
        this.test_Modifiers();
        this.test_getInterfaces();
        this.test_newInstance();
        this.test_forName();
        this.test_ComponentType();
        this.test_getClassloader();
        this.test_isMethods();
        this.test_getResourceAsStream();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }

    private class PrivateType {
        int foo;

        private PrivateType() {
        }
    }
}

