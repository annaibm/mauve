/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JEditorPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.rtf.RTFEditorKit;

public class ConstructorsAndTypes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JEditorPane pane = new JEditorPane();
        harness.check(pane.getEditorKit().getClass().getName(), (Object)"javax.swing.JEditorPane$PlainEditorKit");
        try {
            pane = new JEditorPane("http://www.gnu.org");
            harness.check(pane.getEditorKit().getClass(), HTMLEditorKit.class);
        }
        catch (Exception e) {
            harness.debug(e);
        }
        pane = new JEditorPane("text/rtf", "hello");
        harness.check(pane.getEditorKit().getClass(), RTFEditorKit.class);
        pane = new JEditorPane("application/rtf", "hello");
        harness.check(pane.getEditorKit().getClass(), RTFEditorKit.class);
    }
}

