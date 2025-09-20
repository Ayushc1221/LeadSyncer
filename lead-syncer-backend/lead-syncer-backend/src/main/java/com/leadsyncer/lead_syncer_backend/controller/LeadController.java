package com.leadsyncer.lead_syncer_backend.controller;

import com.leadsyncer.lead_syncer_backend.dto.LeadRequest;
import com.leadsyncer.lead_syncer_backend.model.Lead;
import com.leadsyncer.lead_syncer_backend.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "*")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public Lead createLead(@RequestBody LeadRequest request) {
        return leadService.createLead(request);
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @PutMapping("/{id}")
    public Lead updateLead(@PathVariable String id, @RequestBody LeadRequest request) {
        return leadService.updateLead(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteLead(@PathVariable String id) {
        leadService.deleteLead(id);
    }

    @GetMapping("/followups")
    public List<Lead> getTodayFollowUps() {
        return leadService.getTodayFollowUps();
    }
}
