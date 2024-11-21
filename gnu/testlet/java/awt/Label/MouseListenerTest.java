/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerTest
extends Panel
implements Testlet {
    private static final long serialVersionUID = 477052346645513905L;
    private boolean mouseClickedLabel1Flag = false;
    private boolean mouseClickedLabel2Flag = false;
    private boolean mouseClickedLabel3Flag = false;
    private boolean mousePressedLabel1Flag = false;
    private boolean mousePressedLabel2Flag = false;
    private boolean mousePressedLabel3Flag = false;
    private boolean mouseReleasedLabel1Flag = false;
    private boolean mouseReleasedLabel2Flag = false;
    private boolean mouseReleasedLabel3Flag = false;
    private boolean mouseEnteredFlag = false;
    private boolean mouseExitedFlag = false;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Label label = new Label("xyzzy");
        label.setBackground(Color.blue);
        this.add(label);
        label.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                switch (e.getButton()) {
                    case 1: {
                        MouseListenerTest.this.setMouseClickedLabel1Flag(true);
                        break;
                    }
                    case 2: {
                        MouseListenerTest.this.setMouseClickedLabel2Flag(true);
                        break;
                    }
                    case 3: {
                        MouseListenerTest.this.setMouseClickedLabel3Flag(true);
                        break;
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                MouseListenerTest.this.setMouseEnteredFlag(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MouseListenerTest.this.setMouseExitedFlag(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                switch (e.getButton()) {
                    case 1: {
                        MouseListenerTest.this.setMousePressedLabel1Flag(true);
                        break;
                    }
                    case 2: {
                        MouseListenerTest.this.setMousePressedLabel2Flag(true);
                        break;
                    }
                    case 3: {
                        MouseListenerTest.this.setMousePressedLabel3Flag(true);
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                switch (e.getButton()) {
                    case 1: {
                        MouseListenerTest.this.setMouseReleasedLabel1Flag(true);
                        break;
                    }
                    case 2: {
                        MouseListenerTest.this.setMouseReleasedLabel2Flag(true);
                        break;
                    }
                    case 3: {
                        MouseListenerTest.this.setMouseReleasedLabel3Flag(true);
                        break;
                    }
                }
            }
        });
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(1000);
        Rectangle bounds = label.getBounds();
        Point loc = frame.getLocationOnScreen();
        Insets i = frame.getInsets();
        bounds.x += i.left + loc.x;
        bounds.y += i.top + loc.y;
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        Integer[] integerArray = new Integer[]{16, 8, 4};
        int n = integerArray.length;
        for (int j = 0; j < n; ++j) {
            int mouseLabel = integerArray[j];
            robot.mouseMove(0, 0);
            robot.waitForIdle();
            robot.mouseMove(checkedPixelX, checkedPixelY);
            robot.waitForIdle();
            robot.delay(250);
            robot.mousePress(mouseLabel);
            robot.delay(250);
            robot.mouseRelease(mouseLabel);
            robot.delay(250);
            robot.mouseMove(0, 0);
            robot.delay(250);
        }
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
        harness.check(this.isMouseClickedLabel1Flag());
        harness.check(this.isMouseClickedLabel2Flag());
        harness.check(this.isMouseClickedLabel3Flag());
        harness.check(this.isMousePressedLabel1Flag());
        harness.check(this.isMousePressedLabel2Flag());
        harness.check(this.isMousePressedLabel3Flag());
        harness.check(this.isMouseReleasedLabel1Flag());
        harness.check(this.isMouseReleasedLabel2Flag());
        harness.check(this.isMouseReleasedLabel3Flag());
        harness.check(this.isMouseEnteredFlag());
        harness.check(this.isMouseExitedFlag());
    }

    @Override
    public void paint(Graphics graphics) {
        Image offScr = this.createImage(this.getSize().width, this.getSize().height);
        Graphics offG = offScr.getGraphics();
        offG.setClip(0, 0, this.getSize().width, this.getSize().height);
        super.paint(offG);
        graphics.drawImage(offScr, 0, 0, null);
        offG.dispose();
    }

    public void setMouseEnteredFlag(boolean mouseEnteredFlag) {
        this.mouseEnteredFlag = mouseEnteredFlag;
    }

    public boolean isMouseEnteredFlag() {
        return this.mouseEnteredFlag;
    }

    public void setMouseExitedFlag(boolean mouseExitedFlag) {
        this.mouseExitedFlag = mouseExitedFlag;
    }

    public boolean isMouseExitedFlag() {
        return this.mouseExitedFlag;
    }

    public void setMousePressedLabel1Flag(boolean mousePressedLabel1Flag) {
        this.mousePressedLabel1Flag = mousePressedLabel1Flag;
    }

    public boolean isMousePressedLabel1Flag() {
        return this.mousePressedLabel1Flag;
    }

    public void setMousePressedLabel2Flag(boolean mousePressedLabel2Flag) {
        this.mousePressedLabel2Flag = mousePressedLabel2Flag;
    }

    public boolean isMousePressedLabel2Flag() {
        return this.mousePressedLabel2Flag;
    }

    public void setMousePressedLabel3Flag(boolean mousePressedLabel3Flag) {
        this.mousePressedLabel3Flag = mousePressedLabel3Flag;
    }

    public boolean isMousePressedLabel3Flag() {
        return this.mousePressedLabel3Flag;
    }

    public void setMouseClickedLabel1Flag(boolean mouseClickedLabel1Flag) {
        this.mouseClickedLabel1Flag = mouseClickedLabel1Flag;
    }

    public boolean isMouseClickedLabel1Flag() {
        return this.mouseClickedLabel1Flag;
    }

    public void setMouseClickedLabel2Flag(boolean mouseClickedLabel2Flag) {
        this.mouseClickedLabel2Flag = mouseClickedLabel2Flag;
    }

    public boolean isMouseClickedLabel2Flag() {
        return this.mouseClickedLabel2Flag;
    }

    public void setMouseClickedLabel3Flag(boolean mouseClickedLabel3Flag) {
        this.mouseClickedLabel3Flag = mouseClickedLabel3Flag;
    }

    public boolean isMouseClickedLabel3Flag() {
        return this.mouseClickedLabel3Flag;
    }

    public void setMouseReleasedLabel1Flag(boolean mouseReleasedLabel1Flag) {
        this.mouseReleasedLabel1Flag = mouseReleasedLabel1Flag;
    }

    public boolean isMouseReleasedLabel1Flag() {
        return this.mouseReleasedLabel1Flag;
    }

    public void setMouseReleasedLabel2Flag(boolean mouseReleasedLabel2Flag) {
        this.mouseReleasedLabel2Flag = mouseReleasedLabel2Flag;
    }

    public boolean isMouseReleasedLabel2Flag() {
        return this.mouseReleasedLabel2Flag;
    }

    public void setMouseReleasedLabel3Flag(boolean mouseReleasedLabel3Flag) {
        this.mouseReleasedLabel3Flag = mouseReleasedLabel3Flag;
    }

    public boolean isMouseReleasedLabel3Flag() {
        return this.mouseReleasedLabel3Flag;
    }
}

