package com.example.monitorapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonitorController {

    @Autowired
    private MonitoredServerService serverService;

    /**
     * Endpoint to create entities via requests.
     * @param dto Data Transfer Object for server information
     * @return created server in a JSON object
     */
    @PostMapping
    public MonitoredServer addServer(@RequestBody ServerDto dto) {
        MonitoredServer server = new MonitoredServer(dto.getServerName(), dto.getServerAddress());
        serverService.saveOrUpdate(server);
        return serverService.getServerById(server.getId());
    }

    /**
     * 
     * @param model model entity to hold variables from backend to frontend
     * @return createServerForm.html
     */
    @GetMapping("/add")
    public String showServerForm(Model model) {
        ServerFormDto formDto = new ServerFormDto();    
        formDto.addServer(new MonitoredServer());
    
        model.addAttribute("form", formDto);
        return "createServerForm";
    }

    /**
     * 
     * @param form holds the data inputs
     * @param model model entity to hold variables
     * @return serverlist.html
     */
    @PostMapping("/save")
    public String saveBooks(@ModelAttribute ServerFormDto form, Model model) {
        serverService.saveAll(form.getServers());

        model.addAttribute("servers", serverService.findAll());
        return "redirect:/all";
    }

    /**
     * 
     * @param model model entity to hold variables
     * @return serverlist.html
     */
    @GetMapping("/all")
    public String getAllServers(Model model) {
        model.addAttribute("payload", serverService.getListElements(serverService.findAll()));

        return "serverlist";
    }

    /**
     * Endpoint to check server status manually via request
     * @param servername server address to monitor
     * @return Connection successful or Connection failed or unknown host in JSON object
     */
    @GetMapping("/check")
    public String checkServer(@RequestParam String servername) {
        System.out.println(servername);
        return serverService.checkServer(servername);
    }
}
