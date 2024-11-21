/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidBasicSelfIssuedNewWithOldTest5
extends BaseInvalidTest {
    public InvalidBasicSelfIssuedNewWithOldTest5() {
        super(new String[]{"data/certs/InvalidBasicSelfIssuedNewWithOldTest5EE.crt", "data/certs/BasicSelfIssuedOldKeyNewWithOldCACert.crt", "data/certs/BasicSelfIssuedOldKeyCACert.crt"}, new String[]{"data/crls/BasicSelfIssuedOldKeyCACRL.crl"});
    }
}

