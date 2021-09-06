package com.example.monitorapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "servers")
public class MonitoredServer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serverName;

    private String serverAddress;

    @CreationTimestamp
    private Date addedAt;

    public MonitoredServer() {
    }

    public MonitoredServer(String serverName, String serverAddress) {
        this.serverName = serverName;
        this.serverAddress = serverAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "MonitoredServer [addedAt=" + addedAt + ", id=" + id + ", serverAddress=" + serverAddress
                + ", serverName=" + serverName + "]";
    }

    
}
