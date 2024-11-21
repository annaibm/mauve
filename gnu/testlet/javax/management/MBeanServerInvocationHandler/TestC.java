/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.MBeanServerInvocationHandler;

import gnu.testlet.javax.management.MBeanServerInvocationHandler.ChildMXBean;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.Colour;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestCMXBean;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.management.ObjectName;

public class TestC
implements TestCMXBean {
    private int id;
    private Integer size;
    private ObjectName name;
    private float[] weights;
    private String[] names;
    private Set<Integer> ages;
    private SortedSet<String> biscuits;
    private Colour colour;
    private Map<String, Integer> numbers;
    private SortedMap<String, Integer> sortedNumbers;
    private ChildMXBean child;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public void setSize(Integer size2) {
        this.size = size2;
    }

    @Override
    public ObjectName getName() {
        return this.name;
    }

    @Override
    public void setName(ObjectName name2) {
        this.name = name2;
    }

    @Override
    public float[] getWeights() {
        return this.weights;
    }

    @Override
    public void setWeights(float[] weights) {
        this.weights = weights;
    }

    @Override
    public String[] getNames() {
        return this.names;
    }

    @Override
    public void setNames(String[] names) {
        this.names = names;
    }

    @Override
    public Set<Integer> getAges() {
        return this.ages;
    }

    @Override
    public void setAges(Set<Integer> ages) {
        this.ages = ages;
    }

    @Override
    public SortedSet<String> getBiscuits() {
        return this.biscuits;
    }

    @Override
    public void setBiscuits(SortedSet<String> biscuits) {
        this.biscuits = biscuits;
    }

    @Override
    public Colour getColour() {
        return this.colour;
    }

    @Override
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public Map<String, Integer> getPhoneNumbers() {
        return this.numbers;
    }

    @Override
    public void setPhoneNumbers(Map<String, Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public SortedMap<String, Integer> getSortedPhoneNumbers() {
        return this.sortedNumbers;
    }

    @Override
    public void setSortedPhoneNumbers(SortedMap<String, Integer> numbers) {
        this.sortedNumbers = numbers;
    }

    @Override
    public ChildMXBean getChild() {
        return this.child;
    }

    @Override
    public void setChild(ChildMXBean child) {
        this.child = child;
    }
}

