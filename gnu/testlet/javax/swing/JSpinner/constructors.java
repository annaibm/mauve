/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.EventListener;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.constructor1(harness);
        this.constructor2(harness);
    }

    public void constructor1(TestHarness harness) {
        harness.checkPoint("()");
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            harness.fail(e.toString());
        }
        SpinnerNumberModel m = new SpinnerNumberModel();
        JSpinner spinner = new JSpinner(m);
        harness.check(spinner.getValue(), new Integer(0));
        harness.check(spinner.getEditor() instanceof JSpinner.NumberEditor);
        EventListener[] mListeners = m.getListeners(ChangeListener.class);
        harness.check(mListeners.length, 1);
        harness.check(!Arrays.asList(mListeners).contains(spinner));
        harness.check(!Arrays.asList(mListeners).contains(spinner.getUI()));
        harness.check(!Arrays.asList(mListeners).contains(spinner.getEditor()));
    }

    public void constructor2(TestHarness harness) {
        harness.checkPoint("(SpinnerModel)");
        SpinnerNumberModel m = new SpinnerNumberModel(5, 0, 10, 1);
        JSpinner spinner = new JSpinner(m);
        harness.check(spinner.getValue(), new Integer(5));
        harness.check(spinner.getEditor() instanceof JSpinner.NumberEditor);
        boolean pass = false;
        try {
            new JSpinner(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

