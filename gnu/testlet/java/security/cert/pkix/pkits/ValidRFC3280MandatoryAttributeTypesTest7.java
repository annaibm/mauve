/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidRFC3280MandatoryAttributeTypesTest7
extends BaseValidTest {
    public ValidRFC3280MandatoryAttributeTypesTest7() {
        super(new String[]{"data/certs/ValidRFC3280MandatoryAttributeTypesTest7EE.crt", "data/certs/RFC3280MandatoryAttributeTypesCACert.crt"}, new String[]{"data/crls/RFC3280MandatoryAttributeTypesCACRL.crl"});
    }
}

