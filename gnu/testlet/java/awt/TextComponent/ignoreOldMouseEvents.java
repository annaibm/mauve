/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.TextComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Robot;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.TextField;

public class ignoreOldMouseEvents
extends Frame
implements Testlet {
    TextField a;
    TextArea b;
    TestHarness harness;
    boolean mouseUp = false;
    boolean mouseDown = false;
    boolean mouseEnter = false;
    boolean mouseExit = false;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.a = new TextField(5);
        this.b = new TextArea(10, 10);
        this.add((Component)this.a, "East");
        this.add((Component)this.b, "West");
        this.setSize(200, 200);
        this.show();
        this.testOldMouseEvents();
    }

    public void testOldMouseEvents() {
        Robot r = this.harness.createRobot();
        r.waitForIdle();
        Point aLocScreen = this.a.getLocationOnScreen();
        Point aMiddle = new Point(aLocScreen.x + this.a.getWidth() / 2, aLocScreen.y + this.a.getHeight() / 2);
        r.mouseMove(aMiddle.x, aMiddle.y);
        r.delay(1000);
        this.harness.check(!this.mouseEnter);
        this.mouseEnter = false;
        r.mousePress(16);
        r.delay(1000);
        this.harness.check(!this.mouseDown);
        this.mouseDown = false;
        r.mouseRelease(16);
        r.delay(1000);
        this.harness.check(!this.mouseUp);
        this.mouseUp = false;
        Point bLocScreen = this.b.getLocationOnScreen();
        Point bMiddle = new Point(bLocScreen.x + this.b.getWidth() / 2, bLocScreen.y + this.b.getHeight() / 2);
        r.mouseMove(bMiddle.x, bMiddle.y);
        r.delay(1000);
        this.harness.check(!this.mouseExit);
        this.harness.check(!this.mouseEnter);
        this.mouseEnter = false;
        this.mouseExit = false;
        r.mousePress(16);
        r.delay(1000);
        this.harness.check(!this.mouseDown);
        this.mouseDown = false;
        r.mouseRelease(16);
        r.delay(1000);
        this.harness.check(!this.mouseUp);
        this.mouseUp = false;
        r.mouseMove(bMiddle.x * 2, bMiddle.y * 2);
        r.delay(1000);
        this.harness.check(!this.mouseExit);
        this.mouseExit = false;
    }

    @Override
    public boolean mouseDown(Event evt, int x, int y) {
        if (evt.arg instanceof TextComponent) {
            this.mouseDown = true;
        }
        return false;
    }

    @Override
    public boolean mouseUp(Event evt, int x, int y) {
        if (evt.arg instanceof TextComponent) {
            this.mouseUp = true;
        }
        return false;
    }

    @Override
    public boolean mouseExit(Event evt, int x, int y) {
        if (evt.arg instanceof TextComponent) {
            this.mouseExit = true;
        }
        return false;
    }

    @Override
    public boolean mouseEnter(Event evt, int x, int y) {
        if (evt.arg instanceof TextComponent) {
            this.mouseEnter = true;
        }
        return false;
    }
}

