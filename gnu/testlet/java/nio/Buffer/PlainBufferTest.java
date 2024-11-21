/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.Buffer;

import gnu.testlet.TestHarness;
import gnu.testlet.java.nio.Buffer.BufferFactory;
import java.nio.Buffer;
import java.nio.InvalidMarkException;

public class PlainBufferTest {
    public void test(TestHarness h, BufferFactory factory) {
        try {
            this.intialState(h, factory);
            this.position(h, factory);
            this.mark(h, factory);
            this.limit(h, factory);
            this.rewind(h, factory);
            this.clear(h, factory);
            this.flip(h, factory);
        }
        catch (Exception e) {
            h.fail("Unexpected excetpion: " + e);
            h.debug(e);
        }
    }

    private void intialState(TestHarness h, BufferFactory factory) {
        Buffer buf = null;
        buf = factory.newInstance();
        this.checkStatus(h, buf, "intialState", 10, 10, true, 10, 0);
    }

    private void position(TestHarness h, BufferFactory factory) {
        Buffer buf = null;
        buf = factory.newInstance();
        h.check(buf.position(1), buf, "position: buf.position(1)");
        this.checkStatus(h, buf, "position", 10, 10, true, 9, 1);
        buf.position(10);
        this.checkStatus(h, buf, "position", 10, 10, false, 0, 10);
        buf = factory.newInstance();
        try {
            buf.position(-1);
            h.check(false, "position: is negative");
        }
        catch (IllegalArgumentException iae) {
            h.check(true, "position: can't be negative");
        }
        buf = factory.newInstance();
        buf.limit(5);
        try {
            buf.position(6);
            h.check(false, "position: is larger than capacity");
        }
        catch (IllegalArgumentException iae) {
            h.check(true, "position: can't be larger than capacity");
        }
    }

    private void mark(TestHarness h, BufferFactory factory) {
        Buffer buf = null;
        buf = factory.newInstance();
        h.check(buf.mark(), buf, "mark: buf.mark()");
        this.checkStatus(h, buf, "mark", 10, 10, true, 10, 0);
        buf.position(5);
        this.checkStatus(h, buf, "mark", 10, 10, true, 5, 5);
        h.check(buf.reset(), buf, "mark: buf.reset()");
        this.checkStatus(h, buf, "mark", 10, 10, true, 10, 0);
        buf.position(6);
        this.checkStatus(h, buf, "mark", 10, 10, true, 4, 6);
        buf.reset();
        this.checkStatus(h, buf, "mark", 10, 10, true, 10, 0);
        buf = factory.newInstance();
        buf.position(5);
        buf.mark();
        this.checkStatus(h, buf, "mark", 10, 10, true, 5, 5);
        buf.position(6);
        this.checkStatus(h, buf, "mark", 10, 10, true, 4, 6);
        buf.reset();
        this.checkStatus(h, buf, "mark", 10, 10, true, 5, 5);
        buf.position(7);
        this.checkStatus(h, buf, "mark", 10, 10, true, 3, 7);
        buf.reset();
        this.checkStatus(h, buf, "mark", 10, 10, true, 5, 5);
        buf = factory.newInstance();
        buf.position(5);
        buf.mark();
        buf.position(4);
        try {
            buf.reset();
            h.check(false, "mark: mark not invalidated");
        }
        catch (InvalidMarkException ime) {
            h.check(true, "mark: invalidated mark");
        }
        this.checkStatus(h, buf, "mark", 10, 10, true, 6, 4);
    }

    private void limit(TestHarness h, BufferFactory factory) {
        Buffer buf = null;
        buf = factory.newInstance();
        buf.position(2);
        buf.mark();
        buf.position(3);
        h.check(buf.limit(4), buf, "limit: buf.limit(4)");
        this.checkStatus(h, buf, "limit", 10, 4, true, 1, 3);
        buf.reset();
        this.checkStatus(h, buf, "limit", 10, 4, true, 2, 2);
        buf = factory.newInstance();
        buf.position(5);
        buf.mark();
        buf.position(6);
        buf.limit(4);
        this.checkStatus(h, buf, "limit", 10, 4, false, 0, 4);
        try {
            buf.reset();
            h.check(false, "limit: mark not invalidated");
        }
        catch (InvalidMarkException ime) {
            h.check(true, "limit: invalidated mark");
        }
        buf = factory.newInstance();
        try {
            buf.limit(-1);
            h.check(false, "limit: is negative");
        }
        catch (IllegalArgumentException iae) {
            h.check(true, "limit: can't be negative");
        }
        buf = factory.newInstance();
        try {
            buf.limit(11);
            h.check(false, "limit: is larger than capacity");
        }
        catch (IllegalArgumentException iae) {
            h.check(true, "limit: can't be larger than capacity");
        }
    }

    private void rewind(TestHarness h, BufferFactory factory) {
        Buffer buf = null;
        buf = factory.newInstance();
        buf.position(5);
        buf.mark();
        buf.position(6);
        buf.limit(9);
        h.check(buf.rewind(), buf, "rewind: buf.rewind()");
        this.checkStatus(h, buf, "rewind", 10, 9, true, 9, 0);
        try {
            buf.reset();
            h.check(false, "rewind: mark not invalidated");
        }
        catch (InvalidMarkException ime) {
            h.check(true, "rewind: invalidated mark");
        }
    }

    private void clear(TestHarness h, BufferFactory factory) {
        Buffer buf = null;
        buf = factory.newInstance();
        buf.position(5);
        buf.mark();
        buf.position(6);
        buf.limit(7);
        h.check(buf.clear(), buf, "clear: buf.clear()");
        this.checkStatus(h, buf, "clear", 10, 10, true, 10, 0);
        try {
            buf.reset();
            h.check(false, "clear: mark not invalidated");
        }
        catch (InvalidMarkException ime) {
            h.check(true, "clear: invalidated mark");
        }
    }

    private void flip(TestHarness h, BufferFactory factory) {
        Buffer buf = null;
        buf = factory.newInstance();
        buf.position(5);
        buf.mark();
        buf.position(6);
        h.check(buf.flip(), buf, "flip: buf.flip()");
        this.checkStatus(h, buf, "flip", 10, 6, true, 6, 0);
        try {
            buf.reset();
            h.check(false, "flip: mark not invalidated");
        }
        catch (InvalidMarkException ime) {
            h.check(true, "flip: invalidated mark");
        }
    }

    private void checkStatus(TestHarness h, Buffer buf, String prefix, int cap, int lim, boolean hasRem, int rem, int pos) {
        h.check(buf.capacity(), cap, prefix + ": buf.capacity()");
        h.check(buf.limit(), lim, prefix + ": buf.limit()");
        h.check(buf.hasRemaining(), hasRem, prefix + ": buf.hasRemaining()");
        h.check(buf.remaining(), rem, prefix + ": buf.remaining()");
        h.check(buf.position(), pos, prefix + ": buf.position()");
    }
}

