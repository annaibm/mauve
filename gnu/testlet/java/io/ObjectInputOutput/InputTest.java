/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.ObjectInputOutput.Test;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputTest
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        Test[] tests = Test.getValidTests();
        for (int i = 0; i < tests.length; ++i) {
            this.test(tests[i]);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void test(Test t) {
        String cname = t.getClass().getName();
        this.harness.checkPoint(cname);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(this.harness.getResourceStream(cname.replace('.', '#') + ".data"));
            Object[] objs = t.getTestObjs();
            for (int i = 0; i < objs.length; ++i) {
                this.harness.check(ois.readObject(), objs[i]);
            }
        }
        catch (Exception e) {
            this.harness.debug(e);
            this.harness.check(false);
            return;
        }
        finally {
            if (ois != null) {
                try {
                    ois.close();
                }
                catch (IOException iOException) {}
            }
        }
    }
}

