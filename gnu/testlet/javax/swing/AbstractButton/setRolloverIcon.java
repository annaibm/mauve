/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.plaf.metal.MetalIconFactory;

public class setRolloverIcon
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        Icon icon1 = MetalIconFactory.getFileChooserNewFolderIcon();
        Icon icon2 = MetalIconFactory.getHorizontalSliderThumbIcon();
        JButton b = new JButton("123");
        b.setRolloverEnabled(false);
        b.addPropertyChangeListener(this);
        b.setRolloverIcon(icon1);
        harness.check(b.getRolloverIcon(), icon1);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getSource(), b);
        harness.check(e1.getPropertyName(), (Object)"rolloverIcon");
        harness.check(e1.getOldValue(), null);
        harness.check(e1.getNewValue(), icon1);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getSource(), b);
        harness.check(e2.getPropertyName(), (Object)"rolloverEnabled");
        harness.check(e2.getOldValue(), Boolean.FALSE);
        harness.check(e2.getNewValue(), Boolean.TRUE);
        this.events.clear();
        b.setRolloverIcon(icon2);
        harness.check(b.getRolloverIcon(), icon2);
        harness.check(this.events.size(), 1);
        e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getSource(), b);
        harness.check(e1.getPropertyName(), (Object)"rolloverIcon");
        harness.check(e1.getOldValue(), icon1);
        harness.check(e1.getNewValue(), icon2);
        this.events.clear();
        b.setRolloverIcon(icon2);
        harness.check(this.events.size(), 0);
        b.setRolloverIcon(null);
        harness.check(b.getRolloverIcon(), null);
        harness.check(b.isRolloverEnabled(), true);
        harness.check(this.events.size(), 1);
        e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getSource(), b);
        harness.check(e1.getPropertyName(), (Object)"rolloverIcon");
        harness.check(e1.getOldValue(), icon2);
        harness.check(e1.getNewValue(), null);
    }
}

