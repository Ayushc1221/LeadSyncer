package com.leadsyncer.lead_syncer_backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeadRequest {
    private String name;
    private String phone;
    private String message;
    private String source;
    private String status;
    private LocalDateTime followUpDate;
    private String notes;
}
