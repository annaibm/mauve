/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.Bidi;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.Bidi;

public class reorderVisually
implements Testlet {
    public void testOne(TestHarness harness, String input, String levels, String expected) {
        Object[] inputA = new Object[input.length()];
        byte[] levelsA = new byte[levels.length()];
        for (int i = 0; i < input.length(); ++i) {
            inputA[i] = input.substring(i, i + 1);
            levelsA[i] = (byte)(levels.charAt(i) - 48);
        }
        Bidi.reorderVisually(levelsA, 0, inputA, 0, inputA.length);
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < inputA.length; ++i) {
            result.append(inputA[i]);
        }
        harness.check(result.toString(), (Object)expected);
    }

    @Override
    public void test(TestHarness harness) {
        this.testOne(harness, "car means CAR.", "00000000001110", "car means RAC.");
        this.testOne(harness, "car MEANS CAR.", "22211111111111", ".RAC SNAEM car");
        this.testOne(harness, "he said \"car MEANS CAR.\"", "000000000222111111111100", "he said \"RAC SNAEM car.\"");
        this.testOne(harness, "DID YOU SAY 'he said \"car MEANS CAR\"'?", "11111111111112222222224443333333333211", "?'he said \"RAC SNAEM car\"' YAS UOY DID");
    }
}

