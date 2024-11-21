/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;
import java.security.cert.PKIXParameters;
import java.util.Collections;

public class DifferentPoliciesTest5
extends BaseInvalidTest {
    public DifferentPoliciesTest5() {
        super(new String[]{"data/certs/DifferentPoliciesTest5EE.crt", "data/certs/PoliciesP2subCA2Cert.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/PoliciesP2subCA2CRL.crl", "data/crls/GoodCACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
        params.setInitialPolicies(Collections.EMPTY_SET);
        params.setAnyPolicyInhibited(true);
    }
}

