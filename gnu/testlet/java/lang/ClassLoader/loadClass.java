/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassLoader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class loadClass
extends ClassLoader
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean cnf_thrown;
        ClassLoader cl = this.getClass().getClassLoader();
        try {
            cl.loadClass("gnu");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("gnu.");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass(".");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("/");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("[");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("[[");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("[]");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("L;");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("L.");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("L[");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("[L;");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("[L[;");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("[L.;");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("[Lgnu;");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("[Lgnu.;");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
        try {
            cl.loadClass("");
            cnf_thrown = false;
        }
        catch (ClassNotFoundException x) {
            cnf_thrown = true;
        }
        harness.check(cnf_thrown);
    }
}

