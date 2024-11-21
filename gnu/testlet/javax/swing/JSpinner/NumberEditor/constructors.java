/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.NumberEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(JSpinner)");
        JSpinner s = new JSpinner();
        JSpinner.NumberEditor e = new JSpinner.NumberEditor(s);
        harness.check(e.getLayout(), e);
        harness.check(e.getFormat(), NumberFormat.getInstance());
        JFormattedTextField ftf = e.getTextField();
        NumberFormatter nf = (NumberFormatter)ftf.getFormatter();
        harness.check(nf.getMinimum(), null);
        harness.check(nf.getMaximum(), null);
        SpinnerNumberModel m = new SpinnerNumberModel(50.0, 0.0, 100.0, 5.0);
        s = new JSpinner(m);
        e = new JSpinner.NumberEditor(s);
        harness.check(e.getFormat(), NumberFormat.getInstance());
        ftf = e.getTextField();
        nf = (NumberFormatter)ftf.getFormatter();
        harness.check(nf.getMinimum(), new Double(0.0));
        harness.check(nf.getMaximum(), new Double(100.0));
        boolean pass = false;
        try {
            e = new JSpinner.NumberEditor(null);
        }
        catch (NullPointerException npe) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(JSpinner, String)");
        JSpinner s = new JSpinner();
        JSpinner.NumberEditor e = new JSpinner.NumberEditor(s, "0.00");
        harness.check(e.getLayout(), e);
        harness.check(e.getFormat(), new DecimalFormat("0.00"));
        boolean pass = false;
        try {
            e = new JSpinner.NumberEditor(null, "0.00");
        }
        catch (NullPointerException npe) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e = new JSpinner.NumberEditor(s, null);
        }
        catch (NullPointerException npe) {
            pass = true;
        }
        harness.check(pass);
    }
}

