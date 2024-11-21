/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidBasicSelfIssuedNewWithOldTest3
extends BaseValidTest {
    public ValidBasicSelfIssuedNewWithOldTest3() {
        super(new String[]{"data/certs/ValidBasicSelfIssuedNewWithOldTest3EE.crt", "data/certs/BasicSelfIssuedOldKeyNewWithOldCACert.crt", "data/certs/BasicSelfIssuedOldKeyCACert.crt"}, new String[]{"data/crls/BasicSelfIssuedOldKeyCACRL.crl"});
    }
}

