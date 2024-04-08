package org.example.networking;

/**
 * Object can be sent and received using the ObjectInputStream class, but the object has to be serializable
 * to enable passing.
 */

public class ObjectServers implements java.io.Serializable {
    private String name;
    private String city;
    private String state;
    private String zip;

    ObjectServers(String name, String city, String state, String zip) {
        this.city = city;
        this.name = name;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }


}
