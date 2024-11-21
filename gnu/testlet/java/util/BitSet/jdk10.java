/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.BitSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.BitSet;

public class jdk10
implements Testlet {
    TestHarness h;

    @Override
    public void test(TestHarness harness) {
        this.h = harness;
        this.h.checkPoint("Clone/Equals");
        BitSet b1 = new BitSet();
        BitSet b2 = (BitSet)b1.clone();
        this.h.check(this.trulyEquals(b1, b2));
        b1 = new BitSet(100);
        this.h.check(this.trulyEquals(b1, b2));
        b1.set(5);
        this.h.check(!this.trulyEquals(b1, b2));
        b2 = (BitSet)b1.clone();
        this.h.check(this.trulyEquals(b1, b2));
        this.h.check(!b2.equals(null));
        this.h.checkPoint("NegativeSize");
        try {
            b1 = new BitSet(-1);
            this.h.check(false);
        }
        catch (NegativeArraySizeException e) {
            this.h.check(true);
        }
        this.h.checkPoint("Set/Clear/Get");
        b1 = new BitSet();
        b1.set(1);
        b1.set(200);
        b1.set(0);
        this.h.check(b1.get(0));
        this.h.check(b1.get(1));
        this.h.check(!b1.get(2));
        this.h.check(b1.get(200));
        b1.clear(0);
        this.h.check(!b1.get(0));
        this.h.checkPoint("Set/Clear/Get negative index");
        try {
            b1.set(-1);
            this.h.check(false);
        }
        catch (IndexOutOfBoundsException e) {
            this.h.check(true);
        }
        try {
            b1.get(-1);
            this.h.check(false);
        }
        catch (IndexOutOfBoundsException e) {
            this.h.check(true);
        }
        try {
            b1.clear(-1);
            this.h.check(false);
        }
        catch (IndexOutOfBoundsException e) {
            this.h.check(true);
        }
        this.h.checkPoint("toString");
        this.h.check(b1.toString().equals("{1, 200}"));
        b1.set(2);
        b1.set(11);
        this.h.check(b1.toString().equals("{1, 2, 11, 200}"));
        b2 = new BitSet(100);
        this.h.check(b2.toString().equals("{}"));
        b2.set(1);
        this.h.check(b2.toString().equals("{1}"));
        this.h.checkPoint("Hashcode");
        this.h.check(b1.hashCode() == 2260);
        BitSet b3 = new BitSet();
        this.h.check(b3.hashCode() == 1234);
        this.h.checkPoint("And/Or/Xor");
        b2.set(1);
        b2.set(3);
        b2.set(200);
        b2.set(300);
        b2.and(b1);
        this.h.check(b2.toString().equals("{1, 200}"));
        b1.set(17);
        b2.set(15);
        b2.or(b1);
        this.h.check(b2.toString().equals("{1, 2, 11, 15, 17, 200}"));
        b2.xor(b2);
        this.h.check(b2.toString().equals("{}"));
        b2.xor(b1);
        b3.or(b1);
        this.h.check(this.trulyEquals(b2, b3));
        this.h.checkPoint("NullPointerExceptions");
        try {
            b1.and(null);
            this.h.check(false);
        }
        catch (NullPointerException e) {
            this.h.check(true);
        }
        try {
            b1.or(null);
            this.h.check(false);
        }
        catch (NullPointerException e) {
            this.h.check(true);
        }
        try {
            b1.xor(null);
            this.h.check(false);
        }
        catch (NullPointerException e) {
            this.h.check(true);
        }
    }

    private boolean trulyEquals(BitSet b1, BitSet b2) {
        boolean e1 = b1.equals(b2);
        boolean e2 = true;
        for (int i = 0; i < 300; ++i) {
            if (b1.get(i) == b2.get(i)) continue;
            e2 = false;
        }
        this.h.check(e1 == e2);
        return e2;
    }
}

