package com.example.demo.core.tools.mapstruct;

// database entity
public class Apple {

    private int id;
    private String kind;
    private double weight;

    public Apple() {
    }

    public Apple(int id, String kind, double weight) {
        this.id = id;
        this.kind = kind;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple[id=" + this.id + ", kind=" + this.kind + ", weight=" + this.weight + "]";
    }
}
