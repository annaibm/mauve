/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidOldCRLnextUpdateTest11
extends BaseInvalidTest {
    public InvalidOldCRLnextUpdateTest11() {
        super(new String[]{"data/certs/InvalidOldCRLnextUpdateTest11EE.crt", "data/certs/OldCRLnextUpdateCACert.crt"}, new String[]{"data/crls/OldCRLnextUpdateCACRL.crl"});
    }
}

