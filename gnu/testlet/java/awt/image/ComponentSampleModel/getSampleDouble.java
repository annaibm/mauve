/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;

public class getSampleDouble
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ComponentSampleModel m = new ComponentSampleModel(0, 5, 10, 3, 16, new int[]{0, 1, 2});
        DataBuffer db = m.createDataBuffer();
        harness.check(db.getNumBanks(), 1);
        db.setElem(0, 16, 170);
        db.setElem(0, 17, 187);
        db.setElem(0, 18, 204);
        harness.check(m.getSampleDouble(0, 1, 0, db), 170.0);
        harness.check(m.getSampleDouble(0, 1, 1, db), 187.0);
        harness.check(m.getSampleDouble(0, 1, 2, db), 204.0);
        boolean pass = false;
        try {
            m.getSampleDouble(-1, 1, 0, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSampleDouble(5, 0, 0, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSampleDouble(1, -1, 0, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSampleDouble(0, 10, 0, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

