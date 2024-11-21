/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FilePermission;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FilePermission;
import java.security.Permissions;

public class simple
implements Testlet {
    private static String[] actions = new String[]{"read", "write", "execute", "delete"};

    @Override
    public void test(TestHarness harness) {
        Permissions p = new Permissions();
        p.add(new FilePermission("/tmp/p", "read"));
        p.add(new FilePermission("/tmp/p", "read"));
        FilePermission fp1 = new FilePermission("/tmp", "read");
        harness.check(fp1.implies(fp1));
        harness.checkPoint("constructor file arg checking");
        try {
            harness.check(new FilePermission(null, "read") == null);
        }
        catch (NullPointerException ex) {
            harness.check(true);
        }
        harness.checkPoint("constructor action checking (simple)");
        harness.check(new FilePermission("/tmp/p", "read") != null);
        harness.check(new FilePermission("/tmp/p", "write") != null);
        harness.check(new FilePermission("/tmp/p", "execute") != null);
        harness.check(new FilePermission("/tmp/p", "delete") != null);
        harness.checkPoint("constructor action checking (lists)");
        harness.check(new FilePermission("/tmp/p", "read,delete") != null);
        harness.check(new FilePermission("/tmp/p", "read,read") != null);
        harness.check(new FilePermission("/tmp/p", "read,read,read") != null);
        harness.checkPoint("constructor action checking (case)");
        harness.check(new FilePermission("/tmp/p", "Read,DELETE") != null);
        harness.check(new FilePermission("/tmp/p", "rEAD") != null);
        harness.checkPoint("constructor action checking(underspecified)");
        harness.check(new FilePermission("/tmp/p", " read ") != null);
        harness.check(new FilePermission("/tmp/p", "read, read") != null);
        harness.check(new FilePermission("/tmp/p", "read ,read") != null);
        harness.checkPoint("constructor action checking(bad actions)");
        try {
            harness.check(new FilePermission("/tmp/p", null) == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        try {
            harness.check(new FilePermission("/tmp/p", "") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        try {
            harness.check(new FilePermission("/tmp/p", " ") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        try {
            harness.check(new FilePermission("/tmp/p", "foo") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        try {
            harness.check(new FilePermission("/tmp/p", "nothing") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        harness.checkPoint("constructor action checking(bad action lists)");
        try {
            harness.check(new FilePermission("/tmp/p", ",") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        try {
            harness.check(new FilePermission("/tmp/p", "read,") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        try {
            harness.check(new FilePermission("/tmp/p", "read,,read") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        harness.checkPoint("constructor action checking(wierd stuff)");
        try {
            harness.check(new FilePermission("/tmp/p", "read read") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        try {
            harness.check(new FilePermission("/tmp/p", "read\nread") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        try {
            harness.check(new FilePermission("/tmp/p", "read;read") == null);
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
        harness.checkPoint("implies() action checking");
        for (int i = 1; i < 1 << actions.length; ++i) {
            for (int j = 1; j < 1 << actions.length; ++j) {
                FilePermission pi = new FilePermission("/tmp/p", simple.makeActions(i));
                FilePermission pj = new FilePermission("/tmp/p", simple.makeActions(j));
                harness.check(pi.implies(pj) == ((i & j) == j));
            }
        }
    }

    private static String makeActions(int mask) {
        String result = "";
        for (int i = 0; i < actions.length; ++i) {
            if ((mask & 1 << i) == 0) continue;
            if (result.length() > 0) {
                result = result + ",";
            }
            result = result + actions[i];
        }
        return result;
    }
}

