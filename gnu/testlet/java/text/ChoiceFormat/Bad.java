/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.ChoiceFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ChoiceFormat;

public class Bad
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ChoiceFormat f;
        try {
            f = new ChoiceFormat("0#zero|1#one|1>many");
            h.fail("Failed to catch bad limit 1>");
        }
        catch (IllegalArgumentException e) {
            h.check(true);
        }
        try {
            f = new ChoiceFormat("0#zero|1#one|1>many|");
            h.fail("Failed to catch bad limit 1> with trailing |");
        }
        catch (IllegalArgumentException e) {
            h.check(true);
        }
        try {
            f = new ChoiceFormat("0#zero|1#one|1<many|");
            h.fail("Failed to catch trailing |");
        }
        catch (IllegalArgumentException e) {
            h.check(true);
        }
        try {
            f = new ChoiceFormat("0#zero|1#one|1>many|1<many");
            h.fail("Failed to catch enclosed bad limit");
        }
        catch (IllegalArgumentException e) {
            h.check(true);
        }
    }
}

