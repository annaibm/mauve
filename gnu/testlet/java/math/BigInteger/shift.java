/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class shift
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("shift");
        BigInteger x = new BigInteger("-50123044517898350982301255831878893568", 10);
        harness.check(x.shiftRight(64).toString(), (Object)"-2717175687894652269");
        harness.check(x.shiftLeft(-64).toString(), (Object)"-2717175687894652269");
        harness.check(x.shiftRight(1).toString(), (Object)"-25061522258949175491150627915939446784");
        harness.check(x.shiftLeft(1).toString(), (Object)"-100246089035796701964602511663757787136");
        harness.check(x.shiftRight(0).toString(), (Object)x.toString());
        harness.check(x.shiftLeft(0).toString(), (Object)x.toString());
        x = new BigInteger("50123044517898350982301255831878893568", 10);
        harness.check(x.shiftRight(64).toString(), (Object)"2717175687894652268");
        harness.check(x.shiftLeft(-64).toString(), (Object)"2717175687894652268");
        harness.check(x.shiftRight(1).toString(), (Object)"25061522258949175491150627915939446784");
        harness.check(x.shiftLeft(1).toString(), (Object)"100246089035796701964602511663757787136");
    }
}

