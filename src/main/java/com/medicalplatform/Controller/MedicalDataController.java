package com.medicalplatform.Controller;

import com.medicalplatform.Service.MedicalDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
@RestController("/medicaldata")
public class MedicalDataController {
    private final MedicalDataService medicalDataService;


    public MedicalDataController(MedicalDataService medicalDataService) {
        this.medicalDataService = medicalDataService;
    }
    public ResponseEntity<String> uploadMedicalData() {
        return ResponseEntity.ok("MedicalData");
    }
    public ResponseEntity<String> downloadMedicalData() {
        return ResponseEntity.ok("MedicalData");
    }
    public ResponseEntity<String> AnalysisMedicalData() {
        return ResponseEntity.ok("MedicalData");
    }

}
