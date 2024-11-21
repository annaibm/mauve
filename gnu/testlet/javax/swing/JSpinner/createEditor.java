/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSpinner.MyJSpinner;
import java.util.EventListener;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

public class createEditor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(SpinnerModel)");
        MyJSpinner s1 = new MyJSpinner();
        SpinnerNumberModel m1 = new SpinnerNumberModel();
        JComponent e1 = s1.createEditor(m1);
        harness.check(e1 instanceof JSpinner.NumberEditor);
        EventListener[] e1l = e1.getListeners(ChangeListener.class);
        harness.check(e1l.length, 0);
        SpinnerDateModel m2 = new SpinnerDateModel();
        MyJSpinner s2 = new MyJSpinner(m2);
        JComponent e2 = s2.createEditor(m2);
        harness.check(e2 instanceof JSpinner.DateEditor);
        EventListener[] e2l = e2.getListeners(ChangeListener.class);
        harness.check(e2l.length, 0);
        SpinnerListModel m3 = new SpinnerListModel();
        MyJSpinner s3 = new MyJSpinner(m3);
        JComponent e3 = s3.createEditor(m3);
        harness.check(e3 instanceof JSpinner.ListEditor);
        EventListener[] e3l = e3.getListeners(ChangeListener.class);
        harness.check(e3l.length, 0);
        e3 = s3.createEditor(null);
        harness.check(e3 instanceof JSpinner.DefaultEditor);
    }
}

