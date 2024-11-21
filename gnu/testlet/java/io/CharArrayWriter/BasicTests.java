/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.CharArrayWriter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharArrayWriter;
import java.io.IOException;

public class BasicTests
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean arrayEquals;
        String extractedString;
        String firstLines = "The first lines\nof the test which include \ua000 inverted question\nand \u6666 e-with-hat";
        String thirdLine = "a third line";
        String expected = firstLines + ' ' + "third";
        CharArrayWriter writer = new CharArrayWriter();
        if (writer.size() != 0) {
            harness.check(writer.size(), 0, "empty size");
        }
        char[] thirdLineArray = new char[thirdLine.length()];
        try {
            writer.write(firstLines, 0, firstLines.length());
            writer.write(32);
            thirdLine.getChars(0, thirdLine.length(), thirdLineArray, 0);
            writer.write(thirdLineArray, 2, 5);
            extractedString = writer.toString();
            harness.check(extractedString, expected, "basic string");
            writer.reset();
            writer.write(thirdLine, 0, thirdLine.length());
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.check(false, "Unexpected exception");
            extractedString = "";
        }
        char[] resultArray = writer.toCharArray();
        boolean bl = arrayEquals = resultArray.length == thirdLineArray.length;
        if (arrayEquals) {
            for (int i = 0; i < resultArray.length; ++i) {
                if (resultArray[i] == thirdLineArray[i]) continue;
                arrayEquals = false;
            }
        }
        harness.checkPoint("reset string");
        harness.check(arrayEquals);
        try {
            writer.flush();
            writer.close();
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.check(false, "Unexpected exception flush/close");
        }
        extractedString = writer.toString();
        harness.check(extractedString, thirdLine, "flush and close");
        CharArrayWriter secondWriter = new CharArrayWriter();
        boolean pass = false;
        try {
            writer.writeTo(secondWriter);
            extractedString = secondWriter.toString();
            if (extractedString.equals(thirdLine)) {
                pass = true;
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        harness.checkPoint("writeTo");
        harness.check(pass);
    }
}

