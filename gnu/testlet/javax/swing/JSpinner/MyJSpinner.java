/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public class MyJSpinner
extends JSpinner {
    public MyJSpinner() {
    }

    public MyJSpinner(SpinnerModel m) {
        super(m);
    }

    @Override
    public JComponent createEditor(SpinnerModel model2) {
        return super.createEditor(model2);
    }
}

