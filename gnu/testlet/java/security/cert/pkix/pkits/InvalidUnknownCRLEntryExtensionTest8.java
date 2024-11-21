/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidUnknownCRLEntryExtensionTest8
extends BaseInvalidTest {
    public InvalidUnknownCRLEntryExtensionTest8() {
        super(new String[]{"data/certs/InvalidUnknownCRLEntryExtensionTest8EE.crt", "data/certs/UnknownCRLEntryExtensionCACert.crt"}, new String[]{"data/crls/UnknownCRLEntryExtensionCACRL.crl"});
    }
}

