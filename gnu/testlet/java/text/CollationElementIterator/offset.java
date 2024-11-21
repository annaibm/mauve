/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.CollationElementIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.CollationElementIterator;
import java.text.ParseException;
import java.text.RuleBasedCollator;

public class offset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            RuleBasedCollator collator = new RuleBasedCollator("<a,A<AB,ab<ABC,abc");
            CollationElementIterator iter2 = collator.getCollationElementIterator("abaaABC");
            iter2.setOffset(1);
            harness.check(iter2.getOffset(), 0);
            iter2.setOffset(0);
            iter2.next();
            harness.check(iter2.getOffset(), 2);
            iter2.next();
            harness.check(iter2.getOffset(), 3);
            iter2.next();
            harness.check(iter2.getOffset(), 4);
            iter2.next();
            harness.check(iter2.getOffset(), 7);
        }
        catch (ParseException e) {
            harness.fail("Unexpected parse error exception");
            harness.debug(e);
        }
    }
}

