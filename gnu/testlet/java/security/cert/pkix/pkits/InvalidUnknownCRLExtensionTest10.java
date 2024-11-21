/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidUnknownCRLExtensionTest10
extends BaseInvalidTest {
    public InvalidUnknownCRLExtensionTest10() {
        super(new String[]{"data/certs/InvalidUnknownCRLExtensionTest10EE.crt", "data/certs/UnknownCRLExtensionCACert.crt"}, new String[]{"data/crls/UnknownCRLExtensionCACRL.crl"});
    }
}

