package ru.belov.reactors;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class Reactor {
    @JsonProperty("class") private String classReactor;
    private double burnup;
    private double kpd;
    private double enrichment;
    private double termal_capacity;
    private double electrical_capacity;
    private double life_time;
    private double first_load;

//    public Reactor(String classReactor, double burnup, double kpd, double enrichment, double termal_capacity,
//    double electrical_capacity, double life_time, double first_load){
//        this.classReactor = classReactor;
//        this.burnup = burnup;
//        this.kpd = kpd;
//        this.enrichment = enrichment;
//        this.termal_capacity = termal_capacity;
//        this.electrical_capacity = electrical_capacity;
//        this.life_time = life_time;
//        this.first_load = first_load;
//    }

    public String getClassReactor() {
        return classReactor;
    }

    public void setClassReactor(String classReactor) {
        this.classReactor = classReactor;
    }

    public double getBurnup() {
        return burnup;
    }

    public void setBurnup(double burnup) {
        this.burnup = burnup;
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

    public double getTermal_capacity() {
        return termal_capacity;
    }

    public void setTermal_capacity(double termal_capacity) {
        this.termal_capacity = termal_capacity;
    }

    public double getElectrical_capacity() {
        return electrical_capacity;
    }

    public void setElectrical_capacity(double electrical_capacity) {
        this.electrical_capacity = electrical_capacity;
    }

    public double getLife_time() {
        return life_time;
    }

    public void setLife_time(double life_time) {
        this.life_time = life_time;
    }

    public double getFirst_load() {
        return first_load;
    }

    public void setFirst_load(double first_load) {
        this.first_load = first_load;
    }
    @Override
    public String toString() {
        return "class: " + classReactor + "\n"
                + "burnup: " + Double.toString(burnup) + "\n"
                + "kpd: " + Double.toString(kpd) + "\n"
                + "enrichment: " + Double.toString(enrichment) + "\n"
                + "termal_capacity: " + Double.toString(termal_capacity) + "\n"
                + "electrical_capacity: " + Double.toString(electrical_capacity) + "\n"
                + "life_time: " + Double.toString(life_time) + "\n"
                + "first_load: " + Double.toString(first_load) + "\n";
    }
    public MutableTreeNode getNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(classReactor);
        node.add(new DefaultMutableTreeNode("class: " + classReactor));
        node.add(new DefaultMutableTreeNode("burnup: " + Double.toString(burnup)));
        node.add(new DefaultMutableTreeNode("kpd: " + Double.toString(kpd)));
        node.add(new DefaultMutableTreeNode("enrichment: " + Double.toString(enrichment)));
        node.add(new DefaultMutableTreeNode("termal_capacity: " + Double.toString(termal_capacity)));
        node.add(new DefaultMutableTreeNode("electrical_capacity: " + Double.toString(electrical_capacity)));
        node.add(new DefaultMutableTreeNode("life_time: " + Double.toString(life_time)));
        node.add(new DefaultMutableTreeNode("first_load: " + Double.toString(first_load)));
        return node;
    }
}

