/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.event.MouseEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class modifiers
implements Testlet {
    int mask;
    Robot robot;
    TestHarness h;
    boolean test_alt;

    public void checkMask(int[] keycode, int buttonmask, int keymask) {
        int i;
        for (i = 0; i < keycode.length; ++i) {
            this.robot.keyPress(keycode[i]);
        }
        this.robot.mousePress(buttonmask);
        this.h.check(this.mask, buttonmask | keymask, "mousePressed: " + this.mask);
        this.mask = 0;
        this.robot.mouseRelease(buttonmask);
        this.h.check(this.mask, buttonmask | keymask, "mouseReleased: " + this.mask);
        this.mask = 0;
        for (i = 0; i < keycode.length; ++i) {
            this.robot.keyRelease(keycode[i]);
        }
    }

    public void checkAllMaskCombinations(int buttonmask) {
        this.checkMask(new int[0], buttonmask, 0);
        this.checkMask(new int[]{16}, buttonmask, 1);
        this.checkMask(new int[]{17}, buttonmask, 2);
        if (this.test_alt) {
            this.checkMask(new int[]{157}, buttonmask, 4);
            this.checkMask(new int[]{18}, buttonmask, 8);
            this.checkMask(new int[]{65406}, buttonmask, 32);
        }
        this.checkMask(new int[]{16, 17}, buttonmask, 3);
        if (this.test_alt) {
            this.checkMask(new int[]{16, 157}, buttonmask, 5);
            this.checkMask(new int[]{16, 18}, buttonmask, 9);
            this.checkMask(new int[]{16, 65406}, buttonmask, 33);
            this.checkMask(new int[]{17, 157}, buttonmask, 6);
            this.checkMask(new int[]{17, 18}, buttonmask, 10);
            this.checkMask(new int[]{17, 65406}, buttonmask, 34);
            this.checkMask(new int[]{157, 18}, buttonmask, 12);
            this.checkMask(new int[]{157, 65406}, buttonmask, 36);
            this.checkMask(new int[]{18, 65406}, buttonmask, 40);
            this.checkMask(new int[]{16, 17, 157}, buttonmask, 7);
            this.checkMask(new int[]{16, 17, 18}, buttonmask, 11);
            this.checkMask(new int[]{16, 17, 65406}, buttonmask, 35);
            this.checkMask(new int[]{16, 157, 18}, buttonmask, 13);
            this.checkMask(new int[]{16, 17, 65406}, buttonmask, 35);
            this.checkMask(new int[]{16, 18, 65406}, buttonmask, 41);
            this.checkMask(new int[]{17, 157, 18}, buttonmask, 14);
            this.checkMask(new int[]{17, 157, 65406}, buttonmask, 38);
            this.checkMask(new int[]{17, 18, 65406}, buttonmask, 42);
            this.checkMask(new int[]{157, 18, 65406}, buttonmask, 44);
            this.checkMask(new int[]{16, 17, 157, 18}, buttonmask, 15);
            this.checkMask(new int[]{16, 17, 157, 65406}, buttonmask, 39);
            this.checkMask(new int[]{16, 17, 18, 65406}, buttonmask, 43);
            this.checkMask(new int[]{16, 157, 18, 65406}, buttonmask, 45);
            this.checkMask(new int[]{17, 157, 18, 65406}, buttonmask, 46);
            this.checkMask(new int[]{16, 17, 157, 18, 65406}, buttonmask, 47);
        }
    }

    @Override
    public void test(TestHarness h) {
        this.h = h;
        Frame frame = new Frame();
        MouseAdapter a = new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent ev) {
                modifiers.this.mask = ev.getModifiers();
            }

            @Override
            public void mouseReleased(MouseEvent ev) {
                modifiers.this.mask = ev.getModifiers();
            }
        };
        frame.addMouseListener(a);
        frame.setSize(100, 100);
        frame.show();
        Point loc = frame.getLocationOnScreen();
        this.robot = h.createRobot();
        this.robot.setAutoWaitForIdle(true);
        this.robot.mouseMove(loc.x + 50, loc.y + 50);
        this.checkAllMaskCombinations(16);
        this.checkAllMaskCombinations(8);
        this.checkAllMaskCombinations(4);
    }
}

