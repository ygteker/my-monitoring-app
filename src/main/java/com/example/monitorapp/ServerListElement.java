package com.example.monitorapp;

public class ServerListElement {
    
    private String name;

    private String address;

    private String status;

    public ServerListElement() {
    }

    public ServerListElement(String name, String address, String status) {
        this.name = name;
        this.address = address;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
