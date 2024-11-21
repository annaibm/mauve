/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileInput
extends Base {
    public FileInput() {
        this.setDefaultFilename();
    }

    @Override
    protected void doTest() {
        int i;
        this.myHarness.checkPoint("File Input");
        String[] testWords = new String[]{"This", "is", "a", "simple", "Test", "don't", "panik", "it's", "just", "a", "Teset"};
        testWords[0] = testWords[0].trim();
        String testString = testWords[0];
        for (i = 1; i < testWords.length; ++i) {
            testWords[i] = testWords[i].trim();
            testString = testString + " " + testWords[i].trim();
        }
        try {
            FileOutputStream fos = new FileOutputStream(this.aktFile);
            fos.write(testString.getBytes());
            fos.flush();
            fos.close();
            Scanner s = new Scanner(this.aktFile);
            i = 0;
            while (s.hasNext()) {
                String tmpStr = s.next();
                this.myHarness.check(tmpStr, testWords[i], "next() -> \"" + tmpStr + "\" != \"" + testWords[i] + "\"");
                ++i;
            }
            this.myHarness.check(i, testWords.length, "Incomplete read... (" + i + " / " + testWords.length + ")");
            s.close();
        }
        catch (FileNotFoundException e) {
            this.myHarness.fail("Could not create file");
        }
        catch (IOException e) {
            this.myHarness.fail("Could not write to File \"" + this.aktFile.getName() + "\"");
        }
    }
}

