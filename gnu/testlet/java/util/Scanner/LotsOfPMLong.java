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

public class LotsOfPMLong
extends Base {
    public LotsOfPMLong() {
        this.fileName = this.getClass().getName() + ".txt";
    }

    @Override
    protected void doTest() {
        long tmp;
        int i;
        this.myHarness.checkPoint("Reading lots of shorts");
        long[] numbers = new long[20000];
        long runID = System.currentTimeMillis();
        Random rand = new Random(runID);
        long max2 = 20000000000000L;
        long mean = 10000000000000L;
        StringBuilder tmpBuff = new StringBuilder(10000);
        FileOutputStream fos = null;
        this.myHarness.debug("runID : " + runID);
        for (i = 0; i < numbers.length; ++i) {
            numbers[i] = tmp = (long)(rand.nextFloat() * 2.0E13f) - 10000000000000L;
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
            while (s.hasNextLong()) {
                tmp = s.nextLong();
                this.myHarness.check(tmp, numbers[i], "nextLong() -> " + tmp + " != " + numbers[i]);
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

