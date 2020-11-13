package com.example.demo.core.tools.mapstruct;

// data transfer object
public class AppleDTO {

    private int appleId;
    private String kind;
    private double weight;

    public AppleDTO() {
    }

    public AppleDTO(int appleId, String kind, double weight) {
        this.appleId = appleId;
        this.kind = kind;
        this.weight = weight;
    }

    public int getAppleId() {
        return appleId;
    }

    public void setAppleId(int appleId) {
        this.appleId = appleId;
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
}
