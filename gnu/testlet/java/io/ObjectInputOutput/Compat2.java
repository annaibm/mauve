/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Compat2
implements Testlet {
    static String SERIAL_REFERENCE = "serial.bin";
    static String SERIAL_SCRATCH_FILENAME = "Compat2.tmp";
    static int SERIAL_REF_ID = 0;

    void generate(String fname) throws IOException {
        FileOutputStream of = new FileOutputStream(fname);
        ObjectOutputStream oos = new ObjectOutputStream(of);
        oos.writeObject(new GetTypeMismatch());
    }

    GetTypeMismatch readSerial(String fname) throws IOException, ClassNotFoundException {
        FileInputStream ifs = new FileInputStream(fname);
        ObjectInputStream ios = new ObjectInputStream(ifs);
        return (GetTypeMismatch)ios.readObject();
    }

    @Override
    public void test(TestHarness t) {
        block8: {
            boolean rand_id = false;
            t.checkPoint("Compatibility test for type mismatch when calling get methods");
            try {
                this.generate(SERIAL_SCRATCH_FILENAME);
                t.check(true);
                try {
                    this.readSerial(SERIAL_SCRATCH_FILENAME);
                    t.check(false);
                    t.debug("This should have triggered IllegalArgumentException");
                }
                catch (Exception e) {
                    if (e instanceof IllegalArgumentException) {
                        t.check(true);
                        break block8;
                    }
                    t.check(false);
                    t.debug("Expected IllegalArgumentException, not: " + e);
                }
            }
            catch (Exception e) {
                t.check(false);
                t.debug(e);
            }
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(t.getResourceStream(this.getClass().getName().replace('.', '#') + "." + SERIAL_REFERENCE));
            ois.readObject();
            t.check(false);
            t.debug("This should have triggered IllegalArgumentException");
        }
        catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                t.check(true);
            }
            t.check(false);
            t.debug("Expected IllegalArgumentException, not: " + e);
        }
    }

    public static void main(String[] args) throws IOException {
        new Compat2().generate(SERIAL_REFERENCE);
    }

    private static class GetTypeMismatch
    implements Serializable {
        private static final long serialVersionUID = -2330048339523627109L;
        private Integer x = new Integer(17);
        private Integer y = new Integer(27);

        private GetTypeMismatch() {
        }

        public String toString() {
            return this.getClass().getName() + ": " + this.x + "," + this.y;
        }

        private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException {
            ObjectOutputStream.PutField pf1 = stream.putFields();
            pf1.put("x", this.x);
            pf1.put("y", this.y);
            stream.writeFields();
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            ObjectInputStream.GetField gf1 = stream.readFields();
            this.x = (Integer)gf1.get("x", new String("Missed X?"));
            this.y = (Integer)gf1.get("y", new String("Missed Y?"));
        }
    }
}

