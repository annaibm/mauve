/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.DateEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DateFormatter;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(JSpinner)");
        SpinnerDateModel m = new SpinnerDateModel();
        JSpinner s = new JSpinner(m);
        JSpinner.DateEditor e = new JSpinner.DateEditor(s);
        harness.check(e.getFormat(), DateFormat.getInstance());
        harness.check(e.getLayout(), e);
        JFormattedTextField ftf = e.getTextField();
        DateFormatter nf = (DateFormatter)ftf.getFormatter();
        harness.check(nf.getMinimum(), null);
        harness.check(nf.getMaximum(), null);
        m = new SpinnerDateModel(new Date(50L), new Date(0L), new Date(100L), 14);
        s = new JSpinner(m);
        e = new JSpinner.DateEditor(s);
        harness.check(e.getFormat(), DateFormat.getInstance());
        ftf = e.getTextField();
        nf = (DateFormatter)ftf.getFormatter();
        harness.check(nf.getMinimum(), new Date(0L));
        harness.check(nf.getMaximum(), new Date(100L));
        boolean pass = false;
        try {
            e = new JSpinner.DateEditor(null);
        }
        catch (NullPointerException npe) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(JSpinner, String)");
        SpinnerDateModel m = new SpinnerDateModel();
        JSpinner s = new JSpinner(m);
        JSpinner.DateEditor e = new JSpinner.DateEditor(s, "S");
        harness.check(e.getFormat(), new SimpleDateFormat("S"));
        harness.check(e.getLayout(), e);
        boolean pass = false;
        try {
            e = new JSpinner.DateEditor(null, "S");
        }
        catch (NullPointerException npe) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e = new JSpinner.DateEditor(s, null);
        }
        catch (NullPointerException npe) {
            pass = true;
        }
        harness.check(pass);
    }
}

