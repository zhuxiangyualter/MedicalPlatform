package com.medicalplatform.repository;

import com.medicalplatform.entity.MedicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalDataRepository extends JpaRepository<MedicalData, Long> {

}