package com.example.monitorapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoredServerService {
    @Autowired
    ServerRepository serverRepository;

    public List<MonitoredServer> findAll() {
        return serverRepository.findAll();
    }

    public MonitoredServer getServerById(int id) {
        return serverRepository.findById(id).get();
    }

    public void saveOrUpdate(MonitoredServer server) {
        serverRepository.save(server);
    }

    public void saveAll(List<MonitoredServer> servers) {
        for (MonitoredServer server : servers) {
            saveOrUpdate(server);
        }
    }

    public List<String> checkAll(List<MonitoredServer> servers) {
        List<String> results = new ArrayList<>();
        for (MonitoredServer server : servers) {
            results.add(checkServer(server.getServerAddress()));
        }
        return results;
    }

    public void delete(int id) {
        serverRepository.deleteById(id);
    }

    public List<ServerListElement> getListElements(List<MonitoredServer> servers) {
        List<ServerListElement> elements = new ArrayList<>();
        for (MonitoredServer server : servers) {
            elements.add(new ServerListElement(server.getServerName(), server.getServerAddress(), checkServer(server.getServerAddress())));
        }
        return elements;
    }

    public String checkServer(String hostname) {
        try {
            URL url = new URL(hostname);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            
            int code = connection.getResponseCode();
            return code==200 ? "Connection succesful" : "Connection failed";
        } catch (IOException e) {
            return "unknown host";
        }
    }
}
