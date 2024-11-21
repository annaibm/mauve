/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.PropertyEditorSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditorSupport;

public class setValue
implements Testlet {
    private boolean nonNullPropertyChanged;
    private boolean nullPropertyChanged;
    private PropertyEditorSupport pes;

    @Override
    public void test(final TestHarness harness) {
        this.pes = new PropertyEditorSupport(){};
        final String newValue = "new value";
        this.pes.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                setValue.this.nonNullPropertyChanged = true;
                harness.check(event.getSource(), setValue.this.pes, "pes1-event-event source");
                harness.check(event.getPropertyName(), null, "pes1-event-property name");
                harness.check(event.getOldValue(), null, "pes1-event-old value");
                harness.check(event.getNewValue(), null, "pes1-event-new value");
                harness.check(setValue.this.pes.getValue(), newValue, "pes1-new value");
            }
        });
        this.pes.setValue(newValue);
        harness.check(this.nonNullPropertyChanged, "pes1-PropertyChangeListener call");
        this.pes = new PropertyEditorSupport(){};
        this.pes.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                setValue.this.nullPropertyChanged = true;
                harness.check(event.getSource(), setValue.this.pes, "pes2-event-event source");
                harness.check(event.getPropertyName(), null, "pes2-event-property name");
                harness.check(event.getOldValue(), null, "pes2-event-old value");
                harness.check(event.getNewValue(), null, "pes2-event-new value");
                harness.check(setValue.this.pes.getValue(), null, "pes2-new value");
            }
        });
        this.pes.setValue(null);
        harness.check(this.nullPropertyChanged, "pes2-PropertyChangeListener call");
    }
}

