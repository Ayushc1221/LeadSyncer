package com.leadsyncer.lead_syncer_backend.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "leads")
public class Lead {
    @Id
    private String id;

    private String name;
    private String phone;
    private String message;
    private String source;
    private String status; // New, Follow-Up, Converted, Rejected
    private LocalDateTime receivedAt;
    private LocalDateTime followUpDate;
    private String notes;
}
