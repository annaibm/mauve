/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner.compare;

import gnu.testlet.runner.Result;
import gnu.testlet.runner.compare.ComparisonVisitor;
import java.util.Set;
import java.util.TreeSet;

public abstract class Comparison
implements Comparable {
    private final String name;
    private final Set children = new TreeSet();

    Comparison(Result result) {
        this.name = result.getName();
    }

    public final String getName() {
        return this.name;
    }

    public final Comparison get(String name2) {
        Comparison result = null;
        for (Comparison r : this.children) {
            if (!r.getName().equals(name2)) continue;
            result = r;
            break;
        }
        return result;
    }

    public abstract void accept(ComparisonVisitor var1);

    public int getProgression() {
        int progression = 0;
        for (Comparison r : this.children) {
            progression += r.getProgression();
        }
        return progression;
    }

    public final void add(Comparison child) {
        this.children.add(child);
    }

    public final int compareTo(Object comparison) {
        Comparison c = (Comparison)comparison;
        int result = this.getProgression() - c.getProgression();
        if (result == 0) {
            result = this.getName().compareTo(c.getName());
        }
        return result;
    }

    protected final void acceptChildren(ComparisonVisitor visitor) {
        for (Comparison cmp : this.children) {
            cmp.accept(visitor);
        }
    }
}

