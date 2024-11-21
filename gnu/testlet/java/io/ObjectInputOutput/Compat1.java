/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

public class Compat1
implements Testlet {
    static String SERIAL_REFERENCE = "serial.bin";
    static String SERIAL_SCRATCH_FILENAME = "Compat1.tmp";
    static int SERIAL_REF_ID = 0;

    BigInteger getBigInt(int id) {
        return new BigInteger("1010101010101101010101010102102102013103913019301210" + id);
    }

    void generate(String fname, int id) throws IOException {
        FileOutputStream of = new FileOutputStream(fname);
        ObjectOutputStream oos = new ObjectOutputStream(of);
        oos.writeObject(this.getBigInt(id));
    }

    BigInteger readSerial(String fname) throws Exception {
        FileInputStream ifs = new FileInputStream(fname);
        ObjectInputStream ios = new ObjectInputStream(ifs);
        return (BigInteger)ios.readObject();
    }

    @Override
    public void test(TestHarness t) {
        int rand_id = 0;
        t.checkPoint("Compatibility test for BigInteger");
        try {
            this.generate(SERIAL_SCRATCH_FILENAME, rand_id);
            t.check(true);
            t.check(this.readSerial(SERIAL_SCRATCH_FILENAME), this.getBigInt(rand_id));
        }
        catch (Exception e) {
            t.check(false);
            t.debug(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(t.getResourceStream(this.getClass().getName().replace('.', '#') + "." + SERIAL_REFERENCE));
            t.check(ois.readObject(), this.getBigInt(SERIAL_REF_ID));
        }
        catch (Exception e) {
            t.check(false);
            t.debug(e);
        }
        new File(SERIAL_SCRATCH_FILENAME).delete();
    }

    public static void main(String[] args) throws IOException {
        new Compat1().generate(SERIAL_REFERENCE, SERIAL_REF_ID);
    }
}

