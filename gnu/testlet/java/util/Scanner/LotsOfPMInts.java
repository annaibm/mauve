/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LotsOfPMInts
extends Base {
    public LotsOfPMInts() {
        this.isEnabled = false;
        this.setDefaultFilename();
    }

    @Override
    protected void doTest() {
        int tmp;
        int i;
        this.myHarness.checkPoint("Reading lots of positive ints");
        int[] numbers = new int[100000];
        long runID = System.currentTimeMillis();
        Random rand = new Random(runID);
        int max2 = 1000000;
        int mean = 500000;
        StringBuilder tmpBuff = new StringBuilder(10000);
        FileOutputStream fos = null;
        this.myHarness.debug("runID : " + runID);
        for (i = 0; i < numbers.length; ++i) {
            numbers[i] = tmp = (int)(rand.nextFloat() * 1000000.0f) - 500000;
        }
        tmpBuff.insert(0, "" + numbers[0]);
        for (i = 1; i < numbers.length; ++i) {
            tmpBuff.append(" " + numbers[i]);
        }
        try {
            fos = new FileOutputStream(this.aktFile);
            fos.write(tmpBuff.toString().getBytes());
            fos.flush();
            fos.close();
            Scanner s = new Scanner(this.aktFile);
            i = 0;
            while (s.hasNextInt()) {
                tmp = s.nextInt();
                this.myHarness.check(tmp, numbers[i], "nextInt() -> " + tmp + " != " + numbers[i]);
                ++i;
            }
            this.myHarness.check(i, numbers.length, "Incomplete read... (" + i + " / " + numbers.length + ")");
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

