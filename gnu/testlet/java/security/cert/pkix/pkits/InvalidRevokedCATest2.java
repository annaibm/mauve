/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidRevokedCATest2
extends BaseInvalidTest {
    public InvalidRevokedCATest2() {
        super(new String[]{"data/certs/InvalidRevokedCATest2EE.crt", "data/certs/RevokedsubCACert.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/RevokedsubCACRL.crl", "data/crls/GoodCACRL.crl"});
    }
}

