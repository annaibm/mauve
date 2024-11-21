/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JEditorPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.rtf.RTFEditorKit;

public class ContentType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JEditorPane pane = new JEditorPane();
        harness.checkPoint("Default EditorKits for content types");
        harness.check(pane.getEditorKitForContentType("text/plain").getClass().getName(), (Object)"javax.swing.JEditorPane$PlainEditorKit");
        harness.check(JEditorPane.getEditorKitClassNameForContentType("text/plain"), (Object)"javax.swing.JEditorPane$PlainEditorKit");
        harness.check(pane.getEditorKitForContentType("text/html").getClass(), HTMLEditorKit.class);
        harness.check(pane.getEditorKitForContentType("text/rtf").getClass(), RTFEditorKit.class);
        harness.check(pane.getEditorKitForContentType("application/rtf").getClass(), RTFEditorKit.class);
        harness.checkPoint("Registering an EditorKit for a content type");
        harness.check(pane.getEditorKitForContentType("foobar").getClass().getName(), (Object)"javax.swing.JEditorPane$PlainEditorKit");
        harness.check(JEditorPane.getEditorKitClassNameForContentType("foobar") == null);
        harness.check(JEditorPane.createEditorKitForContentType("foobar") == null);
        JEditorPane.registerEditorKitForContentType("foobar", "javax.swing.text.html.HTMLEditorKit");
        harness.check(pane.getEditorKitForContentType("foobar").getClass(), HTMLEditorKit.class);
        harness.check(JEditorPane.createEditorKitForContentType("foobar").getClass(), HTMLEditorKit.class);
        pane.setEditorKitForContentType("foobar", new RTFEditorKit());
        harness.check(pane.getEditorKitForContentType("foobar").getClass(), RTFEditorKit.class);
        pane.setEditorKitForContentType("tony", new RTFEditorKit());
        harness.check(pane.getEditorKitForContentType("tony").getClass(), RTFEditorKit.class);
        harness.check(JEditorPane.createEditorKitForContentType("tony") == null);
    }
}

