/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class to
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Character.toUpperCase('a'), 65);
        harness.check(Character.toUpperCase('A'), 65);
        harness.check(Character.toUpperCase('\uff5a'), 65338);
        harness.check(Character.toUpperCase('7'), 55);
        harness.check(Character.toUpperCase('\u01f2'), 497);
        harness.check(Character.toLowerCase('q'), 113);
        harness.check(Character.toLowerCase('Q'), 113);
        harness.check(Character.toLowerCase('\u2638'), 9784);
        harness.check(Character.toLowerCase('\u01cb'), 460);
        harness.check(Character.toLowerCase('\u01ca'), 460);
        harness.check(Character.toLowerCase('\u00df'), 223);
        harness.check(Character.toLowerCase('\u2160'), 8560);
        harness.check(Character.toTitleCase('a'), 65);
        harness.check(Character.toTitleCase('\u01f3'), 498);
        harness.check(Character.toTitleCase('\u01f1'), 498);
        harness.check(Character.toTitleCase('\u01f2'), 498);
    }
}

