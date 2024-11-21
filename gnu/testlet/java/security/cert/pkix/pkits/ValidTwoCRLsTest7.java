/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidTwoCRLsTest7
extends BaseValidTest {
    public ValidTwoCRLsTest7() {
        super(new String[]{"data/certs/ValidTwoCRLsTest7EE.crt", "data/certs/TwoCRLsCACert.crt"}, new String[]{"data/crls/TwoCRLsCAGoodCRL.crl", "data/crls/TwoCRLsCABadCRL.crl"});
    }
}

