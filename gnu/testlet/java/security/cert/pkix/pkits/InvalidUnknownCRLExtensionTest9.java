/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidUnknownCRLExtensionTest9
extends BaseInvalidTest {
    public InvalidUnknownCRLExtensionTest9() {
        super(new String[]{"data/certs/InvalidUnknownCRLExtensionTest9EE.crt", "data/certs/UnknownCRLExtensionCACert.crt"}, new String[]{"data/crls/UnknownCRLExtensionCACRL.crl"});
    }
}

