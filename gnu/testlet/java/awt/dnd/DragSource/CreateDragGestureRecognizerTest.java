/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.dnd.DragSource;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Label;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;

public class CreateDragGestureRecognizerTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        DragSource ds = new DragSource();
        DragGestureRecognizer dgr = ds.createDefaultDragGestureRecognizer(new Label("label"), 1, null);
        h.check(dgr != null);
    }
}

