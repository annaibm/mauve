/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidLongSerialNumberTest17
extends BaseValidTest {
    public ValidLongSerialNumberTest17() {
        super(new String[]{"data/certs/ValidLongSerialNumberTest17EE.crt", "data/certs/LongSerialNumberCACert.crt"}, new String[]{"data/crls/LongSerialNumberCACRL.crl"});
    }
}

