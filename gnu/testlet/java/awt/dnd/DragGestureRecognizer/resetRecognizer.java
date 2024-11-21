/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd.DragGestureRecognizer;

import java.awt.Component;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import junit.framework.TestCase;

public class resetRecognizer
extends TestCase {
    public void testSimple() {
        DragSource s = new DragSource();
        Component c = new Component(){};
        DragGestureListener l = new DragGestureListener(){

            @Override
            public void dragGestureRecognized(DragGestureEvent e) {
            }
        };
        TestRecognizer rec = new TestRecognizer(s, c, 2, l);
        resetRecognizer.assertEquals(s, rec.getFieldDragSource());
        resetRecognizer.assertEquals(c, rec.getFieldComponent());
        resetRecognizer.assertEquals(l, rec.getFieldDragGestureListener());
        resetRecognizer.assertEquals(2, rec.getFieldSourceActions());
        ArrayList ev = rec.getFieldEvents();
        ev.add(new MouseEvent(c, 506, System.currentTimeMillis(), 512, 10, 20, 1, false));
        ev.add(new MouseEvent(c, 506, System.currentTimeMillis(), 512, 10, 20, 1, false));
        resetRecognizer.assertEquals(2, ev.size());
        rec.resetRecognizer();
        resetRecognizer.assertSame(ev, rec.getFieldEvents());
        resetRecognizer.assertEquals(0, ev.size());
        resetRecognizer.assertEquals(s, rec.getFieldDragSource());
        resetRecognizer.assertEquals(c, rec.getFieldComponent());
        resetRecognizer.assertEquals(l, rec.getFieldDragGestureListener());
        resetRecognizer.assertEquals(2, rec.getFieldSourceActions());
    }

    static class TestRecognizer
    extends DragGestureRecognizer {
        protected TestRecognizer(DragSource s, Component c, int sa, DragGestureListener l) {
            super(s, c, sa, l);
        }

        @Override
        protected void registerListeners() {
        }

        @Override
        protected void unregisterListeners() {
        }

        Component getFieldComponent() {
            return this.component;
        }

        DragGestureListener getFieldDragGestureListener() {
            return this.dragGestureListener;
        }

        DragSource getFieldDragSource() {
            return this.dragSource;
        }

        ArrayList getFieldEvents() {
            return this.events;
        }

        int getFieldSourceActions() {
            return this.sourceActions;
        }
    }
}

