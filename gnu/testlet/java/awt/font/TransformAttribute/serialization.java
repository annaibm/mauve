/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TransformAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TransformAttribute;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serialization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TransformAttribute t = new TransformAttribute(new AffineTransform());
        this.testSerialization(t, harness);
        t = new TransformAttribute(AffineTransform.getTranslateInstance(1.2, 3.4));
        this.testSerialization(t, harness);
    }

    private void testSerialization(TransformAttribute t1, TestHarness harness) {
        TransformAttribute t2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(t1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            t2 = (TransformAttribute)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(t1.getTransform(), t2.getTransform());
    }
}

