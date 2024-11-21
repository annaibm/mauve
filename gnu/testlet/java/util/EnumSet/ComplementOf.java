/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.EnumSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.EnumSet.Colour;
import java.util.EnumSet;

public class ComplementOf
implements Testlet {
    @Override
    public void test(TestHarness h) {
        EnumSet<Colour> empty = EnumSet.noneOf(Colour.class);
        h.debug("Empty: " + empty);
        EnumSet<Colour> full = EnumSet.complementOf(empty);
        h.debug("Full: " + full);
        h.check(full.size() == ((Colour[])Colour.class.getEnumConstants()).length, "Inverse of empty is full");
        EnumSet<Colour> empty2 = EnumSet.complementOf(full);
        h.debug("Empty2: " + empty2);
        h.check(empty2.size() == 0, "Inverse of full is empty");
        h.check(empty.equals(empty2), "Inversing the inverse is same as original");
    }
}

