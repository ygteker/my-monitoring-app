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
    
    @GetMapping("/test")
    public String getTest() {
        return "greeting";
    }

    @PostMapping
    public MonitoredServer addServer(@RequestBody ServerDto dto) {
        MonitoredServer server = new MonitoredServer(dto.getServerName(), dto.getServerAddress());
        serverService.saveOrUpdate(server);
        return serverService.getServerById(server.getId());
    }

    @GetMapping("/add")
    public String showServerForm(Model model) {
        ServerFormDto formDto = new ServerFormDto();

        for (int i = 1; i <= 3; i++) {
            formDto.addServer(new MonitoredServer());
        }
    
        model.addAttribute("form", formDto);
        return "createServerForm";
    }

    @PostMapping("/save")
    public String saveBooks(@ModelAttribute ServerFormDto form, Model model) {
        serverService.saveAll(form.getServers());

        model.addAttribute("servers", serverService.findAll());
        return "redirect:/all";
    }

    @GetMapping("/all")
    public String getAllServers(Model model) {
        model.addAttribute("payload", serverService.getListElements(serverService.findAll()));

        return "serverlist";
    }

    @GetMapping("/check")
    public String checkServer(@RequestParam String servername) {
        System.out.println(servername);
        return serverService.checkServer(servername);
    }
}
