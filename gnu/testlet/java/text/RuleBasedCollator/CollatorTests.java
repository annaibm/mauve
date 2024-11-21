/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.RuleBasedCollator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.CollationElementIterator;
import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Locale;

public class CollatorTests
implements Testlet {
    private TestHarness harness = null;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.basicCompare();
        this.orderComparision();
    }

    private void basicCompare() {
        Collator myCollator = Collator.getInstance(Locale.US);
        this.harness.check(myCollator.compare("abc", "ABC") < 0, "basic comparision");
        myCollator.setStrength(0);
        this.harness.check(myCollator.compare("abc", "ABC") == 0, "equivalent strings");
        String SimpleRule = "< a< b< c< d";
        boolean pass = false;
        try {
            RuleBasedCollator simpleRuleCollator = new RuleBasedCollator(SimpleRule);
            pass = simpleRuleCollator.compare("abc", "ABC") < 0;
        }
        catch (ParseException e) {
            pass = false;
        }
        this.harness.check(pass, "simple rule test");
    }

    private void orderComparision() {
        int element;
        RuleBasedCollator c = (RuleBasedCollator)Collator.getInstance(Locale.US);
        CollationElementIterator iter2 = c.getCollationElementIterator("Foo");
        int[][] results = new int[][]{{5767169, 88, 0, 1}, {0x610000, 97, 0, 0}, {0x610000, 97, 0, 0}};
        int i = 0;
        while ((element = iter2.next()) != -1) {
            int primary = CollationElementIterator.primaryOrder(element);
            short secondary = CollationElementIterator.secondaryOrder(element);
            short tertiary = CollationElementIterator.tertiaryOrder(element);
            this.harness.check(results[i][0] == element, "element #" + i);
            this.harness.check(results[i][1] == primary, "primary #" + i);
            this.harness.check(results[i][2] == secondary, "secondary #" + i);
            this.harness.check(results[i][3] == tertiary, "tertiary #" + i);
            ++i;
        }
    }
}

