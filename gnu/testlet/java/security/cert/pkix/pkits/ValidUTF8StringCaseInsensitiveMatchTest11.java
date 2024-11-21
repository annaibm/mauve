/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidUTF8StringCaseInsensitiveMatchTest11
extends BaseValidTest {
    public ValidUTF8StringCaseInsensitiveMatchTest11() {
        super(new String[]{"data/certs/ValidUTF8StringCaseInsensitiveMatchTest11EE.crt", "data/certs/UTF8StringCaseInsensitiveMatchCACert.crt"}, new String[]{"data/crls/UTF8StringCaseInsensitiveMatchCACRL.crl"});
    }
}

