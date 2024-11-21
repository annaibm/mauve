/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Vector;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class VectorSerialization
implements Testlet {
    public static void main(String[] args) throws IOException {
        FileOutputStream os = new FileOutputStream("TestVector.ser");
        ObjectOutputStream oo = new ObjectOutputStream(os);
        Vector<Integer> v = new Vector<Integer>();
        v.add(new Integer(10));
        oo.writeObject(v);
        v = new Vector();
        v.add(new Integer(20));
        oo.writeObject(v);
        os.close();
    }

    @Override
    public void test(TestHarness harness) {
        try {
            String packageName = this.getClass().getPackage().getName().replace('.', '#');
            InputStream is = harness.getResourceStream(packageName + "#TestVector.ser");
            ObjectInputStream oi = new ObjectInputStream(is);
            Vector v = (Vector)oi.readObject();
            harness.check(v != null, "returned object null ?");
            harness.check(v.size(), 1);
            harness.check(v.get(0), new Integer(10));
            v = (Vector)oi.readObject();
            harness.check(v != null, "returned object null ?");
            harness.check(v.size(), 1);
            harness.check(v.get(0), new Integer(20));
        }
        catch (Exception e) {
            harness.fail("Caught an unexpected exception");
            harness.debug(e);
        }
    }
}

