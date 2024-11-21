/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTextField;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class fireActionPerformed
implements Testlet {
    JFrame frame;
    JTextField text;
    Robot robot;

    protected void setUp1(final TestHarness harness) throws Exception {
        this.text = new JTextField();
        this.text.setActionCommand(null);
        this.text.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent event) {
                harness.check(event.getActionCommand() != null);
                harness.check(event.getActionCommand(), (Object)fireActionPerformed.this.text.getText());
            }
        });
        this.frame = new JFrame();
        this.frame.setSize(200, 200);
        this.frame.getContentPane().add(this.text);
        this.frame.show();
        this.robot = new Robot();
        this.robot.setAutoDelay(50);
        this.robot.delay(500);
    }

    protected void setUp2(final TestHarness harness) throws Exception {
        this.text = new JTextField();
        this.text.setActionCommand("Action Command");
        this.text.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent event) {
                harness.check(event.getActionCommand() != null);
                harness.check(event.getActionCommand() != fireActionPerformed.this.text.getText());
                harness.check(event.getActionCommand() == "Action Command");
            }
        });
        this.frame = new JFrame();
        this.frame.setSize(200, 200);
        this.frame.getContentPane().add(this.text);
        this.frame.show();
        this.robot = new Robot();
        this.robot.setAutoDelay(50);
        this.robot.delay(500);
    }

    protected void tearDown() throws Exception {
        this.frame.dispose();
    }

    public void click(JTextField text2, int x, int y) {
        Point p = new Point();
        p.x = x;
        p.y = y;
        SwingUtilities.convertPointToScreen(p, text2);
        this.robot.mouseMove(p.x, p.y);
        this.robot.mousePress(16);
        this.robot.mouseRelease(16);
    }

    public void type(int key) {
        this.robot.keyPress(key);
        this.robot.keyRelease(key);
    }

    public void enterInput(TestHarness harness) {
        this.type(85);
        this.type(83);
        this.type(69);
        this.type(82);
        this.type(32);
        this.type(73);
        this.type(78);
        this.type(80);
        this.type(85);
        this.type(84);
        this.type(10);
    }

    @Override
    public void test(TestHarness harness) {
        try {
            this.setUp1(harness);
            try {
                this.click(this.text, this.text.getWidth() / 2, this.text.getHeight() / 2);
                this.enterInput(harness);
            }
            finally {
                this.tearDown();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            harness.fail("Exception: " + e);
        }
        try {
            this.setUp2(harness);
            try {
                this.click(this.text, this.text.getWidth() / 2, this.text.getHeight() / 2);
                this.enterInput(harness);
            }
            finally {
                this.tearDown();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            harness.fail("Exception: " + e);
        }
    }
}

