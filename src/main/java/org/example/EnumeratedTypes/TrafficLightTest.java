package org.example.EnumeratedTypes;

public class TrafficLightTest {
    void main() {
        TrafficLight trafficLight = TrafficLight.RED;
        TrafficLight trafficLight1 = TrafficLight.BLUE;
        TrafficLight trafficLight2 = TrafficLight.GREEN;
        System.out.println("ordinal "+ trafficLight.ordinal());
        System.out.println(trafficLight2.name());
        System.out.println(trafficLight.getDescription());
        System.out.println(trafficLight1.getDescription());
        System.out.println(trafficLight2.getDescription());
    }
}
