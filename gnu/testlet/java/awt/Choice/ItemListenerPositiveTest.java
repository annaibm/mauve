/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Choice;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListenerPositiveTest
extends Panel
implements Testlet {
    boolean itemStateChangedFlag = false;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Choice choice = new Choice();
        choice.add("first");
        choice.add("second");
        choice.add("third");
        choice.setBackground(Color.blue);
        this.add(choice);
        choice.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                ItemListenerPositiveTest.this.itemStateChangedFlag = true;
            }
        });
        frame.add(this);
        frame.pack();
        frame.show();
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(1000);
        Rectangle bounds = choice.getBounds();
        Point loc = frame.getLocationOnScreen();
        Insets i = frame.getInsets();
        bounds.x += i.left + loc.x;
        bounds.y += i.top + loc.y;
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        robot.mouseMove(checkedPixelX, checkedPixelY);
        robot.waitForIdle();
        robot.mousePress(16);
        robot.delay(250);
        robot.mouseRelease(16);
        robot.delay(250);
        robot.mouseMove(checkedPixelX, checkedPixelY + 30);
        robot.delay(250);
        robot.mousePress(16);
        robot.delay(250);
        robot.mouseRelease(16);
        robot.delay(250);
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
        harness.check(this.itemStateChangedFlag);
    }

    @Override
    public void paint(Graphics g) {
        Image offScr = this.createImage(this.getSize().width, this.getSize().height);
        Graphics offG = offScr.getGraphics();
        offG.setClip(0, 0, this.getSize().width, this.getSize().height);
        super.paint(offG);
        g.drawImage(offScr, 0, 0, null);
        offG.dispose();
    }
}

