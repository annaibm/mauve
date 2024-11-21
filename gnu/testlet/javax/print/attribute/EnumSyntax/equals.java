/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.EnumSyntax;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.print.attribute.EnumSyntax.CorrectEnumSyntax;
import gnu.testlet.javax.print.attribute.EnumSyntax.WrongEnumSyntax;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        WrongEnumSyntax test = WrongEnumSyntax.TEST;
        WrongEnumSyntax test22 = WrongEnumSyntax.TEST;
        harness.check(test.hashCode() == 100, "hashcode()");
        harness.check(test.equals(test22), "equals()");
        harness.check(test == test22, "identity");
        harness.check(test.toString(), "100", "toString");
        CorrectEnumSyntax test32 = CorrectEnumSyntax.TEST3;
        CorrectEnumSyntax test42 = CorrectEnumSyntax.TEST3;
        harness.check(test32.hashCode() == 5, "hashcode()");
        harness.check(test32.equals(test42), "equals()");
        harness.check(test32 == test42, "identity");
        harness.check(test32.toString(), "test3", "toString");
    }
}

