package com.medicalplatform.entity;

import javax.persistence.*;
import java.sql.Timestamp;
/**
 * @author 渚相玉
 * @verion 2.6.5
 * 分割结果
 */
@Entity
@Table(name = "segmentation_results")
public class SegmentationResult implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "data_id", nullable = false)
    private MedicalData medicalData;

    @Column(name = "segmentation_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp segmentationTime;

    @Column(nullable = false)
    private String resultPath;

    // Getters and setters

}