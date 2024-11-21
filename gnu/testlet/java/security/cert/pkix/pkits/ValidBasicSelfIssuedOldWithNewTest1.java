/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidBasicSelfIssuedOldWithNewTest1
extends BaseValidTest {
    public ValidBasicSelfIssuedOldWithNewTest1() {
        super(new String[]{"data/certs/ValidBasicSelfIssuedOldWithNewTest1EE.crt", "data/certs/BasicSelfIssuedNewKeyOldWithNewCACert.crt", "data/certs/BasicSelfIssuedNewKeyCACert.crt"}, new String[]{"data/crls/BasicSelfIssuedNewKeyCACRL.crl"});
    }
}

