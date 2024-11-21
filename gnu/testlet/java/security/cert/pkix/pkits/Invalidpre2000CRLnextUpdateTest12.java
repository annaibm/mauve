/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class Invalidpre2000CRLnextUpdateTest12
extends BaseInvalidTest {
    public Invalidpre2000CRLnextUpdateTest12() {
        super(new String[]{"data/certs/Invalidpre2000CRLnextUpdateTest12EE.crt", "data/certs/pre2000CRLnextUpdateCACert.crt"}, new String[]{"data/crls/pre2000CRLnextUpdateCACRL.crl"});
    }
}

