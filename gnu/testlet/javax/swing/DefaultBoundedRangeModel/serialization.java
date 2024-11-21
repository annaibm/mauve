/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class serialization
implements Testlet,
ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
    }

    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel m1 = new DefaultBoundedRangeModel(1, 2, 0, 99);
        m1.addChangeListener(this);
        DefaultBoundedRangeModel m2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(m1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            m2 = (DefaultBoundedRangeModel)in.readObject();
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        harness.check(m1.getValue(), m2.getValue());
        harness.check(m1.getMinimum(), m2.getMinimum());
        harness.check(m1.getMaximum(), m2.getMaximum());
        harness.check(m1.getExtent(), m2.getExtent());
        harness.check(m1.getChangeListeners().length, 1);
        harness.check(m2.getChangeListeners().length, 0);
    }
}

