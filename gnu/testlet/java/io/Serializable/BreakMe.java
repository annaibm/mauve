/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Serializable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.Serializable.MyBreakMe;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BreakMe
implements Testlet {
    static MyBreakMe broken;
    static boolean generating;

    @Override
    public void test(TestHarness harness) {
        Object object = null;
        try {
            FileInputStream fis = new FileInputStream("gnu/testlet/java/io/Serializable/MyBreakMe.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            ois.close();
        }
        catch (ExceptionInInitializerError eiie) {
            harness.check(eiie.getCause() instanceof IndexOutOfBoundsException);
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.check(false);
        }
        if (object != null) {
            harness.check(false);
        }
    }

    public static void main(String[] args) throws IOException {
        generating = true;
        new MyBreakMe();
        FileOutputStream fos = new FileOutputStream("gnu/testlet/java/io/Serializable/MyBreakMe.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(broken);
        oos.close();
    }

    static {
        generating = false;
    }
}

