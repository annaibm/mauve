/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

public class serialization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigInteger b1 = new BigInteger("-4294967296");
        Number b2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(b1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            b2 = (BigInteger)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(b1.equals(b2));
        harness.check(b1.byteValue() == b2.byteValue());
        harness.check(b1.shortValue() == b2.shortValue());
        harness.check(b1.intValue() == ((BigInteger)b2).intValue());
        harness.check(b1.longValue() == ((BigInteger)b2).longValue());
        harness.check(b1.floatValue() == ((BigInteger)b2).floatValue());
        harness.check(b1.doubleValue() == ((BigInteger)b2).doubleValue());
    }
}

