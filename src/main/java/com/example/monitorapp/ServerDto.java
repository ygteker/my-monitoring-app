package com.example.monitorapp;

public class ServerDto {
    
    private String serverName;

    private String serverAddress;
    
    public ServerDto() {
    }

    public ServerDto(String serverName, String serverAddress) {
        this.serverName = serverName;
        this.serverAddress = serverAddress;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    

}
