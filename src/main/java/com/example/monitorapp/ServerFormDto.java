package com.example.monitorapp;

import java.util.ArrayList;
import java.util.List;

public class ServerFormDto {
    private List<MonitoredServer> servers;
    
    public ServerFormDto() {
        this.servers = new ArrayList<>();
    }

    public ServerFormDto(List<MonitoredServer> servers) {
        this.servers = servers;
    }

    public void addServer(MonitoredServer server) {
        servers.add(server);
    }

    public List<MonitoredServer> getServers() {
        return servers;
    }

    public void setServers(List<MonitoredServer> servers) {
        this.servers = servers;
    }
    
}
