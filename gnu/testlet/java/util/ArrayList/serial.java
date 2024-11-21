/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.ArrayList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class serial
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            Object[] array = serial.getArrayListArray();
            oos.writeObject(array);
            oos.close();
            byte[] bs = baos.toByteArray();
            ByteArrayInputStream bois = new ByteArrayInputStream(bs);
            ObjectInputStream ois = new ObjectInputStream(bois);
            Object o = ois.readObject();
            array = (ArrayList[])o;
            harness.check(Arrays.equals(array, serial.getArrayListArray()));
            ois.close();
            String ser = "gnu#testlet#java#util#ArrayList#ArrayList.ser";
            InputStream is = harness.getResourceStream(ser);
            ois = new ObjectInputStream(is);
            o = ois.readObject();
            array = (ArrayList[])o;
            harness.check(Arrays.equals(array, serial.getArrayListArray()));
            ois.close();
            is.close();
        }
        catch (Throwable t) {
            harness.check(false);
            harness.debug(t);
        }
    }

    static ArrayList[] getArrayListArray() {
        ArrayList list32;
        ArrayList one;
        ArrayList empty;
        ArrayList[] array = new ArrayList[5];
        ArrayList<Integer> al = new ArrayList<Integer>();
        array[0] = empty = (ArrayList)al.clone();
        array[4] = empty;
        al.add(new Integer(1));
        array[1] = one = (ArrayList)al.clone();
        for (int i = 2; i <= 32; ++i) {
            al.add(new Integer(i));
        }
        array[2] = list32 = (ArrayList)al.clone();
        for (int i = 0; i < 20; ++i) {
            al.remove(4);
        }
        array[3] = al;
        return array;
    }

    public static void main(String[] args) throws Exception {
        String filename = "ArrayListSerial.ser";
        FileOutputStream os = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        ArrayList[] array = serial.getArrayListArray();
        oos.writeObject(array);
        oos.close();
        ((OutputStream)os).close();
    }
}

