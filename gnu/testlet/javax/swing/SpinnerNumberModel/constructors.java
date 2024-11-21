/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerNumberModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SpinnerNumberModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        SpinnerNumberModel m = new SpinnerNumberModel();
        harness.check(m.getValue(), new Integer(0));
        harness.check(m.getMinimum(), null);
        harness.check(m.getMaximum(), null);
        harness.check(m.getStepSize(), new Integer(1));
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(double, double, double, double)");
        SpinnerNumberModel m = new SpinnerNumberModel(2.0, 1.0, 3.0, 0.5);
        harness.check(m.getValue(), new Double(2.0));
        harness.check(m.getMinimum(), new Double(1.0));
        harness.check(m.getMaximum(), new Double(3.0));
        harness.check(m.getStepSize(), new Double(0.5));
        m = new SpinnerNumberModel(1.0, 1.0, 3.0, 0.5);
        harness.check(m.getValue(), new Double(1.0));
        harness.check(m.getMinimum(), new Double(1.0));
        harness.check(m.getMaximum(), new Double(3.0));
        harness.check(m.getStepSize(), new Double(0.5));
        boolean pass = false;
        try {
            m = new SpinnerNumberModel(0.9, 1.0, 3.0, 0.5);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        m = new SpinnerNumberModel(3.0, 1.0, 3.0, 0.5);
        harness.check(m.getValue(), new Double(3.0));
        harness.check(m.getMinimum(), new Double(1.0));
        harness.check(m.getMaximum(), new Double(3.0));
        harness.check(m.getStepSize(), new Double(0.5));
        pass = false;
        try {
            m = new SpinnerNumberModel(3.1, 1.0, 3.0, 0.5);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        m = new SpinnerNumberModel(2.0, 1.0, 3.0, 0.0);
        harness.check(m.getValue(), new Double(2.0));
        harness.check(m.getMinimum(), new Double(1.0));
        harness.check(m.getMaximum(), new Double(3.0));
        harness.check(m.getStepSize(), new Double(0.0));
        m = new SpinnerNumberModel(2.0, 1.0, 3.0, -0.5);
        harness.check(m.getValue(), new Double(2.0));
        harness.check(m.getMinimum(), new Double(1.0));
        harness.check(m.getMaximum(), new Double(3.0));
        harness.check(m.getStepSize(), new Double(-0.5));
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("(int, int, int, int)");
        SpinnerNumberModel m = new SpinnerNumberModel(20, 10, 30, 5);
        harness.check(m.getValue(), new Integer(20));
        harness.check(m.getMinimum(), new Integer(10));
        harness.check(m.getMaximum(), new Integer(30));
        harness.check(m.getStepSize(), new Integer(5));
        m = new SpinnerNumberModel(10, 10, 30, 5);
        harness.check(m.getValue(), new Integer(10));
        harness.check(m.getMinimum(), new Integer(10));
        harness.check(m.getMaximum(), new Integer(30));
        harness.check(m.getStepSize(), new Integer(5));
        boolean pass = false;
        try {
            m = new SpinnerNumberModel(9, 10, 30, 5);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        m = new SpinnerNumberModel(30, 10, 30, 5);
        harness.check(m.getValue(), new Integer(30));
        harness.check(m.getMinimum(), new Integer(10));
        harness.check(m.getMaximum(), new Integer(30));
        harness.check(m.getStepSize(), new Integer(5));
        pass = false;
        try {
            m = new SpinnerNumberModel(31, 10, 30, 5);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        m = new SpinnerNumberModel(20, 10, 30, 0);
        harness.check(m.getValue(), new Integer(20));
        harness.check(m.getMinimum(), new Integer(10));
        harness.check(m.getMaximum(), new Integer(30));
        harness.check(m.getStepSize(), new Integer(0));
        m = new SpinnerNumberModel(20, 10, 30, -5);
        harness.check(m.getValue(), new Integer(20));
        harness.check(m.getMinimum(), new Integer(10));
        harness.check(m.getMaximum(), new Integer(30));
        harness.check(m.getStepSize(), new Integer(-5));
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("Number, Comparable, Comparable, Number");
        SpinnerNumberModel m = new SpinnerNumberModel(new Long(20L), new Long(10L), new Long(30L), new Long(5L));
        harness.check(m.getValue(), new Long(20L));
        harness.check(m.getMinimum(), new Long(10L));
        harness.check(m.getMaximum(), new Long(30L));
        harness.check(m.getStepSize(), new Long(5L));
        m = new SpinnerNumberModel(new Double(1.0), new Double(1.0), new Double(3.0), new Double(0.5));
        harness.check(m.getValue(), new Double(1.0));
        harness.check(m.getMinimum(), new Double(1.0));
        harness.check(m.getMaximum(), new Double(3.0));
        harness.check(m.getStepSize(), new Double(0.5));
        boolean pass = false;
        try {
            m = new SpinnerNumberModel(new Double(0.9), new Double(1.0), new Double(3.0), new Double(0.5));
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        m = new SpinnerNumberModel(new Double(3.0), new Double(1.0), new Double(3.0), new Double(0.5));
        harness.check(m.getValue(), new Double(3.0));
        harness.check(m.getMinimum(), new Double(1.0));
        harness.check(m.getMaximum(), new Double(3.0));
        harness.check(m.getStepSize(), new Double(0.5));
        pass = false;
        try {
            m = new SpinnerNumberModel(new Double(3.1), new Double(1.0), new Double(3.0), new Double(0.5));
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        m = new SpinnerNumberModel(new Double(2.0), new Double(1.0), new Double(3.0), new Double(0.0));
        harness.check(m.getValue(), new Double(2.0));
        harness.check(m.getMinimum(), new Double(1.0));
        harness.check(m.getMaximum(), new Double(3.0));
        harness.check(m.getStepSize(), new Double(0.0));
        m = new SpinnerNumberModel(new Double(2.0), new Double(1.0), new Double(3.0), new Double(-0.5));
        harness.check(m.getValue(), new Double(2.0));
        harness.check(m.getMinimum(), new Double(1.0));
        harness.check(m.getMaximum(), new Double(3.0));
        harness.check(m.getStepSize(), new Double(-0.5));
        pass = false;
        try {
            new SpinnerNumberModel(null, new Long(10L), new Long(30L), new Long(5L));
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new SpinnerNumberModel(new Long(20L), new Long(10L), new Long(30L), null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

