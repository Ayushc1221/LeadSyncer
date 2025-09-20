package com.leadsyncer.lead_syncer_backend.service;

import com.leadsyncer.lead_syncer_backend.dto.LeadRequest;
import com.leadsyncer.lead_syncer_backend.model.Lead;
import com.leadsyncer.lead_syncer_backend.repository.LeadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public Lead createLead(LeadRequest request) {
        Lead lead = Lead.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .message(request.getMessage())
                .source(request.getSource())
                .status(request.getStatus() != null ? request.getStatus() : "New")
                .receivedAt(LocalDateTime.now())
                .followUpDate(request.getFollowUpDate())
                .notes(request.getNotes())
                .build();
        return leadRepository.save(lead);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Lead updateLead(String id, LeadRequest request) {
        Lead lead = leadRepository.findById(id).orElseThrow(() -> new RuntimeException("Lead not found"));
        lead.setStatus(request.getStatus());
        lead.setNotes(request.getNotes());
        lead.setFollowUpDate(request.getFollowUpDate());
        return leadRepository.save(lead);
    }

    public void deleteLead(String id) {
        leadRepository.deleteById(id);
    }

    public List<Lead> getTodayFollowUps() {
        LocalDateTime start = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LocalDateTime end = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
        return leadRepository.findByFollowUpDateBetween(start, end);
    }
}
