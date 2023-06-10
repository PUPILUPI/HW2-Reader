package ru.belov.reactors;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class Reactor {
    @JsonProperty("class") private String classReactor;
    @JsonProperty("burnup") private double burnUp;
    @JsonProperty("kpd") private double kpd;
    @JsonProperty("enrichment") private double enrichment;
    @JsonProperty("termal_capacity") private double termalCapacity;
    @JsonProperty("electrical_capacity") private double electricalCapacity;
    @JsonProperty("life_time") private double lifeTime;
    @JsonProperty("first_load") private double firstLoad;


    public String getClassReactor() {
        return classReactor;
    }

    public void setClassReactor(String classReactor) {
        this.classReactor = classReactor;
    }

    public double getBurnUp() {
        return burnUp;
    }

    public void setBurnUp(double burnUp) {
        this.burnUp = burnUp;
    }

    public double getKpd() {
        return kpd;
    }

    public void setKpd(double kpd) {
        this.kpd = kpd;
    }

    public double getEnrichment() {
        return enrichment;
    }

    public void setEnrichment(double enrichment) {
        this.enrichment = enrichment;
    }

    public double getTermalCapacity() {
        return termalCapacity;
    }

    public void setTermalCapacity(double termalCapacity) {
        this.termalCapacity = termalCapacity;
    }

    public double getElectricalCapacity() {
        return electricalCapacity;
    }

    public void setElectricalCapacity(double electricalCapacity) {
        this.electricalCapacity = electricalCapacity;
    }

    public double getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(double lifeTime) {
        this.lifeTime = lifeTime;
    }

    public double getFirstLoad() {
        return firstLoad;
    }

    public void setFirstLoad(double firstLoad) {
        this.firstLoad = firstLoad;
    }
    @Override
    public String toString() {
        return "class: " + classReactor + "\n"
                + "burnup: " + burnUp + "\n"
                + "kpd: " + kpd + "\n"
                + "enrichment: " + enrichment + "\n"
                + "termal_capacity: " + termalCapacity + "\n"
                + "electrical_capacity: " + electricalCapacity + "\n"
                + "life_time: " + lifeTime + "\n"
                + "first_load: " + firstLoad + "\n";
    }
    public MutableTreeNode getNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(classReactor);
        node.add(new DefaultMutableTreeNode("class: " + classReactor));
        node.add(new DefaultMutableTreeNode("burnup: " + burnUp));
        node.add(new DefaultMutableTreeNode("kpd: " + kpd));
        node.add(new DefaultMutableTreeNode("enrichment: " + enrichment));
        node.add(new DefaultMutableTreeNode("termal_capacity: " + termalCapacity));
        node.add(new DefaultMutableTreeNode("electrical_capacity: " + electricalCapacity));
        node.add(new DefaultMutableTreeNode("life_time: " + lifeTime));
        node.add(new DefaultMutableTreeNode("first_load: " + firstLoad));
        return node;
    }
}

