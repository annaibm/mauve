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

public class setRolloverSelectedIcon
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
        b.setRolloverSelectedIcon(icon1);
        harness.check(b.getRolloverSelectedIcon(), icon1);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getSource(), b);
        harness.check(e1.getPropertyName(), (Object)"rolloverSelectedIcon");
        harness.check(e1.getOldValue(), null);
        harness.check(e1.getNewValue(), icon1);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getSource(), b);
        harness.check(e2.getPropertyName(), (Object)"rolloverEnabled");
        harness.check(e2.getOldValue(), Boolean.FALSE);
        harness.check(e2.getNewValue(), Boolean.TRUE);
        this.events.clear();
        b.setRolloverSelectedIcon(icon2);
        harness.check(b.getRolloverSelectedIcon(), icon2);
        harness.check(this.events.size(), 1);
        e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getSource(), b);
        harness.check(e1.getPropertyName(), (Object)"rolloverSelectedIcon");
        harness.check(e1.getOldValue(), icon1);
        harness.check(e1.getNewValue(), icon2);
        this.events.clear();
        b.setRolloverSelectedIcon(icon2);
        harness.check(this.events.size(), 0);
        b.setRolloverSelectedIcon(null);
        harness.check(b.getRolloverSelectedIcon(), null);
        harness.check(b.isRolloverEnabled(), true);
        harness.check(this.events.size(), 1);
        e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getSource(), b);
        harness.check(e1.getPropertyName(), (Object)"rolloverSelectedIcon");
        harness.check(e1.getOldValue(), icon2);
        harness.check(e1.getNewValue(), null);
    }
}

