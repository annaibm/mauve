/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel.AccessibleJLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.accessibility.AccessibleText;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.View;

public class getCharacterBounds
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testNoHTML(harness);
        this.testHTML(harness);
    }

    private void testNoHTML(TestHarness h) {
        h.checkPoint("testNoHTML");
        JLabel l = new JLabel("Hello World");
        AccessibleText at = (AccessibleText)((Object)l.getAccessibleContext());
        Rectangle b = at.getCharacterBounds(2);
        h.check(b, null);
    }

    private void testHTML(TestHarness h) {
        h.checkPoint("testHTML");
        JFrame f = new JFrame();
        JLabel l = new JLabel("<html>Hello World</html>");
        f.getContentPane().add(l);
        f.pack();
        f.setVisible(true);
        l.setSize(100, 30);
        AccessibleText at = (AccessibleText)((Object)l.getAccessibleContext());
        View v = (View)l.getClientProperty("html");
        Rectangle r = this.getTextRectangle(l);
        Rectangle expected = null;
        try {
            expected = v.modelToView(2, r, Position.Bias.Forward).getBounds();
        }
        catch (BadLocationException ex) {
            h.debug(ex);
            h.fail("Unexpected BadLocationException");
        }
        Rectangle b = at.getCharacterBounds(2);
        h.check(b, expected);
        f.dispose();
    }

    private Rectangle getTextRectangle(JLabel l) {
        Rectangle textR = new Rectangle();
        Rectangle iconR = new Rectangle();
        Insets i = l.getInsets();
        int w = l.getWidth();
        int h = l.getHeight();
        Rectangle viewR = new Rectangle(i.left, i.top, w - i.left - i.right, h - i.top - i.bottom);
        FontMetrics fm = l.getFontMetrics(l.getFont());
        SwingUtilities.layoutCompoundLabel(l, fm, l.getText(), l.getIcon(), l.getVerticalAlignment(), l.getHorizontalAlignment(), l.getVerticalTextPosition(), l.getHorizontalTextPosition(), viewR, iconR, textR, l.getIconTextGap());
        return textR;
    }
}

