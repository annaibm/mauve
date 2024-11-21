/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.AccessibleObject;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class accessible
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            Class<?> cl_class = Class.forName("java.lang.ClassLoader");
            Class[] params = new Class[]{};
            Constructor<?> cl_cons = cl_class.getDeclaredConstructor(params);
            harness.check(!cl_cons.isAccessible());
            cl_cons.setAccessible(true);
            harness.check(cl_cons.isAccessible());
            cl_cons = cl_class.getDeclaredConstructor(params);
            harness.check(!cl_cons.isAccessible());
            params = new Class[]{Class.forName("java.lang.String")};
            Method m = cl_class.getDeclaredMethod("findLoadedClass", params);
            harness.check(!m.isAccessible());
            m.setAccessible(true);
            harness.check(m.isAccessible());
            m = cl_class.getDeclaredMethod("findLoadedClass", params);
            harness.check(!m.isAccessible());
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(new byte[0]));
            Class<?> dis_cl = dis.getClass();
            Class<?> fis_cl = dis_cl.getSuperclass();
            Field dis_f = fis_cl.getDeclaredField("in");
            harness.check(!dis_f.isAccessible());
            dis_f.setAccessible(true);
            harness.check(dis_f.isAccessible());
            dis_f = fis_cl.getDeclaredField("in");
            harness.check(!dis_f.isAccessible());
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.fail(t.toString());
        }
    }
}

