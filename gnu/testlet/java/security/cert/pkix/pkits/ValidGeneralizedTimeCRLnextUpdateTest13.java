/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidGeneralizedTimeCRLnextUpdateTest13
extends BaseValidTest {
    public ValidGeneralizedTimeCRLnextUpdateTest13() {
        super(new String[]{"data/certs/ValidGeneralizedTimeCRLnextUpdateTest13EE.crt", "data/certs/GeneralizedTimeCRLnextUpdateCACert.crt"}, new String[]{"data/crls/GeneralizedTimeCRLnextUpdateCACRL.crl"});
    }
}

