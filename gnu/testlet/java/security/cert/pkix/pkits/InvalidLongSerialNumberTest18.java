/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidLongSerialNumberTest18
extends BaseInvalidTest {
    public InvalidLongSerialNumberTest18() {
        super(new String[]{"data/certs/InvalidLongSerialNumberTest18EE.crt", "data/certs/LongSerialNumberCACert.crt"}, new String[]{"data/crls/LongSerialNumberCACRL.crl"});
    }
}

