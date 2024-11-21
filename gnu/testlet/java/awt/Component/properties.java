/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.dnd.DropTarget;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;

public class properties
implements Testlet {
    private String propertyName;

    @Override
    public void test(TestHarness harness) {
        TestComponent comp = new TestComponent();
        comp.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent ev) {
                properties.this.propertyName = ev.getPropertyName();
            }
        });
        this.propertyName = null;
        comp.setBackground(Color.YELLOW);
        harness.check(this.propertyName, "background", "Property: background");
        this.propertyName = null;
        comp.setBounds(new Rectangle(143, 564, 1200, 2233));
        harness.check(this.propertyName, null, "Property: bounds");
        this.propertyName = null;
        comp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        comp.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        harness.check(this.propertyName, "componentOrientation", "Property: componentOrientation");
        this.propertyName = null;
        comp.setCursor(new Cursor(12));
        harness.check(this.propertyName, null, "Property: cursor");
        this.propertyName = null;
        comp.setDropTarget(new DropTarget());
        harness.check(this.propertyName, null, "Property: dropTarget");
        this.propertyName = null;
        comp.setEnabled(true);
        comp.setEnabled(false);
        harness.check(this.propertyName, null, "Property: enabled");
        this.propertyName = null;
        comp.setFont(new Font("Monospaced", 0, 12));
        harness.check(this.propertyName, "font", "Property: font");
        this.propertyName = null;
        comp.setForeground(Color.CYAN);
        harness.check(this.propertyName, "foreground", "Property: foreground");
        this.propertyName = null;
        comp.setLocale(Locale.CHINESE);
        comp.setLocale(Locale.GERMAN);
        harness.check(this.propertyName, "locale", "Property: locale");
        this.propertyName = null;
        comp.setLocation(new Point(123, 456));
        harness.check(this.propertyName, null, "Property: location");
        this.propertyName = null;
        comp.setName("Obelix");
        harness.check(this.propertyName, "name", "Property: name");
        this.propertyName = null;
        comp.setSize(new Dimension(987, 654));
        harness.check(this.propertyName, null, "Property: size");
        this.propertyName = null;
        comp.setVisible(true);
        comp.setVisible(false);
        harness.check(this.propertyName, null, "Property: visible");
    }

    public class TestComponent
    extends Component {
    }
}

