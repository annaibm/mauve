/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.ObjectInputOutput.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;

public class OutputTest
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        int i;
        this.harness = harness;
        Test[] tests = Test.getValidTests();
        for (i = 0; i < tests.length; ++i) {
            this.test(tests[i], false);
        }
        tests = Test.getErrorTests();
        for (i = 0; i < tests.length; ++i) {
            this.test(tests[i], true);
        }
    }

    void test(Test t, boolean throwsOSE) {
        String cname = t.getClass().getName();
        this.harness.checkPoint(cname);
        try {
            boolean exception_thrown;
            ObjectOutputStream oos;
            ByteArrayOutputStream bytes;
            block7: {
                bytes = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(bytes);
                Object[] objs = t.getTestObjs();
                exception_thrown = false;
                try {
                    for (int i = 0; i < objs.length; ++i) {
                        oos.writeObject(objs[i]);
                    }
                }
                catch (ObjectStreamException ose) {
                    exception_thrown = true;
                    if (throwsOSE) break block7;
                    this.harness.debug(ose);
                }
            }
            oos.close();
            if (throwsOSE) {
                this.harness.check(exception_thrown, "Unserializable: " + t);
            } else {
                this.harness.check(!exception_thrown, "Serializable: " + t);
                this.harness.check(this.compareBytes(bytes.toByteArray(), this.harness.getResourceStream(cname.replace('.', '#') + ".data")));
            }
        }
        catch (Exception e) {
            this.harness.debug(e);
            this.harness.check(false);
        }
    }

    boolean compareBytes(byte[] written_bytes, InputStream ref_stream) throws IOException {
        for (int i = 0; i < written_bytes.length; ++i) {
            int data = ref_stream.read();
            if (data == -1) {
                this.harness.debug("Reference data is shorter than written data.");
                return false;
            }
            if ((byte)data == written_bytes[i]) continue;
            this.harness.debug("Data differs at byte " + i);
            this.harness.debug("Ref. byte = 0" + Integer.toOctalString(written_bytes[i] & 0xFF) + ", written byte = 0" + Integer.toOctalString(data & 0xFF));
            return false;
        }
        if (ref_stream.read() != -1) {
            this.harness.debug("Reference data is longer than written data.");
            return false;
        }
        return true;
    }
}

