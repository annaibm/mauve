/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidRevokedEETest3
extends BaseInvalidTest {
    public InvalidRevokedEETest3() {
        super(new String[]{"data/certs/InvalidRevokedEETest3EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

