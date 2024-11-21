/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidCAnotAfterDateTest5
extends BaseInvalidTest {
    public InvalidCAnotAfterDateTest5() {
        super(new String[]{"data/certs/InvalidCAnotAfterDateTest5EE.crt", "data/certs/BadnotAfterDateCACert.crt"}, new String[]{"data/crls/BadnotAfterDateCACRL.crl"});
    }
}

