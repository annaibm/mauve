/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
        this.testConstructor6(harness);
        this.testHorizontalAlignment(harness);
    }

    public void test1(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        UIManager.put("Label.font", new Font("Dialog", 0, 21));
        UIManager.put("Label.foreground", Color.green);
        UIManager.put("Label.background", Color.yellow);
        JLabel l = new JLabel();
        harness.check(l.getFont(), new Font("Dialog", 0, 21));
        harness.check(l.getForeground(), Color.green);
        harness.check(l.getBackground(), Color.yellow);
        harness.check((double)l.getAlignmentX(), 0.0, "alignmentX");
        harness.check((double)l.getAlignmentY(), 0.5, "alignmentY");
        harness.check(l.getVerticalAlignment(), 0, "verticalAlignment");
        harness.check(l.getDisabledIcon(), null);
        harness.check(l.getDisplayedMnemonic(), 0);
        harness.check(l.getDisplayedMnemonicIndex(), -1);
        harness.check(l.getHorizontalTextPosition(), 11);
        harness.check(l.getVerticalTextPosition(), 0);
        harness.check(l.getLabelFor(), null);
        harness.check(l.getIconTextGap(), 4);
    }

    public void testConstructor1(TestHarness harness) {
        JLabel label = new JLabel();
        harness.check(label.getIcon(), null);
        harness.check(label.getText(), (Object)"");
    }

    public void testConstructor2(TestHarness harness) {
        JLabel label = new JLabel(new ImageIcon());
        harness.check(label.getIcon() != null);
        harness.check(label.getText(), null);
        label = new JLabel(new ImageIcon(new BufferedImage(16, 16, 4)));
        harness.check(label.getIcon() != null);
        harness.check(label.getText(), null);
        label = new JLabel((Icon)null);
        harness.check(label.getIcon() == null);
        harness.check(label.getText(), null);
    }

    public void testConstructor3(TestHarness harness) {
        JLabel label = new JLabel(new ImageIcon(), 2);
        harness.check(label.getIcon() != null);
        harness.check(label.getText(), null);
        harness.check(label.getHorizontalAlignment(), 2);
        label = new JLabel((Icon)null, 2);
        harness.check(label.getIcon() == null);
        harness.check(label.getText(), null);
        harness.check(label.getHorizontalAlignment(), 2);
        label = new JLabel(new ImageIcon(), 0);
        harness.check(label.getIcon() != null);
        harness.check(label.getText(), null);
        harness.check(label.getHorizontalAlignment(), 0);
        boolean fail = false;
        try {
            label = new JLabel(new ImageIcon(), -1);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
    }

    public void testConstructor4(TestHarness harness) {
        JLabel label = new JLabel("This is some text.");
        harness.check(label.getIcon(), null);
        harness.check(label.getText(), (Object)"This is some text.");
        label = new JLabel("");
        harness.check(label.getIcon(), null);
        harness.check(label.getText(), (Object)"");
        String text2 = null;
        label = new JLabel(text2);
        harness.check(label.getIcon(), null);
        harness.check(label.getText(), null);
    }

    public void testConstructor5(TestHarness harness) {
        JLabel label = new JLabel("This is some text.", 11);
        harness.check(label.getIcon() == null);
        harness.check(label.getText(), (Object)"This is some text.");
        harness.check(label.getHorizontalAlignment(), 11);
        label = new JLabel("", 11);
        harness.check(label.getIcon() == null);
        harness.check(label.getText(), (Object)"");
        harness.check(label.getHorizontalAlignment(), 11);
        String text2 = null;
        label = new JLabel(text2, 0);
        harness.check(label.getIcon() == null);
        harness.check(label.getText(), null);
        harness.check(label.getHorizontalAlignment(), 0);
        boolean fail = false;
        try {
            label = new JLabel("This is some text.", -2);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
    }

    public void testConstructor6(TestHarness harness) {
        JLabel label = new JLabel("This is some text.", new ImageIcon(), 0);
        harness.check(label.getIcon() != null);
        harness.check(label.getText(), (Object)"This is some text.");
        harness.check(label.getHorizontalAlignment(), 0);
        label = new JLabel("", null, 10);
        harness.check(label.getIcon() == null);
        harness.check(label.getText(), (Object)"");
        harness.check(label.getHorizontalAlignment(), 10);
        String text2 = null;
        label = new JLabel(text2, new ImageIcon(), 11);
        harness.check(label.getIcon() != null);
        harness.check(label.getText(), null);
        harness.check(label.getHorizontalAlignment(), 11);
        boolean fail = false;
        try {
            label = new JLabel("This is some text.", new ImageIcon(), -4);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
    }

    public void testHorizontalAlignment(TestHarness harness) {
        JLabel label = null;
        boolean fail = false;
        try {
            label = new JLabel("", -1);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
        boolean pass = false;
        try {
            label = new JLabel("", 0);
            pass = true;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        harness.check(pass);
        harness.check(label.getHorizontalAlignment(), 0);
        fail = false;
        try {
            label = new JLabel("", 1);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
        pass = false;
        try {
            label = new JLabel("", 2);
            pass = true;
        }
        catch (IllegalArgumentException e) {
            // empty catch block
        }
        harness.check(pass);
        harness.check(label.getHorizontalAlignment(), 2);
        fail = false;
        try {
            label = new JLabel("", 3);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
        pass = false;
        try {
            label = new JLabel("", 4);
            pass = true;
        }
        catch (IllegalArgumentException e) {
            // empty catch block
        }
        harness.check(pass);
        harness.check(label.getHorizontalAlignment(), 4);
        fail = false;
        try {
            label = new JLabel("", 5);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
        fail = false;
        try {
            label = new JLabel("", 7);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
        pass = false;
        try {
            label = new JLabel("", 10);
            pass = true;
        }
        catch (IllegalArgumentException e) {
            // empty catch block
        }
        harness.check(pass);
        harness.check(label.getHorizontalAlignment(), 10);
        pass = false;
        try {
            label = new JLabel("", 11);
            pass = true;
        }
        catch (IllegalArgumentException e) {
            // empty catch block
        }
        harness.check(pass);
        harness.check(label.getHorizontalAlignment(), 11);
        fail = false;
        try {
            label = new JLabel("", 13);
        }
        catch (IllegalArgumentException e) {
            fail = true;
        }
        harness.check(fail);
    }
}

