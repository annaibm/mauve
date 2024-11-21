/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidRFC3280OptionalAttributeTypesTest8
extends BaseValidTest {
    public ValidRFC3280OptionalAttributeTypesTest8() {
        super(new String[]{"data/certs/ValidRFC3280OptionalAttributeTypesTest8EE.crt", "data/certs/RFC3280OptionalAttributeTypesCACert.crt"}, new String[]{"data/crls/RFC3280OptionalAttributeTypesCACRL.crl"});
    }
}

