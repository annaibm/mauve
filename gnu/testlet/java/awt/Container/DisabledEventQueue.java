/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import java.awt.AWTEvent;
import java.awt.EventQueue;

public class DisabledEventQueue
extends EventQueue {
    @Override
    protected void dispatchEvent(AWTEvent ev) {
    }

    @Override
    public void postEvent(AWTEvent ev) {
    }
}

