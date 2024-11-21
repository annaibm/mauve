/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidBasicSelfIssuedOldWithNewTest2
extends BaseInvalidTest {
    public InvalidBasicSelfIssuedOldWithNewTest2() {
        super(new String[]{"data/certs/InvalidBasicSelfIssuedOldWithNewTest2EE.crt", "data/certs/BasicSelfIssuedNewKeyOldWithNewCACert.crt", "data/certs/BasicSelfIssuedNewKeyCACert.crt"}, new String[]{"data/crls/BasicSelfIssuedNewKeyCACRL.crl"});
    }
}

