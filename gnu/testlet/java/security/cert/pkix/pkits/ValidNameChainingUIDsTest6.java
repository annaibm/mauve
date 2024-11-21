/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidNameChainingUIDsTest6
extends BaseValidTest {
    public ValidNameChainingUIDsTest6() {
        super(new String[]{"data/certs/ValidNameUIDsTest6EE.crt", "data/certs/UIDCACert.crt"}, new String[]{"data/crls/UIDCACRL.crl"});
    }
}

