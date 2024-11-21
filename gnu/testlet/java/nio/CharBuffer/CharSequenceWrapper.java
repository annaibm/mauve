/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.CharBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.CharBuffer;

public class CharSequenceWrapper
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testSlice(harness);
        this.testDuplicate(harness);
        this.testBasic(harness);
    }

    private void testBasic(TestHarness h) {
        h.checkPoint("testBasic");
        StringBuilder b = new StringBuilder("Hello World");
        CharBuffer cb = CharBuffer.wrap(b, 4, 7);
        try {
            cb.arrayOffset();
            h.fail("testBasic");
        }
        catch (UnsupportedOperationException ex) {
            h.check(true);
        }
        try {
            cb.array();
            h.fail("testBasic");
        }
        catch (UnsupportedOperationException ex) {
            h.check(true);
        }
        h.check(cb.capacity(), b.length());
        h.check(cb.hasArray(), false);
        h.check(cb.hasRemaining(), true);
        h.check(cb.isDirect(), false);
        h.check(cb.isReadOnly(), true);
        h.check(cb.length(), 3);
        h.check(cb.limit(), 7);
        h.check(cb.position(), 4);
        h.check(cb.remaining(), 3);
        try {
            cb.compact();
            h.fail("testBasic");
        }
        catch (UnsupportedOperationException ex) {
            h.check(true);
        }
    }

    private void testSlice(TestHarness h) {
        StringBuilder b = new StringBuilder("Hello World");
        CharBuffer cb = CharBuffer.wrap(b);
        cb.position(4);
        cb.limit(7);
        CharBuffer slice = cb.slice();
        h.check(slice.capacity(), 3);
        try {
            slice.arrayOffset();
            h.fail("testSlice");
        }
        catch (UnsupportedOperationException ex) {
            h.check(true);
        }
        h.check(slice.hasArray(), false);
        try {
            slice.array();
            h.fail("testSlice");
        }
        catch (UnsupportedOperationException ex) {
            h.check(true);
        }
        h.check(slice.isDirect(), false);
        h.check(slice.isReadOnly(), true);
        h.check(slice.length(), 3);
        h.check(slice.limit(), 3);
        h.check(slice.position(), 0);
        h.check(slice.get(), 111);
        h.check(slice.get(), 32);
        h.check(slice.get(), 87);
    }

    private void testDuplicate(TestHarness h) {
        StringBuilder b = new StringBuilder("Hello World");
        CharBuffer cb = CharBuffer.wrap(b);
        cb.position(4);
        cb.limit(7);
        CharBuffer dup = cb.duplicate();
        h.check(dup.capacity(), 11);
        try {
            dup.arrayOffset();
            h.fail("testDuplicate");
        }
        catch (UnsupportedOperationException ex) {
            h.check(true);
        }
        h.check(dup.hasArray(), false);
        try {
            dup.array();
            h.fail("testSlice");
        }
        catch (UnsupportedOperationException ex) {
            h.check(true);
        }
        h.check(dup.isDirect(), false);
        h.check(dup.isReadOnly(), true);
        h.check(dup.length(), 3);
        h.check(dup.limit(), 7);
        h.check(dup.position(), 4);
        h.check(dup.get(), 111);
        h.check(dup.get(), 32);
        h.check(dup.get(), 87);
    }
}

