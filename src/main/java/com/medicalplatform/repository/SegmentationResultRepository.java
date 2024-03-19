package com.medicalplatform.repository;

import com.medicalplatform.entity.SegmentationResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentationResultRepository extends JpaRepository<SegmentationResult, Long> {
}