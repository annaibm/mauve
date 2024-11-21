/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AWTKeyStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTKeyStroke;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serialization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AWTKeyStroke ks1 = AWTKeyStroke.getAWTKeyStroke(10, 192, true);
        AWTKeyStroke ks2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(ks1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            ks2 = (AWTKeyStroke)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(ks1.equals(ks2));
    }
}

