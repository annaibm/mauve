/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;
import java.security.cert.PKIXParameters;

public class DifferentPoliciesTest12
extends BaseInvalidTest {
    public DifferentPoliciesTest12() {
        super(new String[]{"data/certs/DifferentPoliciesTest12EE.crt", "data/certs/PoliciesP3CACert.crt"}, new String[]{"data/crls/PoliciesP3CACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
    }
}

