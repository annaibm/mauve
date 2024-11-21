/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidBasicSelfIssuedNewWithOldTest4
extends BaseValidTest {
    public ValidBasicSelfIssuedNewWithOldTest4() {
        super(new String[]{"data/certs/ValidBasicSelfIssuedNewWithOldTest4EE.crt", "data/certs/BasicSelfIssuedOldKeyCACert.crt"}, new String[]{"data/crls/BasicSelfIssuedOldKeyCACRL.crl"}, new String[]{"data/certs/BasicSelfIssuedOldKeyNewWithOldCACert.crt"});
    }
}

