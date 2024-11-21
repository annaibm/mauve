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

public class modifiersEx
implements Testlet {
    int mask;
    Robot robot;
    TestHarness h;
    boolean test_alt;

    public void checkMask(int[] keycode, int buttonmask, int keymask) {
        int i;
        int robot_button = 0;
        if (buttonmask == 1024) {
            robot_button = 16;
        } else if (buttonmask == 2048) {
            robot_button = 8;
        } else if (buttonmask == 4096) {
            robot_button = 4;
        }
        for (i = 0; i < keycode.length; ++i) {
            this.robot.keyPress(keycode[i]);
        }
        this.robot.mousePress(robot_button);
        this.h.check(this.mask, buttonmask | keymask, "mousePressed: " + this.mask);
        this.mask = 0;
        this.robot.mouseRelease(robot_button);
        this.h.check(this.mask, keymask, "mouseReleased: " + this.mask);
        this.mask = 0;
        for (i = 0; i < keycode.length; ++i) {
            this.robot.keyRelease(keycode[i]);
        }
    }

    public void checkAllMaskCombinations(int buttonmask) {
        this.checkMask(new int[0], buttonmask, 0);
        this.checkMask(new int[]{16}, buttonmask, 64);
        this.checkMask(new int[]{17}, buttonmask, 128);
        if (this.test_alt) {
            this.checkMask(new int[]{157}, buttonmask, 256);
            this.checkMask(new int[]{18}, buttonmask, 512);
            this.checkMask(new int[]{65406}, buttonmask, 8192);
        }
        this.checkMask(new int[]{16, 17}, buttonmask, 192);
        if (this.test_alt) {
            this.checkMask(new int[]{16, 157}, buttonmask, 320);
            this.checkMask(new int[]{16, 18}, buttonmask, 576);
            this.checkMask(new int[]{16, 65406}, buttonmask, 8256);
            this.checkMask(new int[]{17, 157}, buttonmask, 384);
            this.checkMask(new int[]{17, 18}, buttonmask, 640);
            this.checkMask(new int[]{17, 65406}, buttonmask, 8320);
            this.checkMask(new int[]{157, 18}, buttonmask, 768);
            this.checkMask(new int[]{157, 65406}, buttonmask, 8448);
            this.checkMask(new int[]{18, 65406}, buttonmask, 8704);
            this.checkMask(new int[]{16, 17, 157}, buttonmask, 448);
            this.checkMask(new int[]{16, 17, 18}, buttonmask, 704);
            this.checkMask(new int[]{16, 17, 65406}, buttonmask, 8384);
            this.checkMask(new int[]{16, 157, 18}, buttonmask, 832);
            this.checkMask(new int[]{16, 17, 65406}, buttonmask, 8384);
            this.checkMask(new int[]{16, 18, 65406}, buttonmask, 8768);
            this.checkMask(new int[]{17, 157, 18}, buttonmask, 896);
            this.checkMask(new int[]{17, 157, 65406}, buttonmask, 8576);
            this.checkMask(new int[]{17, 18, 65406}, buttonmask, 8832);
            this.checkMask(new int[]{157, 18, 65406}, buttonmask, 8960);
            this.checkMask(new int[]{16, 17, 157, 18}, buttonmask, 960);
            this.checkMask(new int[]{16, 17, 157, 65406}, buttonmask, 8640);
            this.checkMask(new int[]{16, 17, 18, 65406}, buttonmask, 8896);
            this.checkMask(new int[]{16, 157, 18, 65406}, buttonmask, 9024);
            this.checkMask(new int[]{17, 157, 18, 65406}, buttonmask, 9088);
            this.checkMask(new int[]{16, 17, 157, 18, 65406}, buttonmask, 9152);
        }
    }

    @Override
    public void test(TestHarness h) {
        this.h = h;
        Frame frame = new Frame();
        MouseAdapter a = new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent ev) {
                modifiersEx.this.mask = ev.getModifiersEx();
            }

            @Override
            public void mouseReleased(MouseEvent ev) {
                modifiersEx.this.mask = ev.getModifiersEx();
            }
        };
        frame.addMouseListener(a);
        frame.setSize(100, 100);
        frame.show();
        Point loc = frame.getLocationOnScreen();
        this.robot = h.createRobot();
        this.robot.setAutoWaitForIdle(true);
        this.robot.mouseMove(loc.x + 50, loc.y + 50);
        this.checkAllMaskCombinations(1024);
        this.checkAllMaskCombinations(2048);
        this.checkAllMaskCombinations(4096);
    }
}

