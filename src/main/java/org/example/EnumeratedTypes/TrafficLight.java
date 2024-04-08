package org.example.EnumeratedTypes;

public enum TrafficLight {
    RED("Stop now playa!"),
    BLUE("Do you really want to leave? "),

    GREEN("Go now punk.");

    private  String description;
    TrafficLight(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
