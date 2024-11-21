/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;
import java.security.cert.PKIXParameters;

public class DifferentPoliciesTest3_2
extends BaseInvalidTest {
    public DifferentPoliciesTest3_2() {
        super(new String[]{"data/certs/DifferentPoliciesTest3EE.crt", "data/certs/PoliciesP2subCACert.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/PoliciesP2subCACRL.crl", "data/crls/GoodCACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
        params.setExplicitPolicyRequired(true);
    }
}

