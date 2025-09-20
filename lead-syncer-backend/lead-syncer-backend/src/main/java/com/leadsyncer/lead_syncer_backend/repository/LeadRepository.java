package com.leadsyncer.lead_syncer_backend.repository;

import com.leadsyncer.lead_syncer_backend.model.Lead; // ✅ Corrected import
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LeadRepository extends MongoRepository<Lead, String> {
    List<Lead> findByFollowUpDateBetween(LocalDateTime start, LocalDateTime end);
}
