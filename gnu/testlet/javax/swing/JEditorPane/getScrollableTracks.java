/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JEditorPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class getScrollableTracks
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JEditorPane pane = new JEditorPane();
        harness.checkPoint("default value");
        harness.check(!pane.getScrollableTracksViewportWidth());
        harness.check(!pane.getScrollableTracksViewportHeight());
        harness.checkPoint("after putting in scrollpane");
        JScrollPane js = new JScrollPane(pane);
        harness.check(!pane.getScrollableTracksViewportWidth());
        harness.check(!pane.getScrollableTracksViewportHeight());
        harness.checkPoint("after adding to a JFrame and packing");
        JFrame jf = new JFrame();
        jf.add(js);
        jf.pack();
        harness.check(pane.getScrollableTracksViewportWidth());
        harness.check(pane.getScrollableTracksViewportHeight());
    }
}

