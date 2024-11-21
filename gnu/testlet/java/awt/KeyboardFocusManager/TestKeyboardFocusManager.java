/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.KeyboardFocusManager;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class TestKeyboardFocusManager
extends KeyboardFocusManager {
    @Override
    public void setGlobalFocusOwner(Component c) {
        super.setGlobalFocusOwner(c);
    }

    @Override
    public Component getGlobalFocusOwner() {
        return super.getGlobalFocusOwner();
    }

    @Override
    public void setGlobalPermanentFocusOwner(Component c) {
        super.setGlobalPermanentFocusOwner(c);
    }

    @Override
    public Component getGlobalPermanentFocusOwner() {
        return super.getGlobalPermanentFocusOwner();
    }

    @Override
    protected void dequeueKeyEvents(long after2, Component untilFocused) {
    }

    @Override
    protected void discardKeyEvents(Component comp) {
    }

    @Override
    public boolean dispatchEvent(AWTEvent e) {
        return false;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        return false;
    }

    @Override
    public void downFocusCycle(Container cont) {
    }

    @Override
    protected void enqueueKeyEvents(long after2, Component untilFocused) {
    }

    @Override
    public void focusNextComponent(Component comp) {
    }

    @Override
    public void focusPreviousComponent(Component comp) {
    }

    @Override
    public boolean postProcessKeyEvent(KeyEvent e) {
        return false;
    }

    @Override
    public void processKeyEvent(Component focused, KeyEvent e) {
    }

    @Override
    public void upFocusCycle(Component comp) {
    }
}

