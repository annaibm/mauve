/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;

public class ClassLoaderTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object obj;
        byte[] serData;
        Class cl;
        MyClassLoader loader = new MyClassLoader();
        ClassLoader sysLoader = this.getClass().getClassLoader();
        harness.checkPoint("read the file");
        try {
            cl = loader.defineClass(this.getClass().getResourceAsStream("ClassLoaderTest$MyClass.class"), "gnu.testlet.java.io.ObjectInputStream.ClassLoaderTest$MyClass");
            harness.check(true);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
            return;
        }
        harness.check(cl.getClassLoader() == loader, "Class has correct classloader");
        harness.checkPoint("Deserialized objects have correct ClassLoader");
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(cl.newInstance());
            oos.close();
            serData = bos.toByteArray();
            obj = MyClass.deserialize(serData);
            harness.check(obj.getClass().getClassLoader() == sysLoader);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
            return;
        }
        harness.checkPoint("Class equality (==)");
        try {
            Method m = cl.getMethod("deserialize", byte[].class);
            Object obj2 = m.invoke(null, new Object[]{serData});
            harness.check(obj2.getClass().getClassLoader() == loader);
            harness.check(obj.getClass() != obj2.getClass());
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }

    public static class MyClass
    implements Serializable {
        int i = 555;

        public static Object deserialize(byte[] serData) throws IOException, ClassNotFoundException {
            ByteArrayInputStream bis = new ByteArrayInputStream(serData);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object obj = ois.readObject();
            ois.close();
            return obj;
        }
    }

    static class MyClassLoader
    extends ClassLoader {
        MyClassLoader() {
        }

        public Class defineClass(InputStream is, String name2) throws ClassNotFoundException, IOException {
            int len;
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buf = new byte[512];
            while ((len = is.read(buf, 0, buf.length)) != -1) {
                for (int written = 0; written < len; written += len) {
                    os.write(buf, written, len - written);
                }
            }
            byte[] classData = os.toByteArray();
            return this.defineClass(name2, classData, 0, classData.length);
        }
    }
}

