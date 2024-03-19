package com.medicalplatform.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
@Entity
@Table(name = "analysis_results")
@Data
public class AnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;


}
